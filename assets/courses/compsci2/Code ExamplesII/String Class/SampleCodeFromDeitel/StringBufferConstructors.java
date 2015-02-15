// Fig. 10.12: StringBufferConstructors.java
// This program demonstrates the StringBuffer constructors.
import javax.swing.*;

public class StringBufferConstructors {
   public static void main( String args[] )
   {
      StringBuffer buf1, buf2, buf3;
   
      buf1 = new StringBuffer();
      buf2 = new StringBuffer( 10 );
      buf3 = new StringBuffer( "hello" );

      String output =
         "buf1 = " + "\"" + buf1.toString() + "\"" +
         "\nbuf2 = " + "\"" + buf2.toString() + "\"" +
         "\nbuf3 = " + "\"" + buf3.toString() + "\"";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating StringBuffer Class Constructors",
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
