// Fig. 2.17: Comparison.java
// Using if statements, relational operators, 
// and equality operators

import javax.swing.JOptionPane;

public class Comparison {
   public static void main( String args[] )
   {
      String firstNumber,   // first string entered by user
             secondNumber,  // second string entered by user
             result;        // a string containing the output
      int number1,          // first number to compare
          number2;          // second number to compare

      // read first number from user as a string
      firstNumber =
         JOptionPane.showInputDialog( "Enter first integer:" );

      // read second number from user as a string
      secondNumber =
         JOptionPane.showInputDialog( "Enter second integer:" );          

      // convert numbers from type String to type int
      number1 = Integer.parseInt( firstNumber );
      number2 = Integer.parseInt( secondNumber );

      // initialize result to the empty string
      result = "";

      if ( number1 == number2 )
         result = number1 + " == " + number2;

      if ( number1 != number2 )
         result = number1 + " != " + number2;

      if ( number1 < number2 )
         result = result + "\n" + number1 + " < " + number2;

      if ( number1 > number2 )
         result = result + "\n" + number1 + " > " + number2;

      if ( number1 <= number2 )
         result = result + "\n" + number1 + " <= " + number2;

      if ( number1 >= number2 )
         result = result + "\n" + number1 + " >= " + number2;

      // Display results
      JOptionPane.showMessageDialog(
         null, result, "Comparison Results",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
