package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleParent class is the parent class of the two console classes:
 *    Console - A graphics console.
 *    TextConsole - A text console.
 * <p>
 * This is an abstract class that factors out the common behaviour
 * between the two classes.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *                      http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 3.0 2003/04/11
 */

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

abstract class ConsoleParent
    implements ActionListener, FocusListener, KeyListener, WindowListener
{
    //
    // Constants
    //

    // The button commands,
    protected static final String SAVE_COMMAND = "save";
    protected static final String PRINT_COMMAND = "print";
    protected static final String QUIT_COMMAND = "quit";
    // Default attributes of the Console
    protected static final int DEFAULT_ROWS = 25;
    protected static final int DEFAULT_COLUMNS = 80;
    protected static final int DEFAULT_FONT_SIZE = 14;
    protected static final String DEFAULT_TITLE = "Console";
    // The size of a tab in spaces.
    protected final static int TAB_SIZE = 8;

    //
    // Fields
    //

    // The window in which the Console is displayed.
    protected ConsoleFrame window;
    // The number of Console objects instantiated.
    private static int numConsoles = 0;
    // The size of the console in rows and columns.
    protected int maxRow = 0;
    protected int maxCol = 0;
    // Keyboard buffer variables
    protected static final int BUFFER_SIZE = 2048;
    protected static final int EMPTY_BUFFER = -1;
    protected char[] kbdBuffer = new char [BUFFER_SIZE];
    protected int kbdBufferHead = 0, kbdBufferTail = 0;
    protected char[] lineBuffer = new char [BUFFER_SIZE];
    protected int lineBufferHead = 0, lineBufferTail = 0;
    protected int ungotChar = EMPTY_BUFFER;
    // The base title of the window
    private String baseWindowTitle;

    // Panel to place the inner parts of the console
    protected Panel consoleCanvasPanelInner;

    /**
     * The drawing surface.
     */
    ConsoleCanvas consoleCanvas;

    /**
     *
     */
    protected boolean eofReached = false;

    /**
     * Initializes the window.  Not in the constructor because
     * it needs certain elements that are not ready at construction
     * time.
     */
    protected void initialize (int rows, int columns, int fontSize,
	    String title)
    {
	// Increment the number of existing widnows
	numConsoles++;

	// If there's more than one console window, set the title
	if ((title.equals (DEFAULT_TITLE)) && (numConsoles > 1))
	{
	    title = title + " " + numConsoles;
	}
	baseWindowTitle = title;

	// Set the size of the window.
	maxCol = columns;
	maxRow = rows;

	// Create the Frame in which the Console will be displayed.
	window = new ConsoleFrame (this, consoleCanvasPanelInner);

	window.pack ();
	window.setResizable (false);
	
	setWindowTitle ("Running");

	// Place frame in the upper-right corner of the screen
	java.awt.Dimension screenSize =
	    Toolkit.getDefaultToolkit ().getScreenSize ();
	Point loc;
	loc = new java.awt.Point ((screenSize.width - window.getWidth ()), 0);
	loc.x -= (numConsoles - 1) * 30;
	loc.y += (numConsoles - 1) * 30;
	window.setLocation (loc);

	// Show the frame.
	window.toFront ();
	window.show ();

	// Give the system a 10th of a secon to do the drawing and switch
	// the focus to whatever component it's going to switch the focus
	// to.  (We hope this is the canvas, but it might not be...)
	try
	{
	    Thread.sleep (100);
	}
	catch (InterruptedException e)
	{
	    ;
	}

	// With all the default focus switching done, we now set the focus
	// we really want.
	consoleCanvas.requestFocus ();
	window.repaint ();
    } // initialize method


    /**
     * Quits the program, saves the contents of the window, or prints the
     * contents of the window, depending on which button is pressed.  Called
     * by the system when a button in the Console is pressed.
     */
    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals (QUIT_COMMAND))
	{
	    quitProgram ();
	}
	else if (e.getActionCommand ().equals (SAVE_COMMAND))
	{
	    consoleCanvas.saveContents ();
	    consoleCanvas.requestFocus ();
	}
	else if (e.getActionCommand ().equals (PRINT_COMMAND))
	{
	    consoleCanvas.printContents ();
	}
    } // actionPerformed (ActionEvent)


    /**
     * Closes the console window.
     */
    public void close ()
    {
	consoleCanvas.killCursorThread ();
	window.dispose ();
    } // close (void)


    /**
     * Enables or disables all the buttons in the Console.  Used while the
     * contents of the window is being saved or printed.
     */
    protected void enableButtons (boolean enable)
    {
	window.enableButtons (enable);
    } // enableButtons (boolean)


    /**
     * Sets the focus to the invisible button and then the console canvas.
     * This is necessary as a work-around to a bug in VisualAge for Java,
     * which gives buttons default focus that can only be removed by making
     * another button a focus. Called by the system when the Console gains
     * focus.
     */
    public synchronized void focusGained (FocusEvent e)
    {
	consoleCanvas.requestFocus ();
    } // focusGained (FocusEvent)


    /**
     * Does nothing.   Called by the system when the Console loses focus.
     */
    public synchronized void focusLost (FocusEvent e)
    {
    } // focusLost (FocusEvent)


    /**
     * Places a keystroke in the keyboard buffer. It is synchronized so that
     * there can't be a problem with input being taken off the keyboard buffer
     * and placed on the keyboard buffer at the same time.
     */
    public synchronized void keyPressed (KeyEvent e)
    {
	// This is a workaround for a bug where the canvas isn't given
	// focus back!  The frame appears to have it, however.
	if (!consoleCanvas.hasFocus)
	{
	    consoleCanvas.focusGained (null);
	}

	char ch = e.getKeyChar ();
	// Handle standard keystrokes including backspace, newline and
	// Ctrl+U to delete a line of input.
	if (((' ' <= ch) && (ch <= '~')) || (ch == '\b') ||
		(ch == '\t') || (ch == '\n') || (ch == '\025'))
	{
	    // Place the keystroke into the keyboard buffer.
	    kbdBuffer [kbdBufferHead] = e.getKeyChar ();
	    kbdBufferHead = (kbdBufferHead + 1) % kbdBuffer.length;

	    // The following statements wakes up any processes that are
	    // sleeping while waiting for heyboard input.
	    notify ();
	}

	// Handke Ctrl+S to save.
	else if (ch == '\023')
	{
	    consoleCanvas.saveContents ();
	}

	// Handle Ctrl+P to print.
	else if (ch == '\020')
	{
	    consoleCanvas.printContents ();
	}

	// Handle Ctrl+Q to quit.
	else if (ch == '\021')
	{
	    quitProgram ();
	}

	// Handle Ctrl+V to paste.
	else if (ch == '\026')
	{
	    Transferable clipData =
		Toolkit.getDefaultToolkit ().getSystemClipboard ().getContents (this);

	    try
	    {
		String s =
		    (String) (clipData.getTransferData (DataFlavor.stringFlavor));
		int bufferUsed = (kbdBufferHead - kbdBufferTail + kbdBuffer.length) % kbdBuffer.length;
		if (s.length () > kbdBuffer.length - bufferUsed)
		{
		    // Current keyboard buffer isn't big enough.
		    consoleCanvas.invertScreen ();
		}
		else
		{
		    for (int cnt = 0 ; cnt < s.length () ; cnt++)
		    {
			// Place the keystroke into the keyboard buffer.
			ch = s.charAt (cnt);

			// Some systems seem to mix up CR and LF.
			if (((' ' <= ch) && (ch <= '~')) || (ch == '\n'))
			{
			    kbdBuffer [kbdBufferHead] = ch;
			    kbdBufferHead = (kbdBufferHead + 1) % kbdBuffer.length;
			}
		    }
		    notify ();
		}
	    }
	    catch (Exception exception)
	    {
		consoleCanvas.invertScreen ();
	    }
	}

	// To stop tabs from changing the focus.
	e.consume ();
    } // keyPressed (KeyEvent)


    /**
     * Does nothing.  Called by the system when a key is released.
     */
    public void keyReleased (KeyEvent e)
    {
	// This event not handled.
    } // keyReleased (KeyEvent)


    /**
     * Does nothing.  Called by the system when a key is typed.
     */
    public void keyTyped (KeyEvent e)
    {
	// This event not handled.
    } // keyTyped (KeyEvent)


    /**
     * This method is invoked if the "main" method appears to have
     * stopped executing.  This helps the user realize when the program
     * has finished execution.
     */
    protected void mainStopped ()
    {
	window.mainStopped ();
	setWindowTitle ("Finished Execution");
    } // mainStopped (void)


    /**
     * Writes the text representation of an 8-bit integer (a "byte") to
     * the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (byte number)
    {
	print ((int) number);
    } // print (byte)


    /**
     * Writes the text representation of an 8-bit integer (a "byte")
     * to the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (byte number, int fieldSize)
    {
	print ((int) number, fieldSize);
    } // print (byte, int)


    /**
     * Writes a character to the Console.
     *
     * @param ch The character to be written to the Console.
     */
    public void print (char ch)
    {
	print (String.valueOf (ch));
    } // print (char)


    /**
     * Writes a character to the Console with a specified field size..
     *
     * @param ch The character to be written to the Console.
     * @param fieldSize The field width that the character is to be written in.
     */
    public void print (char ch, int fieldSize)
    {
	String charStr = String.valueOf (ch);
	StringBuffer padding = new StringBuffer ();

	for (int cnt = 0 ; cnt < fieldSize - charStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (charStr + padding);
    } // print (char, int)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (double number)
    {
	print (String.valueOf (number));
    } // print (double)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (double number, int fieldSize)
    {
	double posValue = Math.abs (number);
	int placesRemaining = fieldSize;
	String format = null, numStr;
	StringBuffer padding = new StringBuffer ();

	if (number < 0)
	    placesRemaining--;                 // Space for the minus sign
	if (posValue < 10.0)
	    format = "0";
	else if (posValue < 100.0)
	    format = "00";
	else if (posValue < 1000.0)
	    format = "000";
	else if (posValue < 10000.0)
	    format = "0000";
	else if (posValue < 100000.0)
	    format = "00000";
	else if (posValue < 1000000.0)
	    format = "000000";
	else if (posValue < 10000000.0)
	    format = "0000000";
	else if (posValue < 100000000.0)
	    format = "00000000";

	if (format == null)
	{
	    // We're using scientific notation
	    numStr = String.valueOf (number);
	}
	else
	{
	    // Add a decimal point, if there's room
	    placesRemaining -= format.length ();
	    if (placesRemaining > 0)
	    {
		format = format + ".";
		placesRemaining--;
	    }

	    // For any addition room, add decimal places
	    for (int cnt = 0 ; cnt < placesRemaining ; cnt++)
	    {
		format = format + "#";
	    }

	    // Convert the number
	    NumberFormat form = new DecimalFormat (format);
	    numStr = form.format (number);
	}

	// If the number is not long enough, pad with spaces
	for (int cnt = 0 ; cnt < fieldSize - numStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (padding + numStr);
    } // print (double, int)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console with a specified field size and a specified number of
     * decimal places.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public void print (double number, int fieldSize, int decimalPlaces)
    {
	double posValue = Math.abs (number);
	int placesRemaining = fieldSize;
	String format = null, numStr;
	StringBuffer padding = new StringBuffer ();

	if (number < 0)
	    placesRemaining--;                 // Space for the minus sign
	if (posValue < 10.0)
	    format = "0";
	else if (posValue < 100.0)
	    format = "00";
	else if (posValue < 1000.0)
	    format = "000";
	else if (posValue < 10000.0)
	    format = "0000";
	else if (posValue < 100000.0)
	    format = "00000";
	else if (posValue < 1000000.0)
	    format = "000000";
	else if (posValue < 10000000.0)
	    format = "0000000";
	else if (posValue < 100000000.0)
	    format = "00000000";

	if (Math.abs (number) >= 100000000.0)
	{
	    // We're using scientific notation
	    numStr = String.valueOf (number);
	}
	else
	{
	    format = "0.";

	    // For any addition room, add decimal places
	    for (int cnt = 0 ; cnt < decimalPlaces ; cnt++)
	    {
		format = format + "0";
	    }

	    // Convert the number
	    NumberFormat form = new DecimalFormat (format);
	    form.setMinimumIntegerDigits (1);
	    numStr = form.format (number);
	}

	// If the number is not long enough, pad with spaces
	for (int cnt = 0 ; cnt < fieldSize - numStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (padding + numStr);
    } // print (double, int, int)


    /**
     * Writes a floating point number (a "float") to the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (float number)
    {
	print (String.valueOf (number));
    } // print (float)


    /**
     * Writes a floating point number (a "float") to
     * the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (float number, int fieldSize)
    {
	print ((double) number, fieldSize);
    } // print (float, int)


    /**
     * Writes a floating point number (a "double") to the Console with a
     * specified field size and a specified number of decimal places.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public void print (float number, int fieldSize, int decimalPlaces)
    {
	print ((double) number, fieldSize, decimalPlaces);
    } // print (float, int, int)


    /**
     * Writes the text representation of an 32-bit integer (an "int") to
     * the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (int number)
    {
	print (String.valueOf (number));
    } // print (int)


    /**
     * Writes the text representation of an 32-bit integer (an "int")
     * to the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (int number, int fieldSize)
    {
	String numStr = String.valueOf (number);
	StringBuffer padding = new StringBuffer ();

	for (int cnt = 0 ; cnt < fieldSize - numStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (padding + numStr);
    } // print (int, int)


    /**
     * Writes the text representation of an 64-bit integer (a "long") to
     * the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (long number)
    {
	print (String.valueOf (number));
    } // print (long)


    /**
     * Writes the text representation of an 64-bit integer (a "long")
     * to the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (long number, int fieldSize)
    {
	String numStr = String.valueOf (number);
	StringBuffer padding = new StringBuffer ();

	for (int cnt = 0 ; cnt < fieldSize - numStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (padding + numStr);
    } // print (long, int)


    /**
     * Writes a string to the Console.
     *
     * @param text The string to be written to the Console.
     *
     * This procedure is slightly complicated by the fact that if the
     * line of text went to the end of the line exactly and was followed
     * by a newline, then we only perform one newline.
     */
    public abstract void print (String text);
    /**
     * Writes a string to the Console with a specified field size..
     *
     * @param text The string to be written to the Console.
     * @param fieldSize The field width that the string is to be written in.
     */
    public void print (String text, int fieldSize)
    {
	StringBuffer padding = new StringBuffer ();

	for (int cnt = 0 ; cnt < fieldSize - text.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (text + padding);
    } // print (String, int)


    /**
     * Writes the text representation of an 16-bit integer (a "short") to
     * the Console.
     *
     * @param number The number to be written to the Console.
     */
    public void print (short number)
    {
	print ((int) number);
    } // print (short)


    /**
     * Writes the text representation of an 16-bit integer (a "short")
     * to the Console with a specified field size.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void print (short number, int fieldSize)
    {
	print ((int) number, fieldSize);
    } // print (short, int)


    /**
     * Writes the text representation of a boolean to the Console.
     *
     * @param value The boolean to be written to the Console.
     */
    public void print (boolean value)
    {
	print (String.valueOf (value));
    } // print (boolean)


    /**
     * Writes the text representation of a boolean to the Console with a
     * specified field size.
     *
     * @param value The boolean to be written to the Console.
     * @param fieldSize The field width that the boolean is to be written in.
     */
    public void print (boolean value, int fieldSize)
    {
	String boolStr = String.valueOf (value);
	StringBuffer padding = new StringBuffer ();

	for (int cnt = 0 ; cnt < fieldSize - boolStr.length () ; cnt++)
	{
	    padding.append (' ');
	}
	print (boolStr + padding);
    } // print (boolean, int)


    /**
     * Writes a newline to the Console.
     */
    public void println ()
    {
	print ("\n");
    } // println (void)


    /**
     * Writes the text representation of an 8-bit integer (a "byte") to
     * the Console followed by a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (byte number)
    {
	print (number);
	print ("\n");
    } // println (byte)


    /**
     * Writes the text representation of an 8-bit integer (a "byte")
     * to the Console with a specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (byte number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (byte, int)


    /**
     * Writes a character to the Console followed by a newline.
     *
     * @param ch The character to be written to the Console.
     */
    public void println (char ch)
    {
	print (ch);
	print ("\n");
    } // println (char)


    /**
     * Writes a character to the Console with a specified field size..
     *
     * @param ch The character to be written to the Console.
     * @param fieldSize The field width that the character is to be written in.
     */
    public void println (char ch, int fieldSize)
    {
	print (ch, fieldSize);
	print ("\n");
    } // print (char, int)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console followed by a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (double number)
    {
	print (number);
	print ("\n");
    } // println (double)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console with a specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (double number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (double, int)


    /**
     * Writes a double precision floating point number (a "double") to
     * the Console with a specified field size and a specified number of
     * decimal places followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public void println (double number, int fieldSize, int decimalPlaces)
    {
	print (number, fieldSize, decimalPlaces);
	print ("\n");
    } // println (double, int, int)


    /**
     * Writes a floating point number (a "float") to the Console followed by
     * a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (float number)
    {
	print (number);
	print ("\n");
    } // println (float)


    /**
     * Writes a floating point number (a "float") to the Console with a
     * specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (float number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (float, int)


    /**
     * Writes a floating point number (a "double") to the Console with a
     * specified field size and a specified number of decimal places
     * followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     * @param decimalPlaces The number of decimal places of the number
     *    to be displayed.
     */
    public void println (float number, int fieldSize, int decimalPlaces)
    {
	print (number, fieldSize, decimalPlaces);
	print ("\n");
    } // println (float, int, int)


    /**
     * Writes the text representation of an 32-bit integer (an "int") to
     * the Console followed by a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (int number)
    {
	print (number);
	print ("\n");
    } // println (int)


    /**
     * Writes the text representation of an 32-bit integer (an "int")
     * to the Console with a specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (int number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (int, int)


    /**
     * Writes the text representation of an 64-bit integer (a "long") to
     * the Console followed by a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (long number)
    {
	print (number);
	print ("\n");
    } // println (long)


    /**
     * Writes the text representation of an 64-bit integer (a "long")
     * to the Console with a specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (long number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (long, int)


    /**
     * Writes a string to the Console followed by a newline.
     *
     * @param text The string to be written to the Console.
     */
    public void println (String text)
    {
	print (text);
	print ("\n");
    } // print (String)


    /**
     * Writes a string to the Console with a specified field size followed by
     * a newline.
     *
     * @param text The string to be written to the Console.
     * @param fieldSize The field width that the string is to be written in.
     */
    public void println (String text, int fieldSize)
    {
	print (text, fieldSize);
	print ("\n");
    } // println (String, int)


    /**
     * Writes the text representation of an 16-bit integer (a "short") to
     * the Console followed by a newline.
     *
     * @param number The number to be written to the Console.
     */
    public void println (short number)
    {
	print (number);
	print ("\n");
    } // println (short)


    /**
     * Writes the text representation of an 16-bit integer (a "short")
     * to the Console with a specified field size followed by a newline.
     *
     * @param number The number to be written to the Console.
     * @param fieldSize The field width that the number is to be written in.
     */
    public void println (short number, int fieldSize)
    {
	print (number, fieldSize);
	print ("\n");
    } // println (short, int)


    /**
     * Writes the text representation of a boolean to the Console followed
     * by a newline.
     *
     * @param value The boolean to be written to the Console.
     */
    public void println (boolean value)
    {
	print (value);
	print ("\n");
    } // println (boolean)


    /**
     * Writes the text representation of a boolean to the Console with a
     * specified field size followed by a newline.
     *
     * @param value The boolean to be written to the Console.
     * @param fieldSize The field width that the boolean is to be written in.
     */
    public void println (boolean value, int fieldSize)
    {
	print (value, fieldSize);
	print ("\n");
    } // println (boolean, int)


    /**
     * Hides the window and quits the program.
     */
    protected void quitProgram ()
    {
	window.setVisible (false);
	System.exit (0);
    } // quitProgram (void)


    /**
     * Reads a boolean from the Console.
     * The actual text in the Console must be either "true" or "false"
     * although case is irrelvant.
     *
     * @return The boolean value read from the Console.
     */
    public boolean readBoolean ()
    {
	String s;

	s = readToken ().toLowerCase ();
	if (s.equals ("true"))
	{
	    return (true);
	}
	else if (s.equals ("false"))
	{
	    return (false);
	}
	else
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a boolean", window);
	    // Never reaches here
	}
	return (false);
    } // boolean readBoolean ()


    /**
     * Reads an 8-bit integer (a "byte") from the Console.
     * The actual text in the Console must be a number from -128 to 127.
     *
     * @return The byte value read from the Console.
     */
    public byte readByte ()
    {
	String s = readToken ();

	try
	{
	    return (Byte.parseByte (s));
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a byte", window);
	    // Never reaches here
	}
	return (0);
    } // byte readByte (void)


    /**
     * Reads a single character from the Console.  Note that this discards any
     * whitespace.  If you want to get every character on the line, use
     * the readLine () method.
     *
     * @return The character read from the Console.
     */
    public abstract char readChar ();
    /**
     * Reads a double precision floating point number (a "double") from
     * the Console.
     *
     * @return The double value read from the Console.
     */
    public double readDouble ()
    {
	Double d;
	String s;

	s = readToken ();
	try
	{
	    d = Double.valueOf (s);
	    return (d.doubleValue ());
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a double", window);
	    // Never reaches here
	}
	return (0.0);
    } // double readDouble (void)


    /**
     * Reads a floating point number (a "float") from the Console.
     *
     * @return The float value read from the Console.
     */
    public float readFloat ()
    {
	Float f;
	String s;

	s = readToken ();
	try
	{
	    f = Float.valueOf (s);
	    return (f.floatValue ());
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a float", window);
	    // Never reaches here
	}
	return ((float) 0.0);
    } // float readFloat (void)


    /**
     * Reads a 32-bit integer (an "int") from the Console.
     * The actual text in the Console must be a number from
     * -2147483648 to 2147483647.
     *
     * @return The int value read from the Console.
     */
    public int readInt ()
    {
	String s = readToken ();

	try
	{
	    return (Integer.parseInt (s));
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a int", window);
	    // Never reaches here
	}
	return (0);
    } // int readInt (void)


    /**
     * Reads a full line of text from the Console.
     *
     * @return The line of text read from the Console.
     */
    public String readLine ()
    {
	char ch;                                // The character being read in
	String s = "";          // The string typed in

	// Skip whitespace up tio the first newline
	do
	{
	    ch = readChar ();
	}
	while (ch == ' ');

	if (ch == '\n')
	{
	    ch = readChar ();
	}

	while (ch != '\n')
	{
	    s = s + ch;
	    ch = readChar ();
	}

	return (s);
    } // String readLine (void)


    /**
     * Reads a 64-bit integer (a "long") from the Console.
     *
     * @return The long value read from the Console.
     */
    public long readLong ()
    {
	String s = readToken ();                        // The token read in

	try
	{
	    return (Long.parseLong (s));
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a long", window);
	    // Never reaches here
	}
	return (0);
    } // long readLong (void)


    /**
     * Reads a 16-bit integer (a "short") from the Console.
     * The actual text in the Console must be a number from -32768 to 32767.
     *
     * @return The short value read from the Console.
     */
    public short readShort ()
    {
	String s = readToken ();

	try
	{
	    return (Short.parseShort (s));
	}
	catch (NumberFormatException e)
	{
	    new FatalError ("Unable to convert \"" + s + "\" to a short", window);
	    // Never reaches here
	}
	return (0);
    } // short readShort (void)


    /**
     * Reads a whitespace delimited token from the Console.
     *
     * @return The token read from the Console.
     */
    public String readString ()
    {
	return (readToken ());
    } // String readString (void)


    /**
     * Reads in input from the keyboard buffer until it hits a
     * whitespace, which indicates the end of a token.
     */
    protected String readToken ()
    {
	char ch;

	StringBuffer sb = new StringBuffer ();

	// Skip white space
	do
	{
	    ch = readChar ();
	}
	while ((ch == ' ') || (ch == '\n') || (ch == '\t'));

	if (ch == '"')
	{
	    // Read until close quote
	    ch = readChar ();
	    while (ch != '"')
	    {
		sb.append (ch);
		;
		ch = readChar ();
		if (ch == '\n')
		{
		    new FatalError ("No terminating quote for quoted string");
		    // Never reaches here.
		}
	    }

	    // Read the character following the close quote.
	    ch = readChar ();
	}
	else
	{
	    do
	    {
		sb.append (ch);
		;
		ch = readChar ();
	    }
	    while ((ch != ' ') && (ch != '\n') && (ch != '\t'));
	}

	// Lastly, skip any whitespace until the end of line
	while ((ch == ' ') || (ch == '\t'))
	{
	    ch = readChar ();
	}

	if (ch != '\n')
	{
	    ungotChar = (int) ch;
	}

	return (new String (sb));
    } // String readToken (void)


    /**
     * Sets the window title.
     *
     * @param e The window event
     */
    protected void setWindowTitle (String s)
    {
	window.setTitle (baseWindowTitle + " - " + s);
    } // setWindowTitle
    
    
    /**
     * Does nothing. Called by the system after the window has been activated.
     *
     * @param e The window event
     */
    public void windowActivated (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowActivated (WindowEvent)


    /**
     * Does nothing. Called by the system after the window has been closed
     * (dispose () has been called).
     *
     * @param e The window event
     */
    public void windowClosed (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowClosed (WindowEvent)


    /**
     * Quits the program. Called by the system when the close box of the
     * window has been clicked.
     *
     * @param e The window event
     */
    public void windowClosing (WindowEvent e)
    {
	quitProgram ();
    } // windowClosing (WindowEvent)


    /**
     * Does nothing. Called by the system after the window has been deactivated.
     *
     * @param e The window event
     */
    public void windowDeactivated (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowDeactivated (WindowEvent)


    /**
     * Does nothing. Called by the system after the window has been deminimized.
     *
     * @param e The window event
     */
    public void windowDeiconified (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowDeiconified (WindowEvent)


    /**
     * Does nothing. Called by the system after the window has been minimized.
     *
     * @param e The window event
     */
    public void windowIconified (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowIconified (WindowEvent)


    /**
     * Does nothing. Called by the system after the window has been opened
     * for the first time.
     *
     * @param e The window event
     */
    public void windowOpened (java.awt.event.WindowEvent e)
    {
	// Event not handled.
    } // windowOpened (WindowEvent)
} /* ConsoleParent class */
