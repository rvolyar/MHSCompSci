/** 
 * Loops.java
 *
 * Title:			Loops Static functions and Classes
 * Description:		Illustrate the use of iterative statements.
   					Writing static functions.
   					Writing classes.
 * @author			DAVE
 * @version			1.0	
 
 	CALC GOLF SCORE (base 71) for X number of games played
 		also calc over/under par score
 		
 		SAMPLE RUN:  4 rounds of 73 73 73 69 AVG = 72  OVER PAR 4
 		
 */



package usingloops;
import javax.swing.JOptionPane;
import java.lang.Math;
/**
 *
 * @author Dave
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() 
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String input;
		int  numGames = 0, overUnderPar = 0;
		int avgScore;
		
		
		input = JOptionPane.showInputDialog("Enter Number of Rounds Played: ");
		numGames = Integer.parseInt(input);
	
		// call various iterative functions to calc golf score
		avgScore = whileLoop(numGames);
		
		// Display results
		input = "Your Average Score Was " + avgScore;
		JOptionPane.showMessageDialog(null , input, "GOLF RESULTS",
			JOptionPane.INFORMATION_MESSAGE);
		
		
		// get over / under par score
		overUnderPar = forLoop(numGames , avgScore);
		if (overUnderPar < 0)
			{
				overUnderPar = Math.abs(overUnderPar);
				input = "You Were UNDER PAR " + overUnderPar;
			}
			 else if (overUnderPar > 0)
			{
				overUnderPar = Math.abs(overUnderPar);
				input = "You Were OVER PAR " + overUnderPar;
			}
			 else
			 {
				input = "You Were AT PAR ";
			 }
		
		//  Display Results
		JOptionPane.showMessageDialog(null , input, "GOLF RESULTS",
			JOptionPane.INFORMATION_MESSAGE);
			
		// STUDENTS CODE IN CLASS EXERCISE TPS
		// call doWhileLoop
		
			
		
		// call sumIt
		int s = sumIt(9);
		System.out.println(s);
                
                // CALL THE FOR EACH LOOP EXAMPLE 
                String[] ss;
                ss = new String[5];
                ss[0] = new String("Adam");
                ss[1] = new String("Bob"); 
                ss[2] = new String("Joe");
                ss[3] = new String("Sally");
                ss[4] = new String("Casey");
                
                forEachLoop(ss);
		
		System.exit(0);
	}
	
	// calculates average round score using while loop
	static int whileLoop(int numTimes)
	{
		int result = 0, oneScore = 0, ctr = numTimes;
		String input;
	
		while(ctr > 0)
		{
			input = JOptionPane.showInputDialog("Enter Score for Round: " + (numTimes - ctr + 1));
			oneScore = Integer.parseInt(input);
			result += oneScore;
			ctr--;
		}
	
		return result / numTimes;
	}
	
	
	// calculates average round score using for loop
	// STUDENTS CODE IN CLASS EXERCISE TPS
	static int doWhileLoop(int numTimes)
	{
		int result = 0, oneScore = 0;
	
	
	
		return result;
	}
	
	// calculates the over/under par score
	static int forLoop(int numTimes, int avg) // notice arg names
							// are different than var names in SPVM
	{
		int result = 0; // notice local var same name in 
						// each function with different data type
						// can do as each is LOCAL to that function
		int baseScore = 71;
	
		// declare a var local to for loop !!!
		for(int sub = 0; sub < numTimes; sub++)
		{
			result += (avg - baseScore);
		}
	
		return result;
	}
	
	// sum every third number from 1 to n
	// display numbers in sets of 5 on a line
	static int sumIt(int i)
	{
		int sum=0, x=1, line=0;
		String lineOut = new String();
		
		while(x <= i)
		{
			if (x % 3 == 0)
				{
					sum+= x;
					line++;
					lineOut += " " + x;
				}
			x++;
		}
		System.out.println(	lineOut);			
		return sum;
	}
        
        static void forEachLoop(String[] s)
        {
         // USE the FOR EACH approach to iterate over each element in the 
         // string Array
            for(String x : s)
            {
             System.out.println(x);   
                
            }
            
            // ITERATE OVER PRIMITIVE ARRAY
             int[] a = {5,8,14,34,67,72};
         
             for(int x : a)
             {
              System.out.println(x);   
             }
         }
            
            
        }

 
    

