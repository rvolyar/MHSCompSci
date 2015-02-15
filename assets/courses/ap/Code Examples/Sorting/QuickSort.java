// The "QuickSort" class.
// This class implements a recursive quicksort.

public class QuickSort
{
    private static int LIST_SIZE = 10;

    // Recursive method QuickSort to sort list of strings between
    // index left and index right.
    public static void quickSort (Comparable[] list,
	    int left, int right)
    {
	int pivotLocation;

	// Place pivot at left side of list.
	SortUtil.swap (left, (left + right) / 2, list);
	int lastSmall = left;
	for (int i = left + 1 ; i <= right ; i++)
	{
	    if (list [i].compareTo (list [left]) <= 0)
	    {
		lastSmall++;
		SortUtil.swap (lastSmall, i, list);
	    }
	}

	// Place pivot at boundary.
	SortUtil.swap (left, lastSmall, list);
	pivotLocation = lastSmall;

	// Statements to trace execution.
	SortUtil.print (left, 3);
	SortUtil.print (right, 3);
	SortUtil.print (pivotLocation, 3);
	SortUtil.printList (list, LIST_SIZE);

	// Sort left part.
	if (left < pivotLocation - 1)
	{
	    quickSort (list, left, pivotLocation - 1);
	}

	// Sort right part.
	if (pivotLocation + 1 < right)
	{
	    quickSort (list, pivotLocation + 1, right);
	}
    } // quickSort method


    public static void main (String[] args)
    {
	String[] list = SortUtil.createStringArray (LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
	quickSort (list, 0, LIST_SIZE - 1);
	SortUtil.printList (list, LIST_SIZE);
    } // main method
} // QuickSort class
