/** 
 * fibonacci.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */

import javax.swing.JOptionPane; 

public class fibonacci 
{
	public fibonacci() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new fibonacci();
	
	long result, number = 99;
	String s;

	while(number != 0)
	{
		////cin	 >> number;
		s = JOptionPane.showInputDialog("Enter an Integer (0 to Exit): ");
		Long l = new Long(s);
		number = l.longValue();
		if (number == 0)
		{
			continue;
		}

		result = fibonacci(number);
		System.out.println("fibonacci(" + number  + ") = " + result);
	}
	
	return;
	
	} // end of SPVM
	
	
	public static long fibonacci (long n)
	{
	if (n == 0 || n == 1) // base case
		return n;
 	  else
		return fibonacci (n -1 ) + fibonacci(n - 2); 
	}

	
}  // end of Wrapper class
