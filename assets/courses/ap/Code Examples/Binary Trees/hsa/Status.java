package hsa;

/**
 * The Status class displays a message that can be updated at any point
 * along with an OK button to dismiss the dialog.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *			http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */
 
import java.awt.*;

public class Status extends CloseableFrame 
{
	private static int MINIMUM_WIDTH = 200;
	
	Label messageLabel;
	int messageWidth;
/**
 * Contructor - Status to be displayed on centre of screen.
 *
 * @param message The message to be displayed in the Status dialog box.
 */
public Status (String message)
{
	this (message, "", null);
} // Constructor - Status (String)
/**
 * Contructor - Status to be displayed on centre of a specified Frame.
 *
 * @param message The message to be displayed in the Status dialog box.
 * @param frame The Frame that the dialog box should be centred on.
 */
public Status (String message, Frame frame)
{
	this (message, "", frame);
} // Constructor - Status (String, Frame)
/**
 * Contructor - Status to be displayed on centre of screen with a 
 *              specified title.
 *
 * @param message The message to be displayed in the Status dialog box.
 * @param title The title of the Status dialog box.
 */
public Status (String message, String title)
{
	this (message, title, null);
} // Constructor - Status (String, String)
/**
 * Creates a Status dialog box (non-modal).
 *
 * @param message The message to be displayed in the Status dialog box.
 * @param frame The Frame that the dialog box should be centered on.
 * @param title The title of the Status dialog box.
 */
public Status (String message, String title, Frame frame)
{
	// Create the window
	super (title);

	setBackground (Color.lightGray);
	
	setLayout (new FlowLayout ());
	
	// Put the message at the top
	messageLabel = new Label (message, Label.CENTER);
	add (messageLabel);

	pack ();
	messageWidth = 
		getFontMetrics (messageLabel.getFont ()).stringWidth (message);

	// Place the Status Frame in the middle of the screen or Frame, as appropriate.
	Dimension dlg = getSize ();
	Point loc;
	if (frame == null)
	{
		// Place frame in middle of the screen
		Dimension screen = getToolkit ().getScreenSize ();
		loc = new Point ((screen.width - dlg.width) / 2,
			(screen.height - dlg.height) / 3);
	}
	else
	{
		// Place frame in enclosing dialog box.
		Dimension window = frame.getSize ();
		Point windowLoc = frame.getLocation ();
		loc = new Point (windowLoc.x + (window.width - dlg.width) / 2,
			windowLoc.y + (window.height - dlg.height) / 3);
	}	
	setLocation (loc);

	// Display the Status Frame.			
	show ();
}  // Constructor - Status (String, String, Frame)
public Dimension getPreferredSize () 
{
	Dimension d = super.getPreferredSize ();
	d.width = Math.max (MINIMUM_WIDTH, d.width);
	return d;
} // getPreferredSize (void)
/**
 * Sets the message being displayed in the Status Frame to the 
 * specified string.
 *
 * @param newMessage The message that the Status Frame should now display.
 */
public void setMessage (String newMessage)
{
	messageLabel.setText (newMessage);
	int newWidth = 
		getFontMetrics (messageLabel.getFont ()).stringWidth (newMessage);
	if (newWidth > messageWidth)
	{
		messageWidth = newWidth;
		messageLabel.invalidate ();	
		doLayout ();
		pack ();
	}	
	messageLabel.repaint ();
	toFront ();
} // setMessage (String)
/**
 * Hides the Status window. Called by the system when the close box of the
 * window has been clicked.
 *
 * @param e The window event
 */
public void windowClosing (java.awt.event.WindowEvent e) 
{
	setVisible (false);
} // windowClosing (WindowEvent)
} /* Status class */