// The "TreeValue" class.
public class TreeValue implements Comparable
{
    private Comparable key;
    private Object value;

    public TreeValue (Comparable initKey, Object initValue)
    {
	key = initKey;
	value = initValue;
    } // TreeValue constructor


    public Comparable getKey ()
    {
	return key;
    } // getKey method


    public Object getValue ()
    {
	return value;
    } // getValue method


    public int compareTo (Object obj)
    {
	TreeValue other = (TreeValue) obj;
	return key.compareTo (other.getKey ());
    } // compareTo method
} // TreeValue class
