// The "VisualSelectionSort" class.
import hsa.VisualSortUtil;

// This class implements a visual selection sort using
// the VisualSortUtil class.
public class VisualSelectionSort
{
    private static int LIST_SIZE = 500;

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
	    VisualSortUtil.swap (boundary, whereSmall, list);
	} // for
    } // selectionSort method


    public static void main (String[] args)
    {
	Comparable[] list =
	    VisualSortUtil.createVisualArray ("Selection Sort",
		LIST_SIZE, 300);

	selectionSort (list, LIST_SIZE);
    } // main method
} // VisualSelectionSort class
