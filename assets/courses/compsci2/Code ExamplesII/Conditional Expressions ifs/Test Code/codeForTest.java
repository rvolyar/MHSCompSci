/** 
 * codeForTest.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


public class codeForTest
{
	public codeForTest()
	{
	}

	// Main entry point
	static public void main(String[] args)
	{
		new codeForTest();
		
		ifConds();
		
		String ans;
		
		ans = getState("GREEN");
		System.out.println(ans);
		
		ans = getState(1);
		System.out.println(ans);
		
		
		
	} // END OF SPVM
	
	public static void ifConds()
	{
		int a=22, b=45,c=67;
		String s = "Nancy";
	
		if(a * 2 > b || !(s == "nancy"))
		{
			System.out.println("Condition is True");
		}
		 else
		{
			System.out.println("Condition is False");
		}
	
	
		if (a > 50 && b++ > 12)
		{
			System.out.println(b++);
		}
		 else
		{
			System.out.println(b);
		}
			
	
		if(c == a)
			c++;
			
		if (s == "Nancy")
			System.out.println("s equals Nancy");
	
	
		a = 44;
		if(a++ >= b || --c == 66)
		{
			System.out.println("Condition is True");
		}
		 else
		{
			System.out.println("Condition is False");
		}
	}
	
	public static String getState(String streetLight)
	{
		/*switch (streetLight)
			{
			case "YELLOW"
				return "SLOW DOWN";
				
			case "GREEN"
				return "GO FOR IT";
			}
		return "STOP"; */
	
		if(streetLight == "GREEN")
			return "GO FOR IT";
		  else
	  	return " SLOW DOWN";
	}
	
	public static String getState(int streetLight)
	{
		switch (streetLight)
			{
			case 1:
				return "SLOW DOWN";
				
			case 2:
				return "GO FOR IT";
			}
		return "STOP";
	
		
	}
	
} // END OF WRAPPER CLASS

