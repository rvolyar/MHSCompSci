// Fig. 11.12: Metrics.java
// Demonstrating methods of class FontMetrics and
// class Graphics useful for obtaining font metrics
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Metrics extends JFrame {
   public Metrics()
   {
      super( "Demonstrating FontMetrics" );
      
      setSize( 510, 210 );
      show();
   }

   public void paint( Graphics g )             
   {
      g.setFont( new Font( "SansSerif", Font.BOLD, 12 ) );
      FontMetrics fm = g.getFontMetrics();
      g.drawString( "Current font: " + g.getFont(), 10, 40 );
      g.drawString( "Ascent: " + fm.getAscent(), 10, 55 );
      g.drawString( "Descent: " + fm.getDescent(), 10, 70 );
      g.drawString( "Height: " + fm.getHeight(), 10, 85 );
      g.drawString( "Leading: " + fm.getLeading(), 10, 100 );

      Font font = new Font( "Serif", Font.ITALIC, 14 );
      fm = g.getFontMetrics( font );
      g.setFont( font );
      g.drawString( "Current font: " + font, 10, 130 );
      g.drawString( "Ascent: " + fm.getAscent(), 10, 145 );
      g.drawString( "Descent: " + fm.getDescent(), 10, 160 );
      g.drawString( "Height: " + fm.getHeight(), 10, 175 );
      g.drawString( "Leading: " + fm.getLeading(), 10, 190 );
   }

   public static void main( String args[] )
   {
      Metrics app = new Metrics();

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
