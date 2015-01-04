/*
 * Main.java
 *
 * Created on January 1, 2007, 1:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package arraystack;
import java.util.Stack;

/**
 *
 * @author Dave
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
        
     //  USE MY STACK CLASS !!!!!   
        
      arrayStack<String> mS = new arrayStack<String>();
      //  arrayStack mS = new arrayStack();
        
        mS.push("Billy");
        mS.push("Joe");
        mS.push("Bob");
        mS.push("Sally");
        mS.push("Lucy");

        while(!mS.empty())
        {
            String s = mS.pop();
            System.out.println(s.toString());

        }
        mS.push("Billy");
        mS.push("Joe");
        mS.push("Bob");
        mS.push("Sally");
        mS.push("Lucy");

        System.out.println();
        
       String o = mS.pop( );
       System.out.println(o.toString());
        String s = mS.pop( );
        System.out.println(s.toString());
        String y = mS.peek( );  
        System.out.println(y.toString());
        boolean ee = mS.empty();
        System.out.println(ee);
        
        int c = mS.search("Joe");
        System.out.println();
        System.out.println("Joe Search " + c);
        
        // USE JAVAS STACK CLASS
        
        Stack<Integer> sI = new Stack<Integer>();
        
        sI.push(21);
        sI.push(42);  
        sI.push(84);  
        
        for(Integer i:sI)
        {
            System.out.println(i.toString());
        }
        
        sI.pop();
        
        System.out.println(sI.peek().toString());
        
        System.out.println(sI.empty());
        
        System.out.println(sI.search(21));
        
        
    }
    
}
