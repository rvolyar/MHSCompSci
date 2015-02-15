// Fig. 12.11: CheckBoxTest.java
// Creating Checkbox buttons.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest extends JFrame {
   private JTextField t;
   private JCheckBox bold, italic;

   public CheckBoxTest()
   {
      super( "JCheckBox Test" );

      Container c = getContentPane();
      c.setLayout(new FlowLayout());

      t = new JTextField( "Watch the font style change", 20 );
      t.setFont( new Font( "TimesRoman", Font.PLAIN, 14 ) );
      c.add( t );

      // create checkbox objects
      bold = new JCheckBox( "Bold" );
      c.add( bold );     

      italic = new JCheckBox( "Italic" );
      c.add( italic );

      CheckBoxHandler handler = new CheckBoxHandler();
      bold.addItemListener( handler );
      italic.addItemListener( handler );

      setSize( 275, 100 );
      show();
   }

   public static void main( String args[] )
   { 
      CheckBoxTest app = new CheckBoxTest();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }

   private class CheckBoxHandler implements ItemListener {
      private int valBold = Font.PLAIN;
      private int valItalic = Font.PLAIN;

      public void itemStateChanged( ItemEvent e )
      {
         if ( e.getSource() == bold )
            if ( e.getStateChange() == ItemEvent.SELECTED )
               valBold = Font.BOLD;
            else
               valBold = Font.PLAIN;
               
         if ( e.getSource() == italic )
            if ( e.getStateChange() == ItemEvent.SELECTED )
               valItalic = Font.ITALIC;
            else
               valItalic = Font.PLAIN;

         t.setFont(
            new Font( "TimesRoman", valBold + valItalic, 14 ) );
         t.repaint();
      }
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
