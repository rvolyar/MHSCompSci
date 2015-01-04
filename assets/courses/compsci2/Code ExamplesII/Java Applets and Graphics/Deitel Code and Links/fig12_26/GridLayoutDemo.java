// Fig. 12.26: GridLayoutDemo.java
// Demonstrating GridLayout.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame
                            implements ActionListener {
   private JButton b[];
   private String names[] =
      { "one", "two", "three", "four", "five", "six" };
   private boolean toggle = true;
   private Container c;
   private GridLayout grid1, grid2;

   public GridLayoutDemo()
   {
      super( "GridLayout Demo" );

      grid1 = new GridLayout( 2, 3, 5, 5 );
      grid2 = new GridLayout( 3, 2 );

      c = getContentPane();
      c.setLayout( grid1 );

      // create and add buttons
      b = new JButton[ names.length ];

      for (int i = 0; i < names.length; i++ ) {
         b[ i ] = new JButton( names[ i ] );
         b[ i ].addActionListener( this );
         c.add( b[ i ] );
      }

      setSize( 300, 150 );
      show();
   }

   public void actionPerformed( ActionEvent e )
   { 
      if ( toggle )
         c.setLayout( grid2 );
      else
         c.setLayout( grid1 );

      toggle = !toggle;
      c.validate();
   }

   public static void main( String args[] )
   {
      GridLayoutDemo app = new GridLayoutDemo();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
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
