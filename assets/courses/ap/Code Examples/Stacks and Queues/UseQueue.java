/*
 * Main.java
 *
 * Created on January 1, 2007, 3:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package usequeue;
import java.util.LinkedList;


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
        LinkedList<Integer> r = new LinkedList<Integer>();
        
        
        r.add(32);
        r.add(64);
        r.add(128);
        
        
        for(Integer x:r)
        {
            System.out.println(x.toString());
        }
     
       r.remove();
       
       System.out.println( r.isEmpty());
            
        System.out.println( r.peek());
        
      
        
        
    }
    
}
