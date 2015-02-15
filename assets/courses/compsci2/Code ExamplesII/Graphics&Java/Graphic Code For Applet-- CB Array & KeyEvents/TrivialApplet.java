/*
	Trivial applet that displays a string
*/

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

//make sure to import java.awt.event.* and to implement ActionListener
public class TrivialApplet extends Applet implements ActionListener, KeyListener
{
	Button[] buttons = new Button[2];
	java.awt.Label label1 = new java.awt.Label();
	private boolean up, down, right, left;
	
	public void init() 
	{
		setSize(500,500); //enlarge the form
		
		for(int x = 0; x < 2; x++) // a for loop to instantiate the buttons
		{
			buttons[x] = new Button();
			buttons[x].setVisible(true);
			buttons[x].setLabel("");
			buttons[x].setLocation(50 * x, 50 * x);
			buttons[x].setSize(new java.awt.Dimension(40, 40));
			add(buttons[x]);
			
			buttons[x].addActionListener(this);
			buttons[x].addKeyListener(this);
			
		}
			
		label1.setVisible(true);
		label1.setLocation(new java.awt.Point(100, 100));
		label1.setText("");
		add(label1);
		
		
	}
	
	public void paint(Graphics g) // put the code determining object's size and placement here
	{
		buttons[0].setLocation(0,0);
		buttons[1].setLocation(100,0);
		buttons[0].setSize(40,40);
		buttons[1].setSize(40,40);
		label1.setSize(new java.awt.Dimension(200, 100));
		
		//Anything else that needs to be constantly reset should be put here
		
	}
	
	public void actionPerformed(ActionEvent l) //code for when an event is triggered
	{
		Button b = ((Button) l.getSource());
		
		if(b.equals(buttons[0]))
			label1.setText("The left button was pressed");
		else
			label1.setText("The right button was pressed");
		
		repaint();
	}
	
	public void keyPressed(KeyEvent k)
	{
		
		label1.setText(k.getKeyText(k.getKeyCode()));
			
		repaint();
	}
	/*Remember, KeyListener is an interface that includes all 3
	of these methods, so even if you only use 1, all 3 must exist.
	*/
	public void keyTyped(KeyEvent k)
	{
	}
	
	public void keyReleased(KeyEvent k)
	{
	}
}
