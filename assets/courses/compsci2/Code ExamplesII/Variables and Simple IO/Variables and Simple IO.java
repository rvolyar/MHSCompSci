/*
 * Main.java
 *
 * Created on May 24, 2006, 1:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package variablesandsimpleio;
import java.util.Scanner;
import javax.swing.JOptionPane; 
/**
 *  RUN THE APPLICATION BY RIGHT MOUSE AND SELECT RUN ON THE MAIN.JAVA FILE
 *
 * THIS SAMPLE APPLICATION DISPLAYS HOW TO USE THE SCANNER CLASS TO
 *  READ IN VARIABLE INFORMATION FROM THE USER --- CONSOLE.  TO GET
 *  THIS TO RUN, READ THE OUTPUT IN THE BOTTOM OF THE OUTPUT DISPLAY AND 
 *  ENTER THE INFORMATION IN THE INPUT FIELD.
 *
 *  THE SECOND PART OF THE APPLICATION USES JAVAS JOPTIONPANE CLASS.
 *  THIS PROVIDES AN INPUITBOX TO ENTER THE DATA
 * 
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        
        String name;
        int age;
        double iq;
        
        System.out.println("enter your name");
        name = reader.nextLine();
        
        System.out.println("enter your age");
        age = reader.nextInt();
        
         System.out.println("enter your iq");
        iq = reader.nextDouble();
        
        System.out.println("You Entered " + name + " age is " + age + " with an IQ of " + iq);
        
        
        useJOP();
        
        
    }
    
    // I / O Using JOptionPane
	static void useJOP()
	{
		String name1, name2, name3;
		
		name1 = JOptionPane.showInputDialog("Enter first name: ");
		name2 = JOptionPane.showInputDialog("Enter middle name: ");
		name3 = JOptionPane.showInputDialog("Enter last name: ");
		
		JOptionPane.showMessageDialog(null, 
			"Your Full Name is " + name1 + " " 
			+ name2 + " " + name3, "RESULTS", JOptionPane.PLAIN_MESSAGE);
			
		return;
	}
    
}
