/** 
 * StringExamples.java
 *
 * Title:			Working with String and Sringbuffer classes
 * Description:		various examples of working with srings
 * @author			DAVE
 * @version			
 */

import EasyReader;
import java.text.DecimalFormat;
import myString;

public class StringExamples extends Object
{
	public StringExamples()
	{
	}

	// Main entry point
	static public void main(String[] args)
	{
		new StringExamples();
		
		// string literal using a method
		int litLength = 0;
		
		litLength = "My String Literal".length();
		System.out.println("length of \"My String Literal\" is: " +
			litLength);  // Answer is 17
		
		
		// declare string literal 
		String myString = "Hello World";
		
		
		// use new and invoke string constructor
		String myString2 =  new String("Hello Wabbit") ;  
		System.out.println(myString2);
		
		// show immutability of string, change the REFERENCE
		// of a string
		String myString3 = new String("The Jets Stink !!!");
		System.out.println(myString3);
		myString3 = ("The Giants Rule !!!");
		System.out.println(myString3);
		
		// have 1 string get a COPY of another string
		// different references or memory locations
		String myString4 = new String(myString3);
		System.out.println(myString4);
		myString4 = ("Changed MyString4");
		// now strings 3 and 4 are different
		System.out.println(myString4);
		System.out.println(myString3);
		
		System.out.println("");
		
		// have 2 strings REFER to the same Sring object reference
		// SHARED reference or memory location
		String myString5 = myString4;
		System.out.println(myString5);
		myString5 = ("Yankees Stink");
		// now strings 4 and 5 refer to different references
		System.out.println(myString5);
		System.out.println(myString4);
		
		// String methods
		System.out.println("The length of myString5 is: " + 
			myString5.length()); // ANS 13
			
		// length minus 2 gets next to last char as "charat"
		// starts at element ZERO and NOT 1
		char c = myString5.charAt(myString5.length() - 2);
		System.out.println(" the next to last character is: " + c); //n
		
		// substring
		String myString6 = myString5.substring(3);
		System.out.println(myString6); // kees Stink

		myString6 = myString5.substring(8, 13); // [from, to) positions
				// to position is EXCLUSIVE
		System.out.println(myString6); // Stink
		
		// concat
		String myString7 = "Millburn ";
		String myString8 = "High School";
		String myString9 = myString7.concat(myString8);
		System.out.println(myString9); // Millburn High School
		String myString10 = myString7 + myString8;
		System.out.println(myString10); //Millburn High School

		// indexof()
		
		int pos = myString7.indexOf('b');
		System.out.println(pos);  // 4
		
		pos = myString8.indexOf('h', 4);
		System.out.println(pos);  // 7
		
		pos = myString8.lastIndexOf('o');
		System.out.println(pos);  // 9
		
		pos = myString8.lastIndexOf('h', 8);
		System.out.println(pos);  // 7
		
		pos = myString8.lastIndexOf('h', 2);
		System.out.println(pos);  // -1

		String myStr = "ch";
		pos = myString8.lastIndexOf(myStr, 8);
		System.out.println(pos);  // 6
		
		// comparisons
		boolean TF = myString7.equals(myString8);
		System.out.println(TF);  // FALSE
		
		TF = myString7.equals("MIllburn ");
		System.out.println(TF);  // FALSE
		
		TF = myString7.equalsIgnoreCase("Millburn ");
		System.out.println(TF);  // TRUE
		
		// compareto
		String s = "ABC";
		int result = s.compareTo("abc");
		System.out.println(result); //NEGATIVE 32, ABC smaller than abc
		
		result = s.compareTo("ABCD");
		System.out.println(result); //NEGATIVE 1, ABC smaller than ABCD
		
		result = s.compareTo("Amuh");
		System.out.println(result); //NEGATIVE 43 
		
		s = "adset";
		result = s.compareTo("ADSET");
		System.out.println(result); //POSITIVE 32, adset GT ADSET
		
		result = s.compareTo("aDsetf");
		System.out.println(result); //NEGATIVE 32
		
		// decimalformat class
		DecimalFormat  moneyFormat = new DecimalFormat("0.00");
		double totalSales = 123.5;
		String s1 = moneyFormat.format(totalSales);
		System.out.println("total Sales Are $" + s1); // 123.50
		
		// use myString class
		/* TEST OUTPUT:
		TESTING MYSTRING CLASS...
		return of my toString: Test It
		 max size of myString is: 21
		The size of mst is: 7
		Does mst equal mst2? false
		Change mst2 to a number
		mst2 is now 1962
		CAN NOT SET STRING TOO LONG
		*/
		System.out.println("TESTING MYSTRING CLASS..." );
		myString mst = new myString("Test It");
		myString mst2 = new myString("TEST It");
		
		System.out.println(mst.toString());
		System.out.println(" max size of myString is: " +
			mst.getMaxLength());
		System.out.println("The size of mst is: " +
			mst.theLength());
		System.out.println("Does mst equal mst2? " +
			mst.CompMyString(mst2));
		System.out.println("Change mst2 to a number ");
		mst2.setTheString("1962");
		System.out.println("mst2 is now " + mst2.getNumber());
		mst.setTheString("slslkskjsjsjsjshssshhhhsgsgs");
		
		
		
		
		
		
		System.exit(0);
	}
	
}
