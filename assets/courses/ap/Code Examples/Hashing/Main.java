/*
 * Main.java
 *
 * Created on January 23, 2007, 11:50 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package hashing;
import java.util.*;


/**
 *
 * @author Dave
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
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
    
    public static void main(String[] args) 
    {
        Map <Integer, myStuff> stuff = new HashMap<Integer, myStuff>();
        
        
        myStuff[] ms = new myStuff[5];
	
	ms[0] = new myStuff(21,"Neri");
	ms[1] = new myStuff(31,"Castro");
	ms[2] = new myStuff(11,"Defazio");
	ms[3] = new myStuff(61,"Zegers");
	ms[4] = new myStuff(86,"Rogers");

        for(int a = 0; a < ms.length;a++)
            {
                stuff.put(ms[a].getId(), ms[a]);  // AUTO BOXING
            }
        
        myStuff x = stuff.get(new Integer(11));
	System.out.println(x.toString());
        
        System. out .println ("");
	System. out .println ("Number of cases: " + stuff.size ()); // 5
	System. out .println ("");
        
        // EXAMPLE OF AUTO BOXING --- pass in primitive 86, an Integer object is created
        if (stuff.containsKey (86) )
		System. out .println ("Key found. ") ; 
          else
		System.out.println("Key NOT found.");

	System. out .println ("");
        
        // KEY SET AND ITERATE
        Set namesSet = stuff.keySet(); 
	Iterator iter = namesSet.iterator (); 
	while (iter.hasNext())
	{
		Integer caseNumber = (Integer)iter.next();
		System.out.println(caseNumber + " maps to value object " + 		
			stuff.get(caseNumber));
	}
	
	System. out .println ("");
        
        // USE FOR EACH LOOP
        for(Object xx: namesSet)
        {
            System.out.println("FOR EACH " + xx.toString());
        }
        
        stuff.put(new Integer(86), new myStuff(86,"Lincoln"));
        System. out .println (stuff.get(86));
        
        // CALL the function to test sets
        workWithHashSet();
    }
    
    static public void workWithHashSet()
    {
        // Methods:
        // ADD, COntains, Size, REmove, Iterate
        
        Set <String> s;  // could have HashSet s
        
        s = new HashSet<String>();
        
        s.add("Sally");
        s.add("Joe");
        s.add("Bob");
        s.add("Betty");
        s.add("Bob");
        
        // USE FOR EACH LOOP
        for(String xx: s)
        {
            System.out.println("FOR EACH " + xx.toString());
        }
        
        System.out.println("The Size of the Set is " + s.size());
        
        
        // USE ITERATOR
        System.out.println(" ");
        Iterator iter = s.iterator (); 
	while (iter.hasNext())
	{
		System.out.println(iter.next());
	}
        
        s.remove("Bob");
        System.out.println(" ");
        
        iter = s.iterator (); 
        while (iter.hasNext())
	{
		System.out.println(iter.next());               
	}
        
        System.out.println(" ");
        
        if (s.contains("Sally"))
                    System.out.println("SALLY FOUND !!! ");
    }
    
}
