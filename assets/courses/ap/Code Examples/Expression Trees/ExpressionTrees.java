// The "ExpressionTree" class.
import hsa.Stdin;
import hsa.TreeUtil;

public class ExpressionTree
{
    // Recursive expression evaluator.
    private static double evaluate (TreeNode node)
    {
	String value = (String) node.getValue ();
	double leftValue, rightValue;

	if (value.equals ("+"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return leftValue + rightValue;

	}
	else if (value.equals ("-"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return leftValue - rightValue;
	}
	else if (value.equals ("*"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return leftValue * rightValue;
	}
	else if (value.equals ("/"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return leftValue / rightValue;
	}
	else if (value.equals ("%"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return leftValue % rightValue;
	}
	else if (value.equals ("^"))
	{
	    leftValue = evaluate (node.getLeft ());
	    rightValue = evaluate (node.getRight ());
	    return Math.pow (leftValue, rightValue);
	}
	else
	{
	    try
	    {
		return Double.parseDouble (value);
	    }
	    catch (NumberFormatException e)
	    {
		System.out.println ("Unable to convert " +
			value + " into a number");
		return 0;
	    } // catch
	} // if
    } // evaluate method


    public static void main (String[] args)
    {
	String expr;
	TreeNode exprTree;
	double result;

	// Read in the expression.
	System.out.println ("Allowable characters:");
	System.out.println ("    Numbers (real/int), +, -, *, " +
		"/, %, ^, (, )");
	System.out.print ("Enter expression: ");
	expr = Stdin.readLine ();

	// Convert the expression into a tree.
	exprTree = (TreeNode) TreeUtil.createExpressionTree (expr);

	// Display the tree.
	TreeUtil.displayTreeInWindow (exprTree, expr);

	// Evaluate the expression tree.
	result = evaluate (exprTree);
	System.out.println ("Result = " + result);
    } // main method
} // ExpressionTree class
