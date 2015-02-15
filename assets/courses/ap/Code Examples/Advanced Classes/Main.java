/*
 * Main.java
 *
 * Created on August 28, 2006, 9:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package samplecode;

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

public class Main {
    
    /** Creates a new instance of Main */
    public Main() 
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Top myT;
	
	myT = new Coin(0.25, "Nickel");// farrell nickel
	
	//double type = myT.getNum();
	
	Coin c = (Coin)myT;
	
	double type = c.getNum();
	
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

	
	// casting OVERRIDES precedence that would execute .  before casting () so extra ( )
	// allows the cast to occur BEFORE the method is executed
	// getTop executes first and returns a Top ref that is then cast to a parent
	SuperObject to = ((SuperObject)myPurse.getTop());
	
	System.out.println("the total in the purse is " +  to.getMyValue()); // prints out 100.0
	
	System.out.println("the total Objects in purse is " +  myPurse.getCount()); // prints out 3
	
	// cast the reference from Top interface to a class that implements the interface
	// because the method getNum is a method of Coin and TC
	System.out.println("the total COINS in purse is " +  ((Coin)myStuff[0]).getNum()); // prints out 3
	
	System.out.println("the total Travelers Checks in purse is " +  
		((TravelerCheck)myStuff[2]).getNum()); // prints out 3

		
	// test instance of SEE if stuff[1] is an instance of superclass, coin and TC
	if (myStuff[0] instanceof SuperObject)
		{
			System.out.println("myStuff[0] is a SuperClass");
		}
	if (myStuff[0] instanceof Coin)
		{
			System.out.println("myStuff[0] is a Coin");
		}
	if (myStuff[0] instanceof TravelerCheck)
		{
			System.out.println("myStuff[0] is a TC");
		}
	
	// use parents compareTo method from SuperClass
	// compareTo evaluates against the myValue attribute
	
	int ct =  ((SuperObject)myStuff[1]).compareTo(((SuperObject)myStuff[2]));
      
	
	System.out.println(((SuperObject)myStuff[1]).getMyValue() + " Compared to " +
		((SuperObject)myStuff[2]).getMyValue() + " returned " + ct);
	
	
	
	
	// FOLLOWING CODE GOES TO EXPLAIN PPT SLIDE #89
	// where a parent reference valued with a child has the restriction
	// similar to an interface reference in that that reference can only be used
	// to invoke methods that are KNOWN to the parent
	// therefore the following will cause an error
	// as we have a reference of type SuperObject and fill it in
	// with TravelerCheck child
	// if we attempt to call the getCheckType method of the child
	// a compiler error will occur
	
	SuperObject s;
	s = new TravelerCheck();
	
	//// String x = s.getCheckType();  // ERROR
	String x = ((TravelerCheck)s).getCheckType(); // WORKS
	
	
	
	
	}
	
	
}   // END OF Wrapper Class
    
