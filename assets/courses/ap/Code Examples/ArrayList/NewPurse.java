/** 
 * NewPurse.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */
/** 
 
 // OUTPUT:
 /*
    the total in the purse is 100.35
	the total in the purse is 100.0
	the total Objects in purse is 3
	the total COINS in purse is 2
	the total Travelers Checks in purse is 1
	myStuff[0] is a SuperClass
	myStuff[0] is a Coin
	0.1 Compared to 100.0 returned -1
 */
 
import java.util.ArrayList;

public class NewPurse 
{
	public NewPurse() {
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new NewPurse();
		
			
	Purse myPurse = new Purse();

	Top [ ]  myStuff = new Top[3];

	myStuff [0] = new Coin(.25, "Quarter");
	myStuff [1] = new Coin(.10, "Quarter");
	// assume TravelerCheck is another child ofSuperObject
	myStuff [2] = new TravelerCheck(100.0, "TC", "American Express"); 
							


	myPurse.add( myStuff[0] ); // adds .25 to purse and sets THIS Coin object as max
	myPurse.add( myStuff[1] ); // adds .10 to purse 
	myPurse.add( myStuff[2] ); // adds 100.0 to purse and sets THIS TravelerCheck object as max

	System.out.println("the total in the purse is " +  myPurse.getTotal()); // prints out 100.35

	
	SuperObject to = ((SuperObject)myPurse.getTop());
	
	// ArrayList Test 
	Object o = myPurse.getElement(1);
	
	if (o instanceof Coin)
		{
			System.out.println("the 2nd element in the Purse is a Coin");
		}
	
	o = myPurse.getElement(2);
		
	if (o instanceof TravelerCheck)
		{
			System.out.println("the 3rd element in the Purse is a TC");
		}
	
	
	
	// remove an element
	o = myPurse.RemoveElement(1);
	if (o instanceof Coin)
		{
			System.out.println("the 2nd element Coin is removed");
		}
	System.out.println("There are " + myPurse.getCount() + " Objects in the Purse");
	
	//o = myPurse.getElement(2); 
	// the result is an IndexOutOfBoundsException
	// as there are now only 2 elements in the ArrayList
	
	
	// modify an element -- replace a Coin with a TC
	o = myPurse.setElement(0, myStuff[2]);
	if (o instanceof Coin)
		{
			System.out.println("the 1st element was a Coin");
		}
	// display the types of objects in the purse
	String ss = myPurse.toString();
	System.out.println("the elements in the purse are now " + ss);
	
	} // end of SPVM
	
	
}   // END OF Wrapper Class






// POSTCONDITION: Return the HIGHEST valued "SuperObject" in the Purse
public interface Top
{
	double getTop( );
}

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
	
	public int compareTo(Object o) throws ClassCastException
	{
		if (this.myValue < ((SuperObject)o).myValue)
			{
				return -1;
			}
		if (this.myValue > ((SuperObject)o).myValue)
			{
				return 1;
			}
			
		return 0;  // equal
	}
	
	public String toString()
	{
		return myName;
	}
}



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



public class Purse 
{
	private double sum;
	private int count = 0;
	private Top max;
	private ArrayList myArray;
	
	public Purse ()
	{
		myArray = new ArrayList(100); 
		// initial capacity of 100 objects
								
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
		// added for arraylist
		// add new "coin" or "TC" superobject to list
		myArray.add(ci);
		
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
		// return count;
		return myArray.size();
	}
	
	public Object getElement(int i)
	{
		return myArray.get(i);
	} 
	
	public Object RemoveElement(int i)
	{
		return myArray.remove(i);
	} 
	
	public Object setElement(int e, Object o)
	{
		return myArray.set(e, o);
	}
	
	public String toString()
	{
		String s = " ";
		
		for(int x = 0; x < myArray.size(); x++)
		{
			
			s += ((SuperObject)myArray.get(x)).toString();
			s += " ";
		} 
		return s;
	}
	
}



public class MensPurse extends Purse
{
	// class stuff here
}




