// The "VisualQuickSort" class.
import hsa.VisualSortUtil;

// This class implements a recursive Quicksort and displays
// the sorting in a window.
public class VisualQuickSort
{
    private static int LIST_SIZE = 500;

    // Recursive method QuickSort to sort list of strings between
    // index left and index right.
    public static void quickSort (Comparable[] list,
	    int left, int right)
    {
	int pivotLocation;

	// Place pivot at left side of list.
	VisualSortUtil.swap (left, (left + right) / 2, list);
	int lastSmall = left;
	for (int i = left + 1 ; i <= right ; i++)
	{
	    if (list [i].compareTo (list [left]) <= 0)
	    {
		lastSmall++;
		VisualSortUtil.swap (lastSmall, i, list);
	    }
	}

	// Place pivot at boundary.
	VisualSortUtil.swap (left, lastSmall, list);
	pivotLocation = lastSmall;

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
	Comparable[] list =
	    VisualSortUtil.createVisualArray ("Quicksort",
		LIST_SIZE, 300);

	quickSort (list, 0, LIST_SIZE - 1);
    } // main method
} // VisualQuickSort class
