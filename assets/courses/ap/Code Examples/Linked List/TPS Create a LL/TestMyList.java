
/**
 * USE THIS SPVM / DRIVER CODE TO TEST YOUR VERSION OF THE LINKEDLIST CLASS CALLED
 	LittleList.java
 	
 	YOUR Class Must Have the Following Methods:
 	
 			size
 			addLast
 			addFirst
 			remove (index)
 			removeFirst
 			removeLast
 			get (index)
 			toString
 			
 			
 			
 		
 */
public class TestMyList
{

	public static void main(String [] args)
	{
		
	LittleList l = new LittleList();
	l.addFirst("Hello");
	l.addFirst("Hi");
	l.addFirst("bye");
	l.addFirst("sammy joe bob");
	l.addFirst("ice cream");
	l.addLast("SB LAST");
	
	// since get returns an Object, first
	// cast the return to the type of object 
	// being stored in the linked list
	// then use the temporary variable to invoke
	// any of that classes methods
	// this is because, Object does not know about any
	// of the user defined class methods (although 
	// in this case we could just use the returned object
	// as all objects have the toString method
	String m = (String)l.get(3);
	System.out.println("SB third node item  " + m.toString());    
	    
	l.debugPrint();
	System.out.println(l.size());
	
	System.out.println("Now... Remove Last Node...");
	
	l.removeLast();
	l.debugPrint();
	System.out.println(l.size());
	
	System.out.println("Now... Remove First Node...");
	
	l.removeFirst();
	l.debugPrint();
	System.out.println(l.size());
	
	System.out.println("Now... Remove SECOND Node...");
	
	l.remove(2);
	l.debugPrint();
	System.out.println(l.size());
	
	} 

}
