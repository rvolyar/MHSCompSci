// The "SortUtil" class.

// This class is used by the sorting classes in this chapter to
// provide a common set of methods for standard operations.
// Included are methods for array creation, printing an array,
// and swapping and shifting array elements.

import hsa.Stdout;

public class SortUtil
{
    // Creates the array to be sorted and places random data in it.
    public static String[] createStringArray (int listSize)
    {
	String list[] = new String [listSize];
	fakeData (list, listSize);
	return list;
    } // createStringArray method


    // Method to generate simulated data.
    private static void fakeData (String[] list, int listSize)
    {
	for (int i = 0 ; i < listSize ; i++)
	{
	    String alphabet = "abcdefghijklmnopqrstuvwxyz";
	    StringBuffer temp = new StringBuffer ();
	    for (int letter = 0 ; letter < 4 ; letter++)
	    {
		// Generate a random integer between 0 and 25.
		int where = (int) (Math.random () * 26);
		temp.append (alphabet.charAt (where));
	    }
	    list [i] = temp.toString ();
	} // for
    } // fakeData method


    // Method to output list of strings.
    public static void printList (Comparable[] list, int listSize)
    {
	System.out.print (" ");
	for (int i = 0 ; i < listSize ; i++)
	{
	    System.out.print (list [i] + " ");
	}
	System.out.println ();
    } // printList method


    // Method to print out a number in a field of set size.
    public static void print (int theInt, int fieldSize)
    {
	Stdout.print (theInt, fieldSize);
    } // print method


    // Method to shift elements in list.
    protected static void shift (int i, int j, Comparable[] list)
    {
	Comparable temp = list [j];
	for (int k = j ; k >= i + 1 ; k--)
	{
	    list [k] = list [k - 1];
	}
	list [i] = temp;
    } // shift method


    // Method to swap the ith and jth elements of list of strings.
    public static void swap (int i, int j, Comparable[] list)
    {
	Comparable temp = list [i];
	list [i] = list [j];
	list [j] = temp;
    } // swap method
} // SortUtil class
