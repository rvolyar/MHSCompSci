/** 
 * calcTriangle.java
 *
 * Title:			calc parts of a triangle
 * Description:		Arithmetic Expressions and Math Class Lecture project
 * @author			DAVE
 * @version			
 */
 
 /*
 OUTPUT:
	Z is 4.0
	S is 0.5877852522924731
	Y is 6.805206466816319
	X is 5.505527681884695
	Beta is 54

 
 
 */

import javax.swing.JOptionPane;
import java.lang.Math;

public class calcTriangle
{
	public calcTriangle()
	{
	}

	// Main entry point
	static public void main(String[] args)
	{
		new calcTriangle();
		
		String input;
		double X = 0, Y = 0, Z = 0, T = 0, S = 0;
		int A = 0, B = 0;
		input = JOptionPane.showInputDialog("Enter Z: ");
		Z = Double.parseDouble(input);
		System.out.println("Z is " + Z);
		input = JOptionPane.showInputDialog("Enter A: ");
		A = Integer.parseInt(input);
		
		
		// convert the angle to radians
		T = Math.toRadians(A);
		// tan works in radians
		T = Math.tan(T);
				
		// x = Z / tan
		X = Z / T;
		
		// convert the angle to radians
		S = Math.toRadians(A);
		// sin works in radians
		S = Math.sin(S);
		System.out.println("S is " + S);
		
		// Y = Z / sin
		Y = Z / S;
		
		B = 90 - A;
		
		System.out.println("Y is " + Y);
		System.out.println("X is " + X);
		System.out.println("Beta is " + B);
		
		System.exit(0);
		
	}
	
}
