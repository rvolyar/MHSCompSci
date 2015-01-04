// The "ConsoleFrame" class.
package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleFrame class is the frame used by both of the two Console
 * classes:
 *    Console - A graphics console.
 *    TextConsole - A text console.
 * <p>
 * @author Tom West
 * @version 3.0 2003/04/11
 */

import java.awt.*;

class ConsoleFrame extends Frame
{
    // The buttons at the top of the console
    private Button saveButton, printButton, quitButton;
    
    public ConsoleFrame (ConsoleParent parent, Panel consoleCanvasPanelInner)
    {
	super ("");
	
	addFocusListener (parent);
	addKeyListener (parent);
	addWindowListener (parent);

	// In order to place the scrollbar right beside the canvas, we
	// have to do some contortions.
	Panel consoleCanvasPanelOuter = new Panel ();
	consoleCanvasPanelOuter.setLayout (new BorderLayout ());
	consoleCanvasPanelOuter.addFocusListener (parent);
	consoleCanvasPanelOuter.addKeyListener (parent);
	// The innerConsole contains either just a canvas (for a Console)
	// or a canvas and a scroll bar (for a TextConsole)
	consoleCanvasPanelInner.addFocusListener (parent);
	consoleCanvasPanelInner.addKeyListener (parent);

	// Add the edges to the outer panel
	ConsoleEdges consoleEdgeLeft = new ConsoleEdges (ConsoleEdges.LEFT);
	consoleEdgeLeft.addFocusListener (parent);
	ConsoleEdges consoleEdgeRight = new ConsoleEdges (ConsoleEdges.RIGHT);
	consoleEdgeRight.addFocusListener (parent);
	ConsoleEdges consoleEdgeTop = new ConsoleEdges (ConsoleEdges.TOP);
	consoleEdgeTop.addFocusListener (parent);
	ConsoleEdges consoleEdgeBottom = new ConsoleEdges (ConsoleEdges.BOTTOM);
	consoleEdgeBottom.addFocusListener (parent);
	consoleCanvasPanelOuter.add ("North", consoleEdgeTop);
	consoleCanvasPanelOuter.add ("South", consoleEdgeBottom);
	consoleCanvasPanelOuter.add ("East", consoleEdgeRight);
	consoleCanvasPanelOuter.add ("West", consoleEdgeLeft);
	consoleCanvasPanelOuter.add ("Center", consoleCanvasPanelInner);
	consoleCanvasPanelOuter.add ("Center", consoleCanvasPanelInner);
	// Instantiate the buttons
	saveButton = new Button (" Save ");
	saveButton.setActionCommand (ConsoleParent.SAVE_COMMAND);
	saveButton.addActionListener (parent);
	printButton = new Button (" Print ");
	printButton.setActionCommand (ConsoleParent.PRINT_COMMAND);
	printButton.addActionListener (parent);
	quitButton = new Button (" Quit ");
	quitButton.setActionCommand (ConsoleParent.QUIT_COMMAND);
	quitButton.addActionListener (parent);
	Panel buttonPanel = new Panel ();
	buttonPanel.addFocusListener (parent);
	buttonPanel.setBackground (Color.lightGray);
	buttonPanel.setLayout (new FlowLayout (FlowLayout.CENTER, 40, 5));
	buttonPanel.add (saveButton);
	buttonPanel.add (printButton);
	buttonPanel.add (quitButton);

	// Set out layout for console
	add ("Center", consoleCanvasPanelOuter);
	add ("North", buttonPanel);

	// Position all and display
	setBackground (Color.green);
    } // Constructor - ConsoleParent (int, int, int, String)


    protected void enableButtons (boolean enable)
    {
	saveButton.setEnabled (enable);
	printButton.setEnabled (enable);
	quitButton.setEnabled (enable);
    } // enableButtons (boolean)


    protected void mainStopped ()
    {
	quitButton.setLabel (" Close ");
	//        quitButton.getParent ().invalidate ();
	quitButton.getParent ().validate ();
	//try {Thread.sleep (10000);}catch (Exception e) {}
	quitButton.getParent ().repaint ();
    } // mainStopped (void)
} // ConsoleFrame class
