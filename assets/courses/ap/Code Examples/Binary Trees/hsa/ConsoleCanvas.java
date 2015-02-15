package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleCanvas class is the parent class for the drawing surface of
 * the ConsoleParent class.  It is the ancestor class for the
 * ConsoleCanvasGraphics and ConsoleCanvasText class.
 * <P>
 * Among other duties, it handles the blinking cursor and the adjustment
 * of the "Quit" button to "Close" when the main thread has finished
 * execution. (Note this only works in some envionrments.)
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *                      http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.util.*;

abstract class ConsoleCanvas extends Canvas
    implements FocusListener, Runnable
{
    /**
     * Constants for drawing the pane.
     */
    protected static final int MARGIN = 2;
    protected static final int DEPTH = 3;
    protected static final int GREY_MARGIN = 5;

    /**
     * The name of thread for blinking the cursor.
     */
    protected static final String CONSOLE_CURSOR_THREAD_NAME =
	"Console Cursor Thread";
    protected static final String SCREEN_UPDATER_THREAD_NAME =
	"Screen Updater";

    /**
     * Variables for controlling the consoleCanvas pane.
     */
    protected ConsoleParent parentConsole;
    protected int numRows, numCols; // size of drawing surface
    protected int numXPixels, numYPixels; // size of drawing surface

    /**
     * Information about the font used for text drawing.
     */
    protected Font font = null;
    protected int fontWidth = 0, fontHeight = 0, fontBase = 0;

    /**
     * Information about the cursor.
     */
    protected Thread cursorThread;
    // Whether the cursor is on the visible part of the blink.  This
    // goes false/true even when cursorBlinking is 0 and there is no
    // cursor is invisible.
    protected boolean cursorVisible = false;
    // Whether the cursor should be blinking (waiting for input)
    protected int cursorBlinking = 0;
    // Whether the canvas has focus or not.
    protected boolean hasFocus = false;
    // Used to save and print document.
    protected SavePrint savePrint;
    // Used to terminate the cursor thread
    private boolean killCursorThread = false;
    // Used to determine if we are running on Mac OS X
    protected boolean macOSX = false;

    /**
     * Creates the console canvas given the size of the screen in rows and
     * columns and font size.
     *
     * @param parent The parent Console class.
     * @param rows The height of the canvas in rows of text.
     * @param columns The width of the canvas in columns of text.
     * @param fontSize The size of the font in the canvas.
     */
    public ConsoleCanvas (ConsoleParent parent, int rows, int columns,
	    int fontSize)
    {
	parentConsole = parent;
	numRows = rows;
	numCols = columns;

	java.util.Properties p = System.getProperties ();
	if (p.getProperty ("os.name").equals ("Mac OS X"))
	{
	    macOSX = true;
	}

	// Get the font information.  We find the size of the first
	// 256 glyphs instead of using fm.getMaxAdvance to avoid double
	// spaced glyphs.
	font = new Font ("monospaced", Font.PLAIN, fontSize);
	FontMetrics fm = Toolkit.getDefaultToolkit ().getFontMetrics (font);
	fontHeight = fm.getHeight () + fm.getLeading ();
	fontBase = fm.getDescent ();
	fontWidth = 0;
	for (int ch = 32 ; ch < 127 ; ch++)
	{
	    fontWidth = Math.max (fontWidth, fm.charWidth (ch));
	}

	// Set the size of the canvas.
	numXPixels = numCols * fontWidth;
	numYPixels = numRows * fontHeight;
	setSize (numXPixels + 2 * MARGIN, numYPixels + 2 * MARGIN);

	// Set the background to white.
	setBackground (Color.white);

	// Set up the focus listener
	addFocusListener (this);
	addKeyListener (parentConsole);
    } // Constructor - ConsoleCanvas (Console, int, int, int)


    /**
     * Overrides addNotify in order to set up the cursor thread once
     * the canvas has been created.
     */
    public void addNotify ()
    {
	super.addNotify ();

	// Set the thread that blinks the cursor.
	cursorThread = new Thread (this);
	cursorThread.setName (CONSOLE_CURSOR_THREAD_NAME);
	cursorThread.start ();
    } // addNotify method


    /**
     * Blinks the cursor off it was on and on if it was off.
     */
    protected synchronized void blinkCursor ()
    {
	if (macOSX)
	{
	    cursorVisible = !cursorVisible;
	    repaint ();
	    return;
	}

	if (hasFocus)
	{
	    toggleCursor ();
	}
	cursorVisible = !cursorVisible;
    } // blinkCursor (void)


    /**
     * Changes the cursor from an empty square to a normal cursor.  Called by
     * the system when the ConsoleCanvas gains focus.
     */
    public synchronized void focusGained (FocusEvent e)
    {
	if (!hasFocus)
	{
	    if (macOSX)
	    {
		hasFocus = true;
		repaint ();
		return;
	    }

	    toggleCursor ();
	    hasFocus = true;
	    if (cursorVisible)
		toggleCursor ();
	}
    } // focusGained (FocusEvent)


    /**
     * Changes the cursor from a normal cursor to an empty square.  Called by
     * the system when the ConsoleCanvas loses focus.
     */
    public synchronized void focusLost (FocusEvent e)
    {
	if (hasFocus)
	{
	    if (macOSX)
	    {
		hasFocus = false;
		repaint ();
		return;
	    }

	    if (cursorVisible)
		toggleCursor ();
	    hasFocus = false;
	    toggleCursor ();
	}
    } // focusLost (FocusEvent)


    /**
     * Returns the current column number of the cursor.
     *
     * @return The current column number of the cursor.
     */
    public abstract int getCurrentColumn ();
    /**
     * Returns the current row number of the cursor.
     *
     * @return The current row number of the cursor.
     */
    public abstract int getCurrentRow ();


    /**
     * Inverts the console canvas for 50 milliseconds.
     */
    public synchronized void invertScreen ()
    {
	Graphics g = getGraphics ();

	g.translate (MARGIN, MARGIN);
	g.setColor (Color.white);
	g.setXORMode (Color.black);

	// Invert the screen
	g.fillRect (0, 0, numXPixels, numYPixels);
	Toolkit.getDefaultToolkit ().sync ();

	// Wait 50 milliseconds
	try
	{
	    Thread.sleep (50);
	}
	catch (Exception e)
	{
	}

	if (macOSX)
	{
	    g.setPaintMode ();
	    repaint ();
	    return;
	}

	// Restore the screen
	g.fillRect (0, 0, numXPixels, numYPixels);
	Toolkit.getDefaultToolkit ().sync ();

	g.setPaintMode ();
    } // invertScreen (void)


    public boolean isFocusTraversable ()
    {
	return true;
    } // isFocusTraversable (void)


    /**
     * This returns whether the main method is still alive.  If it is not, 
     * then it means that the main thread of execution has terminated in 
     * the user's program.
     *
     * @return Whether the main thread of execution is alive.
     */
    protected boolean isMainRunning ()
    {
/*        // Go through thread list looking for any alive priority five
	// jobs whose names don't start with AWT
	ThreadGroup rootGrp = Thread.currentThread ().getThreadGroup ();
	Thread[] threads;

	while (rootGrp.getParent () != null)
	{
	    rootGrp = rootGrp.getParent ();
	}
	threads = new Thread [rootGrp.activeCount ()];
	int count = rootGrp.enumerate (threads, true);
	for (int i = 0 ; i < count ; i++)
	{
	    Thread t = threads [i];

	    // With the IBM JVM, there is still stuff running when there
	    // are either threads beyond the basic five:
	    //      Thread[main,5,main] or Thread[Main Program,5,main]
	    //      Thread[AWT-EventQueue-0,5,main]
	    //      Thread[AWT-Windows,5,main]
	    //      Thread[Console Cursor Thread,5,main]
	    //      Thread[Screen Updater,4,main]
	    //
	    // Or the stack count of main goes to 0.
	    //      (t.countStackFrames () == 0)
	    if ((t.getPriority () >= 5) && (!t.isDaemon ()) && t.isAlive () &&
		    (((t.getName ().equals ("main")) ||
			    (t.getName ().equals ("Main Program")))))
	    {
		return (true);
	    }
	}
	return (false);
*/
	return !Console.mainReturned;        
    } // isMainRunning (void)


    /**
     * Kills the cursor thread (used when the Console window is closed).
     */
    public void killCursorThread ()
    {
	killCursorThread = true;
	cursorThread.interrupt ();
    } // killCursorThread (void)


    /**
     * Prints the contents of the window on the printer.
     */
    public void printContents ()
    {
	PrinterJob printerJob = PrinterJob.getPrinterJob ();
	Book book = new Book ();
	book.append (savePrint, new PageFormat ());
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
	requestFocus ();
    } // printContents method


    /**
     * ConsoleCanvas implements the Runnable interface.  When run, this thread
     * blinks the cursor every 300 milliseconds and checks to see whether the
     * program has fniished execution.
     */
    public void run ()
    {
	boolean mainIsRunning = true;

	while (!killCursorThread)
	{
	    blinkCursor ();

	    if (mainIsRunning && (!isMainRunning ()))
	    {
		mainIsRunning = false;
		parentConsole.mainStopped ();
		return;
	    }

	    try
	    {
		Thread.sleep (300);
	    }
	    catch (Exception e)
	    {
	    }
	} // while
    } // run (void)


    /**
     * Saves the contents of the window to a file.
     */
    public void saveContents ()
    {
	// Get the file name to save as.
	FileDialog fd = new FileDialog (parentConsole.window,
		"Save Console Window", FileDialog.SAVE);
	fd.setFile ("Console.bmp");
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
	savePrint.saveToFile (fileName);
    } // saveContents method


    /**
     * Makes the blinking cursor visible or invisible.
     *
     * @param visible Whether the cursor should be visible or not.
     */
    public synchronized void setCursorVisible (boolean visible)
    {
	if (visible)
	{
	    cursorBlinking++;
	    if (cursorBlinking == 1)
	    {
		if (cursorVisible || !hasFocus)
		{
		    toggleCursor ();
		}
	    }
	}
	else
	{
	    if (cursorBlinking == 1)
	    {
		if (cursorVisible || !hasFocus)
		{
		    toggleCursor ();
		}
	    }
	    cursorBlinking--;
	}
    } // setCursorVisible (boolean)


    /**
     * Toggles the visible cursor on the screen off or on.
     */
    protected synchronized void toggleCursor ()
    {
	if (cursorBlinking > 0)
	{
	    int x = (getCurrentColumn () - 1) * fontWidth;
	    int y = (getCurrentRow () - 1) * fontHeight;
	    Graphics g = getGraphics ();

	    g.translate (MARGIN, MARGIN);
	    g.setColor (Color.white);
	    g.setXORMode (Color.black);
	    if (hasFocus)
	    {
		g.fillRect (x, y, fontWidth, fontHeight);
	    }
	    else
	    {
		g.drawRect (x, y, fontWidth, fontHeight);
	    }
	    g.setPaintMode ();
	    Toolkit.getDefaultToolkit ().sync ();
	}
    } // toggleCursor (void)


    /**
     * Overrides the getMinimumSize method to specify the proper canvas size
     */
    public Dimension getMinimumSize ()
    {
	return new Dimension (numXPixels + 2 * MARGIN, numYPixels + 2 * MARGIN);
    } // getMinimumSize method


    /**
     * Overrides the getPreferredSize method to specify the proper canvas size
     */
    public Dimension getPreferredSize ()
    {
	return getMinimumSize ();
    } // getPreferredSize method


    /**
     * Overrides the update method to redraw the screen using doDraw
     */
    public void update (Graphics g)
    {
	paint (g);
    } // update (Graphics)
} /* ConsoleCanvas class */
