/** 
 * modVars.java
 *
 * Title:			Arithmetic Expressions and Math Class
 * Description:		working with variables and the Java Math API
 * @author			DAVE
 * @version			
 */
 
 /*  OUTPUT FOR ARITHMETIC OPERATIONS:
 
	INTEGER MATH a = 25 b = 10 c = 20 d = 30 e = 0
	25
	31
	1500
	0
	25
	DOUBLE MATH a = 25.0 b = 10.0 c = 20.0 d = 30.0 e = .0
	40.0
	31.75
	1500.0
	0.058333333333333334
	25.0

 
 
 */

import javax.swing.JOptionPane;
import java.lang.Math;

public class modVars {
	public modVars() {
	}

	// Main entry point
	static public void main(String[] args) {
		new modVars();
	// LOCAL Primitave Double
		double yourGrade = 0.0;
		
		// create instance of the CalcIt class
		// LOCAL variable
		CalcIt myCalc = new CalcIt();
		
		//another way to display the results
		yourGrade = myCalc.calcAvg();	
		JOptionPane.showMessageDialog(null, "Your Average Grade is: "
			 + yourGrade , "RESULTS", JOptionPane.PLAIN_MESSAGE);
			 
		// TEST ARITHMETIC EXPRESSIONS
		System.out.println("INTEGER MATH a = 25 b = 10 c = 20 d = 30 e = 0");
		myCalc.modInts(25, 10, 20, 30);
		
		System.out.println("DOUBLE MATH a = 25.0 b = 10.0 c = 20.0 d = 30.0 e = .0");
		myCalc.modDoubles(25.0, 10.0, 20.0, 30.0 );
		
		
		// USE MATH CLASS
		myCalc.useMath();
		
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
			grade1 = 0.0;
			grade2 = 0.0;
			grade3 = 0.0;
			grade4 = 0.0;
			grade5 = 0.0;
		}
	
	// public method of the class "CalcIt"
		public double calcAvg()
		{
			double avg = 0.0;
			String input;
			
			input = JOptionPane.showInputDialog("Enter First Grade: ");
			grade1 = Integer.parseInt(input);
								
			input = JOptionPane.showInputDialog("Enter Second Grade: ");
			grade2 = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Enter Third Grade: ");
			grade3 = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Enter Fourth Grade: ");
			grade4 = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Enter Fifth Grade: ");
			grade5 = Integer.parseInt(input);
			
			
			avg = (grade1 + grade2 + grade3 + grade4 + grade5) / 
					numGrades;
					
			return avg;
		}
		
		public void modInts(int a, int b, int c, int d)
		{
			int e = 0; // compile error if not initialized
			System.out.println(a + b / c * d);  // 25
			System.out.println((a + b) / c + d);  // 25
			System.out.println(a * (c / b) * d);  // 25
			System.out.println((a + b) / (c * d));  // 25
			System.out.println(e + a);  // 25
			// System.out.println(e + A);  UNDEFINED VAR A -- compile
			//								error
			return;
		}
		
		public void modDoubles(double a, double b, double c,double d)
		{
			double e = 0; // compile error if not initialized
			System.out.println(a + b / c * d);  // 25
			System.out.println((a + b) / c + d);  // 25
			System.out.println(a * (c / b) * d);  // 25
			System.out.println((a + b) / (c * d));  // 25
			System.out.println(e + a);  // 25
			// System.out.println(e + A);  UNDEFINED VAR A -- compile
			//								error
			return;
		}
		
		public void useMath()
		{
			double a = 81, answer = 0.0;
			int b = 50, c = 67;
			
			
			System.out.println("NOW ILLUSTRATING Math Methods: "); 
			
			// LOG
			answer = Math.log(a);
			System.out.println("Log " + answer); 
			
			// Square Root
			answer = Math.sqrt(a);
			System.out.println("Sqr " + answer); 
			
			// Power
			answer = Math.pow(10, 2);
			System.out.println("Pwr " + answer); 
			
			//Sin
			answer = Math.sin(90);
			System.out.println("Sin " + answer); 
			
			//absolute value
			answer = Math.abs(-67);
			System.out.println("Abs " + answer); 
			
			//min
			answer = Math.min(b, c);
			System.out.println("Min " + answer); 
			
			//max
			answer = Math.max(b, c);
			System.out.println("Max " + answer); 
			
			return;
		}
	
	}
	
	
	
	

