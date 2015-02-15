/** 
 * DriverExample.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */
 
 /* SAMPLE OUTPUT:
 
 Driver 84-68-6323 Found!!!
Sequantial Search took 0
Selection Sort took 0
0) 11-70-6341
1) 20-96-8258
2) 28-73-7352
3) 42-61-8618
4) 62-91-3970
5) 68-31-2201
6) 73-52-8873
7) 84-68-6323
8) 87-99-7703
9) 98-90-9619
BS 62-91-39702
BS 84-68-63230
Driver 84-68-6323 Found!!!
Binary Search took 0


*/
 
 
import java.util.Random;


public class DriverExample 
{
	public DriverExample() 
	{
	}

	public static final int NUMELEMENTS = 1000;
	// Main entry point
	static public void main(String[] args) 
	{
		new DriverExample();
		
		// declare and seed a random object
		long seedVal;
		seedVal = System.currentTimeMillis ();
		Random myNum = new Random(seedVal);
		
		// an array of drivers
		Driver myDriver[] = new Driver[NUMELEMENTS];
	
		
		// populate the drivers with different SSN's
		for (int i = 0; i < NUMELEMENTS; i++)
		{
			Long L = new Long(Math.abs(myNum.nextLong()));
			myDriver[i] = new Driver((L.toString()).substring(0,9));
			// System.out.println(myDriver[i].toString());
		   // A longer way to do the same thing:
		   //String ss = L.toString();
		   //System.out.println(ss.substring(0,9));
		}
	
	long startTime;
	long endTime;
	
	// find a "driver" using sequencial / linear search
	startTime =  System.currentTimeMillis ();

	// get a random number to search for
	String find = myDriver[NUMELEMENTS - 5].getSSN();
	boolean b = false;
	
	
	
	//
	// SEQUENTIAL SEARCH
	//
	for(int i=0; i < NUMELEMENTS; i++)
	{
		if(find.equals(myDriver[i].getSSN()))
		{
			System.out.println("Driver " + myDriver[i].toString() + " Found!!!");
			b = true;
			break;
		}
	}
	
	if (b = false)
		System.out.println("Driver " + find + " NOT Found!!!");
	endTime = System.currentTimeMillis ();
	
	System.out.println("Sequantial Search took " + (endTime - startTime));
	b = false;
	
	//
	// sort using selection sort
	//
	startTime =  System.currentTimeMillis ();
	
	int i = 0;
	int iMax = 0;
	int n = myDriver.length;
	
    while (n > 1) 
    
    {
        // Find the largest element:
        for (iMax = 0, i = 1;   i < n;   i++)
        	{
        	int cmp = myDriver[i].compareTo(myDriver[iMax]);
            if (cmp > 0)
            	{
            	 iMax = i;
             	}
			}
        // Swap it with the last element:
        Driver td = myDriver[iMax];
        myDriver[iMax] = myDriver[n-1];
        myDriver[n-1] = td;
        n--;
	}
    
    endTime = System.currentTimeMillis ();
	System.out.println("Selection Sort took " + (endTime - startTime));
	
	// PRINT THE SORTED ARRAY
	for(int x = 0; x < myDriver.length; x++)
	{
		//// System.out.println(x + ") " + myDriver[x].toString());
	}
	
	
	//
	// Binary search
	//
	
	// find a "driver" using binary search
	
      int low = 0;                  // low subscript
      int high = myDriver.length - 1;  // high subscript
      int middle;                   // middle subscript
	  int comp;
	  
      // use compareto to provide equal GT and LT
      // as seen in traditional Binary Search algorithms
     
     startTime =  System.currentTimeMillis ();
     
      while ( low <= high ) 
      {
         middle = ( low + high ) / 2;

         comp = (find.compareTo(myDriver[middle].getSSN()));
         System.out.println("BS " + myDriver[middle].toString() + comp);
         if ( comp == 0 )  // match
         	{
         	System.out.println("Driver " + myDriver[middle].toString() + " Found!!!");
         	b = true;
            break;
            }
         else if (comp < 0)
            high = middle - 1;  // search low end of array
         else
            low = middle + 1;   // search high end of array
      }
		
	if (b == false)
		System.out.println("Driver " + find + " NOT Found!!!");
		
	System.out.println("Binary Search took " + (endTime - startTime));
	b = false;
    
	
	
	// compare the times of the two searches
	
		
		
	} // end of SPVM
	
} // end of Wrapper Class


public class Driver extends Object implements Comparable
{
	private String sSN;
	private String lName;
	private String fName;
	private int liscNum;
	private int yrsDrive;
	static private int count = 0;
	
	public Driver(String s, String l, String f, int y)
	{
		count++;
		sSN = s;
		lName = l;
		fName = f;
		liscNum = count;
		yrsDrive = y;
	}
	
	public Driver(String s)
	{
		count++;
		sSN = s;
		lName = "Doe";
		fName = "John";
		liscNum = count;
		yrsDrive = 1;
	}

	public String getSSN()
	{
		return sSN;
	}
	
	public String toString()
	{
		return sSN.substring(0,2) + "-" + sSN.substring(2,4) + "-" + sSN.substring(4,8);
	}
	
	
	// The Driver class's implementation of the compareTo method
	// actually compares the SSN (a string) by using the STRING'S
	// compareto method
	public int compareTo(Object o)
	{
		if (!(o instanceof Driver))
		{
			throw new IllegalArgumentException("You MUST Pass a Driver Object" );
		}
		
		Driver d = (Driver)o;
		
		int c = this.sSN.compareTo(d.getSSN());
		
		return c;
	}
}
