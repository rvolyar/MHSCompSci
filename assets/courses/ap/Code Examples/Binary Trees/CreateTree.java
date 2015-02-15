// The "CreateTree" class.
import hsa.TreeUtil;

public class CreateTree
{
    public static void main (String[] args)
    {
	TreeNode root, n1, n2, n3, n4, n5, n6;
	n1 = new TreeNode ("X", null, null);
	n2 = new TreeNode ("Y", null, null);
	n3 = new TreeNode ("H", n1, n2);
	n1 = new TreeNode ("T", null, null);
	n2 = new TreeNode ("U", null, null);
	n4 = new TreeNode ("J", n1, n2);
	n1 = new TreeNode ("V", null, null);
	n5 = new TreeNode ("K", n1, null);
	n6 = new TreeNode ("C", n4, n5);
	root = new TreeNode ("A", n3, n6);

	System.out.println ("The depth is " + (getDepth (root) - 1));

	// Calculate width (technique 1).
	int width = 0;
	for (int depth = 0 ; depth < getDepth (root) ; depth++)
	{
	    System.out.println ("The width at depth " + depth +
		    " is " + getWidthAtDepth (root, depth));
	    width = Math.max (width, getWidthAtDepth (root, depth));
	} // for
	System.out.println ("The width is " + width);

	// Calculate width (technique 2).
	width = 0;
	int depth = 1;
	while (getWidthAtDepth (root, depth) > 0)
	{
	    width = Math.max (width, getWidthAtDepth (root, depth));
	    depth++;
	} // for
	System.out.println ("The width is " + width);

	TreeUtil.displayTreeInWindow (root, "myTree", 24);
    } // main method


    private static int getDepth (TreeNode node)
    {
	TreeNode left, right;
	int leftDepth, rightDepth;

	if (node == null)
	{
	    return 0;
	}

	left = node.getLeft ();
	right = node.getRight ();
	leftDepth = getDepth (left);
	rightDepth = getDepth (right);

	return 1 + Math.max (leftDepth, rightDepth);
    } // getDepth method


    private static int getWidthAtDepth (TreeNode node, int depthToGo)
    {
	TreeNode left, right;
	int leftWidth, rightWidth;

	if (node == null)
	{
	    return 0;
	}

	if (depthToGo == 1)
	{
	    return 1;
	}

	left = node.getLeft ();
	right = node.getRight ();
	leftWidth = getWidthAtDepth (left, depthToGo - 1);
	rightWidth = getWidthAtDepth (right, depthToGo - 1);

	return leftWidth + rightWidth;
    } // getWidthAtDepth method
} // CreateTree class


