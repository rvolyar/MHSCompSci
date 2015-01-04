// Fig. 24.1 : javaArrays.java
// Using Java arrays
import java.util.*;

public class javaArrays {
   private int intValues[] = { 1, 2, 3, 4, 5, 6 };
   private double doubleValues[] = { 8.4, 9.3, 0.2, 7.9, 3.4 };
   private int filledInt[], intValuesCopy[];

   public javaArrays()
   {
      filledInt = new int[ 10 ];
      intValuesCopy = new int[ intValues.length ];
      Arrays.fill( filledInt, 7 );   // fill with 7s
      Arrays.sort( doubleValues );   // sort doubleValues
      System.arraycopy( intValues, 0, intValuesCopy,
                        0, intValues.length );
   }

   public void printArrays()
   {     
      System.out.print( "doubleValues: " );
      for ( int k = 0; k < doubleValues.length; k++ )
         System.out.print( doubleValues[ k ] + " " );

      System.out.print("\nintValues: " );
      for ( int k = 0; k < intValues.length; k++ )
         System.out.print( intValues[ k ] + " " );

      System.out.print("\nfilledInt: " );
      for ( int k = 0; k < filledInt.length; k++ )
         System.out.print( filledInt[ k ] + " " );

      System.out.print("\nintValuesCopy: " );
      for ( int k = 0; k < intValuesCopy.length; k++ )
         System.out.print( intValuesCopy[ k ] + " " );

      System.out.println();
   }

   public int searchForInt( int value )
   {  
      return Arrays.binarySearch( intValues, value );
   }

   public void printEquality()
   {
      boolean b = Arrays.equals( intValues, intValuesCopy );

      System.out.println( "intValues " + ( b ? "==" : "!=" )
                          + " intValuesCopy" );

      b = Arrays.equals( intValues, filledInt );
      System.out.println( "intValues " + ( b ? "==" : "!=" )
                          + " filledInt" );
   }

   public static void main( String args[] )
   {
      javaArrays u = new javaArrays();

      u.printArrays();
      u.printEquality();

      int n = u.searchForInt( 5 );
      System.out.println( ( n >= 0 ? "Found 5 at element " + n :
                          "5 not found" ) + " in intValues" );
      n = u.searchForInt( 8763 );
      System.out.println( ( n >= 0 ? "Found 8763 at element "
                          + n : "8763 not found" )
                          + " in intValues" );
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
