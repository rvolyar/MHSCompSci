// The "PriorityQueueExample" class.
public class PriorityQueueExample
{
    public static void main (String[] args)
    {
	PriorityQueue myQueue = new ArrayPriorityQueue ();
	myQueue.add (new PriorityString ("A", 2));
	myQueue.add (new PriorityString ("B", 2));
	myQueue.add (new PriorityString ("C", 2));
	System.out.println (myQueue.remove ());    // Outputs A
	myQueue.add (new PriorityString ("D", 3));
	System.out.println (myQueue.remove ());    // Outputs B
	myQueue.add (new PriorityString ("E", 1));
	myQueue.add (new PriorityString ("F", 1));
	System.out.println (myQueue.remove ());    // Outputs E
	System.out.println (myQueue.remove ());    // Outputs F
	System.out.println (myQueue.remove ());    // Outputs C
	System.out.println (myQueue.remove ());    // Outputs D
	System.out.println (myQueue.isEmpty ());    // Outputs true
    } // main method
} // PriorityQueueExample class
