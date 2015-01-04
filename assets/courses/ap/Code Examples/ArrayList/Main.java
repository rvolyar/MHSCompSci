/*
 * Main.java
 *
 * Created on August 29, 2006, 8:18 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package samplecode;

/**
 *  The "TestLists" class.
 *
 *  NOTE:  A couple of changes from the version we played with in class:
 *      1. Both the get() and iterator() versions are tested in each run
 *      2. A getSum() method has been added to illustrate how the returned values might be used.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // NOTE OLD STYLE ARRAYLIST USING OBJECT
 	ArrayList a = new ArrayList ();
	LinkedList ll = new LinkedList ();
	final int sizeOfList = 1000;

	// Build the lists
	buildRandomList (a, sizeOfList);
	buildRandomList (ll, sizeOfList);

	long startTime;
	double elapsedTime;

	System.out.println ("Testing traversal using get(i)");
	startTime = System.currentTimeMillis ();
	traverseListGet (a);
	elapsedTime = (System.currentTimeMillis () - startTime) / 1000.0;
	System.out.println ("ArrayList: " + sizeOfList + " items ---> " + elapsedTime);

	startTime = System.currentTimeMillis ();
	traverseListGet (ll);
	elapsedTime = (System.currentTimeMillis () - startTime) / 1000.0;
	System.out.println ("LinkedList: " + sizeOfList + " items ---> " + elapsedTime);


	/* */
	System.out.println ("Testing traversal using Iterator");
	startTime = System.currentTimeMillis ();
	traverseListIterator (a);
	elapsedTime = (System.currentTimeMillis () - startTime) / 1000.0;
	System.out.println ("ArrayList: " + sizeOfList + " items ---> " + elapsedTime);

	startTime = System.currentTimeMillis ();
	traverseListIterator (ll);
	elapsedTime = (System.currentTimeMillis () - startTime) / 1000.0;
	System.out.println ("LinkedList: " + sizeOfList + " items ---> " + elapsedTime);
	/* */
	
	System.out.println("The sum of the ArrayList is " + getSum(a));
	System.out.println("The sum of the LinkedList is " + getSum(ll));
        
        // TEST Lists and Generics
        genericExample();
        
    } // end of main method
    
 public static void buildRandomList (List list, int sizeOfList)
    {
	for (int i = 0 ; i < sizeOfList ; i++)
	{
	    Double x = new Double (Math.random ());
	    list.add (x);
	}
    }


    public static void traverseListIterator (List list)
    {
	Iterator iter = list.iterator ();
	while (iter.hasNext ())
	{
	    // returns current item, and then moves to the next (if any)
	    iter.next ();
	}

    }


    public static void traverseListGet (List list)
    {
	for (int i = 0 ; i < list.size () ; i++)
	{
	    list.get (i);
	}
    }


    public static double getSum (List list)
    {
	Iterator iter = list.iterator ();
	double sum = 0;
	while (iter.hasNext ())
	{
	    // returns current item, and then moves to the next (if any)
	    Double x = (Double) iter.next ();
	    sum += x.doubleValue ();
	}
	return sum;
    }   
    
    public static void genericExample()
    {
     Runner myRunner = new Runner();
    
     List<Runner> L = new ArrayList<Runner>();
     L.add( myRunner);
  
     // Retrieve from List
     Runner x = L.get(0);
     int i = x.getHoursTrained();
     i = 0;
     // You can combine the steps
     i = (L.get(0)).getHoursTrained();
     System.out.println(i);
        
    }
   
}