// Fig. 11.6: ShowColors2.java
// Demonstrating JColorChooser
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShowColors2 extends JFrame {
   private JButton changeColor;
   private Color color = Color.lightGray;
   private Container c;

   public ShowColors2()
   {
      super( "Using JColorChooser" );

      c = getContentPane();
      c.setLayout( new FlowLayout() );

      changeColor = new JButton( "Change Color" );
      changeColor.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               color =
                  JColorChooser.showDialog( ShowColors2.this,
                     "Choose a color", color );

               if ( color == null )
                  color = Color.lightGray;

               c.setBackground( color );
               c.repaint();
            }
         }
      );
      c.add( changeColor );

      setSize( 400, 130 );
      show();
   }

   public static void main( String args[] )
   {
      ShowColors2 app = new ShowColors2();

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
