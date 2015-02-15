// Fig. 12.20: MouseDetails.java
// Demonstrating mouse clicks and
// distinguishing between mouse buttons.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDetails extends JFrame {
   private String s = "";
   private int xPos, yPos;

   public MouseDetails()
   {
      super( "Mouse clicks and buttons" );

      addMouseListener( new MouseClickHandler() ); 

      setSize( 350, 150 );
      show();
   }

   public void paint( Graphics g )
   {
      g.drawString( "Clicked @ [" + xPos + ", " + yPos + "]",
                    xPos, yPos );
   }

   public static void main( String args[] )
   {
      MouseDetails app = new MouseDetails();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }

   // inner class to handle mouse events
   private class MouseClickHandler extends MouseAdapter {
      public void mouseClicked( MouseEvent e )
      {
         xPos = e.getX();
         yPos = e.getY();

         String s =
            "Clicked " + e.getClickCount() + " time(s)";
      
         if ( e.isMetaDown() )      // Right mouse button
            s += " with right mouse button";
         else if ( e.isAltDown() )  // Middle mouse button
            s += " with center mouse button";
         else                       // Left mouse button
            s += " with left mouse button";

         setTitle( s );  // set the title bar of the window
         repaint();
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
