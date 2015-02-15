/** 
 * sampleCode.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


public class sampleCode {
	public sampleCode() {
	}

	// Main entry point
	static public void main(String[] args)
	{
		new sampleCode();
		
		
		
		// this code wont even compile
		/*int a[] = new int[20];
	
		a[0] = 10;
		a[1] = 4.5;
		a[2] = (long)4;   */
		
		//double d = 23.3;
		//int a = d;
		
		// create an array of number class so it actually may contain 
		// heterogeneous elements, like Int, double, etc... all derrived classes of Number
		Number[] nums = new Number[3]; //initial state is NULL
		Integer i = new Integer(34);
		Double d = new Double (45.55);
		Float f = new Float(3.14159);
		
		nums[0] = i;
		nums[1] = d;
		nums[2] = f;
		
		System.out.println(nums[0].toString() + " " + nums[2].toString());
		System.out.println(nums[1].intValue() + " " + nums[2].intValue());
		
		
		String s = new String("21.77");
		Number myNum; 
		myNum = Double.valueOf(s);             
		System.out.println(myNum.intValue());
		
		
		// attempt to create instance of abstract Number class
		// ERROR abstract class can not be instantiated
		
		//Number n = new Number();
		
		
		// use abstract and inherited class
		rectangle myrect = new rectangle();
		rectangle myr2 = new rectangle(5,5);
		
		
		// call overloaded calcArea that calcs area of passed shape
		// the passed shape's area is actually calcd --- see the
		// rectangle class for reason why
		double ad = myrect.calcArea(myr2);
		System.out.println("Area of passed Shape is " + ad);
		
		myrect.calcArea();
		System.out.println("Area of local Shape is " + myrect.getArea());
		
		// notice area of myr2 is calcd although we never
		// explicitly called the calaArea method 
		System.out.println(myr2);  // implicit toString() call
		System.out.println(myrect.toString());  // explicit toString() call
	}
	
}


// abstract class

public abstract class shape extends Object
{
	protected double area;
	protected int length, width;
	public shape()
	{
	}
	
	// 2 abstract calArea methods 
	abstract double calcArea(Object o);  // calc area of passed shape
	abstract double calcArea();  // calc area of "this" shape
	
	public void setLength(int l)
	{
		length = l;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public double getArea()
	{
		return area;
	}
	
	
	public String toString()
	{
		return "Abstract class shapes toString method called";
	}
}


// inherit from shape
public class rectangle extends shape
{
	
	public rectangle()
	{
		setLength(10);
		setWidth(10);
	}
	public rectangle(int l, int w)
	{
		setLength(l);
		setWidth(w);
	}
	
	
	// this method actually mutates as the local assignment
	// copies the reference of passed object so any changes are 
	// reflected in passed object
	public double calcArea(Object o)
	{
		/*  THE FOLLOWING IS AN EXAMPLE OF USING INSTANCE OF
			TO GET THE AREA OF ANOTHER SHAPE */
		
		if (o instanceof rectangle) 
		{
	    rectangle anotherrect = (rectangle)o;
		//anotherrect = new rectangle(5,5);
		anotherrect.area = anotherrect.getLength() * 
			anotherrect.getWidth();
		return anotherrect.getArea();
		}
	
	
	return -1.0;
	}
	
	public double calcArea()
	{
		/*  THE FOLLOWING IS AN EXAMPLE OF USING INSTANCE OF
			TO GET THE AREA OF "THIS" SHAPE */
		
		// "this" is assumed and you don't need to use this.method
		this.area = this.getLength() * 
			this.getWidth();
			
		return getArea();
	}

	
	public String toString()
	{
		System.out.println(super.toString());  // call to parents method
		return Double.toString(getArea());;
	}

}