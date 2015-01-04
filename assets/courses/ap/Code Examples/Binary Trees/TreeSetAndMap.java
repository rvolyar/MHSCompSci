/** 
 * TreeSetAndMap.java
 *
 * Description: 
 * @author                      David Farrell
 * @version                     
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;


public class TreeSetAndMap 
{
	public TreeSetAndMap() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new TreeSetAndMap();
		
		
		
		// USE a TREESET
		
		Set s = new HashSet();
		
		s.add("Mary");
		s.add("Jane");
		s.add("Mary");
		s.add("Dennis");
		
		Iterator itr = s.iterator();
		
		// Sets do not allow duplicates
		System.out.println("The hashset has a size of " + s.size());
		
		// HashSet has NO Order
		while (itr.hasNext())
		{
			System.out.print((String) itr.next() + " " );
		}
		
		System.out.println();
		
		// remember that a TreeSet is a Collection !!!
		Set t = new TreeSet(s);  
		
		// NOTE:  the previous treeSet constructor is not in the AP subset
		// it may be replaced by:   Set t = copySetToTreeSet(s)
		
		itr = t.iterator();
		
		System.out.println("The treeset has a size of " + t.size());
		
		// TreeSet ORDERS the Data
		while (itr.hasNext())
		{
			System.out.print((String) itr.next() + " " );
		}
		
		
		// USE a TreeSet to remove all duplicates in an arrayList
		// AN arrayList IS A Collection
		
		/*
		
		ArrayList a = new ArrayList();
		
		Set names = new TreeSet(a);
		
		ArrayList a2 = new Arraylist(names);
		*/
		
		
		Set names = new TreeSet();
		
		names.add("Larry");
		names.add("Tony");
		names.add("Katherine");
		names.add("Eve");
		names.add("Juliet");
		
		System.out.println(names.size());
		
		itr = names.iterator();
		while (itr.hasNext())
		{
			System.out.print((String) itr.next() + " " );
		}
		
		System.out.println();
		
		
		names.add("Tony");
		names.remove("Eve");
		
		
		itr = names.iterator();
		while (itr.hasNext())
		{
			System.out.print((String) itr.next() + " " );
		}
		
		System.out.println();
		
		
		if (names.contains("Juliet"))
			System.out.println("Juliet IS IN THE SET");
		
		System.out.println();
		
		
		
		// Use a TREEMAP
		
		// key object MUST implement comparable interface
		
		
		Map mapNames = new TreeMap();
		
		mapNames.put(new Integer(1435), "Smith");
		mapNames.put(new Integer(1110), "Thomas");
		mapNames.put(new Integer(1425), "Jones");
		mapNames.put(new Integer(987), "Evans");
		mapNames.put(new Integer(1323), "Murray");
		
		
		System.out.println("number of cases is " + mapNames.size());
		
		Integer i = new Integer(1435);
		
		if (mapNames.containsKey(i))
			System.out.println("KEY FOUND");
			else
			System.out.println("KEY NOT FOUND");
			
			
		Set setNames = mapNames.keySet();
		
		itr = setNames.iterator();
		
		while (itr.hasNext())
		{
			Integer caseNumber = (Integer)itr.next();
			System.out.println(caseNumber + "  handled by " + 
				mapNames.get(caseNumber));
		}
		
		
		// TPS  HAVE STUDENTS Reverse the Key value Pairs by using String as the key
		// and Integer as the value )JESG p.327
		
		
		
		
	}
	
}
