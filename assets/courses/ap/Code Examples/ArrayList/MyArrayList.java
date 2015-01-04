// Simulates ARRAYLIST, have students implement this
// to better understand how the java api works

public class MyArrayList
{
    private Object [] list;
    private int numElements;       // number of students currently in the
									// list

    // Constructs the list, initially empty,
    // but can hold up to 100
    public MyArrayList ()
    {
    	list = new Object[100];
    	numElements = 0;
    }


    // Adds t to the end of the list
    public void add (Object t)
    {
    }


    // Returns the number of active elements on the list
    public int size ()
    {
    }


    // Returns the student in the i'th location (counting from 0)
    // Precondition: 0 <= i < size()
    public Object get (int i)
    {
    }


    // Sets the i'th location in the list to t;
    // returns the previous i'th element.
    public Object set (int i, Object t)
    {
    }


    // Removes the i'th element, sliding all items beyond i up by one spot.
    // Returns the element removed
    public Object remove (int i)
    {
    }
}
