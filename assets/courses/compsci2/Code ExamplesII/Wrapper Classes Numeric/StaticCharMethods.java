// Fig. 10.17: StaticCharMethods.java
// Demonstrates the static character testing methods
// and case conversion methods of class Character
// from the java.lang package.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaticCharMethods extends JFrame {
   private char c;
   private JLabel prompt;
   private JTextField input;
   private JTextArea outputArea;

   public StaticCharMethods()
   {
      super( "Static Character Methods" );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      prompt =
         new JLabel( "Enter a character and press Enter" );
      container.add( prompt );

      input = new JTextField( 5 );
      input.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {  
               String s = e.getActionCommand();
               c = s.charAt( 0 );
               buildOutput();
            }
         }
      );
      container.add( input );

      outputArea = new JTextArea( 10, 20 );
      container.add( outputArea );

      setSize( 300, 250 );  // set the window size
      show();               // show the window
   }

   public void buildOutput()
   {
      outputArea.setText(
          "is defined: " + Character.isDefined( c ) +
          "\nis digit: " + Character.isDigit( c ) +
          "\nis Java letter: " +
          Character.isJavaIdentifierStart( c ) +
          "\nis Java letter or digit: " +
          Character.isJavaIdentifierPart( c ) +
          "\nis letter: " + Character.isLetter( c ) +
          "\nis letter or digit: " +
          Character.isLetterOrDigit( c ) +
          "\nis lower case: " + Character.isLowerCase( c ) +
          "\nis upper case: " + Character.isUpperCase( c ) +
          "\nto upper case: " + Character.toUpperCase( c ) +
          "\nto lower case: " + Character.toLowerCase( c ) );
   }

   public static void main( String args[] )
   {
      StaticCharMethods application = new StaticCharMethods();

      application.addWindowListener(
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
