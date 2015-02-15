// The "VisualSortUtil" class.
package hsa;

// Located in: Examples\Ch15\VisualSortFrame.java
// The base class from which all visual sorting classes descend.
// The class creates a window with lines representing the items
// to be sorted. Calling the swap or shift methods in this class
// cause the lines to be swapped or shifted with appropriate
// visual symbols to help mark the swap or shift. By extending
// this class, most sorting classes do not have to explicitly
// add any graphics in order to visually display the sorting
// algorithm.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public abstract class VisualSortUtil
{
    private static ArrayList windows = new ArrayList ();
    private static ArrayList dataSets = new ArrayList ();

    public static Comparable[] createVisualArray (String sortName,
	    int width, int height)
    {
	SortFrame window = new SortFrame (sortName, width, height);
	Comparable[] data = window.getData ();
	windows.add (window);
	dataSets.add (data);

	return data;
    } // createVisualArray method


    private static SortFrame getWindow (Comparable[] list)
    {
	int index = dataSets.indexOf (list);
	return (SortFrame) (windows.get (index));
    } // getWindow method


    // Method to swap the ith and jth elements of list
    // and draw move indicator.
    public static void swap (int i, int j, Comparable[] list)
    {
	getWindow (list).swap (i, j);
    } // swap method


    // Method to shift the ith through jth elements of list
    // and draw move indicator.
    public static void shift (int i, int j, Comparable[] list)
    {
	getWindow (list).shift (i, j);
    } // swap method


    // Method to draw lines over the ith through jth elements of list
    // as an indication of merging activity.
    public static void showMerge (int i, int j, Comparable[] list)
    {
	getWindow (list).showMerge (i, j);
    } // swap method
} // VisualSortUtil class


class SortFrame extends Frame implements AdjustmentListener
{
    private SortCanvas canvas;
    private Scrollbar scrollBar; // The sorting speed control.
    private int delay;
    private Integer[] list;

    // Constructor
    public SortFrame (String sortName, int width, int height)
    {
	super (sortName);

	// Place the canvas, scroll bars, and label.
	canvas = new SortCanvas (width, height);
	add ("North", canvas);
	scrollBar = new Scrollbar (Scrollbar.HORIZONTAL, 5000, 0, 1, 10000);
	delay = (int) (1000 * (1 - (Math.log (5000) / Math.log (10000))));

	add ("West", new Label ("Slow  "));
	add ("Center", scrollBar);
	add ("East", new Label ("  Fast"));

	// Add code to close the window when the user presses close button.
	addWindowListener (new WindowCloser ());

	// Add code to react to the slider
	scrollBar.addAdjustmentListener (this);

	// Create the array
	list = new Integer [width];

	// Create the data in the window.
	fakeData (width, height);

	// Display the window.
	pack ();

	// Move to the left side
	Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
	setLocation (screen.width - getWidth (), 0);

	show ();
    } // SortFrame constructor


    // Method to generate simulated data.
    private void fakeData (int xSize, int maxHeight)
    {
	java.util.ArrayList numbers = new java.util.ArrayList ();

	for (int i = 0 ; i < xSize ; i++)
	{
	    numbers.add (new Integer ((i * maxHeight / xSize) + 1));
	}
	for (int i = 0 ; i < xSize ; i++)
	{
	    int where = (int) (Math.random () * numbers.size ());
	    list [i] = (Integer) numbers.get (where);
	    numbers.remove (where);
	}
    } // fakeData method


    public Comparable[] getData ()
    {
	return list;
    } // getData method


    // Method to swap the ith and jth elements of list of strings
    // and draw move indicator.
    protected void swap (int i, int j)
    {
	// Swap the elements.
	Comparable temp = list [i];
	list [i] = list [j];
	list [j] = (Integer) temp;

	canvas.drawSwap (i, j);

	doDelay ();
    } // swap method


    // Method to shift elements in list.
    protected void shift (int i, int j)
    {
	Comparable temp = list [j];
	for (int k = j ; k >= i + 1 ; k--)
	{
	    list [k] = list [k - 1];
	}
	list [i] = (Integer) temp;

	canvas.drawShift (i, j);

	doDelay ();
    } // shift method


    // Method to shift elements in list.
    protected void showMerge (int i, int j)
    {
	canvas.drawMerge (i, j);

	doDelay ();
    } // shift method


    public void adjustmentValueChanged (AdjustmentEvent evt)
    {
	// The scroll bar has been changed by the user. This changes
	// the delay between swaps or shifts. We use a logarithmic
	// relationship between the scrollbar value and the length of
	// the delay.
	int value = evt.getValue ();
	delay = (int) (1000 * (1 - (Math.log (value) / Math.log (10000))));
    } // adjustmentValueChanged method


    private void doDelay ()
    {

	// Delay 'delay' milliseconds.
	try
	{
	    Thread.sleep (delay);
	}
	catch (InterruptedException e)
	{
	    // This exception will not happen in our program, but
	    // Java requires that we handle it anyway.
	    System.out.println ("Sleep interrupted.");
	}
    } // doDelay method


    // This is an inner class for use by PaintBugWindow class
    class WindowCloser extends WindowAdapter
    {
	public void windowClosing (WindowEvent e)
	{
	    e.getWindow ().dispose ();
	    System.exit (0);
	} // windowClosing method
    } // WindowCloser member class


    // This class exists so that the canvas will be repainted properly when
    // obscured and revealed.
    class SortCanvas extends Canvas
    {
	protected final static int MARGIN = 5;

	private int width, height;
	private int xOffset, yOffset;
	private int xSize, ySize;
	private Color[] colors;  // The array of colors to use.
	private Graphics graphics;

	public SortCanvas (int width, int height)
	{
	    // Set the size of the picture.
	    this.width = width + 2 * MARGIN;
	    this.height = height + 40 + 2 * MARGIN;

	    xOffset = MARGIN;
	    yOffset = MARGIN + 40;
	    xSize = width;
	    ySize = height;

	    createColors (height);
	} // SortCanvas constructor


	public void addNotify ()
	{
	    super.addNotify ();

	    graphics = getGraphics ();
	} // addNotify method


	// Set color array. Used to set colors that smoothly vary from
	// red to orange, yellow, green, blue, and violet.
	// Break the range of values into color ranges, then
	// depending on the location of the element in the range,
	// smoothly vary the color.
	private void createColors (int maxHeight)
	{
	    int orangeBreak = maxHeight / 5;
	    int yellowBreak = maxHeight * 2 / 5;
	    int greenBreak = maxHeight * 3 / 5;
	    int blueBreak = maxHeight * 4 / 5;

	    colors = new Color [maxHeight];

	    for (int i = 0 ; i < maxHeight ; i++)
	    {
		// The location (from 0 - 1) from the lower bound of the color
		// range to the higher bound (0 = lower bound,
		// 1 = upper bound).
		float location;
		if (i <= orangeBreak)
		{
		    location = (float) i / orangeBreak;
		    colors [i] = new Color (1.0f, (float) (0.6 * location), 0.0f);
		}
		else if (i <= yellowBreak)
		{
		    location = (float) (i - orangeBreak) /
			(yellowBreak - orangeBreak);
		    colors [i] =
			new Color (1.0f, (float) (0.6 + 0.4 * location), 0.0f);
		}
		else if (i <= greenBreak)
		{
		    location = (float) (i - yellowBreak) /
			(greenBreak - yellowBreak);
		    colors [i] = new Color ((float) (1.0 - location), 1.0f, 0.0f);
		}
		else if (i <= blueBreak)
		{
		    location = (float) (i - greenBreak) / (blueBreak - greenBreak);
		    colors [i] = new Color (0.0f, (float) (1.0 - location), location);
		}
		else
		{
		    location = (float) (i - blueBreak) /
			((maxHeight - 1) - blueBreak);
		    colors [i] = new Color ((float) (0.6 * location), 0.0f, 1.0f);
		}
	    } // for
	} // createColors method


	protected void drawSwap (int i, int j)
	{
	    drawElement (i);
	    drawElement (j);

	    // Erase the previous move indicator.
	    graphics.setColor (Color.white);
	    graphics.fillRect (xOffset - 4, 0, xSize + 8, yOffset - 3);

	    // Draw the new swap indicator.
	    graphics.setColor (Color.red);
	    // Draw arrow.
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i, 10);
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i + 3,
		    yOffset - 14);
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i - 3,
		    yOffset - 14);
	    // Draw joining line.
	    graphics.drawLine (xOffset + i, 10, xOffset + j, 10);
	    // Draw arrow.
	    graphics.drawLine (xOffset + j, yOffset - 8, xOffset + j, 10);
	    graphics.drawLine (xOffset + j, yOffset - 8, xOffset + j + 3,
		    yOffset - 14);
	    graphics.drawLine (xOffset + j, yOffset - 8, xOffset + j - 3,
		    yOffset - 14);
	} // swap method


	protected void drawShift (int i, int j)
	{
	    // Erase the previous move indicator.
	    graphics.setColor (Color.white);
	    graphics.fillRect (xOffset - 4, 0, xSize + 8, yOffset - 3);

	    // Draw the new shift indicator.
	    graphics.setColor (Color.red);
	    // Draw arrow.
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i, 10);
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i + 3,
		    yOffset - 14);
	    graphics.drawLine (xOffset + i, yOffset - 8, xOffset + i - 3,
		    yOffset - 14);
	    // Draw joining line.
	    graphics.drawLine (xOffset + i, 10, xOffset + j, 10);
	    // Draw source line.
	    graphics.drawLine (xOffset + j, yOffset - 8, xOffset + j, 10);

	    for (int k = j ; k >= i ; k--)
	    {
		drawElement (k);
	    }
	} // drawShift method

	
	protected void drawMerge (int i, int j)
	{
	    // Erase the previous move indicator.
	    graphics.setColor (Color.white);
	    graphics.fillRect (xOffset - 4, 0, xSize + 8, yOffset - 3);

	    // Draw the new shift indicator.
	    graphics.setColor (Color.red);
	    // Draw merging lines.
	    graphics.drawLine (xOffset + i, 30, xOffset + j, 30);
	    graphics.drawLine (xOffset + i, 35, xOffset + j, 35);

	    for (int k = i ; k <= j ; k++)
	    {
		drawElement (k);
	    }
	} // drawMerge method

	
	// Draw the line for element i.
	private void drawElement (int i)
	{
	    int h = list [i].intValue ();
	    graphics.setColor (colors [h - 1]);
	    graphics.drawLine (xOffset + i, yOffset + ySize, xOffset + i,
		    yOffset + ySize - h);
	    graphics.setColor (Color.white);
	    graphics.drawLine (xOffset + i, yOffset + ySize - h - 1,
		    xOffset + i, yOffset);
	} // drawElement method


	public void paint (Graphics g)
	{
	    graphics.clearRect (0, 0, width, height);
	    graphics.setColor (Color.black);
	    graphics.drawRect (xOffset - 2, yOffset - 2,
		    xSize + 4, ySize + 4);
	    for (int i = 0 ; i < xSize ; i++)
	    {
		int h = list [i].intValue ();
		graphics.setColor (colors [h - 1]);
		graphics.drawLine (xOffset + i, yOffset + ySize,
			xOffset + i, yOffset + ySize - h);
	    } // for
	} // paint method


	public Dimension getMinimumSize ()
	{
	    return new Dimension (width, height);
	} // getMinimumSize method


	public Dimension getPreferredSize ()
	{
	    return getMinimumSize ();
	} // getPreferredSize method
    } // SortCanvas class
} // SortFrame class


/*
    private VisualSortFrame[] window;

    protected int list[];  // The list of elements.
    protected int listSize = 0; // The number of elements.

    protected int xOffset, yOffset; // The offset of the drawing area.
    protected int xSize, ySize; // The size of the drawing area.

    protected int delay = 999; // The delay after every swap or shift.

    protected Graphics graphics; // The graphics context.

    protected VisualSortCanvas canvas; // The sorting display.
    protected Button again; // The button to restart sorting.



    // The run method is executed in a separate thread when the start
    // method is called. It creates a set of data. displays it, delays
    // a second, and then starts sorting. The "Sort Another Set" button
    // is disabled while the sorting is taking place.
    public void run ()
    {
	// Prevent more data from being created while sorting.
	again.setEnabled (false);

	// Create the data.
	list = new int [xSize];
	fakeData (xSize, ySize);

	// Update the window.
	repaint ();

	// Delay 1 second.
	try
	{
	    Thread.sleep (1000);
	}
	catch (InterruptedException e)
	{
	    // This exception will not happen in our program, but
	    // Java requires that we handle it anyway.
	    System.out.println ("Sleep interrupted.");
	}

	// Set the graphics context.
	graphics = canvas.getGraphics ();

	// Sort the list.
	sort ();

	// Free the graphics context.
	graphics = null;

	// Allow another set of data to be created and sorted.
	again.setEnabled (true);
    } // run method.




    // Method to shift elements in list and draw move indicator.
    protected void shift (int i, int j)
    {

	// Delay 'delay' milliseconds.
	try
	{
	    Thread.sleep (delay);
	}
	catch (InterruptedException e)
	{
	    // This exception will not happen in our program, but
	    // Java requires that we handle it anyway.
	    System.out.println ("Sleep interrupted.");
	}
    } // shift method


    // Called by the system when an event occurs. Handle the
    // window's close box being pressed or a scroll bar being changed.
    public boolean handleEvent (Event evt)
    {
	if (evt.id == Event.WINDOW_DESTROY)
	{
	    // The close box has been clicked by the user. Quit the
	    // application.
	    System.exit (0);
	}
	else if ((evt.id == Event.SCROLL_ABSOLUTE) ||
		(evt.id == Event.SCROLL_LINE_DOWN) ||
		(evt.id == Event.SCROLL_LINE_UP) ||
		(evt.id == Event.SCROLL_PAGE_DOWN) ||
		(evt.id == Event.SCROLL_PAGE_UP))
	{
	}
	else if ((evt.id == Event.ACTION_EVENT) && (evt.target == again))
	{
	    // The button was clicked. Start the sorting process again.
	    (new Thread (this)).start ();
	}
	return super.handleEvent (evt);
    } // handleEvent method


    // Called whenever the frame needs to be displayed. Erase the
    // window and then display the name, text, and edges of the current
    // vertex.
    public void paint (Graphics g)
    {
    } // paint method
} // VisualSortFrame class

*/
