/** 
 * ExceptionHandlingDemo.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */

import ExHand;

public class ExceptionHandlingDemo 
{
	public ExceptionHandlingDemo() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new ExceptionHandlingDemo();
		
		System.out.println ("Area is " + ExHand.findArea (3));
		System.out.println ("Area is " + ExHand.findArea (- 3));

	try  // The try/catch is required because the code can 
		 // throw a "checked" exception
	{
	    System.out.println ("Area is " + ExHand.findAreaChecked (3));
	    System.out.println ("Area is " + ExHand.findAreaChecked (- 3));
	    ExHand.useFindAreaChecked ();
	}
	catch (Exception e)
	{
	    System.out.println (e);
	}
	}
	
}




/**
 *  The "ExceptionHandlingDemo" class.
 */
public class ExHand
{
    //-------------------------------------------------------------------
    public static double findArea (double r)
    {
	if (r < 0)
	    throw new IllegalArgumentException ("Bad radius value");
	else
	    return Math.PI * r * r;
    }


    //-------------------------------------------------------------------
    public static double findAreaChecked (double r)
	throws Exception  // this is required because it can throw a "checked" exception
    {
	if (r < 0)
	    throw new Exception ("Bad radius value");
	else
	    return Math.PI * r * r;
    }


    //-------------------------------------------------------------------
    public static void useFindAreaChecked () throws Exception
    {
	// try-catch is optional - we just pass exceptions up to the caller.
	double x = findAreaChecked (- 4);
    }
}