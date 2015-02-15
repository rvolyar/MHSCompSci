/** 
 * theBigE.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */

import java.util.Random;

public class theBigE 
{
	public theBigE() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new theBigE();
		
		long seed = System.currentTimeMillis(); 
		//Random myRandom = new Random(seed);
		Random myRandom = new Random();
		
		double rNum;
		int rInt, total = 0, numFracs=0, sumFracs=0;
		final int RUNS = 100000000;
		
		for(int runs = 1; runs <= RUNS; runs++)
		{
			for(total = 0, numFracs=0; total <= 10; numFracs++)
			{
				// random returns a fraction
				//rNum = Math.random();
				// converts fraction to a whole number
				//rInt = (int)(rNum * 10);
				
				rInt = myRandom.nextInt(11);
				
				total += rInt;
			}
			sumFracs += numFracs;
		
		
		}
		
		System.out.println((double)sumFracs / RUNS);
		System.out.println(Math.E);
		
		
		
		
		
	}
	
}
