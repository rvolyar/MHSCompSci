/*
	SIMPLE Hello World applet
*/

import java.awt.Graphics;
import javax.swing.JApplet;


public class MHSJavaApplet extends JApplet
{
	public void init() 
	{
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		//  in start from left, down from top, end left, end down
		g.drawLine(15,10,210,10);
		g.drawLine(15,45,210,45);
		
		g.drawString("Hello World!", 30, 30);
	}
}
 