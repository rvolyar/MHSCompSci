/** 
 * factorial.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */
// ANSWERS:
// 01 = 1
// 11 = 1
// 21 = 2
// 31 = 6
// 41 = 24
// 51 = 120
// 61 = 720
// 71 = 5040
// 81 = 40320
// 91 = 362880
// 101 = 3628800

public class factorial 
{
	public factorial() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new factorial();
		
	for(int i = 0; i <= 10; i++)
	{
	 System.out.println( " " + i + " " +  "1 = " + factorial(i) );
	}

	return ;
	}  // end of SPVM
	
	
	public static long factorial (long num)
	{
	if (num <= 1)  // base class
		return 1;
   	else
		return num * factorial (num -1);
	}
	
	
	
	
}  // end of Wrapper Class
