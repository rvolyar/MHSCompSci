// The "ArrayPriorityQueue" class.
import java.util.ArrayList;
import java.util.List;

public class ArrayPriorityQueue implements PriorityQueue
{
    private List items;

    public ArrayPriorityQueue ()
    {
	items = new ArrayList ();
    } // ArrayPriorityQueue constructor


    public void add (Object x)
    {
	items.add (x);
    } // add method


    public Object remove ()
    {
	Object min = peek ();
	items.remove (min);
	return min;
    } // removeMin method


    public Object peek ()
    {
	int minIndex = 0;
	for (int i = 1 ; i < items.size () ; i++)
	{
	    if (((Comparable) items.get (i)).compareTo (items.get (minIndex)) < 0)
	    {
		minIndex = i;
	    }
	}
	return items.get (minIndex);
    } // peekMin method


    public boolean isEmpty ()
    {
	return items.size () == 0;
    } // isEmpty method
} // ArrayPriorityQueue class
