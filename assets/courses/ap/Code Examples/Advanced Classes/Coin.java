/*
 * Coin.java
 *
 * Created on August 28, 2006, 9:54 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package samplecode;

/**
 *
 * @author Dave
 */
public class Coin extends SuperObject  implements Top
{
	private static int numCoins = 0;
	
	public Coin(double value, String name) 
	{  
		setMyValue(value);	
		setMyName(name);
		numCoins++;
	}
	
	public Coin( )
	{
		this(1, "dollar");  // calls Coins constructor that takes 2 arguments
	} 
	
	public double getTop( )  
	{  
	return getMyValue(); 
	}
	
	public int getNum()
	{
		return numCoins;
	}
} 