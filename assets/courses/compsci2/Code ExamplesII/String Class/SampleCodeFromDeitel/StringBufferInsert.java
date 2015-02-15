// Fig. 10.16: StringBufferInsert.java
// This program demonstrates the insert and delete
// methods of class StringBuffer.
import javax.swing.*;

public class StringBufferInsert {
   public static void main( String args[] )
   {
      Object o = "hello";  
      String s = "good bye";  
      char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
      boolean b = true;
      char c = 'K';
      int i = 7;
      long l = 10000000;
      float f = 2.5f;
      double d = 33.333;
      StringBuffer buf = new StringBuffer();

      buf.insert( 0, o );
      buf.insert( 0, "  " );
      buf.insert( 0, s );
      buf.insert( 0, "  " );
      buf.insert( 0, charArray );
      buf.insert( 0, "  " );
      buf.insert( 0, b );
      buf.insert( 0, "  " );
      buf.insert( 0, c );
      buf.insert( 0, "  " );
      buf.insert( 0, i );
      buf.insert( 0, "  " );
      buf.insert( 0, l );
      buf.insert( 0, "  " );
      buf.insert( 0, f );
      buf.insert( 0, "  " );
      buf.insert( 0, d );

      String output = "buf after inserts:\n" + buf.toString();

      buf.deleteCharAt( 10 );     // delete 5 in 2.5
      buf.delete( 2, 6 );         // delete .333 in 33.333

      output += "\n\nbuf after deletes:\n" + buf.toString();

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating StringBufferer Inserts and Deletes",
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
