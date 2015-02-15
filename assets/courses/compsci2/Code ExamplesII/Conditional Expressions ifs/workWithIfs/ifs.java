/** 
 * ifs.java
 *
 * Title:			practice if statements
 * Description:		try out different tests using ifs, else and
 switch statements.  boolean algebra
 * @author			DAVE
 * @version			
 */
 
import javax.swing.JOptionPane;
import java.lang.Math;

public class ifs {
	public ifs() {
	}

	// Main entry point
	static public void main(String[] args) {
		new ifs();
		
		//String input;
		//double X = 0, Y = 0, Z = 0, T = 0, S = 0;
		//int A = 0, B = 0;
		//input = JOptionPane.showInputDialog("Enter Z: ");
		//Z = Double.parseDouble(input);
		//System.out.println("Z is " + Z);
		
		
		int a=3, b=4, c=5;

		// if a if not equal to be
		// since 3 is not = to 4, the expression
		// returns a TRUE condition
		if(a + b < c) 
			{
			System.out.println("TRUE");
			}
			else
			{
			System.out.println("FALSE");
			}
		
		//////
		// C++ can equate ints to zero / non zero (true / false)
		// JAVA can only deal with booleans
		/*if(b>a && 0) //false, 0 is zero
			System.out.println(" b>a && 0" );
			else
			System.out.println(" b>a && 0 IS FALSE" ); */
		
		/////
			
		boolean lbool = true;  

		if(lbool) // if lbool is true
			{
			 System.out.println("the condition is true") ; 
			}
		lbool = false;
		if(!lbool) // if lbool is false
			{
			 System.out.println("the condition is false"); //executes
			}

		/////	
		
		if(withdoifs()) // fx returns an integer value
		{
		 System.out.println("function returned a TRUE value");
		}
		else
		{
		 System.out.println("function returned a FALSE value");
		}

		int mybool = tf();
		
		System.exit(0);
		
	}
	
	static boolean withdoifs()
	{
	int li = 13;
	if(li%2 == 0) // TRUE when li is EVEN, FALSE when li is ODD
			
		return true;
  	 else
		return false;
	}	
	

	
	
	static int tf()
	{
		return (2 % 1);
	}
}
