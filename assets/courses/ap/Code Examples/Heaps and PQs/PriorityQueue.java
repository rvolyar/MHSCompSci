// The "PriorityQueue" interface.
public interface PriorityQueue
{
    // postcondition: Returns true if the number of elements in
    //                 the priority queue is 0; otherwise, returns false.
    boolean isEmpty ();

    // postcondition: x has been added to the priority queue;
    //                 number of elements in the priority queue is increased by 1.
    void add (Object x);

    // postcondition: The smallest item in the priority queue is removed
    //                 and returned; the number of elements in the priority queue
    //                 is decreased by 1.
    //                 Throws an unchecked exception if the priority queue is empty.
    Object removeMin ();

    // postcondition: The smallest item in the priority queue is returned; the
    //                 priority queue is unchanged.
    //                 Throws an unchecked exception if the priority queue is empty.
    Object peekMin ();
} // PriorityQueue interface
