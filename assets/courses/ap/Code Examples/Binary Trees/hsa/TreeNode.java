// The "TreeNode" class.
package hsa;

public class TreeNode
{
    private Object value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode (Object initValue, TreeNode initLeft,
	    TreeNode initRight)
    {
	value = initValue;
	left = initLeft;
	right = initRight;
    } // TreeNode constructor


    public Object getValue ()
    {
	return value;
    } // getValue method


    public TreeNode getLeft ()
    {
	return left;
    } // getLeft method


    public TreeNode getRight ()
    {
	return right;
    } // getRight method


    public void setValue (Object theNewValue)
    {
	value = theNewValue;
    } // setValue method


    public void setLeft (TreeNode theNewLeft)
    {
	left = theNewLeft;
    } // setLeft method


    public void setRight (TreeNode theNewRight)
    {
	right = theNewRight;
    } // setRight method
} // TreeNode class
