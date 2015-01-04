/**
 * greetings2.java
 *
 * Title:			use easyreader to illustrate a cin method
 * Description:		use litvins easyreader to illustrate one way to get input from the user via console
 * @author			DAVE
 * @version			1.0

 OUTPUT:
   Enter Your First Name: David
   Enter Your Last Name: Farrell
   Hello David Farrell

 */




// TO INCLUDE ANOTHER SOURCE FILE TO YOUR PROGRAM, RIGHT CLICK ON THE
// PROJECT TABS CONTAINING THE NAMES OF THE FILES IN YOUR PROJECT
// AND SELECT ADD FILES
// THEN LOCATE THE FILE YOU NEED AND IT BECOMES PAR OF YOUR PROJECT
// THEN YOU SIMPLY NEED TO INPORT IT INTO YOUR MAIN FILE

import java.util.Scanner;

public class greetings2
{
	public greetings2()
	{
	}

	// Main entry point
	static public void main(String[] args)
	{
		new greetings2();

		System.out.println(display());
	}

	static String display()
	{
		String myString1, myString2, output;

		Scanner console = new Scanner(System.in);
		System.out.print("Enter Your First Name: ");

		// the following uses the string constructor
		// to value he string, you can use the = also

		myString1 = new String(console.nextLine()); // value string
											// by calling easyreader
											// method readLine that
											// returns a string

		System.out.print("Enter Your Last Name: ");

		// value a string as done with myString1, but
		// use the = instead of explicitly calling the new method
		myString2 = console.nextLine();

		// value String with other strings
		output = "Hello " + myString1 + " " + myString2;

		return output;
	}

}
