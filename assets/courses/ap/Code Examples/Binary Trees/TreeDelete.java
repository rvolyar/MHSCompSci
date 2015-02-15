// The "TreeDelete" class.
import hsa.Stdin;
import hsa.TreeUtil;

public class TreeDelete
{
    private final static int LEFT = 0;
    private final static int RIGHT = 1;

    private static TreeNode root;

    private static void delete (TreeNode parentNode, TreeNode node,
	    Comparable delItem, int direction)
    {
	if (node == null)
	{
	    System.out.println ("Unable to find node.");
	    return;
	}
	else if (delItem.compareTo (node.getValue ()) == 0)
	{
	    // We found the node.  Now delete it.
	    if (parentNode == null)
	    {
		root = remove (node);
	    }
	    else
	    {
		if (direction == LEFT)
		{
		    parentNode.setLeft (remove (node));
		}
		else
		{
		    parentNode.setRight (remove (node));
		}
	    }
	}
	else if (delItem.compareTo (node.getValue ()) < 0)
	{
	    // Search down the left subnode.
	    delete (node, node.getLeft (), delItem, LEFT);
	}
	else
	{
	    // Search down the right subnode.
	    delete (node, node.getRight (), delItem, RIGHT);
	}
    } // delete method


    private static TreeNode remove (TreeNode node)
    {
	if (node.getLeft () == null)
	{
	    return node.getRight ();
	}
	else if (node.getRight () == null)
	{
	    return node.getLeft ();
	}
	else
	{
	    TreeNode leftSubtree = node.getLeft ();
	    TreeNode rightSubtree = node.getRight ();

	    TreeNode temp = rightSubtree;
	    while (temp.getLeft () != null)
	    {
		temp = temp.getLeft ();
	    }
	    temp.setLeft (leftSubtree);
	    return rightSubtree;
	}
    } // remove method


    public static void main (String[] args)
    {
	root = (TreeNode) TreeUtil.createBalancedLetterTree (10);

	TreeUtil.displayTreeInWindow (root, "Starting Tree");

	while (true)
	{
	    System.out.print ("Enter node to delete: ");
	    String delItem = Stdin.readLine ();
	    if (delItem.length () == 0)
	    {
		break;
	    }
	    delete (null, root, delItem, LEFT);
	    TreeUtil.displayTreeInWindow (root, "After deleting " +
		    delItem);
	} // while (true)
    } // main method
} // TreeDelete class
