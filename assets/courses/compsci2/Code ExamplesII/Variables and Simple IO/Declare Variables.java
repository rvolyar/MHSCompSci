/*
 * Main.java
 *
 * Created on August 18, 2006, 1:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package declarevariables;
import javax.swing.JOptionPane;

/**
 *
 * @author Dave
 */
public class Main 
{
    
    /** Creates a new instance of Main */
    public Main() 
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
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
    }
}
    
   