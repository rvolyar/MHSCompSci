/** 
 * UsingArrays.java
 *
 * Title:			Illustrate Arrays
 * Description:		Declare, process, modify, pass to classes Arrays
 * @author			DAVE
 * @version			
 */

import java.util.Random;
import java.util.Arrays;

public class UsingArrays
{
	public UsingArrays()
	{
	
	}

	// Main entry point
	static public void main(String[] args)
	{
		new UsingArrays();
		
		int myint[] = {5,3,45,67,12,81,97, 109, 11, 6};  // this also instantiates "new"
		// myint = new int[10];
		// or we could do this:   int myint[] = new int[10];
		
		int RR;
		
		// create an array of number class so it actually may contain 
		// heterogeneous elements, like Int, double, etc... all derrived classes of Number
		Number[] nums = new Number[3]; //initial state is NULL
		Integer i = new Integer(34);
		Double d = new Double (45.55);
		Float f = new Float(3.14159);
		
		nums[0] = i;
		nums[1] = d;
		nums[2] = f;
		
		////
		// call junkarea
		int x[] = new int[10];
		x = junkArea(myint);
		System.out.println("length of x: " + x.length); // 20
		System.out.println("x[1] is: " + x[1]); 
		System.out.println("x[9] is: " + x[9]);
		
		String s = new String("21");
		Integer myNum; //= new Integer(Integer.valueOf(s));
		myNum = Integer.valueOf(s);
		System.out.println(myNum.toString());
		
		
		// change array passed "by reference"
		
		System.out.println("array x's first element BEFORE call: " +  x[0]);
		changeArray(x);
		System.out.println("array x's first element AFTER call: " +  x[0]);
		
		
		// test setting an element of an array of objects to null
		
		String s2[] = new String[5];
		s2[0] = "nelly";
		
		System.out.println("String Array BEFORE call: " +  s2[0].length());
		nullifyString(s2);
		System.out.println("String Array AFTER call: " +  s2[0].length());
		
		////
		
		/*
		
		// get the min value
		System.out.println("The lowest value is " + findmin(myint));
		
		// print out the elements of the Number array --- heterogeneous
		// THIS IS A FORM OF POLYMORPHISM AS EACH ELEMENT IN THE NUMBERS ARRAY'
		// ACTUALLY CONTAINS DIFFERENT SUBCLASSES
		System.out.println("The NUMBER array values are" + nums[0] + "  " + nums[1] + "  " + nums[2]);
		
		// Use the address class
		address myaddress = new address();
		myaddress.setdata(2223333, "John Doe", 1);
		System.out.println("The address for element 1 is: " + 	myaddress.getname(1) + " " + 
				myaddress.getnumber(1));
				
				
		// Use the justaddress class that mirrors a STRUCTURE
		
		justaddress[] myjust = new justaddress[5]; // inst to NULL
		myjust[0] = new justaddress(); // sets 1st element to type "justaddress"
		myjust[0].setname ( "John Jones");
		myjust[0].setnumber ( 4445555);
		
		System.out.println("The address for element 0 using justarray is: " + 	myjust[0].getname() + " " + 
				myjust[0].getnumber());
			
		*/
		System.exit(0);
		}
		
		////
		static int findmin( int[] x)
		{
			int min=999;
			
			for(int s=0; s < x.length; s++)
			{
				if (x[s] < min)
					min = x[s];
			}
		
			return min;
		}
		
		//////
		// junk area to test stuff
		static int[] junkArea(int z[])
		{
			final int ARRAY_SIZE = 10;
			int scores[]= new int[10];
			int c[];
			c = new int[ARRAY_SIZE];
			StringBuffer names[] = new StringBuffer[3];
						
			names[0] = new StringBuffer("Giants");
			names[1] = new StringBuffer("Chiefs");
			names[2] = new StringBuffer("Mets");
			
			// 2d array
			int rows = 2, cols = 3;
			String s1[][] = new String[rows][cols]; // an array or
							// matrix of 2 rows by 3 columns, init
							// to null
			double a1[][] =
			{
			 {0.0, 0.1,0.2},
			 {1.0, 1.1, 1.2}
			};
			
			// access 2d array
			System.out.print("First Row[R][C] (cols 0,1,2)" + 
				a1[0][0] + " "+  a1[0][1] + " "+ a1[0][2] + "\n");
			
			System.out.print("First Row[R][C] (cols 0,1,2)" + 
				a1[1][0] + " "+  a1[1][1] + " "+ a1[1][2] + "\n");
				
				
			System.out.println("Number of ROWS in Array " + 
				a1.length);
			System.out.println("Number of COLS in 1st Row of Array " + 
				a1[0].length);
				
						
			// import java.util.Random
			
			Random myRand = new Random();
				int rN = 0;
			for (int s = 0; s < c.length; s++)
				{
				  rN = myRand.nextInt() % 100;
			      c[s] = rN;
			     // System.out.println("c["+ s + "] is " + c[s]);
			    //  System.out.println("rN is " + rN);
				}

			System.out.println("c[1] is " + c[1]);
			System.out.println("c[9] is " + c[9]);
			
			// SORT c
			Arrays.sort(c); // ascending order
			// you can also specify a range to sort on 
			// by using overloaded sort methods
			// notice we do not instanciate Arrays class
			// because it is a static class
			System.out.println("AFTER SORT values... " );
			
			for(int d = 0; d < c.length; d++)
				{
				  System.out.println("c[" + d + "] is " + c[d]);
				}
			
			// passing an element of primitive array
			System.out.println("c[2] before call is " + c[2]);
			junkArea2(c[2]);
			System.out.println("c[2] after call is " + c[2]);
			
			// pass element of object
			System.out.println("names[0] before call is " + names[0]);
			junkArea2(names[0]);
			System.out.println("names[0] after call is " + names[0]);
			
			
			// increase array size
			int x[] = new int[c.length * 2];
			System.arraycopy(c, 0 , x, 0 , c.length);
			//c = x; // reset orig with larger array

			
			return c;
		}
		
		
		static void junkArea2(int a)
		{
			a += 21;
		
			return;
		}
		
		static void junkArea2(StringBuffer a)
		{
			
			a.append(" RULE !!!");
			return;
		}
		
		
		static void changeArray(int a[])
		{
		
			a[0] = 999;
		
		}
		
		// test changing an array element to null
		static void nullifyString(String s[])
		{
			s[0] = null;
		}
		
		
		
		//////
		
		
	}
	// You could create a class of only the int and string variable
	// then create an array of this class
	public class address
	{
		private int[] number ;
		private String[] name;
		
		public address()  // constructor to instantiate the arrays
		{
		name = new String[5];
		number = new int[5];
		}
		
		public void setdata(int p, String n, int ele)
		{
			number[ele] = p;
			name[ele] = n;
		}
		
		public int getnumber(int e)
		{
			return number[e];
		}
		
		public String getname(int e)
		{
			return name[e];
		}
		
	}  // end of address class


	// This clas uses a SRUCTURE like approach to store just one instance 
	// of an address, names and numbers.
	// We will create an ARRAY of this class in the PSVM
	public class justaddress
	{
		private int number ;
		private String name;
		
		public int getnumber()
		{
			return number;
		}
		
		public String getname()
		{
			return name;
		}
		public void setnumber(int x)
		{
			number = x;
		}
			
		public void setname(String s)
		{
			name = s;
		}

	} // end of justaddress class