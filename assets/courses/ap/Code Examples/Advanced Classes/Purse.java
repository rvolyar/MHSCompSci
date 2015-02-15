/*
 * Purse.java
 *
 * Created on August 28, 2006, 9:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package samplecode;

/**
 *
 * @author Dave
 */
public class Purse {
	private double sum;
	private int count = 0;
	private Top max;
	
	public Purse ()
	{
		// constructor code
	}
	
	public void add(Top ci)  
	{ 
		 // code here 
		if (count == 0 ||  max.getTop() < ci.getTop() )
		{
			max = ci;
		}
		count++;
		sum += ci.getTop();
	}
	
	public double getTotal()  
	{  
		return sum; 
	}
	
	public Top  getTop()
	{
		return max;
	}
	
	public int getCount()
	{
		return count;
	}
	
}