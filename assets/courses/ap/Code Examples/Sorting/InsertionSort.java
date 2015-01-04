// The "InsertionSort" class.
// This class implements a insertion sort using the SortUtil class.

public class InsertionSort
{
    private static int LIST_SIZE = 10;

    // Method to sort list of strings by selection.
    public static void insertionSort (Comparable[] list, int n)
    {
	for (int boundary = 1 ; boundary < n ; boundary++)
	{
	    // Find where to insert element at boundary.
	    int insertLoc = 0;
	    while ((insertLoc < boundary) &&
		    (list [insertLoc].compareTo (
			    list [boundary]) < 0))
	    {
		insertLoc++;
	    }

	    // Insert the boundary element at the appropriate
	    // location by shifting the elements one to the right.
	    SortUtil.shift (insertLoc, boundary, list);

	    // Statements to trace execution.
	    SortUtil.print (insertLoc, 3);
	    SortUtil.print (boundary, 3);
	    SortUtil.printList (list, n);
	} // for
    } // insertionSort method


    public static void main (String[] args)
    {
	String[] list = SortUtil.createStringArray (LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
	insertionSort (list, LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
    } // main method
} // InsertionSort class
