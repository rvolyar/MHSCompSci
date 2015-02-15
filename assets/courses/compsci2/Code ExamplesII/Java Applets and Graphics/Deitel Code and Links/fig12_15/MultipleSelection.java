// Fig. 12.15: MultipleSelection.java
// Copying items from one List to another.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultipleSelection extends JFrame {
   private JList colorList, copyList;
   private JButton copy;
   private String colorNames[] =
      { "Black", "Blue", "Cyan", "Dark Gray", "Gray", 
        "Green", "Light Gray", "Magenta", "Orange", "Pink",
        "Red", "White", "Yellow" };

   public MultipleSelection()
   {
      super( "Multiple Selection Lists" );

      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

      colorList = new JList( colorNames );
      colorList.setVisibleRowCount( 5 );
      colorList.setFixedCellHeight( 15 );
      colorList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
      c.add( new JScrollPane( colorList ) );

      // create copy button
      copy = new JButton( "Copy >>>" );
      copy.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               // place selected values in copyList
               copyList.setListData(
                  colorList.getSelectedValues() );
            }
         }
      );
      c.add( copy );

      copyList = new JList( );
      copyList.setVisibleRowCount( 5 );
      copyList.setFixedCellWidth( 100 );
      copyList.setFixedCellHeight( 15 );
      copyList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION );
      c.add( new JScrollPane( copyList ) );

      setSize( 300, 120 );
      show();
   }

   public static void main( String args[] )
   { 
      MultipleSelection app = new MultipleSelection();

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
