// The "VisualInsertionSort" class.
import hsa.VisualSortUtil;

// This class implements a visual insertion sort using
// the VisualSortUtil class.
public class VisualInsertionSort
{
    private static int LIST_SIZE = 500;

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
	    VisualSortUtil.shift (insertLoc, boundary, list);
	} // for
    } // insertionSort method


    public static void main (String[] args)
    {
	Comparable[] list =
	    VisualSortUtil.createVisualArray ("Insertion Sort",
		LIST_SIZE, 300);

	insertionSort (list, LIST_SIZE);
    } // main method
} // VisualInsertionSort class
