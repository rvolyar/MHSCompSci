// Fig. 7.12: LinearSearch.java
// Linear search of an array
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LinearSearch extends JApplet
                          implements ActionListener {
   JLabel enterLabel, resultLabel;
   JTextField enter, result;
   int a[];

   public void init()
   {
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

      enterLabel = new JLabel( "Enter integer search key" );
      c.add( enterLabel );

      enter = new JTextField( 10 );
      enter.addActionListener( this );
      c.add( enter );

      resultLabel = new JLabel( "Result" );
      c.add( resultLabel );

      result = new JTextField( 20 );
      result.setEditable( false );
      c.add( result );

      // create array and populate with even integers 0 to 198
      a = new int[ 100 ];

      for ( int i = 0; i < a.length; i++ )
         a[ i ] = 2 * i;

   }

   // Search "array" for the specified "key" value
   public int linearSearch( int array[], int key ) 
   {   
      for ( int n = 0; n < a.length; n++ ) 
         if ( array[ n ] == key )
            return n;

      return -1;
   }

   public void actionPerformed( ActionEvent e )
   {
      String searchKey = e.getActionCommand();

      // Array a is passed to linearSearch even though it
      // is an instance variable. Normally an array will
      // be passed to a method for searching.
      int element =
         linearSearch( a, Integer.parseInt( searchKey ) );

      if ( element != -1 )
         result.setText( "Found value in element " +
                         element );
      else
         result.setText( "Value not found" );
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
