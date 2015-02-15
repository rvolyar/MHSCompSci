/*
 * CalcIt.java
 *
 * Created on August 18, 2006, 1:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package declarevariables;

/**
 *
 * @author Dave
 */
// NEW CLASS USED TO CALCULATE THE AVERAGE GRADE
public class CalcIt
{
		// variables available only to class "CalcIt"
		private final int numGrades;
		private double grade1;
		private double grade2;
		private double grade3;
		private double grade4;
		private double grade5;

	// class constructor called when an Instance of a class
	// is created
		public CalcIt()
		{
			// set the initial values of the grades
			numGrades = 5;
			grade1 = 90.0;
			grade2 = 97.0;
			grade3 = 98.0;
			grade4 = 80.0;
			grade5 = 92.0;
		}
	
	// public method of the class "CalcIt"
		public double calcAvg()
		{
			double avg = 0; // local variable to this
			int x = 5;				// method
							
			
			// Example of declaring a local variable
			// with the same name "grade1"
			// local variable's scope is in the while
			// loop ONLY
			
			// If we were to move the declaraion outside the
			// while loop, then the scope of the local
			// variable is FOR THE ENTIRE method.  In THIS
			// case the local grade1's value is used in the
			// grade calculation resulting in a lower AVERAGE		
			while (x > 0)
			{
						//	double grade1=0;

				grade1 = 10.0 * (double)x;
				x--;
				System.out.println("value in loop " + grade1);	
				
			}
			
			System.out.println(grade1);	
			avg = (grade1 + grade2 + grade3 + grade4 + grade5) / 
					numGrades;
					
			return avg;
		}
	
    
}
