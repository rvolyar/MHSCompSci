/** 
 * Application1.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


public class TestInvestment 
{
	public TestInvestment() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new TestInvestment();
	
	
	Investment I[] = new Investment[3];
	
	
	I[0] = new CD("Casey", "973-555-3434","111-22-3333",21,1000.0,8.5,90);
	I[1] = new MutualFund("John", "973-555-3434","111-22-3333",21,1000.0,10.50);	
	I[2] = new CD("Farrell", "973-555-3434","111-22-3333",21,1000.0,6.5,90);
	
	I[0].calcValue();
	I[1].calcValue();
	I[2].calcValue();
	
	
	if(I[0].compareTo(I[2]) > 0)
		{
		System.out.println(I[0].getName() + " Has More Invested");
		System.out.println(I[0].toString());
		}
		else
		{
		System.out.println(I[1].getName() + " Has More Invested");
		System.out.println(I[1].toString());
		}
	
	if(I[2].compareTo(I[1]) > 0)
		{
		System.out.println(I[2].getName() + " Has More Invested");
		System.out.println(I[2].toString());
		}
		else
		{
		System.out.println(I[1].getName() + " Has More Invested");
		System.out.println(I[1].toString());
		}
	
	// Print Details of the Mutual Fund
	System.out.println(I[1].getName() + " " + I[1].getSsn() + " " +
		I[1].getValue());
	
	}
}
