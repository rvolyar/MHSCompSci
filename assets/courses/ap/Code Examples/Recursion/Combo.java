/** 
 * Combo.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */

//1 --- in function with amoumt/value = 4  3
//2 --- in function with amoumt/value = 4  2
//3 --- in function with amoumt/value = 4  1
//4 --- in function with amoumt/value = 4  0
//5 --- in function with amoumt/value = 3  1
//6 --- in function with amoumt/value = 3  0
//7 --- in function with amoumt/value = 2  1
//8 --- in function with amoumt/value = 2  0
//9 --- in function with amoumt/value = 1  1
//10 --- in function with amoumt/value = 1  0
//11 --- in function with amoumt/value = 0  1
//12 --- in function with amoumt/value = 2  2
//13 --- in function with amoumt/value = 2  1
//14 --- in function with amoumt/value = 2  0
//15 --- in function with amoumt/value = 1  1
//16 --- in function with amoumt/value = 1  0
//17 --- in function with amoumt/value = 0  1
//18 --- in function with amoumt/value = 0  2
//19 --- in function with amoumt/value = 1  3
//20 --- in function with amoumt/value = 1  2
//21 --- in function with amoumt/value = 1  1
//22 --- in function with amoumt/value = 1  0
//23 --- in function with amoumt/value = 0  1
//24 --- in function with amoumt/value = -1  2
//25 --- in function with amoumt/value = -2  3
//4

public class Combo 
{
	public Combo() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new Combo();
		
		
		System.out.println(COMBO(4,3));
		
		System.exit(0);
	} // end of SPVM
	
static int a=1;

 static int COMBO(int amount,int value)
 {
	
	System.out.println( a++ + " --- in function with amoumt/value = " +
		 amount + "  " + value);
	
	if ((amount < 0) || (value == 0))
		{
		return(0);
		}
	else 
	{
	if (amount == 0)
		{
		return( 1);
		}
	else
		{
		return( COMBO(amount,value - 1) + COMBO(amount - value,value));
		}
   }
}
	
}  // end of wrapper class
