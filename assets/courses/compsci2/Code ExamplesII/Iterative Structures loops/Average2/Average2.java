// Fig. 4.9: Average2.java
// Class average program with sentinel-controlled repetition
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Average2 {
   public static void main( String args[] )
   {
      int gradeCounter,  // number of grades entered
          gradeValue,    // grade value
          total;         // sum of grades
      double average;    // average of all grades
      String input;      // grade typed by user

      // Initialization phase
      total = 0;         // clear total
      gradeCounter = 0;  // prepare to loop
      
      // Processing phase
      // prompt for input and read grade from user
      input = JOptionPane.showInputDialog(
                 "Enter Integer Grade, -1 to Quit:" );

      // convert grade from a String to an integer
      gradeValue = Integer.parseInt( input );

      while ( gradeValue != -1 ) {
         // add gradeValue to total
         total = total + gradeValue;

         // add 1 to gradeCounter
         gradeCounter = gradeCounter + 1;

         // prompt for input and read grade from user
         input = JOptionPane.showInputDialog(
                    "Enter Integer Grade, -1 to Quit:" );

         // convert grade from a String to an integer
         gradeValue = Integer.parseInt( input );
      }

      // Termination phase
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      if ( gradeCounter != 0 ) {
         average = (double) total / gradeCounter;  

         // display average of exam grades
         JOptionPane.showMessageDialog( null,
            "Class average is " + twoDigits.format( average ),
            "Class Average",
            JOptionPane.INFORMATION_MESSAGE );
      }
      else
         JOptionPane.showMessageDialog( null,
            "No grades were entered", "Class Average",
            JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );    // terminate the program
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