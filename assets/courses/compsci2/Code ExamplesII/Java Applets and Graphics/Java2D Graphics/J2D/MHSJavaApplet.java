/*
	JApplet Work with 2D graphics 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // remember that packages under awt not
					// brought in by java.awt.*

/*
 UPPER LEFT coordinate of a screen is (0,0)  (x,y)
 
 x is the horizontal coordinate (moves right from the upper left corner)
 
 y is the vertical coordinate (moves down from upper left corner)
 
 
 JAVA2D API		java.awt.Graphics2D
 

	color	orange	255,200,0
			pink	255,175,175
			cyan	0,255,255
			magenta	255,0,255
			yellow	255,255,0
			black	0,0,0
			white	255,255,255
			red		255,0,0
			green	0,255,0
			blue	0,0,255
					red,green,blue



*/

public class MHSJavaApplet extends JApplet   
{
	
	private String myColor;
	
	
	public void init() 
	{
		
		myColor = " ";
		
		while (!myColor.equals("red") && !myColor.equals("blue") && !myColor.equals("green"))
		{
			myColor = JOptionPane.showInputDialog("Enter a Color(red, blue, green)");
		}
		repaint();
	}
	
	
	public void paint(Graphics g) 
	{
		
		
		// set new colors using ints
		g.setColor( new Color(255,0,0));
		g.fillRect(25, 25, 100,20);
		g.drawString("Current RGB: " + g.getColor(), 130, 40);
		
		
		// set new colors using static color objects
		g.setColor( Color.blue);
		g.fillRect(25, 75, 100,20);
		g.drawString("Current RGB: " + g.getColor(), 130, 90);
		
		// Color nc = Color.getColor(myColor);     SECURITY ERROR !!!
		Color nc;
		
		if(myColor.equals("red"))
			nc = Color.red; 
			else if( myColor.equals("blue"))
			nc = Color.blue;
		   else
		    nc = Color.green; 
			
		
		
		g.setColor(nc);//  (Color.green);
		g.fill3DRect(25,140,100,125,true);
		g.drawString("Current RGB " + g.getColor(), 130, 160);
		
		
	}
}
