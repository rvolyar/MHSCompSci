/** 
 * SampleLinkedList.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


/*  LINKED LIST  
				 1.  ADD TO BEGINNING OF LIST
				 3.  ADD TO END OF LIST --- TAIL
				 2.  TRAVERSE THE LIST
				 
	
	4A.  REMOVE A NODE FROM BEGINNING 
	4B.  REMOVE A NODE FROM END
	
	
	DOUBLY LINKED LIST  5. INSERT IN ORDER
						6. REMOVE 
						7. TRAVERSE
	
	8. CIRCULAR LINKED LIST	 --- INSERT, TRAVERSE
	
	
	LINKEDLIST CLASS
						9.  USING THE CLASS
						10. ITERATION
*/

import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class SampleLinkedList 
{
	public SampleLinkedList() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new SampleLinkedList();
		
		// create some data objects to store in the list
		
		AirFlight f1 = new AirFlight("Atlanta", 100);
		AirFlight f2 = new AirFlight("Orlando", 500);
		AirFlight f3 = new AirFlight("Kennedy", 350);
		AirFlight f4 = new AirFlight("Newark", 300);
		AirFlight f5 = new AirFlight("Utah", 400);
		AirFlight f6 = new AirFlight("Houston", 200);
		AirFlight f7 = new AirFlight("Chicago", 860);
		

// 1. ADD NODES TO THE BEGINNING OF THE LIST

		// create a linked list &  put the nodes into a list
		
		// head node
		ListNode head = null;
		
		// create a new node
		ListNode node = new ListNode(f1, null);           // A
		
		// set head to point to first element in the link
		head = node;  
		
		// print the head node
		System.out.println("The first Node is " + ((AirFlight)head.getValue()).toString());
		System.out.println();
		
		// add a node to the list using the setnext method
		// this will be the second node in the list
		head.setNext(new ListNode(f2, null));            // A O
		
		// add new nodes to the BEGINNING OF THE LIST
		head = new ListNode(f3,head);                    // K A O  
		// NOTE:  head is the "next" node which was Atlanta --> Orlando
		//        when head becomes Kennedy, its "next" node is Atlanta and
		//		  Atlanta's is Orlando
														 
		head = new ListNode(f4,head);					// N K A O
		head = new ListNode(f5,head);					// U N K A O
		head = new ListNode(f6,head);					// H U N K A O
		
		// GET the contents of the first node in the list
		AirFlight a = (AirFlight)head.getValue();
		System.out.println(a.toString());
		
		

// 2. TRAVERSE THE LIST
		
		// Traverse List
		System.out.println();
		System.out.println("Print the initial list inserted to the FRONT s/b H U N K A O");
		
		AirFlight b;
		
		for (node = head; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
		}
		

// 4A.  REMOVE A NODE FROM THE BEGINNING OF THE LIST
		head = head.getNext();


// 2. TRAVERSE THE LIST
		
		// Traverse List
		System.out.println();
		System.out.println("Print the list AFTER the  FIRST node is REMOVED s/b U N K A O");
		
		for (node = head; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
		}
		
		

// 3. ADD NODES TO THE END OF THE LIST	
	
		// Add Nodes to the End of the List --- TAIL
		
		ListNode head2 = new ListNode(f1, null);  
		ListNode tail = head2;
		
		node = new ListNode(f2,null);
		// change previous "tails" next node
		// BEFORE updating the list to include the NEW tail
		tail.setNext(node);
		tail = node;
		
		node = new ListNode(f3,null);
		tail.setNext(node); // current tail to point to "new" tail
		tail = node;  // set the new tail
		
		node = new ListNode(f4,null);
		tail.setNext(node);  // current tail to point to "new" tail
		tail = node;  // set the new tail

		
// 2. TRAVERSE THE LIST

		// Traverse List
		System.out.println();
		System.out.println("Print the initial list inserted to the TAIL s/b = A O K N");
		
		// 8. CIRCULAR LINKED LIST
		// note the termination test is NOT "node != null"
		// when processing a circular LL, check for a "next" node = head node
		// this signifies the last node	
		for (node = head2; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
		}
		
					
		// if we were adding to the END of the list IN A LOOP
		// we would do the following
		/*
			ListNode head = null, tail = null. node;
			
			while( nodes to add )
			{
				Object value = ;
				node = new ListNode(value, null);
				if (head == null)  // first node in the list
					head = node;
				   else
				   	tail.setNext(node);
				tail = node; // update the tail node
		
		
		*/
		
// 4B.  REMOVE A NODE FROM THE END OF THE LIST
		node = head2;
		ListNode p = null;
		while(node.getNext() != null)
		{
			p = node;
			node = node.getNext();
		}
		if (p != null)
			{
				p.setNext(null);  // prev is now last node
			}
			else
			{
				head2 = null;  // list is now empty
			}


// 2. TRAVERSE THE LIST

		// Traverse List
		System.out.println();
		System.out.println("Print the list AFTER the TAIL is REMOVED s/b = A O K");
		
		
		for (node = head2; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
		}


		
// 8. CIRCULAR LINKED LIST

	// Add Nodes to the End of the List --- TAIL
			
			ListNode head3 = new ListNode(f1, null);  
			tail = head3;
			tail.setNext(head3);
			
			node = new ListNode(f2,null);
			// change previous "tails" next node
			// BEFORE updating the list to include the NEW tail
			tail.setNext(node);
			tail = node;
			tail.setNext(head3);  // 8. Cir LL requires last node's "next" to point
								  // to HEAD or First node
			
			node = new ListNode(f3,null);
			tail.setNext(node); // current tail to point to "new" tail
			tail = node;  // set the new tail
			tail.setNext(head3);  // 8.
			
			node = new ListNode(f4,null);
			tail.setNext(node);  // current tail to point to "new" tail
			tail = node;  // set the new tail
			tail.setNext(head3);  // 8.
		
// 2. TRAVERSE THE LIST

		// Traverse List
		System.out.println();
		System.out.println("Print the initial CIRCULAR list with TAIL s/b = A O K N");
		
		// 8. CIRCULAR LINKED LIST
		// note the termination test is NOT "node != null"
		// when processing a circular LL, check for a "next" node = head node
		// this signifies the last node	
		node = head3;
		do
		 {
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
			node = node.getNext();
			
			System.out.println(node + "  "+ head3);
			
		 }while (node != head3); // this is a circular linked list !!!
		
					
		
// 5. INSERT NODES IN ORDER TO A DOUBLY LINKED LIST
		
		// Doubly Linked List
		// The ListNode class needed to be modified to handle a "previous" node
		// INSERT NODES IN ORDER
		
		AirFlight myAir[] = new AirFlight[5];
		myAir[0] = f5;
		myAir[1] = f2;
		myAir[2] = f1;
		myAir[3] = f4;
		myAir[4] = f7;
		
		
		ListNode head4 = null;   
		ListNode newNode = null;
		ListNode next = null;
		ListNode prev = null;
		
		for (int x = 0; x < 5; x++) // insert nodes
		{
			if (head4 == null)
				{
					head4 = new ListNode(myAir[x], null,null);
					continue;
				}
			// search for correct "place" to insert new node
			node = head4;
			// compare the flight numbers of the nodes in list to new node being inserted
			while (node != null && ((AirFlight)node.getValue()).getFlightNum() <
				 myAir[x].getFlightNum())
			{
				// track previous node
				prev = node;
				
				// move to next node
				node = node.getNext();
			}
			
			// create the new node, set its previous node to the 
			// "prev" node
			newNode =  new ListNode(myAir[x], null, prev);
		
			// set the new nodes next pointer to "prev" nodes next pointer
			// OR to the "head" of the list if there is no previous node
			if (prev == null)
				{
					newNode.setNext(head4);
					head4.setPrev(newNode);
					// update "head" of the list as the new node is first node
					head4 = newNode;
				}
			  else
			  	{
					newNode.setNext(prev.getNext());
					// finally set the prev node's "next" pointer to 
					// point to the new node
					prev.setNext(newNode);
			
				}
			// reset 
			prev = null;
		}
		
// 7. TRAVERSE A DOUBLY LINKED LIST
		
		// TRAVERSE THE ORDERED DOUBLY LINKED LIST
		System.out.println();
		System.out.println("Print the DOUBLY ORDERED LL s/b = A E U O C");
		
		
		for (node = head4; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
			
		}
		
// 6. REMOVE NODES IN A DOUBLY LINKED LIST		
		
		// REMOVE an element from the DOUBLY LINKED LIST
		
		// find the correct node
		node = head4;
		prev = null;
			// compare the flight numbers of the nodes in list to new node being inserted
			while (node != null && ((AirFlight)node.getValue()).getFlightNum() !=
				 f5.getFlightNum()) // remove utah -- f5
			{
				// track previous node
				prev = node;
				
				// move to next node
				node = node.getNext();
			}
		// if node is null then node such node exists
		// throw an error
		if (node == null)
			throw new NoSuchElementException("The Object to be Removed is NOT in the List");
		// unlink the node to be removed
		if (prev == null) // then this is the first node in the list
			{             // so set the next nodes prev to null and 
						  // make it the head node
			ListNode n = node.getNext();
			n.setPrev(null); 
			head4 = n;
			}
		   else
		   // simply unlink the node to be removed
		   {
		   	prev.setNext(node.getNext());
		   }
		
		
// 7. TRAVERSE A DOUBLY LINKED LIST
		
		// TRAVERSE THE ORDERED DOUBLY LINKED LIST
		System.out.println();
		System.out.println("Print the Modified DOUBLY ORDERED LL s/b = A E O C");
		
		
		for (node = head4; node != null ; node = node.getNext())
		{			
			b = (AirFlight)node.getValue();
			System.out.println(b.toString());
		}
		
		// Circular Linked List
		


// 9 & 10  LINKEDLIST CLASS		
		
	// This class utilizes a Doubly Linked List
		
	LinkedList ll = new LinkedList();
		
	ll.add(f1);
	ll.add(f2);
	ll.add(f3);
	ll.add(f4);
	ll.add(f5);
	ll.add(f6);
	ll.add(f7);
	
	System.out.println();
	System.out.println("Print the elements of LinkedList Using Java Class & Iterator");
	System.out.println();
	System.out.println("There are " + ll.size() + " Nodes in the List  A O K N U H C");
	
	printLL(ll);
	
	
	// remove a node
	// there are 4 overloaded removes:
	//		remove first
	//  	remove last
	//		remove specific index
	//		remove a target object
	
	ll.remove(1); // removes 
	ll.removeLast();
	
	AirFlight af = (AirFlight)ll.getFirst();
	System.out.println();
	System.out.println(af);
	
	System.out.println();

	System.out.println();
	System.out.println("AFTER Removals There are NOW " + ll.size() + " Nodes in the List  O K N U H ");	
	
	printLL(ll);	
	
	System.out.println();
		// instance of iterator
		Iterator iter = ll.iterator();
		// roll thru nodes of list until none are left
		while(iter.hasNext())
		{
			//  returns the next node's Object (value) in the list
			AirFlight f = (AirFlight)iter.next();
			// remove the flight number 300 -- Newark
			if (f.getFlightNum() == 300)
				{
				 iter.remove();
				 System.out.println(f + " Removed");
				}
		}
	System.out.println();
	System.out.println("AFTER Removals There are NOW " + ll.size() + " Nodes in the List  O K U H ");	
	
	printLL(ll);
		
	} // end of SPVM
	
	static public void printLL(List ll)
	{
		Iterator iter = ll.iterator();
		iter = ll.iterator();
		while(iter.hasNext())
		{
		// display list with newark removed
		System.out.println(iter.next());
		}
	}
	
}  // end of Wrapper

// data object to store 
public class AirFlight
{
	private String Destination;
	private int flightNum;
	
	public AirFlight(String s, int num)
	{
		Destination = s;
		flightNum = num;
	}
	
	
	public String getDestination()
	{
		return Destination;
	}
	
	public int getFlightNum()
	{
		return flightNum;
	}
	
	public String toString()
	{
		return Destination + " flight #" + flightNum;
	}
}	
	


// Linked List Node Class
public class ListNode
{  
  // content of each node as an Object
  private Object value;
  
  // points to next node in list
  private ListNode next;
  
  // points to previous node in list
  // Required to implement a DOUBLY LINKED LIST
  private ListNode prev;
  
  // constructs a new node in the link
  public ListNode(Object initValue, ListNode initNext)
  { 
    value = initValue; 
    next = initNext; 
  }
  
   // overloaded constructor for a new node with a DOUBLY LINKED LIST
  public ListNode(Object initValue, ListNode initNext, ListNode initPrev)
  { 
    value = initValue; 
    next = initNext; 
    prev = initPrev;  // DOUBLY LINKED LIST
  }

  // returns the state of the current node in the link
  public Object getValue() 
  { 
  	return value; 
  }
  
  // returns the reference of the next node in the link
  public ListNode getNext() 
  {
  	return next; 
  }

  // returns the reference of the next node with a DOUBLY LINKED LIST
  public ListNode getPrev() 
  {
  	return prev; 
  }
  
  // mutates the state of the current node
  public void setValue(Object theNewValue) 
  {
  value = theNewValue; 
  }
  
  // set a link to the next logical node in the link
  public void setNext(ListNode theNewNext) 
  { 
  	next = theNewNext; 
  }
  
  // set a link to the PREVIOUS logical node with a DOUBLY LINKED LIST
  public void setPrev(ListNode theNewPrev) 
  { 
  	prev = theNewPrev; 
  }

  
}
