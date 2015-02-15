package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The CloseableFrame class is the base class for Frame objects 
 * created by the hsa package.  Frames based on this class will 
 * close when the window's close box is clicked.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *			http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */
class CloseableFrame extends java.awt.Frame 
	implements java.awt.event.ActionListener, 
		java.awt.event.WindowListener
{
/**
 * Creates a closeable window with a close box that closes the window.
 *
 * @param title The title of the window.
 */
public CloseableFrame (String title) 
{
	super (title);
	setResizable (false);
	addWindowListener (this);
} // Constructor - CloseableFrame (String) 
/**
 * Closes the window. Used as the default action for an OK button.
 *
 * @param e The action event
 */
public void actionPerformed (java.awt.event.ActionEvent e)
{
	dispose ();
} // actionPerformed (ActionEvent)
/**
 * Places the dialog in the centre of the window passed in, or in
 * the centre of the screen if no window is provided.
 *
 * @param window The window to centre the dialog on
 */
public void positionDialog (java.awt.Window window) 
{
	java.awt.Dimension dlgSize = getSize ();
	java.awt.Point loc;
	if (window == null)
	{
		// Place frame in middle of the screen
		java.awt.Dimension screenSize = getToolkit ().getScreenSize ();
		loc = new java.awt.Point (
			(screenSize.width - dlgSize.width) / 2,
			(screenSize.height - dlgSize.height) / 3);
	}
	else
	{
		java.awt.Dimension windowSize = window.getSize ();
		java.awt.Point windowLoc = window.getLocation ();
		loc = new java.awt.Point (
			windowLoc.x + (windowSize.width - dlgSize.width) / 2,
			windowLoc.y + (windowSize.height - dlgSize.height) / 3);
	}	
	setLocation (loc);
} // positionDialog (Window)
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
 * Closes the window. Called by the system when the close box of the
 * window has been clicked.
 *
 * @param e The window event
 */
public void windowClosing (java.awt.event.WindowEvent e) 
{
	dispose ();
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
} /* CloseableFrame class */