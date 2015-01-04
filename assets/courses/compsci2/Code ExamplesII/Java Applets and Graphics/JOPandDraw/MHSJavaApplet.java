/*
	JApplet and JOptionPane
*/

import java.awt.Graphics;
import javax.swing.*;
// using the * allows us to import both swing and jop in one import
// as opposed to 2 imports
//import javax.swing.JApplet;
//import javax.swing.JOptionPane;

// IMPORTANT --- PUT INTO CLASS NOTES:
/*

many package directories have sub directories
for example java.awt contains a subdirectoryt event
when the compiler encounters an import statement that uses the *
java.awt.*
the compiler will not import the event subdirectory

so, when using the import statement seperate import statements 
must be specified for each package used in a program




*/


public class MHSJavaApplet extends JApplet
{
	double sum = 0;
	
	// only place statements in init( ) that are one time items like 
	// initializing variables
	public void init() 
	{
		double first, second;
		
		first = Double.parseDouble(JOptionPane.showInputDialog("Enter 1st: "));
		second = Double.parseDouble(JOptionPane.showInputDialog("Enter 2nd: "));
		
		sum = first + second;
		
	}
	
	// only place statements in paint( ) that are directly related to drawing
	public void paint(Graphics g) 
	{
		
		// draw the results
		g.drawRect(15,10,270,20);
		g.drawString("The Sum is " + sum, 25, 25);
		
		
	}
}
