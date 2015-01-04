package hsa;

import java.awt.*;

public class PaintBug
{
    // Constants
    static final int DEFAULT_X = -99;
    static final double DEFAULT_DIR = 0.0;
    static final int DEFAULT_TRAIL_WIDTH = 5;

    // Class variable that handle the grid
    static boolean gridInitialized = false;
    static boolean drawGrid = false;
    static int xSize = 0, ySize = 0;
    static PaintBugWindow window;
    static Color[] colors = {Color.red, Color.green, Color.blue, Color.cyan,
	Color.orange, Color.magenta, Color.yellow};
    static int colorNumber = 0;

    // Fields of a PaintBug object
    double xPos, yPos;      // What is the current position of the PaintBug
    double direction;       // Which direction is the PaintBug facing
    Color color;            // What color is the PaintBug and its trail
    int trailWidth;         // How wide is the trail left behind
    boolean trailVisible;   // Does PaintBug leave a visible trail when moving
    String label;           // A label for the PaintBug
    Thread movementThread;  // Active while PaintBug moving from the
    // previous command.

    public PaintBug (double startX, double startY, double startDirection,
	    Color startColor)
    {
	initializeGridIfNecessary ();

	if (startX == DEFAULT_X)
	{
	    xPos = window.getXSize () / 2;
	    yPos = window.getYSize () / 2;
	}
	else
	{
	    xPos = startX;
	    yPos = startY;
	}
	direction = startDirection;
	color = startColor;
	trailWidth = DEFAULT_TRAIL_WIDTH;
	trailVisible = true;   // Start with PaintBug leaving a trail
	label = "";         // Start with no visible label

	window.showBug (this, xPos, yPos, direction, color, label);
    } // PaintBug (int, int, int, Color) constructor


    public PaintBug ()
    {
	this (DEFAULT_X, DEFAULT_X, DEFAULT_DIR, getNextColor ());
    } // PaintBug (void) constructor


    public PaintBug (int startX, int startY)
    {
	this (startX, startY, DEFAULT_DIR, getNextColor ());
    } // PaintBug (int, int) constructor


    public PaintBug (double startX, double startY)
    {
	this ((int) startX, (int) startY, DEFAULT_DIR, getNextColor ());
    } // PaintBug (int, int) constructor


    public PaintBug (Color color)
    {
	this (DEFAULT_X, DEFAULT_X, DEFAULT_DIR, color);
    } // PaintBug (Color) constructor


    public PaintBug (int startX, int startY, Color color)
    {
	this (startX, startY, DEFAULT_DIR, color);
    } // PaintBug (int, int) constructor


    public PaintBug (double startX, double startY, Color color)
    {
	this ((int) startX, (int) startY, DEFAULT_DIR, color);
    } // PaintBug (int, int) constructor


    private static void initializeGridIfNecessary ()
    {
	if (!gridInitialized)
	{
	    if (xSize != 0)
	    {
		window = new PaintBugWindow (xSize, ySize, drawGrid);
	    }
	    else
	    {
		window = new PaintBugWindow (drawGrid);
	    }
	    gridInitialized = true;
	}
    } // initializeGridIfNecessary method


    public void move (double distance)
    {
	waitUntilPreviousMoveCompleted ();

	// Start the graphics of the bug moving.
	movementThread = window.moveBug (this, xPos, yPos, direction,
		distance, color, trailWidth, trailVisible, label);

	// Calculate the new position of the bug.
	xPos += distance * Math.cos (Math.toRadians (direction));
	yPos -= distance * Math.sin (Math.toRadians (direction));
    } // move method


    public void turnRight (double degreesRight)
    {
	waitUntilPreviousMoveCompleted ();

	// Start the graphics of the bug moving.
	movementThread = window.rotateBug (this, xPos, yPos,
		direction, -degreesRight, color);

	// Calculate the new direction of the bug.  The direction
	// is between -360.0 and 360.0
	direction = (direction - degreesRight) % 360.0;

	// Set the direction between 0 and 360.
	if (direction < 0)
	{
	    direction += 360.0;
	}
    } // turnRight method


    public void turnLeft (double degreesLeft)
    {
	waitUntilPreviousMoveCompleted ();

	// Start the graphics of the bug moving.
	movementThread = window.rotateBug (this, xPos, yPos,
		direction, degreesLeft, color);

	// Calculate the new direction of the bug.  The direction
	// is between -360.0 and 360.0
	direction = (direction + degreesLeft) % 360.0;
    } // turnLeft method


    public double getXPos ()
    {
	waitUntilPreviousMoveCompleted ();

	return xPos;
    } // getXPos method


    public double getYPos ()
    {
	waitUntilPreviousMoveCompleted ();

	return yPos;
    } // getYPos method


    public double getDirection ()
    {
	waitUntilPreviousMoveCompleted ();

	return direction;
    } // getDirection method


    public void setPosition (double newX, double newY)
    {
	waitUntilPreviousMoveCompleted ();

	window.hideBug (this, xPos, yPos, direction, color, label);
	xPos = newX;
	yPos = newY;
	window.showBug (this, xPos, yPos, direction, color, label);
    } // setPosition method


    public void setDirection (double newDirection)
    {
	double angleRotated;

	waitUntilPreviousMoveCompleted ();

	// We want to rotate in the appropriate direction
	angleRotated = (newDirection - direction) % 360.0;
	if (angleRotated < 0)
	{
	    angleRotated += 360.0;
	}

	// Start the graphics of the bug moving.
	if (angleRotated <= 180.0)
	{
	    movementThread = window.rotateBug (this, xPos, yPos,
		    direction, angleRotated, color);
	}
	else
	{
	    movementThread = window.rotateBug (this, xPos, yPos,
		    direction, angleRotated - 360.0, color);
	}
	direction = newDirection;
    } // setDirection method


    public void setColor (Color newColor)
    {
	waitUntilPreviousMoveCompleted ();

	window.hideBug (this, xPos, yPos, direction, color, label);
	color = newColor;
	window.showBug (this, xPos, yPos, direction, color, label);
    } // setColor method


    public void setTrailWidth (int newTrailWidth)
    {
	trailWidth = newTrailWidth;
    } // setTrailWidth method


    public void setLabel (String newLabel)
    {
	waitUntilPreviousMoveCompleted ();

	window.hideBug (this, xPos, yPos, direction, color, label);
	label = newLabel;
	window.showBug (this, xPos, yPos, direction, color, label);
    } // setLabel method


    public void show ()
    {
	window.showBug (this, xPos, yPos, direction, color, label);
    } // show method


    public void hide ()
    {
	window.hideBug (this, xPos, yPos, direction, color, label);
    } // hide method


    public void trailOn ()
    {
	trailVisible = true;
    } // trailOn method


    public void trailOff ()
    {
	trailVisible = false;
    } // trailOff method


    public static void setWindowSize (int newXSize, int newYSize)
    {
	if (gridInitialized)
	{
	    System.out.println ("The PaintBug.setWindowSize method must " +
		    "be called before the first PaintBug is created");
	}
	else
	{
	    xSize = newXSize;
	    ySize = newYSize;
	}
    } // setWindowSize method


    private synchronized void waitUntilPreviousMoveCompleted ()
    {
	// This commands waits until the thread is completed.
	if (movementThread == null)
	{
	    return;
	}
	try
	{
	    movementThread.join ();
	}
	catch (InterruptedException e)
	{
	    ;
	}
    } // waitUntilPreviousMoveCompleted


    public static int getXSize ()
    {
	initializeGridIfNecessary ();
	return window.getXSize ();
    } // getXSize


    public static int getYSize ()
    {
	initializeGridIfNecessary ();
	return window.getYSize ();
    } // getYSize


    public static void drawGrid ()
    {
	if (gridInitialized)
	{
	    System.out.println ("The PaintBug.setGridSize method must be " +
		    "called before the first PaintBug is created");
	}
	else
	{
	    drawGrid = true;
	}
    } // drawGrid method


    public static void setSpeed (int speed)
    {
	initializeGridIfNecessary ();

	window.setSpeed (speed);
    } // setSpeed


    private static Color getNextColor ()
    {
	if (colorNumber < colors.length)
	{
	    colorNumber++;
	    return colors [colorNumber - 1];
	}
	else
	{
	    Color newColor;

	    newColor = new Color ((int) (Math.random () * 256),
		    (int) (Math.random () * 256), (int) (Math.random () * 256));
	    return newColor;
	} // if - else
    } // getNextColor
} // PaintBug class


