/*
 * Gener.java
 *
 * Created on October 3, 2006, 10:03 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package generics;

/**
 *
 * @author Dave
 */
public class Gener implements Comparable <Gener>
{
    private int myValue;
    /** Creates a new instance of Gener */
    public Gener() 
    {
        myValue = 61;
    }
    public Gener(int c) 
    {
        myValue = c;
    }
    
   //      Make Use of Java 1.5's Generic use of compareTo where we
//      can TYPE the compareTo method to accept a specific class (or any in its hierarchy)
        public int compareTo(Gener o) throws ClassCastException
//      Non Generic Version of CompareTo:
//	public int compareTo(Object o) throws ClassCastException
	{
		//if (this.myValue < ((SuperObject)o).myValue)
                if (this.myValue < o.myValue)
			{
				return -1;
			}
		//if (this.myValue > ((SuperObject)o).myValue)
                if (this.myValue > o.myValue)
			{
				return 1;
			}
			
		return 0;  // equal
	}
        public String toString()
        {
         return Integer.toString(myValue);   
        }
      
    
}