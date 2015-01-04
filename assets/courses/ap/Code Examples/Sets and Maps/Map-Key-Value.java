

// use to test hashmap --- you must use objects as key and data
// to store
public class myStuff
{
	Integer id;
	String name;
	
	public myStuff(int i, String n)
	{
		id = new Integer(i);
		name = n;
	}
	public Integer getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return id.toString() + " , " + name;
	}
}


// MAP accepts "elements" as 2 seperate objects, a key and the data

// A MAP ADT must conform to the following:
/*
Put Associates the specified value with the specified key
	in this map If the map previously contained a mapping
	for this key, the old value is replaced.
	
Get -- Returns the value to which this map maps the specified key
		
Remove --  Removes the mapping for this key from this map if present 
			
Containskey - Returns true if this map contains a mapping for the 
			specified key
Size
		
Keyset - Returns a set view of the keys contained in this map.	
*/


// IN THIS PROJECT I IMPLEMENT THIS ADT UTILIZING JAVAS HASHMAP CLASS