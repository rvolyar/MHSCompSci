public class myNumber extends Number
{
	private int x;
	
	public myNumber(int a)
	{
		x = a;
	}
	
	public double doubleValue()
	{
	
		return (double)x;
	}
	
	public int intValue()
	{
	
		return x;
	}
	
	public float floatValue()
	{
	
		return (float)x;
	}
	
	public long longValue()
	{
	
		return (long)x;
	}
	
	public String toString()
	{
		return "This is myNumber " + x;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


}
