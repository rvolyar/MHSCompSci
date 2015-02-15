/*
 * Main.java
 *
 * Created on October 3, 2006, 9:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package generics;
import java.util.ArrayList;

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
        
        // use geneericly declared comparable from Gener user defined class
        Gener g1 = new Gener();
        Gener g2 = new Gener(55);
        Gener g3 = new Gener(34);
        
        if(g1.compareTo(g2) > 0)
            System.out.println(g1 + " is bigger");
        else
             System.out.println(g2 + " is bigger");
        
        
        // use generic arraylist
        // MUST identify the TYPE of class being used
        ArrayList<Gener> myList;
        myList = new ArrayList<Gener>();
        
        myList.add(g1);
        myList.add(g2);
        myList.add(g3);
        
        // USE new for each loop
        // Note you are iterating thru elements of Gener without casting
        for(Gener g : myList)
        {
            System.out.println(g.toString());
        }
        
        // NON Generic Traversal
        ArrayList a;
        a = new ArrayList();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        
        for(Object x: a)
        {
            System.out.println(x.toString());
        }
        
        // OLD loop & NON Generic Arraylist
        // Therefore you MUST cast 
        for(int s=0;s< a.size();s++)
        {
            //Gener f = a.get(s);  --- YIELDS and incompatable TYPE message
            Gener f = (Gener)a.get(s);
            System.out.println(f.toString());
        }
         // USE TEMPLATED CLASS
	        
	        TempExample<Integer> i = new TempExample<Integer>(21);
	        
	        System.out.println(i.toString());
        
    }
    
}
