public class PriorityString implements Comparable
{
    private String s;
    private int priority;

    public PriorityString (String newString, int newPriority)
    {
	s = newString;
	priority = newPriority;
    } // PriorityString constructor


    public String getString ()
    {
	return s;
    } // getString method


    public String toString ()
    {
	return s + "(" + priority + ")";
    } // toString method


    public int compareTo (Object obj)
    {
	PriorityString other = (PriorityString) obj;
	if (priority < other.priority)
	    return -1;
	else if (priority == other.priority)
	    return 0;
	else
	    return 1;
    } // compareTo method
} // PriorityString class
