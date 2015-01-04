/*
 * TravelerCheck.java
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
public class TravelerCheck extends SuperObject  implements Top
{
	private static int numTC = 0;
	private String checkType;
	
	public TravelerCheck(double value, String name, String t) 
	{  
		checkType = t;
		numTC++;
		setMyValue(value);	
		setMyName(name);
	}
	
	public TravelerCheck()
	{
		this(100.0, "TC", "American Express");
	} 
	
	public double getTop()  
	{  
	return getMyValue(); 
	}
	
	public String getCheckType()
	{
		return checkType;
	}
	
	public int getNum()
	{
		return numTC;
	}
} 

