// The "VisibleHanoi" class.
package hsa;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
//import java.util.*;

public class VisibleHanoi extends Frame
    implements ActionListener, AdjustmentListener
{
    // Constants
    static final int DEFAULT_XSIZE = 500;
    static final int DEFAULT_YSIZE = 300;

    static final int INIT_SLIDER_POS = 50;

    // Fields
    int xSize, ySize;
    int delayTime = calculateDelayTimeFromSlider (INIT_SLIDER_POS);

    // Components
    WindowCanvas canvas;                // The drawing surface
    Button saveButton, printButton; // The save and quit buttons
    Scrollbar scrollBar;            // The scroll bar to control the speed

    public VisibleHanoi (int numDisks)
    {
	super ("Towers of Hanio");

	xSize = DEFAULT_XSIZE;
	ySize = DEFAULT_YSIZE;
	canvas = new WindowCanvas (xSize, ySize, numDisks);

	// Add code to close the window when the user presses close button.
	addWindowListener (new WindowCloser ());

	saveButton = new Button ("Save");
	printButton = new Button ("Print");
	scrollBar =
	    new Scrollbar (Scrollbar.HORIZONTAL, INIT_SLIDER_POS, 0, 0, 100);

	// Add code to react to buttons when the user presses print/save
	saveButton.addActionListener (this);
	printButton.addActionListener (this);

	// Add code to react to the slider
	scrollBar.addAdjustmentListener (this);

	// Lay out the components

	// From the inside, lay out the scroll bar and its labels
	Panel scrollPanel = new Panel ();
	Label slower = new Label ("Slower", Label.RIGHT);
	Label faster = new Label ("Faster", Label.LEFT);
	Label setDelay = new Label ("Set Speed", Label.CENTER);
	Font labelFont = new Font ("SansSerif", Font.PLAIN, 10);
	slower.setFont (labelFont);
	faster.setFont (labelFont);
	setDelay.setFont (labelFont);
	scrollPanel.setLayout (new BorderLayout ());
	scrollPanel.add (slower, "West");
	scrollPanel.add (faster, "East");
	scrollPanel.add (setDelay, "North");
	scrollPanel.add (scrollBar, "Center");

	// Now lay out the buttons and the scroll bar
	Panel controlPanel = new Panel ();
	GridBagLayout gb = new GridBagLayout ();
	GridBagConstraints cn = new GridBagConstraints ();
	Label label1 = new Label ("   ");
	Label label2 = new Label ("   ");
	controlPanel.setBackground (Color.lightGray);
	controlPanel.setLayout (gb);

	// Add the controls.  The blank labels are to produce space
	// on the right and left of the controls.
	controlPanel.add (label1);
	controlPanel.add (saveButton);
	controlPanel.add (printButton);
	controlPanel.add (scrollPanel);
	controlPanel.add (label2);

	// Set some space around the windows.
	cn.insets = new Insets (4, 4, 4, 4);
	gb.setConstraints (saveButton, cn);
	gb.setConstraints (printButton, cn);

	// Set the insets for the scroll bar panel.  Let is expand as
	// the window expands.
	cn.insets = new Insets (0, 4, 4, 4);
	cn.fill = GridBagConstraints.HORIZONTAL;
	cn.weightx = 1;
	gb.setConstraints (scrollPanel, cn);

	// Add the controls panel above
	add (controlPanel, "North");
	// Add the canvas below
	add (canvas, "South");

	pack ();

	// Move to the left side
	Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
	setLocation (screen.width - getSize ().width, 0);

	show ();
    } // VisibleHanoi (int) constructor


    public void setSpeed (int speed)
    {
	int value = Math.min (Math.max (speed, 0), 100);
	scrollBar.setValue (value);
	delayTime = calculateDelayTimeFromSlider (value);
    } // setSpeed method


    public void moveTop (int fromPost, int toPost)
    {
	canvas.moveTop (fromPost - 1, toPost - 1);
    } // moveBug


    public void actionPerformed (ActionEvent evt)
    {
	if (evt.getSource () == saveButton)
	{
	    // Get the file name to save as.
	    FileDialog fd = new FileDialog (this, "Save PaintBug Window",
		    FileDialog.SAVE);
	    fd.setFile ("PaintBug.bmp");
	    fd.show ();

	    if (fd.getFile () == null)
	    {
		return;
	    }

	    String fileName = fd.getDirectory () + fd.getFile ();
	    // Handle bug if fileName doesn't exist, Java appends ".*.*"
	    if (fileName.indexOf (".*.*") != -1)
	    {
		fileName = fileName.substring (0, fileName.length () - 4);
	    }

	    // Save to the file.
	    canvas.savePrint.saveToFile (fileName);
	}
	else if (evt.getSource () == printButton)
	{
	    PrinterJob printerJob = PrinterJob.getPrinterJob ();
	    Book book = new Book ();
	    book.append (canvas.savePrint, new PageFormat ());
	    printerJob.setPageable (book);
	    if (!printerJob.printDialog ())
	    {
		return;
	    }

	    try
	    {
		printerJob.print ();
	    }
	    catch (PrinterException exception)
	    {
		System.err.println ("Printing error: " + exception);
	    }
	}
    } // actionPerformed method


    public void adjustmentValueChanged (AdjustmentEvent evt)
    {
	delayTime = calculateDelayTimeFromSlider (evt.getValue ());
    } // adjustmentValueChanged method


    int calculateDelayTimeFromSlider (int value)
    {
	int delay;

	if (value <= 10)
	{
	    delay = 75 * 10 + 15 * 50 + (10 - value) * 250;
	}
	else if (value < 25)
	{
	    delay = 75 * 10 + (25 - value) * 50;
	}
	else
	{
	    delay = (100 - value) * 10;
	}
	delay /= 20;

	return delay;
    } // calculateDelayTimeFromSlider


    // This is an inner class for use by PaintBugWindow class
    // It handles all the drawing of the actual grid surface.  (i.e.
    // it excludes all the controls.)
    class WindowCanvas extends Canvas implements DrawGraphics
    {
	// Constants
	static final int BASE_THICKNESS = 30;
	static final int BASE_MARGIN = 15;
	static final int POLE_THICKNESS = 10;
	static final int POLE_TOP = 70;
	static final int MIN_DISK_WIDTH = 25;
	static final int DISK_THICKNESS = 18;
	static final int DISK_MOVE_TOP = 40;

	// Fields
	Font poleLabelFont, diskLabelFont;
	FontMetrics poleLabelFM, diskLabelFM;
	int poleLabelWidth, poleLabelHeight;
	int diskLabelWidth, diskLabelHeight;
	String[] poleLabels = {"1", "2", "3"};
	String[] diskLabels = {"a", "b", "c", "d", "e", "f", "g", "h"};
	int[] poleX;
	int[] diskRadius, diskY;
	int[] [] posts;         // The disks on the posts

	SavePrint savePrint;    // Used to save or print graphics
	int xSize, ySize;       // Size of drawing surface
	Image offscreen;        // Surface used to compose final pic

	public WindowCanvas (int xSize, int ySize, int disks)
	{
	    int pos = 0;
	    int diskDiff;

	    posts = new int [3] [9];
	    for (int counter = disks ; counter > 0 ; counter--)
	    {
		posts [0] [pos++] = counter;
	    }
	    poleLabelFont = new Font ("Serif", Font.PLAIN, 12);
	    poleLabelFM = getFontMetrics (poleLabelFont);
	    poleLabelWidth = poleLabelFM.stringWidth ("0");
	    poleLabelHeight = poleLabelFM.getAscent ();
	    this.xSize = xSize;
	    this.ySize = ySize;
	    diskLabelFont = new Font ("SanSerif", Font.BOLD, 10);
	    diskLabelFM = getFontMetrics (diskLabelFont);
	    diskLabelWidth = diskLabelFM.stringWidth ("m");
	    diskLabelHeight = diskLabelFM.getAscent ();

	    setSize (xSize, ySize);

	    int sep = (xSize - 4 * BASE_MARGIN - 3 * POLE_THICKNESS) / 6;

	    poleX = new int [3];
	    poleX [0] = BASE_MARGIN * 2 + sep;
	    poleX [1] = poleX [0] + POLE_THICKNESS + 2 * sep;
	    poleX [2] = poleX [1] + POLE_THICKNESS + 2 * sep;

	    diskDiff = (sep - POLE_THICKNESS / 2 - MIN_DISK_WIDTH) / 7;
	    diskRadius = new int [8];
	    diskRadius [0] = MIN_DISK_WIDTH + POLE_THICKNESS / 2;
	    for (int disk = 1 ; disk < 8 ; disk++)
	    {
		diskRadius [disk] = diskRadius [disk - 1] + diskDiff;
	    } // for
	    diskY = new int [8];
	    diskY [0] = ySize - BASE_MARGIN - BASE_THICKNESS - DISK_THICKNESS - 3;
	    for (int disk = 1 ; disk < 8 ; disk++)
	    {
		diskY [disk] = diskY [disk - 1] - DISK_THICKNESS - 3;
	    } // for

	    savePrint = new SavePrint (this, this, xSize, ySize);
	} // WindowCanvas (int, int) constructor


	public void addNotify ()
	{
	    super.addNotify ();
	    offscreen = createImage (xSize, ySize);
	    drawBackgroundToOffscreen ();
	} // addNotify method


	public void paint (Graphics g)
	{
	    update (g);
	}


	public void update (Graphics g)
	{
	    // Copy offscreen bitmap to the screen.
	    Rectangle r = g.getClipBounds ();
	    g.drawImage (offscreen, r.x, r.y, r.x + r.width,
		    r.y + r.width, r.x, r.y, r.x + r.width,
		    r.y + r.width, null, null);
	} // update method


	public void moveTop (int fromPost, int toPost)
	{
	    int diskNo, fromPosition, toPosition;
	    int pos;
	    Graphics g = offscreen.getGraphics ();

	    // What is top on this pole
	    pos = 8;
	    while (posts [fromPost] [pos] == 0)
	    {
		pos--;
	    }
	    fromPosition = pos;
	    diskNo = posts [fromPost] [pos];
	    pos = 8;
	    while ((pos >= 0) && (posts [toPost] [pos] == 0))
	    {
		pos--;
	    }
	    toPosition = pos + 1;

	    posts [fromPost] [fromPosition] = 0;

	    for (int y = diskY [fromPosition] ; y > DISK_MOVE_TOP ; y -= 3)
	    {
		drawBackgroundToOffscreen ();
		drawDisk (diskNo, poleX [fromPost], y, g);
		repaint ();
		delay ();
	    } // for
	    if (fromPost < toPost)
	    {
		for (int x = poleX [fromPost] ; x < poleX [toPost] ; x += 3)
		{
		    drawBackgroundToOffscreen ();
		    drawDisk (diskNo, x, DISK_MOVE_TOP, g);
		    repaint ();
		    delay ();
		} // for
	    }
	    else
	    {
		for (int x = poleX [fromPost] ; x > poleX [toPost] ; x -= 3)
		{
		    drawBackgroundToOffscreen ();
		    drawDisk (diskNo, x, DISK_MOVE_TOP, g);
		    repaint ();
		    delay ();
		} // for
	    }
	    for (int y = DISK_MOVE_TOP ; y < diskY [toPosition] ; y += 3)
	    {
		drawBackgroundToOffscreen ();
		drawDisk (diskNo, poleX [toPost], y, g);
		repaint ();
		delay ();
	    } // for
	    posts [toPost] [toPosition] = diskNo;
	} // moveBug


	// Used for saving and printing.  Keep coordinated with the update
	// method above.
	public void drawWindowToGraphics (Graphics g)
	{
	    g.drawImage (offscreen, 0, 0, null);
	} // drawWindowToGraphics method


	public void drawWindowToGraphics (Graphics g, int width, int height)
	{
	    g.drawImage (offscreen, 0, 0, null);
	} // drawWindowToGraphics method


	public int getMargin ()
	{
	    return 0;
	} // getMargin method


	private void delay ()
	{
	    try
	    {
		Thread.sleep (delayTime);
	    }
	    catch (InterruptedException e)
	    {
		;
	    }
	} // delay method


	// Draw a disk. x represents the left edge of the pole that
	// the disk is upon.
	private void drawDisk (int diskNo, int x, int y, Graphics g)
	{
	    int radius = diskRadius [diskNo - 1];

	    // Draw green disk
	    g.setColor (Color.green);
	    g.fillRoundRect (x + POLE_THICKNESS / 2 - radius, y,
		    2 * radius, DISK_THICKNESS, 10, 10);
	    // Draw outline
	    g.setColor (Color.black);
	    g.drawRoundRect (x + POLE_THICKNESS / 2 - radius, y,
		    2 * radius, DISK_THICKNESS, 10, 10);
	    // Draw labelling letter
	    g.setColor (Color.black);
	    g.setFont (diskLabelFont);
	    g.drawString (diskLabels [diskNo - 1],
		    x + (POLE_THICKNESS - diskLabelFM.stringWidth (diskLabels [diskNo - 1])) / 2,
		    y + DISK_THICKNESS - (DISK_THICKNESS - diskLabelHeight) / 2);
	} // drawDisk


	private void drawBackgroundToOffscreen ()
	{
	    Graphics g = offscreen.getGraphics ();

	    g.setColor (Color.white);
	    g.fillRect (0, 0, xSize, ySize);
	    g.setColor (Color.red);
	    for (int post = 0 ; post < 3 ; post++)
	    {
		g.fillRoundRect (poleX [post], POLE_TOP, POLE_THICKNESS,
			ySize - POLE_TOP - BASE_MARGIN, 10, 10);
	    }

	    // Draw the base
	    g.setColor (Color.darkGray);
	    g.fillRoundRect (BASE_MARGIN,
		    ySize - BASE_MARGIN - BASE_THICKNESS,
		    xSize - 2 * BASE_MARGIN, BASE_THICKNESS, 10, 10);

	    // Label the poles
	    g.setFont (poleLabelFont);
	    g.setColor (Color.white);
	    for (int pole = 0 ; pole < 3 ; pole++)
	    {
		g.drawString (poleLabels [pole],
			poleX [pole] + (POLE_THICKNESS - poleLabelWidth) / 2,
			ySize - BASE_MARGIN - (BASE_THICKNESS - poleLabelWidth) / 2);
	    }

	    // Draw the disks
	    for (int post = 0 ; post < 3 ; post++)
	    {
		int pos = 0;
		while (posts [post] [pos] != 0)
		{
		    drawDisk (posts [post] [pos],
			    poleX [post], diskY [pos], g);
		    pos++;
		} // while
	    } // for
	} // drawBackgroundToOffscreen ();
    } // WindowCanvas class


    // This is an inner class for use by PaintBugWindow class
    class WindowCloser extends WindowAdapter
    {
	public void windowClosing (WindowEvent e)
	{
	    e.getWindow ().dispose ();
	    System.exit (0);
	} // windowClosing method
    } // WindowCloser member class
} // VisibleHanoi class


