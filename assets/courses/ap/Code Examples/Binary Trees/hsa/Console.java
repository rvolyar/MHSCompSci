package hsa;

/**
 * The Console class implements a 25x80 window that supports text and
 * graphics. It supports the display of different data types to the
 * screen and the reading in of all the primitive data types as well
 * as string.  It also supports most of the standard drawing methods
 * that can used with the Graphics class.  It also supports a blinking
 * cursor to indicate where input is taking place.
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
import java.text.*;

public class Console extends ConsoleParent
{
    /**
     * Console text variables
     */
    protected int currentRow = 1, currentCol = 1;
    protected int actualRow = 1, actualCol = 1;
    protected int startCol = 0, startRow = 0;
    protected Color textColor = Color.black;
    protected Color textBGColor = Color.white;
    protected boolean echoOn = true;
    protected boolean clearToEOL = true;

    /**
     * Console graphics variables
     */
    protected Color graphicsColor = Color.black;
    protected Font font = new Font ("Serif", Font.PLAIN, 12);
    // An alternate name for the console canvas for graphics.
    protected ConsoleCanvasGraphics graphicsCanvas;

    protected static boolean mainReturned = false;
    
    /**
     * Creates a console using the default values of:
     *        25x80 screen, 14 pt font, "Console" as title.
     */
    public Console ()
    {
	this (DEFAULT_ROWS, DEFAULT_COLUMNS, DEFAULT_FONT_SIZE,
		DEFAULT_TITLE);
    } // Constructor - Console (void)


    /**
     * Creates a console using the default values of:
     *        25x80 screen, "Console" as title.
     *
     * @param fontSize The size of the font to be used in the Console window
     */
    public Console (int fontSize)
    {
	this (DEFAULT_ROWS, DEFAULT_COLUMNS, fontSize, DEFAULT_TITLE);
    } // Constructor - Console (int)


    /**
     * Creates a console using the default values of:
     *        14 pt font, "Console" as title.
     *
     * @param rows The height of the window in rows
     * @param columns The width of the window in columns
     */
    public Console (int rows, int columns)
    {
	this (rows, columns, DEFAULT_FONT_SIZE, DEFAULT_TITLE);
    } // Constructor - Console (int, int)


    /**
     * Creates a console using the default values of:
     *        "Console" as title.
     *
     * @param rows The height of the window in rows
     * @param columns The width of the window in columns
     * @param fontSize The size of the font to be used in the Console window
     */
    public Console (int rows, int columns, int fontSize)
    {
	this (rows, columns, fontSize, DEFAULT_TITLE);
    } // Constructor - Console (int, int, int)


    /**
     * Creates a console.
     *
     * @param rows The height of the window in rows
     * @param columns The width of the window in columns
     * @param fontSize The size of the font to be used in the Console window
     * @param title The title of the Console window
     */
    public Console (int rows, int columns, int fontSize, String title)
    {
	// The console canvas
	consoleCanvas = new ConsoleCanvasGraphics (this, rows, columns,
		fontSize);

	// Set the graphics console
	graphicsCanvas = (ConsoleCanvasGraphics) consoleCanvas;

	// Add these to the inner panel
	consoleCanvasPanelInner = new Panel ();
	consoleCanvasPanelInner.setLayout (new BorderLayout ());
	consoleCanvasPanelInner.add ("Center", consoleCanvas);

	super.initialize (rows, columns, fontSize, title);
    } // Constructor - Console (int, int, int, String)


    /**
     * Creates a console using the default values of:
     *        14 pt font.
     *
     * @param rows The height of the window in rows
     * @param columns The width of the window in columns
     * @param title The title of the Console window
     */
    public Console (int rows, int columns, String title)
    {
	this (rows, columns, DEFAULT_FONT_SIZE, title);
    } // Constructor - Console (int, int, String)


    /**
     * Creates a console using the default values of:
     *        25x80 screen.
     *
     * @param fontSize The size of the font to be used in the Console window.
     * @param title The title of the Console window.
     */
    public Console (int fontSize, String title)
    {
	this (DEFAULT_ROWS, DEFAULT_COLUMNS, fontSize, title);
    } // Constructor - Console (int, String)


    /**
     * Creates a console using the default values of:
     *        25x80 screen, 14 pt font.
     *
     * @param title The title of the Console window
     */
    public Console (String title)
    {
	this (DEFAULT_ROWS, DEFAULT_COLUMNS, DEFAULT_FONT_SIZE, title);
    } // Constructor - Console (String)


    /**
     * Clears the screen and moves the cursor to the top left corner.
     */
    public void clear ()
    {
	graphicsCanvas.clearScreen (textBGColor);
	currentRow = 1;
	currentCol = 1;
	actualRow = 1;
	actualCol = 1;
	graphicsCanvas.setCursorPos (currentRow, currentCol);
    } // clear (void)


    /**
     * Clears a rectangle in the console to white.
     *
     * @see java.awt.Graphics.clearRect
     */
    public void clearRect (int x, int y, int width, int height)
    {
	graphicsCanvas.clearRect (x, y, width, height);
    } // clearRect (int, int, int, int)


    /**
     * Copies an area of the screen from (x, y) to (x + width, y + height) onto
     * the screen with top corner at (x + delta_x, y + delta_y).
     *
     * @see java.awt.Graphics.copyArea
     */
    public void copyArea (int x, int y, int width, int height,
	    int delta_x, int delta_y)
    {
	graphicsCanvas.copyArea (x, y, width, height, delta_x, delta_y);
    } // copyArea (int, int, int, int, int, int)


    /**
     * Draws a 3D rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.draw3DRect
     */
    public void draw3DRect (int x, int y, int width, int height,
	    boolean raised)
    {
	graphicsCanvas.draw3DRect (x, y, width, height, raised,
		graphicsColor);
    } // draw3DRect (int, int, int, int, boolean)


    /**
     * Draws an arc on the screen from (x, y) to
     * (x + width, y + height) from startAngle to startAngle + arcAngle
     * in specified colour.
     *
     * @see java.awt.Graphics.drawArc
     */
    public void drawArc (int x, int y, int width, int height,
	    int startAngle, int arcAngle)
    {
	graphicsCanvas.drawArc (x, y, width, height, startAngle,
		arcAngle, graphicsColor);
    } // drawArc (int, int, int, int, int, int)


    /**
     * Draws an image on the screen at (x, y).
     *
     * @see java.awt.Graphics.drawImage
     */
    public void drawImage (Image img, int x, int y, ImageObserver obs)
    {
	graphicsCanvas.drawImage (img, x, y, obs);
    } // drawImage (int, int, int, int)


    /**
     * Draws a line on the screen from (x1, y1) to (x2, y2).
     *
     * @see java.awt.Graphics.drawLine
     */
    public void drawLine (int x1, int y1, int x2, int y2)
    {
	graphicsCanvas.drawLine (x1, y1, x2, y2, graphicsColor);
    } // drawLine (int, int, int, int)


    /**
     * Draws a maple leaf on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @param x The x coordinate of the top left corner of the
     *    rectangle that the maple leaf is inscribed in.
     * @param y The y coordinate of the top left corner of the
     *    rectangle that the maple leaf is inscribed in.
     * @param width The width of the rectangle that the
     *    maple leaf is inscribed in.
     * @param height The height of the rectangle that the
     *    maple leaf is inscribed in.
     */
    public void drawMapleLeaf (int x, int y, int width, int height)
    {
	int[] xPoints, yPoints;
	float rx, ry, xc, yc;

	rx = width;
	ry = height;
	xc = x + rx / 2;
	yc = y + height;

	xPoints = new int [26];
	yPoints = new int [26];
	xPoints [0] = (int) (xc + rx * 0.021423);
	yPoints [0] = (int) (yc - ry * 0.215686);
	xPoints [1] = (int) (xc + rx * 0.270780);
	yPoints [1] = (int) (yc - ry * 0.203804);
	xPoints [2] = (int) (xc + rx * 0.271820);
	yPoints [2] = (int) (yc - ry * 0.295752);
	xPoints [3] = (int) (xc + rx * 0.482015);
	yPoints [3] = (int) (yc - ry * 0.411765);
	xPoints [4] = (int) (xc + rx * 0.443046);
	yPoints [4] = (int) (yc - ry * 0.483267);
	xPoints [5] = (int) (xc + rx * 0.500000);
	yPoints [5] = (int) (yc - ry * 0.587435);
	xPoints [6] = (int) (xc + rx * 0.363353);
	yPoints [6] = (int) (yc - ry * 0.619576);
	xPoints [7] = (int) (xc + rx * 0.342287);
	yPoints [7] = (int) (yc - ry * 0.693849);
	xPoints [8] = (int) (xc + rx * 0.153596);
	yPoints [8] = (int) (yc - ry * 0.612537);
	xPoints [9] = (int) (xc + rx * 0.201601);
	yPoints [9] = (int) (yc - ry * 0.918462);
	xPoints [10] = (int) (xc + rx * 0.093001);
	yPoints [10] = (int) (yc - ry * 0.894514);
	xPoints [11] = (int) xc;
	yPoints [11] = (int) (yc - ry);
	xPoints [12] = (int) (xc - rx * 0.093001);
	yPoints [12] = yPoints [10];
	xPoints [13] = (int) (xc - rx * 0.201601);
	yPoints [13] = yPoints [9];
	xPoints [14] = (int) (xc - rx * 0.153596);
	yPoints [14] = yPoints [8];
	xPoints [15] = (int) (xc - rx * 0.342287);
	yPoints [15] = yPoints [7];
	xPoints [16] = (int) (xc - rx * 0.363353);
	yPoints [16] = yPoints [6];
	xPoints [17] = (int) (xc - rx * 0.500000);
	yPoints [17] = yPoints [5];
	xPoints [18] = (int) (xc - rx * 0.443046);
	yPoints [18] = yPoints [4];
	xPoints [19] = (int) (xc - rx * 0.482015);
	yPoints [19] = yPoints [3];
	xPoints [20] = (int) (xc - rx * 0.271820);
	yPoints [20] = yPoints [2];
	xPoints [21] = (int) (xc - rx * .2707796);
	yPoints [21] = yPoints [1];
	xPoints [22] = (int) (xc - rx * 0.021423);
	yPoints [22] = yPoints [0];
	xPoints [23] = xPoints [22];
	yPoints [23] = (int) yc;
	xPoints [24] = xPoints [0];
	yPoints [24] = yPoints [23];
	xPoints [25] = xPoints [0];
	yPoints [25] = yPoints [0];
	graphicsCanvas.drawPolygon (xPoints, yPoints, 26, graphicsColor);
    } // drawMapleLeaf (int, int, int, int)


    /**
     * Draws an oval on the screen in the sqaure from (x, y) to
     * (x + width, y + height).
     *
     * @see java.awt.Graphics.drawOval
     */
    public void drawOval (int x, int y, int width, int height)
    {
	graphicsCanvas.drawOval (x, y, width, height, graphicsColor);
    } // drawOval (int, int, int, int)


    /**
     * Draws a polygon specified by the arrays of points.
     *
     * @see java.awt.Graphics.drawPolygon
     */
    public void drawPolygon (int[] xPoints, int[] yPoints, int nPoints)
    {
	graphicsCanvas.drawPolygon (xPoints, yPoints, nPoints, graphicsColor);
    } // drawPolygon (int[], int[], int)


    /**
     * Draws a rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.drawRect
     */
    public void drawRect (int x, int y, int width, int height)
    {
	graphicsCanvas.drawRect (x, y, width, height, graphicsColor);
    } // drawRect (int, int, int, int)


    /**
     * Draws a rounded rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.drawRoundRect
     */
    public void drawRoundRect (int x, int y, int width, int height,
	    int arcWidth, int arcHeight)
    {
	graphicsCanvas.drawRoundRect (x, y, width, height,
		arcWidth, arcHeight, graphicsColor);
    } // drawRoundRect (int, int, int, int, int, int)


    /**
     * Draws a star on the screen from (x, y) to (x + width, y + width).
     *
     * @param x The x coordinate of the top left corner of the
     *    rectangle that the star is inscribed in.
     * @param y The y coordinate of the top left corner of the
     *    rectangle that the star is inscribed in.
     * @param width The width of the rectangle that the
     *    star is inscribed in.
     * @param height The height of the rectangle that the
     *    star is inscribed in.
     */
    public void drawStar (int x, int y, int width, int height)
    {
	int[] xPoints, yPoints;
	float rx, ry, xc, yc;

	rx = width;
	ry = height;
	xc = x + rx / 2;
	yc = y + height;

	xPoints = new int [11];
	yPoints = new int [11];
	xPoints [0] = (int) xc;
	yPoints [0] = (int) (yc - ry);
	xPoints [1] = (int) (xc + rx * 0.118034);
	yPoints [1] = (int) (yc - ry * 0.618560);
	xPoints [2] = (int) (xc + rx * 0.500000);
	yPoints [2] = yPoints [1];
	xPoints [3] = (int) (xc + rx * 0.190983);
	yPoints [3] = (int) (yc - ry * 0.381759);
	xPoints [4] = (int) (xc + rx * 0.309017);
	yPoints [4] = (int) yc;
	xPoints [5] = (int) xc;
	yPoints [5] = (int) (yc - ry * 0.236068);
	xPoints [6] = (int) (xc - rx * 0.309017);
	yPoints [6] = yPoints [4];
	xPoints [7] = (int) (xc - rx * 0.190983);
	yPoints [7] = yPoints [3];
	xPoints [8] = (int) (xc - rx * 0.500000);
	yPoints [8] = yPoints [2];
	xPoints [9] = (int) (xc - rx * 0.118034);
	yPoints [9] = yPoints [1];
	xPoints [10] = xPoints [0];
	yPoints [10] = yPoints [0];
	graphicsCanvas.drawPolygon (xPoints, yPoints, 11, graphicsColor);
    } // drawStar (int, int, int, int)


    /**
     * Draws a text on the screen at location (x, y).
     *
     * @see java.awt.Graphics.drawString
     */
    public void drawString (String str, int x, int y)
    {
	graphicsCanvas.drawString (str, x, y, font, graphicsColor);
    } // drawString (String, int, int)


    /**
     * Erases the entire line of input.     Called  when the user presses Ctrl+U
     * when typing.
     */
    protected void eraseLineOfInput ()
    {
	int numChars, cnt;

	numChars = (actualCol - startCol) + maxCol * (actualRow - startRow);
	currentRow = startRow;
	currentCol = startCol;
	actualRow = startRow;
	actualCol = startCol;
	for (cnt = 0 ; cnt < numChars ; cnt++)
	    print (" ");
	currentRow = startRow;
	currentCol = startCol;
	actualRow = startRow;
	actualCol = startCol;
	graphicsCanvas.setCursorPos (currentRow, currentCol);
    } // eraseLineOfInput (void)


    /**
     * Erases the previous character in a line of input.  Called when the user
     * presses backspace when typing.
     */
    protected void erasePreviousChar ()
    {
	if (currentCol > 1)
	{
	    currentCol--;
	}
	else
	{
	    if (currentRow > 1)
	    {
		currentRow--;
		currentCol = maxCol;
	    }
	}
	actualRow = currentRow;
	actualCol = currentCol;

	graphicsCanvas.drawText (currentRow, currentCol, " ", textColor, textBGColor);
	graphicsCanvas.setCursorPos (currentRow, currentCol);

	if ((currentCol == 1) && (currentRow != startRow))
	{
	    currentCol = maxCol + 1;
	    currentRow--;
	}
    } // erasePreviousChar (void)


    /**
     * Draws a filled 3D rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.fill3DRect
     */
    public void fill3DRect (int x, int y, int width, int height,
	    boolean raised)
    {
	graphicsCanvas.fill3DRect (x, y, width, height, raised,
		graphicsColor);
    } //fill3DRect (int, int, int, int, boolean)


    /**
     * Draws a filled arc on the screen from (x, y) to
     * (x + width, y + height) from startAngle to startAngle + arcAngle
     * in specified colour.
     *
     * @see java.awt.Graphics.fillArc
     */
    public void fillArc (int x, int y, int width, int height,
	    int startAngle, int arcAngle)
    {
	graphicsCanvas.fillArc (x, y, width, height, startAngle,
		arcAngle, graphicsColor);
    } // fillArc (int, int, int, int, int, int)


    /**
     * Draws a filled maple leaf on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @param x int The x coordinate of the top left corner of the
     *    rectangle that the maple leaf is inscribed in.
     * @param y int The y coordinate of the top left corner of the
     *    rectangle that the maple leaf is inscribed in.
     * @param width int The width of the rectangle that the
     *    maple leaf is inscribed in.
     * @param height int The height of the rectangle that the
     *    maple leaf is inscribed in.
     */
    public void fillMapleLeaf (int x, int y, int width, int height)
    {
	int[] xPoints, yPoints;
	float rx, ry, xc, yc;

	rx = width;
	ry = height;
	xc = x + rx / 2;
	yc = y + height;

	xPoints = new int [26];
	yPoints = new int [26];
	xPoints [0] = (int) (xc + rx * 0.021423);
	yPoints [0] = (int) (yc - ry * 0.215686);
	xPoints [1] = (int) (xc + rx * 0.270780);
	yPoints [1] = (int) (yc - ry * 0.203804);
	xPoints [2] = (int) (xc + rx * 0.271820);
	yPoints [2] = (int) (yc - ry * 0.295752);
	xPoints [3] = (int) (xc + rx * 0.482015);
	yPoints [3] = (int) (yc - ry * 0.411765);
	xPoints [4] = (int) (xc + rx * 0.443046);
	yPoints [4] = (int) (yc - ry * 0.483267);
	xPoints [5] = (int) (xc + rx * 0.500000);
	yPoints [5] = (int) (yc - ry * 0.587435);
	xPoints [6] = (int) (xc + rx * 0.363353);
	yPoints [6] = (int) (yc - ry * 0.619576);
	xPoints [7] = (int) (xc + rx * 0.342287);
	yPoints [7] = (int) (yc - ry * 0.693849);
	xPoints [8] = (int) (xc + rx * 0.153596);
	yPoints [8] = (int) (yc - ry * 0.612537);
	xPoints [9] = (int) (xc + rx * 0.201601);
	yPoints [9] = (int) (yc - ry * 0.918462);
	xPoints [10] = (int) (xc + rx * 0.093001);
	yPoints [10] = (int) (yc - ry * 0.894514);
	xPoints [11] = (int) xc;
	yPoints [11] = (int) (yc - ry);
	xPoints [12] = (int) (xc - rx * 0.093001);
	yPoints [12] = yPoints [10];
	xPoints [13] = (int) (xc - rx * 0.201601);
	yPoints [13] = yPoints [9];
	xPoints [14] = (int) (xc - rx * 0.153596);
	yPoints [14] = yPoints [8];
	xPoints [15] = (int) (xc - rx * 0.342287);
	yPoints [15] = yPoints [7];
	xPoints [16] = (int) (xc - rx * 0.363353);
	yPoints [16] = yPoints [6];
	xPoints [17] = (int) (xc - rx * 0.500000);
	yPoints [17] = yPoints [5];
	xPoints [18] = (int) (xc - rx * 0.443046);
	yPoints [18] = yPoints [4];
	xPoints [19] = (int) (xc - rx * 0.482015);
	yPoints [19] = yPoints [3];
	xPoints [20] = (int) (xc - rx * 0.271820);
	yPoints [20] = yPoints [2];
	xPoints [21] = (int) (xc - rx * .2707796);
	yPoints [21] = yPoints [1];
	xPoints [22] = (int) (xc - rx * 0.021423);
	yPoints [22] = yPoints [0];
	xPoints [23] = xPoints [22];
	yPoints [23] = (int) yc;
	xPoints [24] = xPoints [0];
	yPoints [24] = yPoints [23];
	xPoints [25] = xPoints [0];
	yPoints [25] = yPoints [0];
	graphicsCanvas.fillPolygon (xPoints, yPoints, 26, graphicsColor);
    } // fillMapleLeaf (int, int, int, int)


    /**
     * Draws a filled oval on the screen in the sqaure from (x, y) to
     * (x + width, y + height).
     *
     * @see java.awt.Graphics.fillOval
     */
    public void fillOval (int x, int y, int width, int height)
    {
	graphicsCanvas.fillOval (x, y, width, height, graphicsColor);
    } // fillOval (int, int, int, int)


    /**
     * Draws a filled polygon specified by the arrays of points..
     *
     * @see java.awt.Graphics.fillPolygon
     */
    public void fillPolygon (int[] xPoints, int[] yPoints, int nPoints)
    {
	graphicsCanvas.fillPolygon (xPoints, yPoints, nPoints, graphicsColor);
    } // fillPolygon (int[], int[], int)


    /**
     * Draws a filled rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.fillRect
     */
    public void fillRect (int x, int y, int width, int height)
    {
	graphicsCanvas.fillRect (x, y, width, height, graphicsColor);
    } // fillRect (int, int, int, int)


    /**
     * Draws a filled rounded rectangle on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @see java.awt.Graphics.fillRoundRect
     */
    public void fillRoundRect (int x, int y, int width, int height,
	    int arcWidth, int arcHeight)
    {
	graphicsCanvas.fillRoundRect (x, y, width, height, arcWidth,
		arcHeight, graphicsColor);
    } // fillRoundRect (int, int, int, int, int, int)


    /**
     * Draws a filled star on the screen from (x, y) to
     * (x + width, y + width).
     *
     * @param x The x coordinate of the top left corner of the
     *    rectangle that the star is inscribed in.
     * @param y The y coordinate of the top left corner of the
     *    rectangle that the star is inscribed in.
     * @param width The width of the rectangle that the
     *    star is inscribed in.
     * @param height The height of the rectangle that the
     *    star is inscribed in.
     */
    public void fillStar (int x, int y, int width, int height)
    {
	int[] xPoints, yPoints;
	float rx, ry, xc, yc;

	rx = width;
	ry = height;
	xc = x + rx / 2;
	yc = y + height;

	xPoints = new int [11];
	yPoints = new int [11];
	xPoints [0] = (int) xc;
	yPoints [0] = (int) (yc - ry);
	xPoints [1] = (int) (xc + rx * 0.118034);
	yPoints [1] = (int) (yc - ry * 0.618560);
	xPoints [2] = (int) (xc + rx * 0.500000);
	yPoints [2] = yPoints [1];
	xPoints [3] = (int) (xc + rx * 0.190983);
	yPoints [3] = (int) (yc - ry * 0.381759);
	xPoints [4] = (int) (xc + rx * 0.309017);
	yPoints [4] = (int) yc;
	xPoints [5] = (int) xc;
	yPoints [5] = (int) (yc - ry * 0.236068);
	xPoints [6] = (int) (xc - rx * 0.309017);
	yPoints [6] = yPoints [4];
	xPoints [7] = (int) (xc - rx * 0.190983);
	yPoints [7] = yPoints [3];
	xPoints [8] = (int) (xc - rx * 0.500000);
	yPoints [8] = yPoints [2];
	xPoints [9] = (int) (xc - rx * 0.118034);
	yPoints [9] = yPoints [1];
	xPoints [10] = xPoints [0];
	yPoints [10] = yPoints [0];
	graphicsCanvas.fillPolygon (xPoints, yPoints, 11, graphicsColor);
    } // fillStar (int, int, int, int)


    /**
     * Returns whether a character is available in the keyboard buffer.
     * Ignores characters currently in the line buffer.
     *
     * @return true if a character is ready to be read with getChar
     */
    public synchronized boolean isCharAvail ()
    {
	return kbdBufferHead != kbdBufferTail;
    } // isCharAvail (void)


    /**
     * Returns the next character entered on the keyboard.  Ignores characters
     * currently in the line buffer.
     *
     * @return The next character entered on the keyboard.
     */
    public synchronized char getChar ()
    {
	while (kbdBufferHead == kbdBufferTail)
	{
	    try
	    {
		setWindowTitle ("Waiting for input");
		wait ();
		setWindowTitle ("Running");
	    }
	    catch (InterruptedException e)
	    {
	    }
	}

	char ch = kbdBuffer [kbdBufferTail];
	kbdBufferTail = (kbdBufferTail + 1) % kbdBuffer.length;

	return ch;
    } // getChar (void)


    /**
     * Returns the current column number of the cursor.
     *
     * @return The current column number of the cursor.
     */
    public int getColumn ()
    {
	return consoleCanvas.getCurrentColumn ();
    } // getColumn (void)


    /**
     * Returns the height of the console drawing surface in pixels.
     *
     * @return The height of the console window in pixels.
     */
    public int getHeight ()
    {
	return graphicsCanvas.getDrawingAreaHeight ();
    } // int getDrawHeight (void)


    /**
     * Returns the number of columns in the console window.
     *
     * @return The width of the screen in columns.
     */
    public int getMaxColumns ()
    {
	return (maxCol);
    } // int maxcol (void)


    /**
     * Returns the number of rows in the console window.
     *
     * @return The height of the screen in rows.
     */
    public int getMaxRows ()
    {
	return (maxRow);
    } // int getMaxRows (void)


    /**
     * Returns the current row number of the cursor.
     *
     * @return The current row number of the cursor.
     */
    public int getRow ()
    {
	return consoleCanvas.getCurrentRow ();
    } // getRow (void)


    /**
     * Returns the width of the console drawing surface in pixels.
     *
     * @return The width of the console drawing surface in pixels.
     */
    public int getWidth ()
    {
	return graphicsCanvas.getDrawingAreaWidth ();
    } // int getDrawWidth (void)


    /**
     * Returns the number of columns in the console window.
     *
     * @return The width of the screen in columns.
     */
    public int maxcol ()
    {
	return (getMaxColumns ());
    } // int maxcol (void)


    /**
     * Returns the number of rows in the console window.
     *
     * @return The height of the screen in rows.
     */
    public int maxrow ()
    {
	return (getMaxRows ());
    } // int getMaxRows (void)


    /**
     * Returns the maximum x coordinate of the console window in pixels.
     * Available for compatibility with first printing of "Programming Concepts"
     *
     * @return The maximum x coordinate of the console window in pixels.
     */
    public int maxx ()
    {
	return graphicsCanvas.getDrawingAreaWidth () - 1;
    } // int maxx (void)


    /**
     * Returns the maximum y coordinate of the console window in pixels.
     * Available for compatibility with first printing of "Programming Concepts"
     *
     * @return The maximum y coordinate the console window in pixels.
     */
    public int maxy ()
    {
	return graphicsCanvas.getDrawingAreaHeight () - 1;
    } // int maxy (void)


    /**
     * Write a string to the Console.
     *
     * @param text The string to be written to the Console
     */
    public void print (String text)
    {
	// Convert the printing of null to a printable string.
	if (text == null)
	{
	    text = "<null>";
	}

	int index = 0;
	int len = text.length ();
	int start = 0;
	char ch;

	while (true)
	{
	    index = start;
	    if (index == len)
	    {
		graphicsCanvas.setCursorPos (actualRow, actualCol);
		return;
	    }
	    ch = text.charAt (index);
	    while ((index < len) && (text.charAt (index) != '\n') &&
		    (text.charAt (index) != '\t') &&
		    (index - start < maxCol - currentCol))
	    {
		index++;
	    }
	    if (start != index)
	    {
		// Draw what we have so far
		graphicsCanvas.drawText (currentRow, currentCol,
			text.substring (start, index), textColor, textBGColor);
		currentCol += index - start;
		actualCol = currentCol;
	    }
	    if (index == len)
	    {
		graphicsCanvas.setCursorPos (actualRow, actualCol);
		return;
	    }
	    if (text.charAt (index) == '\n')
	    {
		if ((currentRow <= maxRow) && (currentCol <= maxCol))
		{
		    graphicsCanvas.clearToEOL (currentRow, currentCol, textBGColor);
		}
		if (currentRow < maxRow)
		{
		    currentCol = 1;
		    currentRow++;
		    actualCol = currentCol;
		    actualRow = currentRow;
		}
		else
		{
		    graphicsCanvas.scrollUpALine (textBGColor);
		    startRow--;
		    currentCol = 1;
		    actualCol = currentCol;
		}
	    }
	    else if (text.charAt (index) == '\t')
	    {
		int numSpaces = TAB_SIZE - ((currentCol - 1) % TAB_SIZE);
		// If the next tab position is off the end of the screen,
		// scroll down a line and place the cursor at the beginning
		// of the line.
		if (currentCol + numSpaces > maxCol)
		{
		    print ("\n");
		}
		else
		{
		    print ("        ".substring (0, numSpaces));
		}
	    }
	    else
	    {
		if (currentCol <= maxCol)
		{
		    graphicsCanvas.drawText (currentRow, currentCol,
			    text.substring (index, index + 1), textColor, textBGColor);
		    if (currentCol < maxCol)
		    {
			currentCol++;
			actualCol = currentCol;
		    }
		    else
		    {
			if (currentRow < maxRow)
			{
			    currentCol++;
			    actualCol = 1;
			    actualRow++;
			}
			else
			{
			    currentCol++;
			}
		    }
		}
		else
		{
		    if (currentRow < maxRow)
		    {
			currentRow++;
		    }
		    else
		    {
			graphicsCanvas.scrollUpALine (textBGColor);
			startRow--;
		    }
		    graphicsCanvas.drawText (currentRow, 1,
			    text.substring (index, index + 1), textColor, textBGColor);
		    currentCol = 2;
		    actualCol = currentCol;
		    actualRow = currentRow;
		}
	    }
	    start = index + 1;
	} // while
    } // print (String)


    /**
     * Reads a single character from the Console.  Note that this discards any
     * whitespace.  If you want to get every character on the line, use
     * the readLine () method.
     *
     * @return The character read from the Console
     */
    public synchronized char readChar ()
    {
	char result, ch;

	if (ungotChar != EMPTY_BUFFER)
	{
	    result = (char) ungotChar;
	    ungotChar = EMPTY_BUFFER;
	    return (result);
	}

	if (lineBufferHead != lineBufferTail)
	{
	    result = lineBuffer [lineBufferTail];
	    lineBufferTail = (lineBufferTail + 1) % lineBuffer.length;
	    return (result);
	}

	startRow = currentRow;
	startCol = currentCol;
	if (currentRow > maxRow)
	{
	    startRow++;
	    currentCol = 1;
	}

	// Turn cursor on if necessary
	consoleCanvas.setCursorVisible (true);

	// Wait for a character to be entered
	while (true)
	{
	    ch = getChar ();

	    if (ch == '\n')
	    {
		clearToEOL = false;
		if (echoOn)
		    print ("\n");
		clearToEOL = true;
		lineBuffer [lineBufferHead] = '\n';
		lineBufferHead = (lineBufferHead + 1) % lineBuffer.length;
		break;
	    }
	    if (ch == '\b')
	    {
		if (lineBufferHead == lineBufferTail)
		{
		    consoleCanvas.invertScreen ();
		}
		else
		{
		    int chToErase;

		    lineBufferHead = (lineBufferHead + lineBuffer.length - 1) % lineBuffer.length;
		    chToErase = lineBuffer [lineBufferHead];
		    if (echoOn)
		    {
			if (chToErase != '\t')
			{
			    erasePreviousChar ();
			}
			else
			{
			    int cnt;
			    eraseLineOfInput ();
			    cnt = lineBufferTail;
			    while (cnt != lineBufferHead)
			    {
				print (lineBuffer [cnt]);
				cnt = (cnt + 1) % lineBuffer.length;
			    }
			}
		    }
		}
	    } // if backspace
	    else if (ch == '\025')
	    {
		if (echoOn)
		{
		    eraseLineOfInput ();
		}
		lineBufferHead = lineBufferTail;
	    }
	    else
	    {
		if (echoOn)
		{
		    print (ch);
		}
		lineBuffer [lineBufferHead] = ch;
		lineBufferHead = (lineBufferHead + 1) % lineBuffer.length;
	    }
	} // while

	result = lineBuffer [lineBufferTail];
	lineBufferTail = (lineBufferTail + 1) % lineBuffer.length;

	// Turn cursor on if necessary
	consoleCanvas.setCursorVisible (false);

	return (result);
    } // char readChar (void)


    /**
     * Sets the foreground color for any graphics.
     *
     * @see java.awt.Graphics.setColor
     */
    public void setColor (Color color)
    {
	graphicsColor = color;
    } // setColor (Color)


    /**
     * Sets the foreground colour for any graphics.
     *
     * @see java.awt.Graphics.setColor
     */
    public void setColour (Color colour)
    {
	setColor (colour);
    } // setColour (Color)


    /**
     * Moves the cursor to the specified row and column.
     *
     * @param row The row to move the cursor to
     * @param column The column to move the cursor to
     */
    public void setCursor (int row, int column)
    {
	currentRow = row;
	currentCol = column;
	actualRow = row;
	actualCol = column;
	graphicsCanvas.setCursorPos (currentRow, currentCol);
    } // setCursor (int, int)


    /**
     * Makes the blinking cursor visible or invisible.
     */
    public void setCursorVisible (boolean visible)
    {
	consoleCanvas.setCursorVisible (visible);
    } // setCursorVisible (boolean)


    /**
     * Sets the font for the drawString method.
     *
     * @see java.awt.Graphics.setFont
     */
    public void setFont (Font font)
    {
	this.font = font;
    } // setFont (Font)


    /**
     * Sets the drawing mode for any graphics to "Paint".
     *
     * @see java.awt.Graphics.setPaintMode
     */
    public void setPaintMode ()
    {
	graphicsCanvas.setPaintMode ();
    } // setPaintMode (void)


    /**
     * Sets the background color for any text.
     *
     * @param color The color that text displayed by print and println
     *    methods will appear on.
     */
    public void setTextBackgroundColor (Color color)
    {
	textBGColor = color;
    } // setTextBackgroundColor (Color)


    /**
     * Sets the background color for any text.
     *
     * @param colour The color that text displayed by print and println
     *    methods will appear on.
     */
    public void setTextBackgroundColour (Color colour)
    {
	setTextBackgroundColor (colour);
    } // setTextBackgroundColour (Color)


    /**
     * Sets the foreground color for any text.
     *
     * @param color The color that text displayed by print and println
     *    methods will appear in.
     */
    public void setTextColor (Color color)
    {
	textColor = color;
    } // setTextColor (Color)


    /**
     * Sets the foreground colour for any text.
     *
     * @param colour The color that text displayed by print and println
     *    methods will appear in.
     */
    public void setTextColour (Color colour)
    {
	setTextColor (colour);
    } // setTextColour (Color)


    /**
     * Sets the drawing mode for any graphics to "XOR".
     *
     * @see java.awt.Graphics.setXORMode
     */
    public void setXORMode (Color xorColor)
    {
	graphicsCanvas.setXORMode (xorColor);
    } // setXORMode (Color)
    
    
    public static void mainReturned ()
    {
	mainReturned = true;
    } // executionFinished (void)
} /* Console class */
