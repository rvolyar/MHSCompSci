package hsa;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;

class PaintBugWindow extends Frame
    implements ActionListener, AdjustmentListener
{
    // Constants
    static final int DEFAULT_XSIZE = 400;
    static final int DEFAULT_YSIZE = 300;

    static final int INIT_SLIDER_POS = 50;

    static final int MAX_PAINTBUGS = 1000;

    // Fields
    int xSize, ySize;
    int delayTime = calculateDelayTimeFromSlider (INIT_SLIDER_POS);

    // Components
    WindowCanvas canvas;                // The drawing surface
    Button saveButton, printButton; // The save and quit buttons
    Scrollbar scrollBar;            // The scroll bar to control the speed

    public PaintBugWindow (boolean drawGrid)
    {
	this (DEFAULT_XSIZE, DEFAULT_YSIZE, drawGrid);
    } // PaintBugWindow (void) constructor


    public PaintBugWindow (int newXSize, int newYSize, boolean drawGrid)
    {
	super ("Paint Bugs");

	xSize = newXSize;
	ySize = newYSize;
	canvas = new WindowCanvas (xSize, ySize, drawGrid);

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
	setLocation (screen.width - getWidth (), 0);

	show ();
    } // PaintBugWindow (int, int) constructor


    public int getXSize ()
    {
	return xSize;
    } // getRows method


    public int getYSize ()
    {
	return ySize;
    } // getCols method


    public void setSpeed (int speed)
    {
	int value = Math.min (Math.max (speed, 0), 100);
	scrollBar.setValue (value);
	delayTime = calculateDelayTimeFromSlider (value);
    } // setSpeed method


    public Thread moveBug (PaintBug bug, double xPos, double yPos,
	    double direction, double distance, Color color, int trailWidth,
	    boolean trailVisible, String label)
    {
	// We start a new thread that will slide the bug.
	// We then pause until the new thread synchronizes the bug (getting
	// the bugs lock).
	PaintBugThread t = new PaintBugThread (bug, canvas, xPos, yPos,
		direction, distance, color, trailWidth, trailVisible);
	t.start ();
	return t;
    } // moveBug


    public Thread rotateBug (PaintBug bug, double xPos, double yPos,
	    double direction, double changeAngle, Color color)
    {
	// We start a new thread that will slide the bug.
	// We then pause until the new thread synchronizes the bug (getting
	// the bugs lock).
	PaintBugThread t = new PaintBugThread (bug, canvas, xPos, yPos,
		direction, changeAngle, color);
	t.start ();
	return t;
    } // hideBug method


    public void showBug (PaintBug bug, double xPos, double yPos,
	    double direction, Color color, String label)
    {
	canvas.showBug (bug, xPos, yPos, direction, color, label);
    } // showBug method


    public void hideBug (PaintBug bug, double xPos, double yPos,
	    double direction, Color color, String label)
    {
	canvas.hideBug (bug, xPos, yPos, direction, color, label);
    } // hideBug method


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
	static final int LEFT_TOP_MARGIN = 5;
	static final int RIGHT_BOTTOM_MARGIN = 15;
	static final int TEXT_MARGIN = 5;

	// Fields
	Font bugLabelFont;
	Font gridLabelFont;
	FontMetrics bugLabelFM, gridLabelFM;
	boolean drawGrid;               // Draw a grid?
	int textWidth, textHeight;      // Height and width of grid label
	int labelWidth, labelHeight;    // Height and width of bug label
	// The official size of the drawing surface (no margins)
	int xSize, ySize;
	// The actual size of the drawing surface (including margins)
	int canvasWidth, canvasHeight;
	// The defacto origin (includes margins and text)
	int left, top, textLeft, textTop;
	Image offscreenTrails;          // Surface used to draw trails
	Image offscreen;                // Surface used to compose final pic
	SavePrint savePrint;

	// The list of Bugs
	PaintBug[] bugs = new PaintBug [MAX_PAINTBUGS];
	double[] bugX = new double [MAX_PAINTBUGS];
	double[] bugY = new double [MAX_PAINTBUGS];
	double[] bugDirection = new double [MAX_PAINTBUGS];
	Color[] bugColor = new Color [MAX_PAINTBUGS];
	String[] bugLabel = new String [MAX_PAINTBUGS];

	int numBugs = 0;

	// Used for writing BMP files
	static final int ROWS_GRABBED_AT_A_TIME = 75;
	Status status;
	static final int BI_RGB = 0;
	static final int BI_COMPRESSED_RLE8 = 1;
	static final int BI_COMPRESSED_RLE4 = 2;
	DataOutputStream out;

	public WindowCanvas (int xSize, int ySize,
		boolean drawGrid)
	{

	    gridLabelFont = new Font ("Serif", Font.PLAIN, 12);
	    gridLabelFM = getFontMetrics (gridLabelFont);
	    textWidth = gridLabelFM.stringWidth ("0000");
	    textHeight = gridLabelFM.getAscent ();
	    this.xSize = xSize;
	    this.ySize = ySize;
	    this.drawGrid = drawGrid;
	    bugLabelFont = new Font ("SanSerif", Font.BOLD, 10);
	    bugLabelFM = getFontMetrics (bugLabelFont);
	    labelHeight = bugLabelFM.getAscent ();
	    if (drawGrid)
	    {
		textLeft = LEFT_TOP_MARGIN + textWidth;
		left = LEFT_TOP_MARGIN + TEXT_MARGIN + textWidth;
		canvasWidth = left + xSize + RIGHT_BOTTOM_MARGIN;
		textTop = LEFT_TOP_MARGIN + textHeight;
		top = LEFT_TOP_MARGIN + TEXT_MARGIN + textHeight;
		canvasHeight = top + ySize + RIGHT_BOTTOM_MARGIN;
	    }
	    else
	    {
		left = LEFT_TOP_MARGIN;
		canvasWidth = left + xSize + LEFT_TOP_MARGIN;
		top = LEFT_TOP_MARGIN;
		canvasHeight = top + ySize + LEFT_TOP_MARGIN;
	    }
	    setSize (canvasWidth, canvasHeight);

	    savePrint = new SavePrint (this, this, canvasWidth, canvasHeight);
	} // WindowCanvas (int, int) constructor


	public void paint (Graphics g)
	{
	    update (g);
	}


	public void update (Graphics g)
	{
	    // Draw the grid and the trails to the composting surface
	    Rectangle r = g.getClipBounds ();
	    Graphics offscreenG = offscreen.getGraphics ();
	    offscreenG.drawImage (offscreenTrails, r.x, r.y, r.x + r.width,
		    r.y + r.width, r.x, r.y, r.x + r.width,
		    r.y + r.width, null, null);

	    // Draw the Bugs to the composting surface
	    for (int cnt = 0 ; cnt < numBugs ; cnt++)
	    {
		drawOneBug (offscreenG, left + bugX [cnt], top + bugY [cnt],
			bugDirection [cnt], bugColor [cnt],
			bugLabel [cnt]);
	    } // for

	    // Copy the bugs and the trail to the screen.
	    g.drawImage (offscreen, r.x, r.y, r.x + r.width,
		    r.y + r.width, r.x, r.y, r.x + r.width,
		    r.y + r.width, null, null);
	} // update method


	// Used for saving and printing.  Keep coordinated with the update
	// method above.
	public void drawWindowToGraphics (Graphics g)
	{
	    // Draw the grid and the trails to the composting surface
	    g.drawImage (offscreenTrails, 0, 0, null);

	    // Draw the Bugs to the composting surface
	    for (int cnt = 0 ; cnt < numBugs ; cnt++)
	    {
		drawOneBug (g, left + bugX [cnt], top + bugY [cnt],
			bugDirection [cnt], bugColor [cnt],
			bugLabel [cnt]);
	    } // for
	} // drawWindowToGraphics method


	public void drawWindowToGraphics (Graphics g, int width, int height)
	{
	    // Not used
	} // drawWindowToGraphics method


	public int getMargin ()
	{
	    return 0;
	} // getMargin method

	
	// Draw a single bug located at x, y (canvas coordinates) in the
	// specified direction and color.
	private void drawOneBug (Graphics g, double x, double y,
		double direction, Color bugColor, String label)
	{
	    int ix = (int) Math.round (x);
	    int iy = (int) Math.round (y);

	    g.setColor (bugColor);

	    // Draw the label if necessary
	    if (!label.equals (""))
	    {
		g.setFont (bugLabelFont);
		g.drawString (label, (int) Math.round (x + 10),
			(int) Math.round (y - 10));
	    }

	    Graphics2D g2d = (Graphics2D) g.create ();
	    g2d.rotate (Math.toRadians (-direction), x, y);
	    // Body
	    g2d.fillOval (ix - 8, iy - 4, 16, 8);
	    g2d.setColor (Color.black);
	    g2d.drawOval (ix - 8, iy - 4, 15, 7);
	    // Antennae
	    g2d.setColor (Color.black);
	    g2d.drawArc (ix + 4, iy - 4, 8, 4, 30, 110);
	    g2d.drawArc (ix + 5, iy, 8, 4, 225, 90);
	} // drawOneBug


	public void hideBug (PaintBug bug, double xPos, double yPos,
		double direction, Color color, String label)
	{
	    // We try and find this bug in our list of bug's and remove it.

	    for (int cnt = 0 ; cnt < numBugs ; cnt++)
	    {
		if (bug == bugs [cnt])
		{
		    // We've found the matching Bug.  Remove it from the list
		    for (int cnt1 = cnt + 1 ; cnt1 < numBugs ; cnt1++)
		    {
			bugs [cnt1 - 1] = bugs [cnt1];
			bugX [cnt1 - 1] = bugX [cnt1];
			bugY [cnt1 - 1] = bugY [cnt1];
			bugDirection [cnt1 - 1] = bugDirection [cnt1];
			bugColor [cnt1 - 1] = bugColor [cnt1];
			bugLabel [cnt1 - 1] = bugLabel [cnt1];
		    } // for

		    numBugs--;
		    break;
		} // if
	    } // for
	} // hideBug method


	public void showBug (PaintBug bug, double xPos, double yPos,
		double direction, Color color, String label)
	{
	    bugs [numBugs] = bug;
	    bugX [numBugs] = xPos;
	    bugY [numBugs] = yPos;
	    bugDirection [numBugs] = direction;
	    bugColor [numBugs] = color;
	    bugLabel [numBugs] = label;

	    numBugs++;

	    repaint ();
	} // showBug method


	public void moveBug (PaintBug bug, double xPos, double yPos,
		double direction)
	{
	    // We try and find this bug in our list of bug's and change it.
	    for (int cnt = 0 ; cnt < numBugs ; cnt++)
	    {
		if (bug == bugs [cnt])
		{
		    bugX [cnt] = xPos;
		    bugY [cnt] = yPos;
		    bugDirection [cnt] = direction;
		    break;
		} // for
	    } // for
	} // showBug method


	public void drawBugTrail (double xPos, double yPos, int trailWidth,
		Color color)
	{
	    Graphics g = offscreenTrails.getGraphics ();
	    g.setColor (color);

	    g.fillOval (left + (int) Math.round (xPos - trailWidth / 2.0),
		    top + (int) Math.round (yPos - trailWidth / 2.0),
		    trailWidth, trailWidth);
	} // drawBugTrail


	public void addNotify ()
	{
	    super.addNotify ();

	    offscreen = createImage (canvasWidth, canvasHeight);
	    offscreenTrails = createImage (canvasWidth, canvasHeight);

	    int right = left + (xSize - 1);
	    int bottom = top + (ySize - 1);
	    if (drawGrid)
	    {
		Graphics g = offscreenTrails.getGraphics ();

		g.setFont (gridLabelFont);
		g.setColor (Color.gray);

		// Draw the text and lines down
		for (int y = 0 ; y <= ySize ; y += 25)
		{
		    String number = "" + y;

		    g.drawString (number,
			    textLeft - gridLabelFM.stringWidth (number),
			    y + top + textHeight / 2);
		    g.drawLine (left, y + top, right, y + top);
		} // for

		// Draw the text and lines down
		for (int x = 0 ; x <= xSize ; x += 25)
		{
		    String number = "" + x;
		    g.drawString (number,
			    x + left - gridLabelFM.stringWidth (number) / 2,
			    textTop);
		    g.drawLine (x + left, top, x + left, bottom);
		} // for
	    } // if (drawGrid)
	} // addNotify method
    } // WindowCanvas class


    class PaintBugThread extends Thread
    {
	int commandKind;
	PaintBug bug;
	WindowCanvas canvas;
	double xPos, yPos, direction, distance, changeAngle;
	Color color;
	int trailWidth;
	boolean trailVisible;

	public PaintBugThread (PaintBug bug, WindowCanvas canvas,
		double xPos, double yPos, double direction, double distance,
		Color color, int trailWidth, boolean trailVisible)
	{
	    commandKind = 1;
	    this.bug = bug;
	    this.canvas = canvas;
	    this.xPos = xPos;
	    this.yPos = yPos;
	    this.direction = direction;
	    this.distance = distance;
	    this.color = color;
	    this.trailWidth = trailWidth;
	    this.trailVisible = trailVisible;
	} // PaintBugThread constructor


	public PaintBugThread (PaintBug bug, WindowCanvas canvas,
		double xPos, double yPos, double direction,
		double changeAngle, Color color)
	{
	    commandKind = 2;
	    this.bug = bug;
	    this.canvas = canvas;
	    this.xPos = xPos;
	    this.yPos = yPos;
	    this.direction = direction;
	    this.changeAngle = changeAngle;
	    this.color = color;
	} // PaintBugThread constructor


	public void run ()
	{
	    if (commandKind == 1)
	    {
		int distanceTravelled = 0;

		while (distanceTravelled < distance)
		{
		    double distStep =
			Math.min (1.0, distance - distanceTravelled);

		    xPos += distStep * Math.cos (Math.toRadians (direction));
		    yPos -= distStep * Math.sin (Math.toRadians (direction));
		    if (trailVisible)
		    {
			canvas.drawBugTrail (xPos, yPos, trailWidth, color);
		    }
		    canvas.moveBug (bug, xPos, yPos, direction);
		    if (bug.label.length () > 0)
		    {
			int above = Math.max (15, 10 + canvas.labelHeight + 3);
			int right = 25 + Math.max (5, canvas.bugLabelFM.stringWidth (bug.label) + 3);
			canvas.repaint (
				canvas.left + (int) Math.round (xPos) - 15,
				canvas.top + (int) Math.round (yPos) - above,
				right, 15 + above);
		    }
		    else
		    {
			canvas.repaint (
				canvas.left + (int) Math.round (xPos) - 15,
				canvas.top + (int) Math.round (yPos) - 15,
				30, 30);
		    }
		    try
		    {
			Thread.sleep (delayTime);
		    }
		    catch (InterruptedException e)
		    {
			;
		    }
		    distanceTravelled += 1;
		}
	    }
	    else if (commandKind == 2)
	    {
		int sign = 1;
		if (changeAngle < 0)
		{
		    sign = -1;
		}
		while (Math.abs (changeAngle) > 0.0)
		{
		    double angleStep = Math.min (5.0, Math.abs (changeAngle));
		    angleStep *= sign;

		    direction += angleStep;
		    canvas.moveBug (bug, xPos, yPos, direction);
		    canvas.repaint (canvas.left + (int) Math.round (xPos) - 20,
			    canvas.top + (int) Math.round (yPos) - 20, 40, 40);
		    try
		    {
			Thread.sleep (delayTime);
		    }
		    catch (InterruptedException e)
		    {
			;
		    }
		    changeAngle -= angleStep;
		}
	    }
	} // run method
    } // PaintBugThread class


    // This is an inner class for use by PaintBugWindow class
    class WindowCloser extends WindowAdapter
    {
	public void windowClosing (WindowEvent e)
	{
	    e.getWindow ().dispose ();
	    System.exit (0);
	} // windowClosing method
    } // WindowCloser member class
} // PaintBugWindow class


