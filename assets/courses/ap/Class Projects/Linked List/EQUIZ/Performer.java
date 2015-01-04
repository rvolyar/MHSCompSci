/*
 * Performer.java
 *
 * Created on December 11, 2006, 9:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package linkedlist_equiz;

/**
 *
 * @author Dave
 */
public abstract class Performer {
    
    private String name, type;
    private int ID;
    /** Creates a new instance of Performer */
    public Performer() 
    {
        name = "Sally";
        ID = 111;
        type = "";
    }
     public Performer(String n, int i, String t)
    {
     name = n;
     ID = i;
     type = t;
    }
     
     public String getName()
     {
         return name;
     }
      public int getID()
     {
         return ID;
      }
         public String getType()
     {
         return type;
     }
     
    abstract public double calcRate(); 
    
    public String toString()
    {
        return name;
    }
    
    
}
