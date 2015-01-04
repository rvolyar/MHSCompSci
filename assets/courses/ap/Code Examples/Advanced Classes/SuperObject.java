/*
 * SuperObject.java
 *
 * Created on August 28, 2006, 9:50 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package samplecode;

// abstract due to abstract method getNum

abstract public class SuperObject implements Comparable
{
	private String myName;
	private double myValue;
	
	public SuperObject() 
	{ 
		myName = "";
		myValue = 0; 
		
	}
	
	public double getMyValue()
	{
	 return myValue;
	}
	
	public String getMyName()
	{
	 return myName;
	}
	
	public void setMyName(String s)
	{
		myName = s;
	}
	
	// PRECONDITION:  value is > 0 and less than 100
	public void setMyValue(double d)
	{
		myValue = d;
	}
	
	// abstract method to have behavior coded in children
	abstract public int getNum();
	
        public int compareTo(SuperObject o) throws ClassCastException
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
	
}
