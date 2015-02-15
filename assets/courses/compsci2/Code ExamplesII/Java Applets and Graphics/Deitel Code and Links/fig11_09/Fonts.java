// Fig. 11.9: Fonts.java
// Using fonts
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Fonts extends JFrame {
   public Fonts()
   {
      super( "Using fonts" );

      setSize( 420, 125 );
      show();
   }

   public void paint( Graphics g )
   {
      // set current font to Serif (Times), bold, 12pt
      // and draw a string 
      g.setFont( new Font( "Serif", Font.BOLD, 12 ) );
      g.drawString( "Serif 12 point bold.", 20, 50 );

      // set current font to Monospaced (Courier),
      // italic, 24pt and draw a string 
      g.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
      g.drawString( "Monospaced 24 point italic.", 20, 70 );

      // set current font to SansSerif (Helvetica),
      // plain, 14pt and draw a string 
      g.setFont( new Font( "SansSerif", Font.PLAIN, 14 ) );
      g.drawString( "SansSerif 14 point plain.", 20, 90 );

      // set current font to Serif (times), bold/italic,
      // 18pt and draw a string
      g.setColor( Color.red );
      g.setFont(
         new Font( "Serif", Font.BOLD + Font.ITALIC, 18 ) );
      g.drawString( g.getFont().getName() + " " +
                    g.getFont().getSize() +
                    " point bold italic.", 20, 110 );
   }

   public static void main( String args[] )
   {
      Fonts app = new Fonts();

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
