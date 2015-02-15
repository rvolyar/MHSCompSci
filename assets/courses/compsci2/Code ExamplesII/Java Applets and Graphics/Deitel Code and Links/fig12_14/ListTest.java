// Fig. 12.14: ListTest.java
// Selecting colors from a JList.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
   private JList colorList;
   private Container c;
 
   private String colorNames[] =
      { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
        "Light Gray", "Magenta", "Orange", "Pink", "Red",
        "White", "Yellow" };

   private Color colors[] =
      { Color.black, Color.blue, Color.cyan, Color.darkGray,
        Color.gray, Color.green, Color.lightGray,
        Color.magenta, Color.orange, Color.pink, Color.red,
        Color.white, Color.yellow };

   public ListTest()
   {
      super( "List Test" );

      c = getContentPane();
      c.setLayout( new FlowLayout() );

      // create a list with the items in the colorNames array
      colorList = new JList( colorNames );
      colorList.setVisibleRowCount( 5 );
      
      // do not allow multiple selections
      colorList.setSelectionMode(
         ListSelectionModel.SINGLE_SELECTION );

      // add a JScrollPane containing the JList
      // to the content pane
      c.add( new JScrollPane( colorList ) );

      // set up event handler
      colorList.addListSelectionListener(
         new ListSelectionListener() {
            public void valueChanged( ListSelectionEvent e )  
            {
               c.setBackground(
                  colors[ colorList.getSelectedIndex() ] );
            }
         }
      );

      setSize( 350, 150 );
      show();
   }

   public static void main( String args[] )
   { 
      ListTest app = new ListTest();

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
