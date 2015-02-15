// Fig. 11.23: Shapes2.java
// Demonstrating a general path
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Shapes2 extends JFrame {
   public Shapes2()
   {
      super( "Drawing 2D Shapes" );

      setBackground( Color.yellow );
      setSize( 400, 400 );
      show();
   }

   public void paint( Graphics g )
   {
      int xPoints[] = 
         { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
      int yPoints[] = 
         { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };

      Graphics2D g2d = ( Graphics2D ) g;

      // create a star from a series of points
      GeneralPath star = new GeneralPath();

      // set the initial coordinate of the General Path
      star.moveTo( xPoints[ 0 ], yPoints[ 0 ] );

      // create the star--this does not draw the star
      for ( int k = 1; k < xPoints.length; k++ )
         star.lineTo( xPoints[ k ], yPoints[ k ] );

      // close the shape
      star.closePath();

      // translate the origin to (200, 200)
      g2d.translate( 200, 200 );

      // rotate around origin and draw stars in random colors
      for ( int j = 1; j <= 20; j++ ) {
         g2d.rotate( Math.PI / 10.0 );
         g2d.setColor(
            new Color( ( int ) ( Math.random() * 256 ),
                       ( int ) ( Math.random() * 256 ),              
                       ( int ) ( Math.random() * 256 ) ) );
         g2d.fill( star );   // draw a filled star
      }
   }

   public static void main( String args[] )
   {
      Shapes2 app = new Shapes2();

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
