// Fig. 10.1: StringConstructors.java
// This program demonstrates the String class constructors.
import javax.swing.*;

public class StringConstructors {
   public static void main( String args[] )
   {
      char charArray[] = { 'b', 'i', 'r', 't', 'h', ' ',
                           'd', 'a', 'y' };
      byte byteArray[] = { (byte) 'n', (byte) 'e', (byte) 'w',
                           (byte) ' ', (byte) 'y', (byte) 'e',
                           (byte) 'a', (byte) 'r' };
      StringBuffer buffer;
      String s, s1, s2, s3, s4, s5, s6, s7, output;

      s = new String( "hello" );
      buffer =
         new StringBuffer( "Welcome to Java Programming!" );

      // use the String constructors
      s1 = new String();
      s2 = new String( s );
      s3 = new String( charArray );
      s4 = new String( charArray, 6, 3 );
      s5 = new String( byteArray, 4, 4 );
      s6 = new String( byteArray );
      s7 = new String( buffer );

      output = "s1 = " + s1 +
               "\ns2 = " + s2 +
               "\ns3 = " + s3 +
               "\ns4 = " + s4 +
               "\ns5 = " + s5 +
               "\ns6 = " + s6 +
               "\ns7 = " + s7;

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class Constructors",
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
