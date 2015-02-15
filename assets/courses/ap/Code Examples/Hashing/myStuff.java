/*
 * myStuff.java
 *
 * Created on January 23, 2007, 12:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Dave
 */

package hashing;

public class myStuff
{
	Integer id;
	String name;
	
	public myStuff(int i, String n)
	{
		id = new Integer(i);
		name = n;
	}
	public Integer getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return id.toString() + " , " + name;
	}
}