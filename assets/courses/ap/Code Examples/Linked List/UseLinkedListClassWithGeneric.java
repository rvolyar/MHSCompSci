/*
 * Main.java
 *
 * Created on December 3, 2006, 1:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package listnodegeneric;
/**
 *
 * @author Dave
 */
public class Main
{


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {


        // 1. ADD NODES TO THE BEGINNING OF THE LIST

		// create a linked list &  put the nodes into a list

		// head node
		ListNode head = null;
		// TempExample<Integer> i = new TempExample<Integer>(21);
		// create a new node
		ListNode<Integer> node = new ListNode<Integer>(12);
             //  ListNode<AirFlight> node = new ListNode<AirFlight>("Chicago", 860); // A

		// set head to point to first element in the link
		head = node;

                // print the head node
		System.out.println("The first Node is " + (head.getValue()).toString());
		System.out.println();

                // add a node to the list using the setnext method
		// this will be the second node in the list
		head.setNext(new ListNode<Integer>(34));

                // add new nodes to the BEGINNING OF THE LIST
                ListNode<Integer> t = new ListNode<Integer>(65);
                t.setNext(head);
		head = t;

                System.out.println("The New first Node is " + (head.getValue()).toString());
		System.out.println();

             // 2. TRAVERSE THE LIST

		// Traverse List
		System.out.println();
		System.out.println("Print the list BEFORE the  FIRST node is REMOVED s/b 65 12 34");

		// CANT USE FOR EACH LOOP AS OUT LISTNODE DOES NOT UTILIZE ITERATOR OR
                // LISTITERATOR
                Integer b;
                for (node = head; node != null ; node = node.getNext())
		{
			b = node.getValue();
			System.out.println(b.toString());
		}


                // 4A.  REMOVE A NODE FROM THE BEGINNING OF THE LIST
		head = head.getNext();

                // Traverse List
		System.out.println();
		System.out.println("Print the list BEFORE the  FIRST node is REMOVED s/b 12 34");

                for (node = head; node != null ; node = node.getNext())
		{
			b = node.getValue();
			System.out.println(b.toString());
		}


                }

    }

