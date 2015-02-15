// The "TreeInsert" class.
import hsa.Stdin;
import hsa.TreeUtil;

public class TreeInsert
{
    private static TreeNode root;

    private static void insert (Comparable insertItem)
    {
	TreeNode newNode = new TreeNode (insertItem, null, null);
	if (root == null)
	{
	    root = newNode;
	}
	else
	{
	    recursiveInsert (root, newNode);
	}
    } // insert method


    private static void recursiveInsert (TreeNode searchNode,
	    TreeNode newNode)
    {
	Comparable insertValue = (Comparable) newNode.getValue ();
	Comparable value = (Comparable) searchNode.getValue ();

	if (insertValue.equals (value))
	{
	    // Already in the tree, do not insert anything.
	    return;
	}
	else if (insertValue.compareTo (value) < 0)
	{
	    if (searchNode.getLeft () == null)
	    {
		searchNode.setLeft (newNode);
		return;
	    }
	    recursiveInsert (searchNode.getLeft (), newNode);
	}
	else
	{
	    if (searchNode.getRight () == null)
	    {
		searchNode.setRight (newNode);
		return;
	    }
	    recursiveInsert (searchNode.getRight (), newNode);
	}
    } // recursiveInsert method


    public static void main (String[] args)
    {
	System.out.print ("Enter a string of letters (no spaces): ");
	String letters = Stdin.readLine ();

	root = null; // Start with an empty tree.

	for (int letter = 0 ; letter < letters.length () ;
		letter++)
	{
	    String insert = letters.substring (letter, letter + 1);

	    insert (insert);
	} // for
	TreeUtil.displayTreeInWindow (root);
    } // main method
} // TreeInsert class
