/** 
 * BSTClass.java
 *
 * Description: 
 * @author                      David Farrell
 * @version                     
 */

import hsa.TreeUtil;
public class BSTClass 
{
	public BSTClass() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new BSTClass();
		
		// CREATE
		BST myTree = new BST("Ellis");
		
		// INSERT
		myTree.InsertNode("Sammy");
		myTree.InsertNode("Abe");
		myTree.InsertNode("Christian");
		myTree.InsertNode("Ian");
		myTree.InsertNode("John");    // test no children, comment out John
		myTree.InsertNode("Toby");   // do to test removal of a node with 2 children ALSO REMOVE "SAMMY"
		
		// TRAVERSE
		myTree.setTypeTraversal("INORDER");
		
		String nodeList = myTree.toString();
		System.out.println(nodeList);
		
		TreeNode root = myTree.getRoot();
		TreeUtil.displayTreeInWindow (root);
		
		// SEARCH
		String res = (String)myTree.find("Abe");
		if (res == null)
		    System.out.println("String NOT Found");
		   else
		    System.out.println("String IS Found");
		    
		
		// REMOVE
		boolean b = myTree.removeNode("Ellis");  // test 1 and no children with "Ian"
		System.out.println("NODE REMOVAL RETURNED "+ b);
		TreeUtil.displayTreeInWindow (root);
		nodeList = myTree.toString();
		System.out.println(nodeList);
		
		/*
		b = myTree.removeNode("John");  // change to a no existant node to test failed remove
		System.out.println("NODE REMOVAL RETURNED "+ b);
		TreeUtil.displayTreeInWindow (root);
		nodeList = myTree.toString();
		System.out.println(nodeList);
		*/
	}
	
}