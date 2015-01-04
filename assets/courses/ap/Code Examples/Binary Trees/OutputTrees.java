// The "OutputTrees" class.
import hsa.TreeUtil;

public class OutputTrees
{
    private static void inOrder (TreeNode node)
    {
	if (node != null)
	{
	    inOrder (node.getLeft ());
	    System.out.print (node.getValue () + " ");
	    inOrder (node.getRight ());
	}
    } // inOrder method


    private static void preOrder (TreeNode node)
    {
	if (node != null)
	{
	    System.out.print (node.getValue () + " ");
	    preOrder (node.getLeft ());
	    preOrder (node.getRight ());
	}
    } // preOrder method


    private static void postOrder (TreeNode node)
    {
	if (node != null)
	{
	    postOrder (node.getLeft ());
	    postOrder (node.getRight ());
	    System.out.print (node.getValue () + " ");
	}
    } // postOrder method


    public static void main (String[] args)
    {
	TreeNode root;

	root = (TreeNode) TreeUtil.createBalancedLetterTree (15);

	TreeUtil.displayTreeInWindow (root, "Tree",24);

	System.out.print ("In Order: ");
	inOrder (root);
	System.out.println ();

	System.out.print ("Pre Order: ");
	preOrder (root);
	System.out.println ();

	System.out.print ("Post Order: ");
	postOrder (root);
	System.out.println ();
    } // main method
} // OutputTrees class
