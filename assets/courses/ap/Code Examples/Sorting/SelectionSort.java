// The "SelectionSort" class.

// This class implements a selection sort using the SortUtil class.

public class SelectionSort
{
    private static int LIST_SIZE = 10;

    // Method to sort list of strings by selection.
    public static void selectionSort (Comparable[] list, int n)
    {
	for (int boundary = 0 ; boundary < n - 1 ; boundary++)
	{
	    // Select smallest element.
	    int whereSmall = boundary;
	    for (int i = boundary + 1 ; i < n ; i++)
	    {
		if (list [i].compareTo (list [whereSmall]) < 0)
		{
		    whereSmall = i;
		}
	    } // for

	    // Swap the smallest element with the boundary element.
	    SortUtil.swap (boundary, whereSmall, list);

	    // Statements to trace execution.
	    SortUtil.print (boundary, 3);
	    SortUtil.print (whereSmall, 3);
	    SortUtil.printList (list, n);
	} // for
    } // selectionSort method


    public static void main (String[] args)
    {
	String[] list = SortUtil.createStringArray (LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
	selectionSort (list, LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
    } // main method
} // SelectionSort class
