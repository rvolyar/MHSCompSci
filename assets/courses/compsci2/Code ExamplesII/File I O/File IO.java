/*
 * Main.java
 *
 * Created on May 10, 2006, 1:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fileio;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author David Farrell
 */
public class Main {
    public static void main(String[] args) throws IOException 
    {
        
        // Create an Instance of the File Class
        // java.io
        File file = new File("file.txt");
        
        // Create an Instance of the Scanner Class and ASSOCIATE it with the FILE
        // To read in the fields of the FILE
        // OPENS the FILE "file.txt"
        Scanner scanner = new Scanner(file);
    
        // 1.	read a file one line at a time
                
        while (scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }
       scanner.close();
   
       
       
        // 2.	read a file one word at a time
             
        scanner = new Scanner(file);
        
        scanner.useDelimiter(",");
        
         while (scanner.hasNext())
        {
            System.out.println(scanner.next());
        }
        scanner.close();
   
// 3.	write a new file     
        // Create an Instance of the PrintWriter Class to WRITE out an FILE
        
        file = new File("fileout.txt");
        
        PrintWriter pw = new PrintWriter(file);
       
        pw.println("NEW LINE FIRST IN OUT FILE");
        pw.println("NEW LINE SECOND IN OUT FILE");
        pw.println("20 40 56 45");
        pw.print("34,");
        pw.print("72,");
         
        pw.close();


 }
}
        
        
        
        
        
       
