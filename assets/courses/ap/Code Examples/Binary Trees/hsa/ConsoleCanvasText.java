package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleCanvasText class implements the actual drawing surface
 * of a TextConsole object.  It holds all the text sent to the 
 * TextConsole so that the output can be scrolled through.
 * <p>	
 * The interface to the ConsoleCanvasText class are mainly the addNewLine
 * and addText methods.
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
 *			http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class ConsoleCanvasText extends ConsoleCanvas 
{
	/**
	 * Variables on the text stored in the canvas.
	 */	
	private StringBuffer[] text = new StringBuffer [1000];
	private int numLines = 1;
	private int topLine = 1;
	
	/**
	 * Information used to delete the entire line of input
	 */
	int startOfInputNumLines = 0;
	int startOfInputLastLineLength = 0;
	
	/**
	 * The Scrollbar beside the canvas.
	 */
	Scrollbar scrollbar;
/**
 * Creates the console canvas given the size of the screen in rows and 
 * columns and font size.
 *
 * @param parent The parent Console class.
 * @param rows The height of the canvas in rows of text.
 * @param columns The width of the canvas in columns of text.
 * @param fontSize The size of the font in the canvas.
 */
public ConsoleCanvasText (ConsoleParent parent, Scrollbar scrollbar, 
	int rows, int columns, int fontSize)
{
	super (parent, rows, columns, fontSize);
	
	// Set the scrollbar beside the canvas.
	this.scrollbar = scrollbar;
		
	// Set up the first line to be blank.
	text [0] = new StringBuffer ();
} // Constructor - ConsoleCanvasText (ConsoleParent, int, int, int)
/**
 * Adds a newline to the text in the buffer, expanding the buffer if
 * necessary. It also modifies the scrollbars to take into account the
 * extra line.
 */
public synchronized void addNewLine ()
{
	if (numLines == text.length)
	{
		StringBuffer[] text1 = new StringBuffer [text.length + 1000];
		if (text1 == null)
		{
			// There's no more space.  Eliminate the first third
			// of the lines.
			int numLinesToBeEliminated = text.length / 3;
			System.arraycopy (text, numLinesToBeEliminated, text, 0,
				text.length - numLinesToBeEliminated);
			numLines -= numLinesToBeEliminated;
		}
		else
		{
			System.arraycopy (text, 0, text1, 0, text.length);
			text = text1;
		}		
	}
		
	if (cursorVisible || !hasFocus) toggleCursor ();
	numLines++;
	text [numLines - 1] = new StringBuffer ();
	if (cursorVisible || !hasFocus) toggleCursor ();
	
	if (numLines <= numRows) 
	{
		scrollbar.setMaximum (numRows + 1);
	}
	else 
	{
		scrollbar.setMaximum (numLines + 1);
	}
	scrollbar.setVisibleAmount (numRows);
	if ((numLines - topLine) >= numRows)
	{
		setTopLine (numLines - numRows + 1);
		scrollbar.setValue (topLine);
	}	
} // addNewLine (void)
/**
 * Adds text to the buffer, expanding the buffer if necessary. It then
 * draw the text to the screen.
 */
public synchronized void addText (String newText) 
{
	// Scroll to bottom if necessary
	if (numLines - topLine >= numRows)
	{
		// Add to the line data base.
		text [numLines - 1].append (newText);
		
		setTopLine (numLines - numRows + 1);
		if (cursorVisible || !hasFocus) toggleCursor ();
		return;
	}
			
	// Draw the text.
	Graphics 	g = getGraphics ();
	g.translate (MARGIN, MARGIN);
	g.setColor (Color.black);
	g.setFont (font);
	int yPos = (numLines - topLine) * fontHeight + fontHeight - fontBase;
	if (cursorVisible || !hasFocus) toggleCursor ();
	
	// Add to the line data base.
	text [numLines - 1].append (newText);

	// Draw the new line.
	g.drawString (text [numLines - 1].toString (), 0 ,yPos);
	
	if (cursorVisible || !hasFocus) toggleCursor ();
} // addText (String)
/**
 * Deletes all text in the window from the start of the input (specified
 * by the call to the "markStartOfInput" method to the end of the text.
 */
public void deleteFromStartOfInput () 
{
	numLines = startOfInputNumLines;
	text [numLines - 1].setLength (startOfInputLastLineLength);
	doDraw (getGraphics ());
} // deleteFromStartOfInput (void)
/**
 * Redraws the entire ConsoleCanvasText including the margins.
 */
protected synchronized void doDraw (Graphics g)
{
	int	yPos, bottomLine = Math.min (numLines, topLine + numRows - 1);
	if (cursorVisible || !hasFocus) toggleCursor ();
	g.translate (MARGIN, MARGIN);

	// Clear the screen.
	g.clearRect (-MARGIN, -MARGIN, getSize ().width, getSize ().height);
	
	// Draw the text.
	g.setColor (Color.black);
	g.setFont (font);
	for (int line = topLine ; line <= bottomLine ; line++)
	{
		yPos = (line - topLine) * fontHeight + fontHeight - fontBase;
		g.drawString (text [line - 1].toString (), 0 ,yPos);
	}	

	if (cursorVisible || !hasFocus) toggleCursor ();
} // doDraw (Graphics)
/**
 * Erases the last character in the text buffer and redraws the drawing
 * surface.
 */
public void eraseLastChar () 
{
	if (text [numLines - 1].length () == 0)
	{
		numLines--;
	}
		
	// Remove the last character.
	text [numLines - 1].setLength (text [numLines - 1].length () - 1);
	doDraw (getGraphics ());
} // eraseLastChar (void)
/**
 * Returns the current column number of the cursor.
 *
 * @return The current column number of the cursor.
 */
public int getCurrentColumn () 
{
	return text [numLines - 1].length () + 1;
} // getCurrentColumn (void)
/**
 * Returns the current row number of the cursor.
 *
 * @return The current row number of the cursor.
 */
public int getCurrentRow () 
{
	return numLines - topLine + 1;
} // getCurrentColumn (void)
/**
 * Marks the current end of the text buffer. Used to mark where input
 * is beginning from in case the input must be deleted.
 */
public void markStartOfInput () 
{
	startOfInputNumLines = numLines;
	startOfInputLastLineLength = text [numLines - 1].length ();
} // markStartOfInput (void)
/**
 * Overrides the paint method to redraw the screen using doDraw
 */
public void paint (Graphics g)
{
	doDraw (g);
} // paint (Graphics)
/**
 * Prints the contents of the window on the printer.
 */
public void printContents ()
{
	ConsoleSavePrint savePrint = 
		new ConsoleSavePrint (parentConsole, text, numLines, 
			ConsoleSavePrint.PRINT);
	savePrint.start ();
} // printContents (void)
/**
 * Saves the contents of the window to a file.
 */
public void saveContents ()
{
	ConsoleSavePrint savePrint = 
		new ConsoleSavePrint (parentConsole, text, numLines, 
			ConsoleSavePrint.SAVE);
	savePrint.start ();
} // saveContents (void)
/**
 * Sets the top visible line in the text buffer and then redraws
 * the screen.
 */
public synchronized void setTopLine (int newTopLine) 
{
	newTopLine = Math.max (1, 
		Math.min (newTopLine, numLines - numRows + 2));
	
	if (topLine != newTopLine)
	{
		topLine = newTopLine;
		repaint ();
	}	
} // setTopLine (int)
} /* ConsoleCanvasText class */