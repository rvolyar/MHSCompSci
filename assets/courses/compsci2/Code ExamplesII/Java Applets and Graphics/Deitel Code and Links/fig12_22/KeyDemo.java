// Fig. 12.22: KeyDemo.java
// Demonstrating keystroke events.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyDemo extends JFrame implements KeyListener {
   private String line1 = "", line2 = "";
   private String line3 = "";
   private JTextArea textArea;

   public KeyDemo()
   {
      super( "Demonstrating Keystroke Events" );

      textArea = new JTextArea( 10, 15 );
      textArea.setText( "Press any key on the keyboard..." );
      textArea.setEnabled( false );

      // allow frame to process Key events
      addKeyListener( this );

      getContentPane().add( textArea );  

      setSize( 350, 100 );
      show();
   }

   public void keyPressed( KeyEvent e )
   {
      line1 = "Key pressed: " +
               e.getKeyText( e.getKeyCode() );
      setLines2and3( e );
   }

   public void keyReleased( KeyEvent e )
   {
      line1 = "Key released: " +
               e.getKeyText( e.getKeyCode() );
      setLines2and3( e );
   }

   public void keyTyped( KeyEvent e )
   {
      line1 = "Key typed: " + e.getKeyChar();
      setLines2and3( e );
   }

   private void setLines2and3( KeyEvent e )
   {
      line2 = "This key is " +
              ( e.isActionKey() ? "" : "not " ) +
              "an action key";

      String temp = 
         e.getKeyModifiersText( e.getModifiers() );

      line3 = "Modifier keys pressed: " +
              ( temp.equals( "" ) ? "none" : temp );

      textArea.setText(
         line1 + "\n" + line2 + "\n" + line3 + "\n" );
   }

   public static void main( String args[] )
   {
      KeyDemo app = new KeyDemo();

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
