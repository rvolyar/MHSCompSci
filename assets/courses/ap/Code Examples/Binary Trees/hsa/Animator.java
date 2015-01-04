package hsa;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Animator extends Frame
    implements ActionListener, KeyListener
{
    // Constants
    static final int DEFAULT_XSIZE = 400;
    static final int DEFAULT_YSIZE = 300;

    // Fields
    private int xSize, ySize;
    private long lastTime = 0;
    private Vector items = new Vector ();
    private Vector keysPressed = new Vector ();

    // Components
    WindowCanvas canvas;            // The drawing surface
    Button saveButton, printButton; // The save and quit buttons

    public Animator ()
    {
	this (DEFAULT_XSIZE, DEFAULT_YSIZE);
    } // PaintBugWindow (void) constructor


    public Animator (int newXSize, int newYSize)
    {
	super ("Animator");

	xSize = newXSize;
	ySize = newYSize;
	canvas = new WindowCanvas (xSize, ySize);

	// Add code to close the window when the user presses close button.
	addWindowListener (new WindowCloser ());
	// Add code to determine which keys are depressed
	addKeyListener (this);
	canvas.addKeyListener (this);
	
	saveButton = new Button ("Save");
	printButton = new Button ("Print");

	// Add code to react to buttons when the user presses print/save
	saveButton.addActionListener (this);
	printButton.addActionListener (this);

	// Lay out the components

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
	controlPanel.add (label2);

	// Set some space around the windows.
	cn.insets = new Insets (4, 4, 4, 4);
	gb.setConstraints (saveButton, cn);
	gb.setConstraints (printButton, cn);

	// Add the controls panel above
	add (controlPanel, "North");
	// Add the canvas below
	add (canvas, "South");

	pack ();

	// Move to the left side
	Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
	setLocation (screen.width - getSize ().width, 0);

	show ();
	canvas.requestFocus ();
    } // Animator (int, int) constructor


    public int getXSize ()
    {
	return xSize;
    } // getXSize method


    public int getYSize ()
    {
	return ySize;
    } // getYSize method


    public void add (Moveable item)
    {
	items.add (item);
    } // add method


    public void add (Bounceable item)
    {
	items.add (item);
    } // add method


    public void add (Paintable item)
    {
	items.add (item);
    } // add method


    // Delay for up to delayTime milliseconds since
    // the last time this method was called.
    public void delay (int delayTime)
    {
	long currentTime = System.currentTimeMillis ();
	if (currentTime - lastTime >= delayTime)
	{
	    lastTime = currentTime;
	    return;
	}
	delayTime = delayTime - (int) (currentTime - lastTime);
	try
	{
	    Thread.sleep (delayTime);
	}
	catch (InterruptedException e)
	{
	    ;
	}
	lastTime = System.currentTimeMillis ();
    } // delay method


    private void drawMoveable (Moveable item, Graphics g)
    {
	double x, y, direction, speed;
	boolean inBounds;

	x = item.getX ();
	y = item.getY ();
	direction = item.getDirection ();
	speed = item.getSpeed ();

	x += Math.cos (Math.toRadians (direction)) * speed;
	y -= Math.sin (Math.toRadians (direction)) * speed;

	do
	{
	    inBounds = true;

	    if (x < 0)
	    {
		x = -x;
		if (direction <= 180)
		{
		    direction = 180 - direction;
		}
		else
		{
		    direction = 540 - direction;
		}
		inBounds = false;
	    }
	    if (x > xSize)
	    {
		x = xSize - (x - xSize);
		if (direction <= 180)
		{
		    direction = 180 - direction;
		}
		else
		{
		    direction = 540 - direction;
		}
		inBounds = false;
	    }
	    if (y < 0)
	    {
		y = -y;
		direction = 360 - direction;
		inBounds = false;
	    }
	    if (y > ySize)
	    {
		y = ySize - (y - ySize);
		direction = 360 - direction;
		inBounds = false;
	    }
	}
	while (!inBounds);
	item.setLocation (x, y);
	item.setDirection (direction);
	item.paint (g, (int) Math.round (x), (int) Math.round (y));
    } // drawMoveable method


    private void drawBounceable (Bounceable item, Graphics g)
    {
	double x, y, direction, speed;
	boolean inBounds;

	x = item.getX ();
	y = item.getY ();
	direction = item.getDirection ();
	speed = item.getSpeed ();

	x += Math.cos (Math.toRadians (direction)) * speed;
	y -= Math.sin (Math.toRadians (direction)) * speed;
	item.setLocation (x, y);

	do
	{
	    inBounds = true;

	    if (item.getLeft () < 0)
	    {
		item.setLocation (
			item.getX () - 2 * item.getLeft (),
			item.getY ());
		if (direction <= 180)
		{
		    direction = 180 - direction;
		}
		else
		{
		    direction = 540 - direction;
		}
		inBounds = false;
	    }
	    if (item.getRight () > xSize)
	    {
		item.setLocation (
			item.getX () - 2 * (item.getRight () - xSize),
			item.getY ());
		if (direction <= 180)
		{
		    direction = 180 - direction;
		}
		else
		{
		    direction = 540 - direction;
		}
		inBounds = false;
	    }
	    if (item.getTop () < 0)
	    {
		item.setLocation (item.getX (),
			item.getY () - 2 * item.getTop ());
		direction = 360 - direction;
		inBounds = false;
	    }
	    if (item.getBottom () > ySize)
	    {

		item.setLocation (item.getX (),
			item.getY () - 2 * (item.getBottom () - ySize));
		direction = 360 - direction;
		inBounds = false;
	    }
	}
	while (!inBounds);
	item.setDirection (direction);
	item.paint (g, (int) Math.round (x), (int) Math.round (y));
    } // drawBounceable method


    public void drawFrame ()
    {
	Graphics g = canvas.offscreen.getGraphics ();

	g.clearRect (0, 0, xSize, ySize);

	// Move and display the Moveable items
	for (int counter = 0 ; counter < items.size () ; counter++)
	{
	    Object item = items.elementAt (counter);
	    double x, y, direction, speed;

	    if (item instanceof Moveable)
	    {
		drawMoveable ((Moveable) item, g);
	    }
	    else if (item instanceof Bounceable)
	    {
		drawBounceable ((Bounceable) item, g);
	    }
	    else // Paintable
	    {
		Paintable paintableItem = (Paintable) item;

		paintableItem.paint (g);
	    }
	} // for

	canvas.repaint ();
    } // drawFrame method


    public boolean isKeyPressed (int keyCode)
    {
	for (int i = 0 ; i < keysPressed.size () ; i++)
	{
	    if (((Integer) (keysPressed.elementAt (i))).intValue () == keyCode)
	    {
		return true;
	    }
	}

	return false;
    } // isKeyPressed method


    // This sets up the image
    public Image loadImage (String path)
    {
	// Load the image.
	Image picture = getToolkit ().getImage (path);
	prepareImage (picture, this);

	// Now, it can actually take some time to load the image, and
	// it could fail (image not found, etc).  The following checks for
	// all that.
	MediaTracker tracker = new MediaTracker (this);
	// Add the picture to the list of images to be tracked
	tracker.addImage (picture, 0);
	// Wait until all the images are loaded.  This can throw an
	// InterruptedException although it's not likely, so we ignore
	// it if it occurs.
	try
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e)
	{
	}
	// If there were any errors loading the image, then abort the
	// program with a message.
	if (tracker.isErrorAny ())
	{
	    throw new RuntimeException ("Couldn't load picture located at \"" +
		    path + "\"");
	}

	return picture;
    } // loadImage method


    public void actionPerformed (ActionEvent evt)
    {
	if (evt.getSource () == saveButton)
	{
	    // Get the file name to save as.
	    FileDialog fd = new FileDialog (this, "Save Animator Window",
		    FileDialog.SAVE);
	    fd.setFile ("Animator.bmp");
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


    //
    // The following methods (beginning with key...) implement the
    // various methods in the KeyListener interface.
    //
    public void keyPressed (KeyEvent e)
    {
	int keyCode = e.getKeyCode ();

	for (int i = 0 ; i < keysPressed.size () ; i++)
	{
	    if (((Integer) (keysPressed.elementAt (i))).intValue () == keyCode)
	    {
		return;
	    }
	}
	keysPressed.addElement (new Integer (keyCode));
    } // keyPressed method


    public void keyReleased (KeyEvent e)
    {
	int keyCode = e.getKeyCode ();

	for (int i = 0 ; i < keysPressed.size () ; i++)
	{
	    if (((Integer) (keysPressed.elementAt (i))).intValue () == keyCode)
	    {
		keysPressed.removeElementAt (i);
		return;
	    }
	}
//        throw new java.lang.RuntimeException ("Key not found");
    } // keyReleased method


    public void keyTyped (KeyEvent e)
    {
    } // keyTyped method


    // This is an inner class for use by PaintBugWindow class
    // It handles all the drawing of the actual grid surface.  (i.e.
    // it excludes all the controls.)
    class WindowCanvas extends Canvas implements DrawGraphics
    {
	// Fields
	SavePrint savePrint;    // Used to save or print graphics
	int xSize, ySize;       // Size of drawing surface
	Image offscreen;        // Surface used to compose final pic

	public WindowCanvas (int xSize, int ySize)
	{
	    this.xSize = xSize;
	    this.ySize = ySize;
	    setSize (xSize, ySize);

	    savePrint = new SavePrint (this, this, xSize, ySize);
	} // WindowCanvas (int, int) constructor


	public void addNotify ()
	{
	    super.addNotify ();
	    offscreen = createImage (xSize, ySize);
	} // addNotify method


	public void paint (Graphics g)
	{
	    update (g);
	} // paint method


	public void update (Graphics g)
	{
	    Rectangle r = g.getClipBounds ();
	    g.drawImage (offscreen, r.x, r.y, r.x + r.width,
		    r.y + r.width, r.x, r.y, r.x + r.width,
		    r.y + r.width, null, null);
	} // update method


	// Used for saving and printing.  Keep coordinated with the update
	// method above.
	public void drawWindowToGraphics (Graphics g)
	{
	    g.drawImage (offscreen, 0, 0, null);
	} // drawWindowToGraphics


	public void drawWindowToGraphics (Graphics g, int width, int height)
	{
	    g.drawImage (offscreen, 0, 0, null);
	} // drawWindowToGraphics


	public int getMargin ()
	{
	    return 0;
	} // getMargin method
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
} // Animator class



