/*
 * Clown.java
 *
 * Created on December 11, 2006, 9:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package linkedlist_equiz;
/**
 *
 * @author Dave
 */
public class Clown extends Performer
{
    private String ClownType = "Trainee";
    
    /** Creates a new instance of Clown */
    public Clown(String n, int x, String t, String ct) 
    {
        super(n,x,t);
        ClownType = ct;
    }
    public Clown()
    {
        
    }
    
    public String getCLownType()
    {
        return ClownType;
    }
     public String toString()
    {
        return super.toString() + " " + ClownType;
    }
     
      public double calcRate()
      {
          double rate=0.0;
          if(ClownType.equals("Trainee"))
              rate = 25.25;
           if(ClownType.equals("Level 1"))
              rate = 35.50;
           if(ClownType.equals("Level 2"))
              rate = 67.35;
           if(ClownType.equals("Level 3"))
              rate = 81.23;
          if(ClownType.equals("Expert"))
              rate = 101.25;
          
          return rate;
      }
}
