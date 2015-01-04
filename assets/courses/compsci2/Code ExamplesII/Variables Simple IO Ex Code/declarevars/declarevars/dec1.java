/** 
 * dec1.java
 *
 * Title:			variables and simple IO
 * Description:		this application is used as examples for the lecture on declaring variables 
and simple I/O
 * @author			DAVE
 * @version			1.0
 
 OUTOUT:
 	Your Grade Average Is: 91.4
	
 */

package declarevars;

import javax.swing.JOptionPane;


// WRAPPER CLASS USED TO RUN SPVM
public class dec1  // class name should be "Dec1"
{
	public dec1()  // class constructor
	{
	
	}
	
	
	// Main entry point SPVM
	// static methods can not call non-static methods
	static public void main(String[] args) 
	{
		new dec1();  // calls the class constructor
		
		// LOCAL Primitave Double
		double yourGrade = 0.0;
		
		// create instance of the CalcIt class
		// LOCAL variable
		CalcIt myCalc = new CalcIt();
		// myCalc.grade1 = 23.0; --- wont run cause grade1 is private
		
		// one way to display the results
		System.out.print("\nYour Grade Average Is:\t " + myCalc.calcAvg()+ "\n");
		
		//another way to display the results
		yourGrade = myCalc.calcAvg();	
		JOptionPane.showMessageDialog(null, "Your Average Grade is: "
			 + yourGrade , "RESULTS", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
	}
}	
	
	// NEW CLASS USED TO CALCULAE THE AVERAGE GRADE
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
				double grade1=0;
				grade1 = 10.0 * (double)x;
				x--;
				System.out.println(grade1);	
				
			}
			System.out.println(grade1);	
			avg = (grade1 + grade2 + grade3 + grade4 + grade5) / 
					numGrades;
					
			return avg;
		}
	
	}
	
	
	
	

