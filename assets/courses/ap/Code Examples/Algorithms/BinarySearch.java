// Fig. 7.13: BinarySearch.java
// Binary search of an array
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class BinarySearch extends JApplet
                          implements ActionListener {
   JLabel enterLabel, resultLabel;
   JTextField enter, result;
   JTextArea output;

   int a[];
   String display = "";

   public void init()
   {
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

      enterLabel = new JLabel( "Enter key" );
      c.add( enterLabel );

      enter = new JTextField( 5 );
      enter.addActionListener( this );
      c.add( enter );

      resultLabel = new JLabel( "Result" );
      c.add( resultLabel );

      result = new JTextField( 22 );
      result.setEditable( false );
      c.add( result );

      output = new JTextArea( 6, 60 );
      output.setFont(
         new Font( "Courier", Font.PLAIN, 12 ) );
      c.add( output );

      // create array and fill with even integers 0 to 28
      a = new int[ 15 ];

      for ( int i = 0; i < a.length; i++ ) 
         a[ i ] = 2 * i;
   }

   public void actionPerformed( ActionEvent e )
   {
      String searchKey = e.getActionCommand();

      // initialize display string for the new search
      display = "Portions of array searched\n";

      // perform the binary search
      int element =
         binarySearch( a, Integer.parseInt( searchKey ) );

      output.setText( display );

      if ( element != -1 )
         result.setText(
            "Found value in element " + element );
      else
         result.setText( "Value not found" );
   }

   // Binary search
   public int binarySearch( int array[], int key ) 
   {
      int low = 0;                  // low subscript
      int high = array.length - 1;  // high subscript
      int middle;                   // middle subscript

      while ( low <= high ) {
         middle = ( low + high ) / 2;

         // The following line is used to display the part
         // of the array currently being manipulated during
         // each iteration of the binary search loop.
         buildOutput( low, middle, high ); 

         if ( key == array[ middle ] )  // match
            return middle;
         else if ( key < array[ middle ] )
            high = middle - 1;  // search low end of array
         else
            low = middle + 1;   // search high end of array
      }

      return -1;   // searchKey not found
   }

   // Build one row of output showing the current
   // part of the array being processed.
   void buildOutput( int low, int mid, int high )
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      for ( int i = 0; i < a.length; i++ ) {
         if ( i < low || i > high )
            display += "    ";
         else if ( i == mid ) // mark middle element in output
            display += twoDigits.format( a[ i ] ) + "* ";
         else                                          
            display += twoDigits.format( a[ i ] ) + "  ";
      }

      display += "\n";
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
