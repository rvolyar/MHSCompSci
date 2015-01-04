package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleCanvasGraphics class implements the actual drawing surface
 * of a Console object.  It also creates an offscreen image so that the
 * drawing surface can refresh itself when it needs to.
 * <p>
 * The interface to the ConsoleCanvasGraphics class consists pretty much
 * of methods for drawing on the surface.  The canvas contains few
 * variables to control the general text handling except that it handles
 * the cursor entirely on its own.
 * <p>
 * Note that most drawing methods in this class are synchronized.
 * This is because we don't want to worry about messing up the cursor.
 * When an object is drawn to the onscreen Graphics context, the cursor
 * is toggled off if necessary and then when the drawing is finished,
 * it's toggled back on.  If the thread that controls the cursor
 * blinking on and off woke up and tried to toggle the cursor in the
 * middle of the draw operations, the drawing could get messed up.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *                      http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */

import java.awt.*;
import java.awt.image.*;

class ConsoleCanvasGraphics extends ConsoleCanvas implements DrawGraphics
{
    protected static final int NO_SCALING = -1;
    /**
     * Variables for controlling the consoleCanvas pane.
     */
    protected Image offscreenImage;
    protected boolean inXORMode = false;
    protected Color xorColor;
    protected int cursorRow, cursorCol;
    /**
     * Creates the console canvas given the size of the screen in rows and
     * columns and font size.
     *
     * @param parent The parent Console class.
     * @param rows The height of the canvas in rows of text.
     * @param columns The width of the canvas in columns of text.
     * @param fontSize The size of the font in the canvas.
     */
    public ConsoleCanvasGraphics (ConsoleParent parent, int rows,
	    int columns, int fontSize)
    {
	super (parent, rows, columns, fontSize);
	cursorRow = 1;
	cursorCol = 1;

	savePrint = new SavePrint (this, this, numXPixels + 2 * MARGIN,
		numYPixels + 2 * MARGIN);
    } // Constructor - ConsoleCanvas (Console, int, int, int)


    /**
     * Overrides addNotify in order to set up the device dependent features
     * once the canvas has actually been created.
     */
    public void addNotify ()
    {
	super.addNotify ();

	// Create the offscreen bitmap
	offscreenImage = createImage (numXPixels, numYPixels);
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	offscreenGraphics.setFont (font);

	// Clear the screen to white
	offscreenGraphics.setColor (Color.white);
	offscreenGraphics.fillRect (0, 0, numXPixels, numYPixels);
    } // addNotify (void)


    /**
     * Clears a rectangle on the console canvas.
     */
    public synchronized void clearRect (int x, int y, int width,
	    int height)
    {
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// First clear the rectangle on the offscreen image.
	offscreenGraphics.clearRect (x, y, width, height);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then clear the rectangle on the onscreen image.
	if (cursorVisible || !hasFocus)
	    toggleCursor ();
	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.clearRect (x, y, width, height);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // clearRect (int, int, int, int)


    /**
     * Clears the entire console canvas to a specified colour
     */
    public synchronized void clearScreen (Color bgColor)
    {
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// Erase the offscreen bitmap.
	offscreenGraphics.setColor (bgColor);
	offscreenGraphics.fillRect (0, 0, numXPixels, numYPixels);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Erase the onscreen window.
	if (cursorVisible || !hasFocus)
	    toggleCursor ();
	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.setColor (bgColor);
	onscreenGraphics.fillRect (0, 0, numXPixels, numYPixels);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // clearScreen (Color)


    /**
     * Clears a rectangle on console canvas from the specified row and column
     * to the end of line
     */
    public synchronized void clearToEOL (int row, int col, Color bgColor)
    {
	int x = (col - 1) * fontWidth;
	int y = (row - 1) * fontHeight;
	int len = numXPixels - x;
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// First clear the rectangle on the offscreen image.
	offscreenGraphics.setColor (bgColor);
	offscreenGraphics.fillRect (x, y, len, fontHeight);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then clear the rectangle on the onscreen image.
	if (cursorVisible || !hasFocus)
	    toggleCursor ();
	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.setColor (bgColor);
	onscreenGraphics.fillRect (x, y, len, fontHeight);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // clearToEOL (int, int, Color)


    /**
     * Copies an area of the screen from (x, y) to (x + width, y + height) onto
     * the screen with top corner at (x + delta_x, y + delta_y).
     */
    public synchronized void copyArea (int x, int y, int width,
	    int height, int deltaX, int deltaY)
    {
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// First copy the area in the offscreen image.
	offscreenGraphics.copyArea (x, y, width, height, deltaX, deltaY);

	// Update the onscreen image from the offscreen image
	// We can't use copyArea because there may be windows in front
	// of the console obscuring the screen.
	// Copy offscreen image
	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.drawImage (offscreenImage, 0, 0, this);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // copyArea (int, int, int, int, int, int)


    /**
     * Draws a 3D rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void draw3DRect (int x, int y, int width,
	    int height, boolean raised, Color color)
    {
	// First draw the 3-D rect to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.draw3DRect (x, y, width, height, raised);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the 3-D rect to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.draw3DRect (x, y, width, height, raised);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // draw3DRect (int, int, int, int, boolean, Color)


    /**
     * Draws an arc on the screen from (x, y) to
     * (x + width, y + height) from startAngle to startAngle + arcAngle
     * in specified colour.
     */
    public synchronized void drawArc (int x, int y, int width,
	    int height, int startAngle, int arcAngle, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawArc (x, y, width, height, startAngle, arcAngle);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawArc (x, y, width, height, startAngle, arcAngle);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawArc (int, int, int, int, int, int, Color)


    /**
     * Draws an image at (x, y).
     */
    public synchronized void drawImage (Image img, int x, int y,
	    ImageObserver obs)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (Color.black);
	offscreenGraphics.drawImage (img, x, y, obs);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (Color.black);
	onscreenGraphics.drawImage (img, x, y, obs);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawImage


    /**
     * Draws a line from (x1, y1) to (x2, y2) in specified colour.
     */
    public synchronized void drawLine (int x1, int y1, int x2, int y2,
	    Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawLine (x1, y1, x2, y2);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawLine (x1, y1, x2, y2);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawLine (int, int, int, int, Color)


    /**
     * Draws an oval on the screen in the sqaure from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void drawOval (int x, int y, int width, int height,
	    Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawOval (x, y, width, height);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawOval (x, y, width, height);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawOval (int, int, int, int, Color)


    /**
     * Draws a polygon.
     */
    public synchronized void drawPolygon (int[] xPoints, int[] yPoints,
	    int nPoints, Color color)
    {
	// First draw the filled polygon to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawPolygon (xPoints, yPoints, nPoints);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the filled polgon to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawPolygon (xPoints, yPoints, nPoints);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawPolygon (int[], int[], int, Color)


    /**
     * Draws a rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void drawRect (int x, int y, int width, int height,
	    Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawRect (x, y, width, height);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawRect (x, y, width, height);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawRect (int, int, int, int, Color)


    /**
     * Draws a rounded rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void drawRoundRect (int x, int y, int width, int height,
	    int arcWidth, int arcHeight, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.drawRoundRect (x, y, width, height, arcWidth,
		arcHeight);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.drawRoundRect (x, y, width, height, arcWidth,
		arcHeight);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // drawRoundRect (int, int, int, int, int, int, Color)


    /**
     * Draws a line from (x1, y1) to (x2, y2) in specified colour.
     */
    public synchronized void drawString (String str, int x, int y,
	    Font font, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.setFont (font);
	offscreenGraphics.drawString (str, x, y);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.setFont (font);
	onscreenGraphics.drawString (str, x, y);

	if (cursorVisible)
	    toggleCursor ();
    } // drawLine (int, int, int, int, Color)


    /**
     * Draws the specified text to the screen at the specified row and column
     * using the specified foreground and background colours.
     */
    public synchronized void drawText (int row, int col, String text,
	    Color fgColor, Color bgColor)
    {
	int x = (col - 1) * fontWidth;
	int y = (row - 1) * fontHeight;
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// First draw it to the offscreen image.

	// Erase the area that the image will appear on.
	offscreenGraphics.setColor (bgColor);
	offscreenGraphics.fillRect (x, y, fontWidth * text.length (), fontHeight);

	// Draw the text
	offscreenGraphics.setColor (fgColor);
	offscreenGraphics.setFont (font);
	offscreenGraphics.drawString (text, x, y + fontHeight - fontBase);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	if (cursorVisible)
	    toggleCursor ();

	// Then draw the string to the onscreen image.

	// Erase the area that the image will appear on.
	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.setColor (bgColor);
	onscreenGraphics.fillRect (x, y, fontWidth * text.length (), fontHeight);

	// Draw the text
	onscreenGraphics.setColor (fgColor);
	onscreenGraphics.setFont (font);
	onscreenGraphics.drawString (text, x, y + fontHeight - fontBase);

	if (cursorVisible)
	    toggleCursor ();
    } // drawText (int, int, String, Color, Color)


    /**
     * This routine is used to implement the saving and printing.
     * The Graphics object passed in is a printing or saving surface.
     */
    public void drawWindowToGraphics (Graphics g)
    {
	g.translate (MARGIN, MARGIN);

	// Draw white margins
	g.setColor (Color.white);
	for (int cnt = 1 ; cnt <= MARGIN ; cnt++)
	{
	    g.drawRect (-cnt, -cnt,
		    numXPixels + 2 * cnt - 1, numYPixels + 2 * cnt - 1);
	}

	// Copy offscreen image
	g.drawImage (offscreenImage, 0, 0, this);

	g.translate (-MARGIN, -MARGIN);
    } // drawWindowToGraphics method


    public void drawWindowToGraphics (Graphics g, int pageWidth, int pageHeight)
    {
	int xSize, ySize;

	g.translate (MARGIN + 2, MARGIN + 2);

	if ((double) pageWidth / numXPixels < (double) pageHeight / numYPixels)
	{
	    // The printer page is constained by width
	    xSize = pageWidth - 2 * MARGIN - 4;
	    ySize = (int) ((double) xSize / numXPixels * numYPixels + 0.5);
	}
	else
	{
	    // The printer page is constained by height
	    ySize = pageHeight - 2 * MARGIN - 4;
	    xSize = (int) ((double) ySize / numYPixels * numXPixels + 0.5);
	}

	// Draw white margins
	g.setColor (Color.white);
	for (int cnt = 1 ; cnt <= MARGIN ; cnt++)
	{
	    g.drawRect (-cnt, -cnt,
		    xSize + 2 * cnt - 1, ySize + 2 * cnt - 1);
	}

	// Copy offscreen image
	g.drawImage (offscreenImage, 0, 0, xSize, ySize, this);

	g.translate (-MARGIN - 2, -MARGIN - 2);
    } // drawWindowToGraphics method


    public int getMargin ()
    {
	return MARGIN;
    } // getMargin method


    /**
     * Draws a filled 3D rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void fill3DRect (int x, int y, int width,
	    int height, boolean raised, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.fill3DRect (x, y, width, height, raised);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fill3DRect (x, y, width, height, raised);

	if (cursorVisible)
	    toggleCursor ();
    } // fill3DRect (int, int, int, int, boolean, Color)


    /**
     * Draws a filled arc on the screen from (x, y) to
     * (x + width, y + height) from startAngle to startAngle + arcAngle
     * in specified colour.
     */
    public synchronized void fillArc (int x, int y, int width,
	    int height, int startAngle, int arcAngle, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.setColor (color);
	offscreenGraphics.fillArc (x, y, width, height, startAngle, arcAngle);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fillArc (x, y, width, height, startAngle, arcAngle);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // fillArc (int, int, int, int, int, int, Color)


    /**
     * Draws a filled oval on the screen in the sqaure from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void fillOval (int x, int y, int width,
	    int height, Color color)
    {
	// First draw the filled oval to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.fillOval (x, y, width, height);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the filled oval to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fillOval (x, y, width, height);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // fillOval (int, int, int, int, Color)


    /**
     * Draws a filled polygon.
     */
    public synchronized void fillPolygon (int[] xPoints, int[] yPoints,
	    int nPoints, Color color)
    {
	// First draw the filled polygon to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.fillPolygon (xPoints, yPoints, nPoints);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the filled polgon to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fillPolygon (xPoints, yPoints, nPoints);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // fillPolygon (int[], int[], int, Color)


    /**
     * Draws a filled rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void fillRect (int x, int y, int width,
	    int height, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.fillRect (x, y, width, height);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fillRect (x, y, width, height);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // fillRect (int, int, int, int, Color)


    /**
     * Draws a filled rounded rectangle on the screen from (x, y) to
     * (x + width, y + height) in specified colour.
     */
    public synchronized void fillRoundRect (int x, int y, int width,
	    int height, int arcWidth, int arcHeight, Color color)
    {
	// First draw the line to the offscreen image.
	Graphics offscreenGraphics = getOffscreenGraphics (color);
	offscreenGraphics.fillRoundRect (x, y, width, height, arcWidth,
		arcHeight);

	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	// Then draw the line to the onscreen image.
	Graphics onscreenGraphics = getOnscreenGraphics (color);
	onscreenGraphics.fillRoundRect (x, y, width, height, arcWidth,
		arcHeight);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // fillRoundRect (int, int, int, int, int, int, Color)


    /**
     * Returns the current column number of the cursor.
     *
     * @return The current column number of the cursor.
     */
    public int getCurrentColumn ()
    {
	return cursorCol;
    } // getCurrentColumn (void)


    /**
     * Returns the current row number of the cursor.
     *
     * @return The current row number of the cursor.
     */
    public int getCurrentRow ()
    {
	return cursorRow;
    } // getCurrentColumn (void)


    /**
     * Returns the height of the console window in pixels.
     *
     * @return The height of the console window in pixels.
     */
    public int getDrawingAreaHeight ()
    {
	return numYPixels;
    } // int getDrawingAreaHeight (void)


    /**
     * Returns the Graphics object associated with the offscreen bitmap.
     * Sets the drawing mode and foreground colour appropriately.
     */
    protected Graphics getOffscreenGraphics (Color color)
    {
	Graphics offscreenGraphics = offscreenImage.getGraphics ();

	// First draw the line to the offscreen image.
	if (inXORMode)
	    offscreenGraphics.setXORMode (xorColor);
	offscreenGraphics.setColor (color);

	return (offscreenGraphics);
    } // getOffscreenGraphics (Color)


    /**
     * Returns the Graphics object associated with the ConsoleCanvas.
     * Turns off the cursor (if necessary), sets the drawing mode,
     * translates the coordinates to take into account the margins,
     * sets the foreground colour and clips the drawing to the drawing
     * area.
     */
    protected Graphics getOnscreenGraphics (Color color)
    {
	Graphics onscreenGraphics = getGraphics ();

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
	if (inXORMode)
	    onscreenGraphics.setXORMode (xorColor);
	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.setColor (color);
	onscreenGraphics.clipRect (0, 0, numXPixels, numYPixels);

	return (onscreenGraphics);
    } // getOnscreenGraphics (Color)


    /**
     * Returns the width of the console window in pixels.
     *
     * @return The width of the console window in pixels.
     */
    public int getDrawingAreaWidth ()
    {
	return numXPixels;
    } // int getDrawingAreaWidth (void)


    /**
     * Overrides the paint method to redraw the screen using doDraw
     */
    public void paint (Graphics g)
    {
	// Under OSX the entire screen is repaint, so don't wait.
	if (!macOSX)
	{
	    if (cursorVisible)
		toggleCursor ();
	}

	drawWindowToGraphics (g);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // paint (Graphics)


    /**
     * Prints the contents of the window on the printer.
     */
    // public void printContents ()
    // {
    //     ConsoleSavePrint savePrint =
    //         new ConsoleSavePrint (parentConsole, offscreenImage,
    //             ConsoleSavePrint.PRINT);
    //     savePrint.start ();
    // } // void printContents (void)
    //
    //
    // /**
    //  * Saves the contents of the window to a file.
    //  */
    // public void saveContents ()
    // {
    //     ConsoleSavePrint savePrint =
    //         new ConsoleSavePrint (parentConsole, offscreenImage,
    //             ConsoleSavePrint.SAVE);
    //     savePrint.start ();
    // } // void saveContents (void)


    /**
     * Scrolls up the entire ConsoleCanvas a single line.  The blank space at
     * the bottom is filled in the specified colour.
     */
    public synchronized void scrollUpALine (Color bgColor)
    {
	Graphics offscreenGraphics = offscreenImage.getGraphics ();
	Graphics onscreenGraphics = getGraphics ();

	// First scroll the offscreen image.

	// Scroll the screen up
	offscreenGraphics.copyArea (0, fontHeight, numXPixels,
		numYPixels - fontHeight, 0, -fontHeight);

	// Erase the last line
	offscreenGraphics.setColor (bgColor);
	offscreenGraphics.fillRect (0, numYPixels - fontHeight, numXPixels,
		fontHeight);

	// Then scroll the onscreen image.

	// Update the onscreen image from the offscreen image
	// We can't use copyArea because there may be windows in front
	// of the console obscuring the screen.
	// Copy offscreen image
	// MacOS X seems to have a problem.  Only repainting seems to work.
	if (macOSX)
	{
	    repaint ();
	    return;
	} // if (macOSX)

	onscreenGraphics.translate (MARGIN, MARGIN);
	onscreenGraphics.drawImage (offscreenImage, 0, 0, this);

	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // scrollUpALine (Color)


    /**
     * Sets the cursor to the specified row and column.
     */
    public synchronized void setCursorPos (int row, int col)
    {
	if (cursorVisible || !hasFocus)
	    toggleCursor ();
	cursorRow = row;
	cursorCol = col;
	if (cursorVisible || !hasFocus)
	    toggleCursor ();
    } // setCursorPos (int, int)


    /**
     * Sets the drawing mode for any graphics to "Paint".
     */
    public synchronized void setPaintMode ()
    {
	inXORMode = false;
    } // setPaintMode (void)


    /**
     * Sets the drawing mode for any graphics to "XOR".
     */
    public synchronized void setXORMode (Color xorColor)
    {
	inXORMode = true;
	this.xorColor = xorColor;
    } // setXORMode (Color)
} /* ConsoleCanvasGraphics class */
