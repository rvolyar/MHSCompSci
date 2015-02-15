/*
 * TempExample.java
 *
 * Created on October 3, 2006, 11:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package generics;

/**
 *
 * @author Dave
 */
public class TempExample <T>
{
    private T tValue;
    /** Creates a new instance of TempExample */
    public TempExample(T t) 
    {
    tValue = t;
    }
    public T get()
	{
		return tValue;
	}
    public void set(T t)
    {
        tValue = t;
    }
     public String toString()
	{
		return tValue.toString();
	}

}