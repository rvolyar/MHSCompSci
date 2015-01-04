public class ListNode
{  

  // constructs a new node in the link
  public ListNode(Object initValue, ListNode initNext)
  { 
    value = initValue; 
    next = initNext; 
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

  // content of each node as an Object
  private Object value;
  
  // points to next node in list
  private ListNode next;
}

