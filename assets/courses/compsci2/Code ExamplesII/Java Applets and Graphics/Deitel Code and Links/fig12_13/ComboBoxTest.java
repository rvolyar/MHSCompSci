// Fig. 12.13: ComboBoxTest.java
// Using a JComboBox to select an image to display.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest extends JFrame {
   private JComboBox images;
   private JLabel label;
   private String names[] =
      { "bug1.gif", "bug2.gif",
        "travelbug.gif", "buganim.gif" };
   private Icon icons[] =
      { new ImageIcon( names[ 0 ] ),
        new ImageIcon( names[ 1 ] ),
        new ImageIcon( names[ 2 ] ),
        new ImageIcon( names[ 3 ] ) };

   public ComboBoxTest()
   {
      super( "Testing JComboBox" );
    
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );      

      images = new JComboBox( names );
      images.setMaximumRowCount( 3 );

      images.addItemListener(
         new ItemListener() {
            public void itemStateChanged( ItemEvent e )
            {
               label.setIcon(
                  icons[ images.getSelectedIndex() ] );
            }
         }
      );

      c.add( images );

      label = new JLabel( icons[ 0 ] );
      c.add( label );

      setSize( 350, 100 );
      show();
   }

   public static void main( String args[] )
   { 
      ComboBoxTest app = new ComboBoxTest();

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
