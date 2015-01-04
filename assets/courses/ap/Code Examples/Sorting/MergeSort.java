// The "MergeSort" class.
// This class implements a recursive merge sort.

public class MergeSort
{
    private static int LIST_SIZE = 10;

    private static void merge (Comparable[] list,
	    int first, int middle, int last)
    {
	// List going from first to middle is sorted.
	// List going from middle + 1 to last is sorted.
	Comparable temp[] = new Comparable [last + 1];
	// Index of the front of the first sorted list.
	int firstListPos = first;
	// Index of the front of the second sorted list.
	int secondListPos = middle + 1;
	// Index of the front of the result array.
	int resultListPos = first;

	while (resultListPos <= last)
	{
	    if ((firstListPos < middle + 1) &&
		    ((secondListPos > last) ||
			(list [firstListPos].compareTo (
				list [secondListPos]) < 0)))
	    {
		temp [resultListPos] = list [firstListPos];
		firstListPos++;
	    }
	    else
	    {
		temp [resultListPos] = list [secondListPos];
		secondListPos++;
	    }
	    resultListPos++;
	} // while

	// Copy merged array back to original place.
	for (int i = first ; i <= last ; i++)
	{
	    list [i] = temp [i];
	} // for
    } // merge method


    // Recursive method that uses itself and the merge method
    // to sort.
    public static void mergeSort (Comparable[] list,
	    int first, int last)
    {
	// If there is only one element (first == last),
	// then the list is already sorted.
	if (last > first)
	{
	    int middle = (first + last) / 2;
	    // Sort the first half.
	    mergeSort (list, first, middle);
	    // Sort the second half.
	    mergeSort (list, middle + 1, last);
	    // Merge the two halves.
	    merge (list, first, middle, last);

	    // Statements to trace execution.
	    SortUtil.print (first, 3);
	    SortUtil.print (last, 3);
	    SortUtil.printList (list, LIST_SIZE);
	} // if
    } // mergeSort method


    public static void main (String[] args)
    {
	String[] list = SortUtil.createStringArray (LIST_SIZE);
	SortUtil.printList (list, LIST_SIZE);
	mergeSort (list, 0, LIST_SIZE - 1);
	SortUtil.printList (list, LIST_SIZE);
    } // main method
} // MergeSort class
