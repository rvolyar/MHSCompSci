// The "SavePrint" class.
package hsa;

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.awt.print.*;
import java.text.*;
import java.io.*;
import java.util.*;

// This class contains the code to allow a program to save or print
// its graphics window.  Any program using this must implement the
// "DrawGraphics" interface, which is used to draw the output window
// to a Graphics object.
public class SavePrint implements Printable
{
    // Used for writing BMP files
    private static final int ROWS_GRABBED_AT_A_TIME = 75;
    private static final int BI_RGB = 0;
    private static final int BI_COMPRESSED_RLE8 = 1;
    private static final int BI_COMPRESSED_RLE4 = 2;

    // The object and its size
    private DrawGraphics savePrintObj;
    private Component componentObj;
    private int xSize, ySize;

    private Status status;
    private DataOutputStream out;

    public SavePrint (DrawGraphics savePrintObj, Component componentObj,
	    int xSize, int ySize)
    {
	this.savePrintObj = savePrintObj;
	this.componentObj = componentObj;
	this.xSize = xSize;
	this.ySize = ySize;
    } // SavePrint constructor


    public void saveToFile (String fileName)
    {
	Image saveBuffer = componentObj.createImage (xSize, ySize);
	savePrintObj.drawWindowToGraphics (saveBuffer.getGraphics ());

	// Now determine the information about the image
	long lastStatusTime = 0;

	// Put up status message.
	status = new Status ("Calculating Size", "Converting to BMP");

	// Calculate the size of the picture.
	int[] pixels = new int [ySize * xSize];
	byte[] indexedPixels = new byte [ySize * xSize];
	int[] colourMap = new int [256];
	int numColours = 0;

	// Grab the pixels, 75 rows at a time.
	PixelGrabber grabber;
	for (int y = 0 ; y < ySize ; y += ROWS_GRABBED_AT_A_TIME)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Grabbing pixels: " +
			(y * 100 / ySize) + "% Done");
	    }

	    grabber = new PixelGrabber (saveBuffer, 0, y, xSize,
		    Math.min (ROWS_GRABBED_AT_A_TIME, xSize - y),
		    pixels, y * xSize, xSize);

	    try
	    {
		if (!grabber.grabPixels ())
		{
		    status.dispose ();
		    new Message ("Unable to get picture image");
		    return;
		}
	    }
	    catch (InterruptedException e)
	    {
		status.dispose ();
		new Message ("Unable to get picture image");
		return;
	    }
	}

	int match;
	for (int y = 0 ; y < ySize ; y++)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Making Colormap: " +
			(y * 100 / ySize) + "% Done");
	    }

	    for (int x = 0 ; x < xSize ; x++)
	    {
		int pixel = pixels [y * xSize + x] & 0xffffff;
		for (match = 0 ; match < numColours ; match++)
		    if (pixel == colourMap [match])
			break;
		if (match > 255)
		{
		    indexedPixels = null;
		    // Call 24 bit BMP mapper
		    write24BitBMP (pixels, xSize, ySize, fileName);
		    if (status != null)
		    {
			status.dispose ();
		    }
		    return;
		}
		indexedPixels [y * xSize + x] = (byte) match;
		if (match == numColours)
		{
		    colourMap [numColours++] = pixel;
		}
	    }
	} // for (y)

	// Write out 1, 4 or 8 bit per pixel BMP
	pixels = null;
	if (numColours <= 2)
	{
	    write1BitBMP (indexedPixels, colourMap, xSize, ySize, fileName);
	}
	else if (numColours <= 16)
	{
	    write4BitBMP (indexedPixels, colourMap, xSize, ySize, fileName);
	}
	else
	{
	    write8BitBMP (indexedPixels, colourMap, xSize, ySize, fileName);
	}

	if (status != null)
	{
	    status.dispose ();
	}
    } // saveToFile


    public int print (Graphics g, PageFormat format, int pageIndex)
    {
	if (pageIndex > 0)
	{
	    return Printable.NO_SUCH_PAGE;
	}

	int left = (int) format.getImageableX ();
	int top = (int) format.getImageableY ();
	int right = left + (int) format.getImageableWidth ();

	//
	// Draw a header  User-Name   Date
	//

	// Initial elements of the header
	DateFormat formatter = new SimpleDateFormat ("d MMM yyyy HH:mm:ss");
	formatter.setTimeZone (TimeZone.getDefault ());
	String dateString = formatter.format (new Date ());
	String userName = System.getProperty ("user.name");

	Font headerFont = new Font ("SansSerif", Font.BOLD, 12);
	FontMetrics fm = componentObj.getFontMetrics (headerFont);
	g.setColor (Color.black);
	g.setFont (headerFont);
	if (userName.length () != 0)
	{
	    g.drawString (userName, left + 2, top + fm.getHeight () + 2);
	}
	g.drawString (dateString, right - 2 - fm.stringWidth (dateString),
		top + fm.getHeight () + 2);

	// Now draw the grid
	int ty = 3 * fm.getHeight () + top;
	if (((int) format.getImageableWidth () >
		    xSize + 2 * savePrintObj.getMargin ()) ||
		((int) format.getImageableHeight () >
		    ySize + 3 * fm.getHeight () + 2 * savePrintObj.getMargin ()))
	{
	    g.translate (left, ty);
	    savePrintObj.drawWindowToGraphics (g, (int) format.getImageableWidth (),
		    (int) format.getImageableHeight () - 3 * fm.getHeight ());
	    g.translate (left, -ty);
	}
	else
	{
	    int tx = ((int) format.getImageableWidth () - xSize) / 2 + left;
	    g.translate (tx, ty);
	    savePrintObj.drawWindowToGraphics (g);
	    g.translate (-tx, -ty);
	}

	return Printable.PAGE_EXISTS;
    } // print method


    /**
     * Writes a 1-bit deep BMP image to a file.
     */
    private void write1BitBMP (byte[] pixels, int[] colourMap,
	    int width, int height, String fileName)
    {
	long lastStatusTime = 0;

	status.setMessage ("Writing 1 bit BMP");

	// Calculate the size of the picture.
	int padding = (4 - (((width + 7) / 8) % 4)) % 4;
	int imageSize = ((width + 7) / 8 + padding) * height;
	byte[] picture = new byte [imageSize];

	int ptr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Converting to BMP: " + (y * 100 / height) +
			"% Done");
	    }

	    for (int x = 0 ; x < width ; x++)
	    {
		int pixel = pixels [(height - 1 - y) * width + x];
		picture [ptr] |= pixel << (7 - (x % 8));
		if (((x % 8) == 7) || (x == width - 1))
		    ptr++;
	    }
	    for (int cnt = 0 ; cnt < padding ; cnt++)
	    {
		picture [ptr++] = 0;
	    }
	} // for (y)


	// Write the file out.
	writeBMPFile (fileName, imageSize, 2, width, height,
		1, BI_RGB, colourMap, picture);
    } // write1BitBMP (byte[], int[], int, int, String)


    /**
     * Writes a 24-bit deep BMP image to a file.
     */
    private void write24BitBMP (int[] pixels, int width,
	    int height, String fileName)
    {
	long lastStatusTime = 0;

	status.setMessage ("Writing 24 bit BMP");

	// Calculate the size of the picture.
	int padding = (4 - ((width * 3) % 4)) % 4;
	int imageSize = (width * 3 + padding) * height;
	byte[] picture = new byte [imageSize];

	int ptr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Converting to BMP: " + (y * 100 / height) +
			"% Done");
	    }

	    for (int x = 0 ; x < width ; x++)
	    {
		int pixel = pixels [(height - 1 - y) * width + x];
		picture [ptr++] = (byte) (pixel & 0xff);
		picture [ptr++] = (byte) ((pixel >> 8) & 0xff);
		picture [ptr++] = (byte) ((pixel >> 16) & 0xff);
	    }
	    for (int cnt = 0 ; cnt < padding ; cnt++)
	    {
		picture [ptr++] = 0;
	    }
	} // for (y)


	// Write the file out.
	writeBMPFile (fileName, imageSize, 0, width, height,
		24, BI_RGB, null, picture);
    } // write24BitBMP (int[], int, int, String)


    /**
     * Writes a 4-bit deep BMP image to a file.
     */
    private void write4BitBMP (byte[] pixels, int[] colourMap,
	    int width, int height, String fileName)
    {
	int bitShift[] = {4, 0};
	long lastStatusTime = 0;

	status.setMessage ("Writing 4 bit BMP");

	// Calculate the size of the picture.
	int padding = (4 - (((width + 1) / 2) % 4)) % 4;
	int imageSize = ((width + 1) / 2 + padding) * height;
	byte[] picture = new byte [imageSize];

	int ptr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Converting to BMP: " + (y * 100 / height) +
			"% Done");
	    }

	    for (int x = 0 ; x < width ; x++)
	    {
		int pixel = pixels [(height - 1 - y) * width + x];
		picture [ptr] |= pixel << bitShift [x % 2];
		if (((x % 2) == 1) || (x == width - 1))
		    ptr++;
	    }
	    for (int cnt = 0 ; cnt < padding ; cnt++)
	    {
		picture [ptr++] = 0;
	    }
	} // for (y)


	// Compress the BMP image using RLE4
	status.setMessage ("Compressing the bitmap");
	byte[] compressed = new byte [imageSize];
	int byteWidth = width / 2 + padding;
	int compressedPtr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    int startY = y;

	    // Okay, let's check the rest of the line.
	    int x = 0;
	    while (x < (width + 1) / 2)
	    {
		int startX = x;

		// Look for three "identicals" in a row.
		boolean foundIdenticals = false;
		while (!foundIdenticals && (x < width - 4))
		{
		    int loc = y * byteWidth + x;
		    if ((picture [loc] == picture [loc + 1]) &&
			    (picture [loc + 1] == picture [loc + 2]))
		    {
			foundIdenticals = true;
			break;
		    }
		    x++;
		}

		// If we didn't find any identical, use absolute to end of line.
		if (!foundIdenticals)
		    x = (width + 1) / 2;

		while (x - startX > 2)
		{
		    // If the compressed file is not much smaller than the
		    // uncompressed version, write out the uncompressed
		    // version.
		    if (compressedPtr + 300 > imageSize)
		    {
			// Write the uncompressed file out.
			writeBMPFile (fileName, imageSize, 16, width, height,
				4, BI_RGB, colourMap, picture);
			return;
		    }

		    int size = Math.min (x - startX, 127);
		    compressed [compressedPtr++] = 0;
		    compressed [compressedPtr++] = (byte) (size * 2);
		    int picPtr = y * byteWidth + startX;
		    for (int cnt = 0 ; cnt < size ; cnt++)
		    {
			compressed [compressedPtr++] = picture [picPtr + cnt];
		    }
		    if ((size % 2) == 1)
			compressed [compressedPtr++] = 0;
		    startX += size;
		}
		x = startX;

		if (x == width)
		    break;

		// Look for "identicals".
		byte pixel = picture [y * byteWidth + x];
		boolean identical = true;
		x++;
		while (identical && (x < (width + 1) / 2))
		{
		    if (picture [y * byteWidth + x] != pixel)
		    {
			identical = false;
			break;
		    }
		    x++;
		}

		while (x != startX)
		{
		    // If the compressed file is not much smaller than the
		    // uncompressed version, write out the uncompressed
		    // version.
		    if (compressedPtr + 300 > imageSize)
		    {
			// Write the uncompressed file out.
			writeBMPFile (fileName, imageSize, 16, width, height,
				4, BI_RGB, colourMap, picture);
			return;
		    }

		    int size = Math.min (x - startX, 127);
		    compressed [compressedPtr++] = (byte) (size * 2);
		    compressed [compressedPtr++] = pixel;
		    startX += size;
		}
	    } // for (x)

	    // Write end of line marker.
	    compressed [compressedPtr++] = 0;
	    compressed [compressedPtr++] = 0;
	} // for (y)


	// Write end of bitmap marker.
	compressed [compressedPtr++] = 0;
	compressed [compressedPtr++] = 1;

	writeBMPFile (fileName, compressedPtr, 16, width, height,
		4, BI_COMPRESSED_RLE4, colourMap, compressed);
    } // write4BitBMP (byte[], int[], int, int, String)


    /**
     * Writes a 8-bit deep BMP image to a file.
     */
    private void write8BitBMP (byte[] pixels, int[] colourMap,
	    int width, int height, String fileName)
    {
	long lastStatusTime = 0;

	status.setMessage ("Writing 8 bit BMP");

	// Calculate the size of the picture.
	int padding = (4 - (width % 4)) % 4;
	int imageSize = (width + padding) * height;
	byte[] picture = new byte [imageSize];

	int ptr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    // Change the status message.
	    if (System.currentTimeMillis () - lastStatusTime > 1000)
	    {
		lastStatusTime = System.currentTimeMillis ();
		status.setMessage ("Converting to BMP: " + (y * 100 / height) +
			"% Done");
	    }

	    for (int x = 0 ; x < width ; x++)
	    {
		picture [ptr++] |= pixels [(height - 1 - y) * width + x];
	    }
	    for (int cnt = 0 ; cnt < padding ; cnt++)
	    {
		picture [ptr++] = 0;
	    }
	} // for (y)


	// Compress the BMP image using RLE8
	status.setMessage ("Compressing the bitmap");
	byte[] compressed = new byte [imageSize];
	int byteWidth = width + padding;
	int compressedPtr = 0;
	for (int y = 0 ; y < height ; y++)
	{
	    int startY = y;

	    // Okay, let's check the rest of the line.
	    int x = 0;
	    while (x < width)
	    {
		int startX = x;

		// Look for three "identicals" in a row.
		boolean foundIdenticals = false;
		while (!foundIdenticals && (x < width - 4))
		{
		    int loc = y * byteWidth + x;
		    if ((picture [loc] == picture [loc + 1]) &&
			    (picture [loc + 1] == picture [loc + 2]))
		    {
			foundIdenticals = true;
			break;
		    }
		    x++;
		}

		// If we didn't find any identical, use absolute to end of line.
		if (!foundIdenticals)
		    x = width;

		while (x - startX > 2)
		{
		    // If the compressed file is not much smaller than the
		    // uncompressed version, write out the uncompressed
		    // version.
		    if (compressedPtr + 300 > imageSize)
		    {
			// Write the uncompressed file out.
			writeBMPFile (fileName, imageSize, 256, width, height,
				8, BI_RGB, colourMap, picture);
			return;
		    }

		    int size = Math.min (x - startX, 255);
		    compressed [compressedPtr++] = 0;
		    compressed [compressedPtr++] = (byte) size;
		    int picPtr = y * byteWidth + startX;
		    for (int cnt = 0 ; cnt < size ; cnt++)
		    {
			compressed [compressedPtr++] = picture [picPtr + cnt];
		    }
		    if ((size % 2) == 1)
			compressed [compressedPtr++] = 0;
		    startX += size;
		}
		x = startX;

		if (x == width)
		    break;

		// Look for "identicals".
		byte pixel = picture [y * byteWidth + x];
		boolean identical = true;
		x++;
		while (identical && (x < width))
		{
		    if (picture [y * byteWidth + x] != pixel)
		    {
			identical = false;
			break;
		    }
		    x++;
		}

		while (x != startX)
		{
		    // If the compressed file is not much smaller than the
		    // uncompressed version, write out the uncompressed
		    // version.
		    if (compressedPtr + 300 > imageSize)
		    {
			// Write the uncompressed file out.
			writeBMPFile (fileName, imageSize, 256, width, height,
				8, BI_RGB, colourMap, picture);
			return;
		    }

		    int size = Math.min (x - startX, 255);
		    compressed [compressedPtr++] = (byte) size;
		    compressed [compressedPtr++] = pixel;
		    startX += size;
		}
	    } // for (x)

	    // Write end of line marker.
	    compressed [compressedPtr++] = 0;
	    compressed [compressedPtr++] = 0;
	} // for (y)


	// Write end of bitmap marker.
	compressed [compressedPtr++] = 0;
	compressed [compressedPtr++] = 1;

	writeBMPFile (fileName, compressedPtr, 256, width, height,
		8, BI_COMPRESSED_RLE8, colourMap, compressed);
    } // write8BitBMP (byte[], int[], int, int, String)


    /**
     * Writes a BMP file header.
     */
    private void writeBMPFile (String fileName, int imageSize,
	    int paletteEntries, int width, int height, int bitCount,
	    int compressionType, int[] colourMap, byte[] buffer)
    {
	status.setMessage ("Writing image");

	try
	{
	    out = new DataOutputStream (new FileOutputStream (fileName));

	    // Writing header
	    writeShort (0x4d42);                                                    // bfType
	    writeInt (imageSize + 54 + paletteEntries * 4); // bfSize
	    writeShort (0);                                                                 // bfReserved1
	    writeShort (0);                                                                 // bfReserved2
	    writeInt (54 + paletteEntries * 4);                             // bfOffBits

	    writeInt (40);                                                                  // biSize
	    writeInt (width);                                                               // biWidth
	    writeInt (height);                                                              // biHeight
	    writeShort (1);                                                                 // biPlanes
	    writeShort (bitCount);                                                  // biBitCount
	    writeInt (compressionType);                                             // biCompression
	    writeInt (imageSize);                                                   // biSizeImage
	    writeInt (2835);                                                                // biXPelsPerMeter
	    writeInt (2835);                                                                // biYPelsPerMeter
	    writeInt (paletteEntries);                                              // biClrUsed
	    writeInt (paletteEntries);                                              // biClrImportant

	    // Write palette
	    for (int colours = 0 ; colours < paletteEntries ; colours++)
	    {
		int colour = colourMap [colours];

		out.writeByte (colour & 0xff);                          // Blue
		out.writeByte ((colour >> 8) & 0xff);           // Green
		out.writeByte ((colour >> 16) & 0xff);  // Red
		out.writeByte (0);
	    }

	    // Writing image
	    out.write (buffer, 0, imageSize);

	    out.close ();

	    out = null;
	}
	catch (IOException e)
	{
	}
	finally
	{
	    if (out != null)
	    {
		try
		{
		    out.close ();
		    out = null;
		}
		catch (IOException e)
		{
		}
	    }
	}
    } // WriteBMPFile ()


    /**
     * Writes out a 4-byte int with the correct "endian-ness".
     */
    private void writeInt (int number)
    {
	try
	{
	    out.writeByte (number & 0xFF);
	    out.writeByte ((number >> 8) & 0xFF);
	    out.writeByte ((number >> 16) & 0xFF);
	    out.writeByte ((number >> 24) & 0xFF);
	}

	catch (IOException e)
	{
	}
    } // writeShort (short)


    /**
     * Writes out a 2-byte int with the correct "endian-ness".
     */
    private void writeShort (int number)
    {
	try
	{
	    out.writeByte (number & 0xFF);
	    out.writeByte ((number >> 8) & 0xFF);
	}
	catch (IOException e)
	{
	}
    } // writeShort (short)


    // This is an inner class for use by PaintBugWindow class
    class Status
    {
	public Status (String windowTitle, String message)
	{
	} // Status constructor


	public void setMessage (String windowTitle)
	{
	} // setMessage method


	public void dispose ()
	{
	} // dispose method
    } // Status member class


    // This is an inner class for use by PaintBugWindow class
    class Message
    {
	public Message (String message)
	{
	} // Message constructor
    } // Message member class
} // SavePrint class
