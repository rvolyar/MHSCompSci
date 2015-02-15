// Fig. 12.19: Painter.java
// Using class MouseMotionAdapter.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Painter extends JFrame {
   private int xValue = -10, yValue = -10;

   public Painter()
   {
      super( "A simple paint program" );

      getContentPane().add(
         new Label( "Drag the mouse to draw" ),
         BorderLayout.SOUTH );

      addMouseMotionListener(
         new MouseMotionAdapter() {
            public void mouseDragged( MouseEvent e )
            {
               xValue = e.getX();
               yValue = e.getY();
               repaint();
            }           
         }
      );

      setSize( 300, 150 );  
      show();   
   }

   public void paint( Graphics g )
   {
      g.fillOval( xValue, yValue, 4, 4 );
   }

   public static void main( String args[] )
   {
      Painter app = new Painter();

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
