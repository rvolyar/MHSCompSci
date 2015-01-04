/** 
 * PassingAnObjrectExample.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


public class PassingAnObjrectExample 
{
	public PassingAnObjrectExample() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new PassingAnObjrectExample();
		
		// String myString = new String();
		// myString = "Hello ";
		String myString = new String("Hello");

		changeString(myString);

		System.out.println(myString);
		
		
		// EXAMPLE of passing a copy of an objects reference 
		// note how the called function Mutates the original
		
		date myDate = new date();
		System.out.println(myDate.toString());
		System.out.println("and now the same instancce AFTER the function call...");
		changeDate(myDate);
		System.out.println(myDate.toString());
		
		// return an object reference
		date newDate = new date(returnReference());
		System.out.println(newDate); // implicit call to the date
									// class'es toString() method
									
		// play around with == versus .equals method when working with objects
		//Integer i = new Integer(21);
		//Integer y = new Integer(21);
		String i = new String("21");
		String y = new String("21");
		
		// compares REFERENCES
		if (i == y)
			System.out.println("The Integers are EQUAL !!!");
		   else
		   	System.out.println("The Integers are NOT EQUAL !!!");
		
		// compares STATE   	
	 	if (i.equals(y))
			System.out.println("The Integers are EQUAL !!!");
		   else
		   	System.out.println("The Integers are NOT EQUAL !!!");
		
		i = y;
		if (i == y)
			System.out.println("The Integers are EQUAL !!!");
		   else
		   	System.out.println("The Integers are NOT EQUAL !!!");
				

	}
	
	static public void changeDate(date d)
	{
		d.setYear(2003);
		
		// now assign to a new date object and make a change
		// since d will now refer to a different object
		// any changes made to d will NOT BE REFLECTED in the 
		// original reference (in SPVM)
		
		date localDate = new date(12,31,2001);
		
		d = localDate;
		
		System.out.println("local date var d After reassigned " + 
			localDate.toString());
			
			
		return;
	}
	
	static public date returnReference()
	{
		date localDate = new date(04,15,2002);
	
		return localDate;
		
	}


	static public void changeString(String s)
	{
	  s += " World";
      System.out.println(s);
      
      // however, because objects' references are passed by value
      // if we were to change the reference of the object variable
      // this change IS NOT REFLECTED in the called instance object
      // as the reference s is a COPY of the original, and when 
      // we say s += " World"  WE ARE ACTUALLY doing s = s + " World"
      // in so doing the RVALUE uses the initial state of s, Hello, and
      // adds  World to a temporary reference
      // when the assignment, = , is made the reference s is overwritten
      // to point to a new string reference
      // because of this, the reference to s as was initially passed in as
      // as argument is NO LONGER pointing to the original.  the original remains
      // unchanged.  This is because the String is IMMUTABLE !!!
      s = new String("xyz");
       System.out.println(s);

	 return;
	}
}