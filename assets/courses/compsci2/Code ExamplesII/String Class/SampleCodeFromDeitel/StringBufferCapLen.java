// Fig. 10.13: StringBufferCapLen.java
// This program demonstrates the length and
// capacity methods of the StringBuffer class.
import javax.swing.*;

public class StringBufferCapLen {
   public static void main( String args[] )
   {
      StringBuffer buf =
         new StringBuffer( "Hello, how are you?" );

      String output = "buf = " + buf.toString() +
                      "\nlength = " + buf.length() +
                      "\ncapacity = " + buf.capacity();

      buf.ensureCapacity( 75 );
      output += "\n\nNew capacity = " + buf.capacity();

      buf.setLength( 10 );
      output += "\n\nNew length = " + buf.length() +
                "\nbuf = " + buf.toString();

      JOptionPane.showMessageDialog( null, output,
         "StringBuffer length and capacity Methods",
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
