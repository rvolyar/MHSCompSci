/*
 * arrayStack.java
 *
 * Created on January 1, 2007, 1:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package arraystack;
import java.util.Stack;
import java.util.ArrayList;

/**
 *
 * @author Dave
 */
public class arrayStack <E> extends Stack<E>{
   
   // private E value;
    private ArrayList<E> array;
   
    
    /** Creates a new instance of arrayStack */
    public arrayStack() //(E i) 
    {
      //  value = i;
        array = new ArrayList<E>(); 
    }
    
    public E push(E item) 
  { 
  	array.add (item);
        
        return item;
      
  } 
  
  public E pop() 
  {
   return array.remove(array.size() - 1); 
  } 
   
  public E peek() 
  { 
  	return array.get(array.size() - 1); 
  } 
  
  public boolean empty() 
  { 
    return array.size() == 0; 
  } 

    public int search(Object o) {
	int i = array.lastIndexOf(o);

	if (i >= 0) {
	    return array.size() - i;
	}
	return -1;
    }
}
