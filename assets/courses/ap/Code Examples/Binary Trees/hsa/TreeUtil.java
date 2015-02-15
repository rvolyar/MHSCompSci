// The "TreeUtil" class.

// This file actually contains several classes:
//
//    TreeUtil, AVLTreeNode, AVLNodeInfo, TreeWindow, TreeCanvas
//

package hsa;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class TreeUtil
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NODE_IS_TALLER = 1;
    private static final int DEPTH_UNCHANGED = 0;
    private static final int NODE_IS_SHORTER = -1;

    private static final String DEFAULT_TITLE = "Tree";
    private static final int DEFAULT_FONT_SIZE = 12;

    private static Method getLeft, getRight, getValue, setValue;
    private static Object[] setArgument = new Object [1];

    public static Object createNumberTree (int numNodes)
    {
	TreeNode root = null;
	ArrayList a = new ArrayList (numNodes);

	for (int i = 0 ; i < numNodes ; i++)
	{
	    a.add ("" + (i + 1));
	} // for

	// Insert all the elements in the tree.
	for (int i = 0 ; i < numNodes ; i++)
	{
	    int r = (int) (Math.random () * a.size ());
	    root = insert (root, (Comparable) a.get (r));
	    a.remove (r);
	} // for

	return convertToUserTreeNode (root);
    } // createNumberTree method


    public static Object createLetterTree (int numNodes)
    {
	TreeNode root = null;
	ArrayList a = new ArrayList (numNodes);
	StringBuffer letters = new StringBuffer (alphabet);
	int pos;

	if (numNodes > 26)
	{
	    System.out.println ("You cannot have more than 26 letter nodes");
	    return null;
	}

	for (int i = 0 ; i < numNodes ; i++)
	{
	    pos = (int) (Math.random () * letters.length ());
	    a.add (letters.substring (pos, pos + 1));
	    letters.deleteCharAt (pos);
	} // for

	// Insert all the elements in the tree.
	for (int i = 0 ; i < numNodes ; i++)
	{
	    int r = (int) (Math.random () * a.size ());
	    root = insert (root, (Comparable) a.get (r));
	    a.remove (r);
	} // for

	return convertToUserTreeNode (root);
    } // createLetterTree method


    public static Object createIntegerTree (int numNodes)
    {
	TreeNode root = null;
	Random r = new Random ();

	// Insert all the elements in the tree.
	for (int i = 0 ; i < numNodes ; i++)
	{
	    root = insert (root, new Integer (r.nextInt (1000)));
	} // for

	return convertToUserTreeNode (root);
    } // createIntegerTree method


    public static Object createBalancedNumberTree (int numNodes)
    {
	AVLTreeNode avlRoot = null;
	ArrayList a = new ArrayList (numNodes);

	for (int i = 0 ; i < numNodes ; i++)
	{
	    a.add (new Integer ("" + (i + 1)));
	} // for

	// Insert all the elements in the tree.
	for (int i = 0 ; i < numNodes ; i++)
	{
	    int r = (int) (Math.random () * a.size ());
	    avlRoot = avlInsert (avlRoot, (Comparable) a.get (r)).node;
	    a.remove (r);
	} // for

	// Now convert the AVL tree into a regular tree.
	return convertAVLToUserTreeNode (avlRoot);
    } // createBalancedNumberTree method


    public static Object createBalancedLetterTree (int numNodes)
    {
	AVLTreeNode avlRoot = null;
	ArrayList a = new ArrayList (numNodes);
	StringBuffer letters = new StringBuffer (alphabet);
	int pos;

	if (numNodes > 26)
	{
	    System.out.println ("You cannot have more than 26 letter nodes");
	    return null;
	}

	for (int i = 0 ; i < numNodes ; i++)
	{
	    pos = (int) (Math.random () * letters.length ());
	    a.add (letters.substring (pos, pos + 1));
	    letters.deleteCharAt (pos);
	} // for

	// Insert all the elements in the tree.
	for (int i = 0 ; i < numNodes ; i++)
	{
	    int r = (int) (Math.random () * a.size ());
	    avlRoot = avlInsert (avlRoot, (Comparable) a.get (r)).node;
	    a.remove (r);
	} // for

	// Now convert the AVL tree into a regular tree.
	return convertAVLToUserTreeNode (avlRoot);
    } // createBalancedLetterTree method


    public static void displayTreeInWindow (Object root)
    {
	new TreeWindow (root, DEFAULT_TITLE, DEFAULT_FONT_SIZE);
    } // displayTreeInWindow method


    public static void displayTreeInWindow (Object root, String title)
    {
	new TreeWindow (root, title, DEFAULT_FONT_SIZE);
    } // displayTreeInWindow method


    public static void displayTreeInWindow (Object root, String title,
	    int fontSize)
    {
	if ((fontSize < 6) || (fontSize > 72))
	{
	    System.out.println ("The font size between 6 and 72");
	    return;
	}

	new TreeWindow (root, title, fontSize);
    } // displayTreeInWindow method


    public static Object createExpressionTree (String expr)
    {
	TreeNode root = createExpr (expr);

	return convertToUserTreeNode (root);
    } // createExpressionTree method


    private static TreeNode createExpr (String expr)
    {
	int pos = 0;
	int parenDepth = 0;
	TreeNode left, right;

	expr = expr.trim ();

	pos = 0;
	while (pos < expr.length ())
	{
	    char ch = expr.charAt (pos);

	    if (ch == '(')
		parenDepth++;
	    else if (ch == ')')
		parenDepth--;
	    else if (parenDepth == 0)
	    {
		if ((ch == '+') || (ch == '-'))
		{
		    left = createExpr (expr.substring (0, pos - 1));
		    right = createExpr (expr.substring (pos + 1));
		    return new TreeNode ("" + ch, left, right);
		}
	    }
	    pos++;
	} // while

	pos = 0;
	while (pos < expr.length ())
	{
	    char ch = expr.charAt (pos);

	    if (ch == '(')
		parenDepth++;
	    else if (ch == ')')
		parenDepth--;
	    else if (parenDepth == 0)
	    {
		if ((ch == '*') || (ch == '/') || (ch == '%'))
		{
		    left = createExpr (expr.substring (0, pos - 1));
		    right = createExpr (expr.substring (pos + 1));
		    return new TreeNode ("" + ch, left, right);
		}
	    }
	    pos++;
	} // while

	pos = 0;
	while (pos < expr.length ())
	{
	    char ch = expr.charAt (pos);

	    if (ch == '(')
		parenDepth++;
	    else if (ch == ')')
		parenDepth--;
	    else if (parenDepth == 0)
	    {
		if ((ch == '^'))
		{
		    left = createExpr (expr.substring (0, pos));
		    right = createExpr (expr.substring (pos + 1));
		    return new TreeNode ("" + ch, left, right);
		}
	    }
	    pos++;
	} // while

	if ((expr.charAt (0) == '(') &&
		(expr.charAt (expr.length () - 1) == ')'))
	{
	    return createExpr (expr.substring (1, expr.length () - 1));
	}

	return new TreeNode (expr, null, null);
    } // createExpr method


    private static TreeNode insert (TreeNode node, Comparable value)
    {
	if (node == null)
	{
	    node = new TreeNode (value, null, null);
	}
	else if (value.compareTo (node.getValue ()) < 0)
	{
	    node.setLeft (insert (node.getLeft (), value));
	}
	else
	{
	    node.setRight (insert (node.getRight (), value));
	}

	return node;
    } // insert method


    private static AVLNodeInfo avlInsert (AVLTreeNode node, Comparable value)
    {
	int newState; // State of node after rebalance attempt.

	if (node == null)
	{
	    // We have reached the location where the node should be
	    // inserted. Create the new node. Since the node did not
	    // exist before, it is now taller than what existed before.
	    node = new AVLTreeNode (value, null, null, AVLTreeNode.EVEN);
	    newState = NODE_IS_TALLER;
	}
	else if (value.compareTo (node.getValue ()) == 0)
	{
	    // We have found a node in the tree that has the same value.
	    // Do nothing.
	    newState = DEPTH_UNCHANGED;
	}
	else if (value.compareTo (node.getValue ()) < 0)
	{
	    // The node is to be inserted somewhere in the left branch.
	    // recInsert returns the new left node and whether the depth
	    // of the new left node is now taller than it was.
	    AVLNodeInfo info = avlInsert (node.getLeft (), value);
	    node.setLeft (info.node);

	    if (info.stateChange == NODE_IS_TALLER)
	    {
		if (node.getBalance () == AVLTreeNode.MORE_LEFT)
		{
		    // The node was already tilted to the left and the left
		    // branch just became taller. It is now tilted too far
		    // (unbalanced). Attempt to rebalance the unbalanced
		    // left subtree.
		    info = delLeftBalance (node);
		    node = info.node;

		    // If delLeftBalance successfully made the node shorter,
		    // then the new state is back to an unchanged depth,
		    // otherwise it is still taller.
		    if (info.stateChange == NODE_IS_SHORTER)
			newState = DEPTH_UNCHANGED;
		    else
			newState = NODE_IS_TALLER;
		}
		else if (node.getBalance () == AVLTreeNode.EVEN)
		{
		    // If the node was even, it is now tilted left. The
		    // node's depth is larger.
		    node.setBalance (AVLTreeNode.MORE_LEFT);
		    newState = NODE_IS_TALLER;
		}
		else
		{
		    // If the node was tilted right, it is now even. Its
		    // depth is unchanged.
		    node.setBalance (AVLTreeNode.EVEN);
		    newState = DEPTH_UNCHANGED;
		}
	    }
	    else
	    {
		newState = DEPTH_UNCHANGED;
	    }
	}
	else
	{
	    // The node is to be inserted somewhere in the right branch.
	    // recInsert returns the new right node and whether the depth
	    // of the new right node is now taller than it was.
	    AVLNodeInfo info = avlInsert (node.getRight (), value);
	    node.setRight (info.node);

	    if (info.stateChange == NODE_IS_TALLER)
	    {
		if (node.getBalance () == AVLTreeNode.MORE_LEFT)
		{
		    // If the node was tilted left, it is now even. Its
		    // depth is unchanged.
		    node.setBalance (AVLTreeNode.EVEN);
		    newState = DEPTH_UNCHANGED;
		}
		else if (node.getBalance () == AVLTreeNode.EVEN)
		{
		    // If the node was even, it is now tilted right. The
		    // node's depth is larger.
		    node.setBalance (AVLTreeNode.MORE_RIGHT);
		    newState = NODE_IS_TALLER;
		}
		else
		{
		    // The node was already tilted to the right and the
		    // right branch just became taller. It is now tilted
		    // too far (unbalanced). Attempt to rebalance the
		    // unbalanced right subtree.
		    info = delRightBalance (node);
		    node = info.node;

		    // If delRightBalance successfully made the node shorter,
		    // then the new state is back to an unchanged depth,
		    // otherwise it is still taller.
		    if (info.stateChange == NODE_IS_SHORTER)
			newState = DEPTH_UNCHANGED;
		    else
			newState = NODE_IS_TALLER;
		}
	    }
	    else
	    {
		newState = DEPTH_UNCHANGED;
	    }
	}

	return new AVLNodeInfo (node, newState);
    } // avlInsert method


    // Rebalance a right subtree after deletion.
    private static AVLNodeInfo delRightBalance (AVLTreeNode node)
    {
	AVLTreeNode right = node.getRight (); // The taller subtree.

	if (right.getBalance () == AVLTreeNode.EVEN)
	{
	    node.setBalance (AVLTreeNode.MORE_RIGHT);
	    right.setBalance (AVLTreeNode.MORE_LEFT);
	    node = rotateLeft (node);
	    return new AVLNodeInfo (node, DEPTH_UNCHANGED);
	}
	else if (right.getBalance () == AVLTreeNode.MORE_RIGHT)
	{
	    node.setBalance (AVLTreeNode.EVEN);
	    right.setBalance (AVLTreeNode.EVEN);
	    node = rotateLeft (node);
	    return new AVLNodeInfo (node, NODE_IS_SHORTER);
	}
	else // right.getBalance () == AVLTreeNode.MORE_LEFT
	{
	    AVLTreeNode left = right.getLeft ();
	    if (left.getBalance () == AVLTreeNode.MORE_LEFT)
	    {
		node.setBalance (AVLTreeNode.EVEN);
		right.setBalance (AVLTreeNode.MORE_RIGHT);
	    }
	    else if (left.getBalance () == AVLTreeNode.EVEN)
	    {
		node.setBalance (AVLTreeNode.EVEN);
		right.setBalance (AVLTreeNode.EVEN);
	    }
	    else // left.getBalance () == AVLTreeNode.MORE_RIGHT
	    {
		node.setBalance (AVLTreeNode.MORE_LEFT);
		right.setBalance (AVLTreeNode.EVEN);
	    }
	    left.setBalance (AVLTreeNode.EVEN);
	    right = rotateRight (right);
	    node.setRight (right);
	    node = rotateLeft (node);
	    return new AVLNodeInfo (node, NODE_IS_SHORTER);
	}
    } // delRightBalance method


    // Rebalance a left subtree after deletion.
    private static AVLNodeInfo delLeftBalance (AVLTreeNode node)
    {
	AVLTreeNode left = node.getLeft (); // The taller subtree.

	if (left.getBalance () == AVLTreeNode.EVEN)
	{
	    node.setBalance (AVLTreeNode.MORE_LEFT);
	    left.setBalance (AVLTreeNode.MORE_RIGHT);
	    node = rotateRight (node);
	    return new AVLNodeInfo (node, DEPTH_UNCHANGED);
	}


	else if (left.getBalance () == AVLTreeNode.MORE_LEFT)
	{
	    node.setBalance (AVLTreeNode.EVEN);
	    left.setBalance (AVLTreeNode.EVEN);
	    node = rotateRight (node);
	    return new AVLNodeInfo (node, NODE_IS_SHORTER);
	}
	else // left.setBalance () == AVLTreeNode.MORE_RIGHT
	{
	    AVLTreeNode right = left.getRight ();
	    if (right.getBalance () == AVLTreeNode.MORE_RIGHT)
	    {
		node.setBalance (AVLTreeNode.EVEN);
		left.setBalance (AVLTreeNode.MORE_LEFT);
	    }
	    else if (right.getBalance () == AVLTreeNode.EVEN)
	    {
		node.setBalance (AVLTreeNode.EVEN);
		left.setBalance (AVLTreeNode.EVEN);
	    }
	    else // right.getBalance () == AVLTreeNode.MORE_LEFT
	    {
		node.setBalance (AVLTreeNode.MORE_RIGHT);
		left.setBalance (AVLTreeNode.EVEN);
	    }
	    right.setBalance (AVLTreeNode.EVEN);
	    left = rotateLeft (left);
	    node.setLeft (left);
	    node = rotateRight (node);
	    return new AVLNodeInfo (node, NODE_IS_SHORTER);
	}
    } // delLeftBalance method


    // Rotate the pointers right in a single node.
    private static AVLTreeNode rotateRight (AVLTreeNode node)
    {
	AVLTreeNode t = node.getLeft ();
	node.setLeft (t.getRight ());
	t.setRight (node);
	return t;
    } // rotateRight method


    // Rotate the pointers left in a single node.
    private static AVLTreeNode rotateLeft (AVLTreeNode node)
    {
	AVLTreeNode t = node.getRight ();
	node.setRight (t.getLeft ());
	t.setLeft (node);
	return t;
    } // rotateRight method


    private static Object convertToUserTreeNode (hsa.TreeNode root)
    {
	Class userTreeNodeClass;
	Class objectClass;
	Constructor con;
	try
	{
	    userTreeNodeClass = Class.forName ("TreeNode");
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println ("TreeNode class not found");
	    return root;
	}

	Class[] conParams = new Class [3];
	try
	{
	    conParams [0] = Class.forName ("java.lang.Object");
	}


	catch (ClassNotFoundException e)
	{
	    System.out.println ("Object class not found");
	    return root;
	}

	conParams [1] = userTreeNodeClass;
	conParams [2] = userTreeNodeClass;

	try
	{
	    con = userTreeNodeClass.getConstructor (conParams);
	}
	catch (NoSuchMethodException e)
	{
	    System.out.println ("No constructor found");
	    return root;
	}

	return convertNodeToUserTreeNode (root, con);
    } //  convertToUserTreeNode method


    private static Object convertNodeToUserTreeNode (hsa.TreeNode node,
	    Constructor con)
    {
	Object[] args = new Object [3];

	if (node == null)
	{
	    return null;
	}

	args [0] = node.getValue ();
	args [1] = convertNodeToUserTreeNode (node.getLeft (), con);
	args [2] = convertNodeToUserTreeNode (node.getRight (), con);

	try
	{
	    return con.newInstance (args);
	}
	catch (Exception e)
	{
	    System.out.println ("Unable to to call TreeNode constructor");
	    return null;
	}
    } // convertNodeToUserTreeNode method


    private static Object convertAVLToUserTreeNode (AVLTreeNode root)
    {
	Class userTreeNodeClass;
	Class objectClass;
	Constructor con;
	try
	{
	    userTreeNodeClass = Class.forName ("TreeNode");
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println ("TreeNode class not found");
	    return root;
	}

	Class[] conParams = new Class [3];
	try
	{
	    conParams [0] = Class.forName ("java.lang.Object");
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println ("Object class not found");
	    return root;
	}

	conParams [1] = userTreeNodeClass;
	conParams [2] = userTreeNodeClass;

	try
	{
	    con = userTreeNodeClass.getConstructor (conParams);
	}


	catch (NoSuchMethodException e)
	{
	    System.out.println ("No constructor found");
	    return root;
	}


	return convertAVLNodeToUserTreeNode (root, con);
    } //  convertAVLToUserTreeNode method


    private static Object convertAVLNodeToUserTreeNode (AVLTreeNode node,
	    Constructor con)
    {
	Object[] args = new Object [3];

	if (node == null)
	{
	    return null;
	}

	args [0] = node.getValue ();
	args [1] = convertAVLNodeToUserTreeNode (node.getLeft (), con);
	args [2] = convertAVLNodeToUserTreeNode (node.getRight (), con);

	try
	{
	    return con.newInstance (args);
	}
	catch (Exception e)
	{
	    System.out.println ("Unable to to call TreeNode constructor");
	    return null;
	}
    } // convertAVLNodeToTreeNode method
} // TreeUtil class


class AVLTreeNode
{
    // Public constants.
    public static final int MORE_LEFT = 1;
    public static final int EVEN = 2;
    public static final int MORE_RIGHT = 3;

    // Instance variables.
    private Object value;
    private AVLTreeNode left, right;
    private int balance; // One of MORE_LEFT, EVEN, or MORE_RIGHT.

    public AVLTreeNode (Object value, AVLTreeNode left,
	    AVLTreeNode right, int balance)
    {
	this.value = value;
	this.left = left;
	this.right = right;
	this.balance = balance;
    } // AVLTreeNode constructor


    public Object getValue ()
    {
	return value;
    } // getValue method


    public AVLTreeNode getLeft ()
    {
	return left;
    } // getLeft method


    public AVLTreeNode getRight ()
    {
	return right;
    } // getRight method


    public int getBalance ()
    {
	return balance;
    } // getBalance method


    public void setValue (Object value)
    {
	this.value = value;
    } // setValue method


    public void setLeft (AVLTreeNode node)
    {
	left = node;
    } // setLeft method


    public void setRight (AVLTreeNode node)
    {
	right = node;
    } // setRight method


    public void setBalance (int balance)
    {
	this.balance = balance;
    } // setBalance method
} // AVLTreeNode class


class AVLNodeInfo
{
    public AVLTreeNode node;
    public int stateChange;

    public AVLNodeInfo (AVLTreeNode node, int stateChange)
    {
	this.node = node;
	this.stateChange = stateChange;
    } // AVLNodeInfo constructor
} // AVLNodeInfo class


class TreeWindow extends Frame
{
    private static int numWindows = 0;

    public TreeWindow (Object root, String title, int fontSize)
    {
	super (title);

	ScrollPane scrollPane;
	TreeCanvas treeCanvas;

	// Add the window closer.
	addWindowListener (new WindowAdapter ()
	{
	    public void windowClosing (WindowEvent e)
	    {
		hide ();
		dispose ();
	    }
	}
	);

	// Get the dimensions
	Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();

	// Add the canvas
	scrollPane = new ScrollPane ();
	add (scrollPane);

	treeCanvas = new TreeCanvas (root, fontSize);
	scrollPane.add (treeCanvas);
	// Why does the ScrollPane have to be set to the size of the
	// canvas "+ 4"?  I don't know!
	scrollPane.setSize (treeCanvas.getPreferredSize ().width + 4,
		treeCanvas.getPreferredSize ().height + 4);

	// Place the window.
	pack ();
	if (getWidth () > screen.width * 5 / 6)
	{
	    setSize (screen.width * 5 / 6,
		    getHeight () + scrollPane.getVScrollbarWidth ());
	}
	if (getHeight () > screen.height * 5 / 6)
	{
	    setSize (getWidth () + scrollPane.getHScrollbarHeight (),
		    screen.height * 5 / 6);
	}

	// Move to the left side
	setLocation (screen.width - getWidth () - (numWindows * 30),
		(numWindows * 30));
	numWindows++;

	// Show the window.
	show ();
    } // TreeWindow constructor
} // TreeWindow class


class TreeCanvas extends Canvas
{
    private static int VERT_MARGIN = 4;
    private static int HORZ_MARGIN = 4;
    private static int SPACE_BETWEEN = 6;
    private static int MAIN_VERT_MARGIN = 10;
    private static int MAIN_HORZ_MARGIN = 10;

    private int xSize, ySize;
    private Image offscreen;
    //    private TreeNode root;
    private Font font;
    private FontMetrics fm;
    private int treeDepth;
    private int numNodes;
    private int boxWidth;
    private int boxHeight;
    private String[] nodes;
    private int[] nodeDepth;
    private Point[] nodePos;

    private static Method getLeft, getRight, getValue;

    public TreeCanvas (Object root, int fontSize)
    {
	// Create the TreeNode class necessary to load the methods
	Class userTreeNodeClass;
	Class objectClass;
	try
	{
	    userTreeNodeClass = Class.forName ("TreeNode");
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println ("TreeNode class not found");
	    return;
	}

	Class[] noParams = new Class [0];

	try
	{
	    getLeft = userTreeNodeClass.getMethod ("getLeft", noParams);
	    getRight = userTreeNodeClass.getMethod ("getRight", noParams);
	    getValue = userTreeNodeClass.getMethod ("getValue", noParams);
	}
	catch (NoSuchMethodException e)
	{
	    System.out.println ("No method found");
	    return;
	}

	// Set the font
	font = new Font ("SansSerif", Font.PLAIN, fontSize);
	fm = getFontMetrics (font);

	// Calculate the depth
	treeDepth = getDepth (root);

	// Calculate the size of a box
	boxWidth = getWidestNode (root) + 2 * HORZ_MARGIN;
	if ((boxWidth + SPACE_BETWEEN) % 2 == 1)
	{
	    boxWidth++;
	}

	boxHeight = fm.getAscent () + 2 * VERT_MARGIN;

	numNodes = (int) Math.round (Math.pow (2.0, treeDepth)) - 1;

	// Create the arrays
	nodes = new String [numNodes];
	nodeDepth = new int [numNodes];
	nodePos = new Point [numNodes];

	// Place the nodes into an array
	place (root, 0, 0);

	// Position the roots using a constant formula
	positionUsingConstantDistance ();

	// If the tree produced is too big, then try using variable
	// distance, which makes the tree much smaller.
	Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
	if ((xSize > (screen.width * 2 / 3)) ||
		(ySize > (screen.height * 3 / 4)))
	{
	    // Position the nodes to make the narrowest possible tree.
	    nodePos [0].x = 0;
	    positionUsingVariableDistance ();
	}

	setSize (xSize, ySize);
    } // TreeCanvas constructor


    private void place (Object node, int index, int depth)
    {
	if (node == null)
	{
	    return;
	}
	try
	{
	    nodes [index] = getValue.invoke (node, null).toString ();
	    nodeDepth [index] = depth;
	    nodePos [index] = new Point (0,
		    MAIN_VERT_MARGIN + depth * 3 * boxHeight);
	    place (getLeft.invoke (node, null), 2 * index + 1, depth + 1);
	    place (getRight.invoke (node, null), 2 * index + 2, depth + 1);
	}
	catch (Exception e)
	{
	    System.out.println ("Unable to invoke TreeNode method");
	    return;
	}
    } // place method


    // This method positions the node as if every node position in the
    // tree was extant.  It produces a symmetric, if wide tree
    private void positionUsingConstantDistance ()
    {
	int[] xMargin;
	int[] spaceBetween;

	// Calculate height and width
	int maxWidth = (int) Math.round (Math.pow (2.0, treeDepth - 1));
	xMargin = new int [treeDepth];
	spaceBetween = new int [treeDepth];
	xMargin [treeDepth - 1] = MAIN_HORZ_MARGIN;
	spaceBetween [treeDepth - 1] = SPACE_BETWEEN;

	for (int depth = treeDepth - 2 ; depth >= 0 ; depth--)
	{
	    xMargin [depth] = xMargin [depth + 1] + boxWidth +
		(spaceBetween [depth + 1] - boxWidth) / 2;
	    spaceBetween [depth] = spaceBetween [depth + 1] * 2 + boxWidth;
	}

	for (int cnt = 0 ; cnt < numNodes ; cnt++)
	{
	    if (nodes [cnt] == null)
	    {
		continue;
	    }
	    int depth = nodeDepth [cnt];
	    int beginLine = (int) Math.round (Math.pow (2.0, depth)) - 1;
	    nodePos [cnt].x = xMargin [depth] +
		(cnt - beginLine) * (spaceBetween [depth] + boxWidth);
	}

	// Calculate the size of the window
	xSize = MAIN_HORZ_MARGIN * 2 +
	    (maxWidth - 1) * (boxWidth + SPACE_BETWEEN) + boxWidth;
	ySize = MAIN_VERT_MARGIN * 2 +
	    (treeDepth - 1) * 3 * boxHeight + boxHeight;
    } // positionUsingConstantDistance method


    private void positionUsingVariableDistance ()
    {
	for (int cnt = 1 ; cnt < numNodes ; cnt++)
	{
	    if (nodes [cnt] != null)
	    {
		position (cnt);
		// printPos (cnt);
		// checkPos (cnt);
	    }
	}

	int min = nodePos [0].x;
	int max = min;
	for (int cnt = 0 ; cnt < numNodes ; cnt++)
	{
	    if (nodes [cnt] != null)
	    {
		min = Math.min (min, nodePos [cnt].x);
		max = Math.max (max, nodePos [cnt].x);
	    }
	}
	for (int cnt = 0 ; cnt < numNodes ; cnt++)
	{
	    if (nodes [cnt] != null)
	    {
		nodePos [cnt].x += MAIN_HORZ_MARGIN - min;
	    }
	}

	// Calculate the size of the window
	xSize = 2 * MAIN_HORZ_MARGIN + max - min + boxWidth;
	ySize = MAIN_VERT_MARGIN * 2 +
	    (treeDepth - 1) * 3 * boxHeight + boxHeight;
    } // positionUsingVariableDistance method


    // Algorithm: All measurements are taken from the centre line.
    // For each node in a line, place it
    //          +/- (boxWidth + SPACE_BETWEEN) / 2
    // from the parent node. Check to see if there is an overlap with
    // the previous node in the line.  If there is, adjust the parents
    // of the two overlapping nodes.  If both are +, adjust the second node
    // right as much as necessary to separate the two nodes enough.
    // If both are -, adjust the first node left as much as necessary,
    // shifting any previous nodes lef

    private void position (int index)
    {
	int depth = nodeDepth [index];
	int endLine = (int) Math.round (Math.pow (2.0, depth + 1));
	int parent = (index - 1) / 2;
	int x;
	boolean left = ((index % 2) == 1);

	// Calculate the base guess for x in this node
	if (left)
	{
	    x = nodePos [parent].x - (boxWidth + SPACE_BETWEEN) / 2;
	}
	else
	{
	    x = nodePos [parent].x + (boxWidth + SPACE_BETWEEN) / 2;
	}
	nodePos [index].x = x;

	// Find the location of the previous node.
	int prevIndex = getPrevious (index);
	// prevIndex now points to the previous node or beginLine - 1
	if (prevIndex == -1)
	{
	    // There is no previous node, don't worry about collision
	    return;
	}

	// difference = space between current node and previous node
	int difference = x - nodePos [prevIndex].x;
	if (difference >= (boxWidth + SPACE_BETWEEN))
	{
	    // There's a big enough space
	    return;
	}

	// extraSpaceNeeded indicates how much extra space is needed
	int extraSpaceNeeded = (boxWidth + SPACE_BETWEEN) - difference;

	// Both this node and the previous node are on right of centre
	shiftLeft (prevIndex, extraSpaceNeeded, index);
    } // position method


    private int getParent (int index)
    {
	if (index == 0)
	{
	    return -1;
	}
	return (index - 1) / 2;
    } // getParent


    private int getPrevious (int index)
    {
	int depth = nodeDepth [index];
	int beginLine = (int) Math.round (Math.pow (2.0, depth)) - 1;
	int prevIndex = index - 1;

	while (prevIndex >= beginLine)
	{
	    if (nodes [prevIndex] != null)
		break;
	    prevIndex--;
	}
	if (prevIndex < beginLine)
	{
	    return -1;
	}
	else
	{
	    return prevIndex;
	}
    } // getPrevious method


    private void printPos (int index)
    {
	System.out.println ("Inserted node " + index +
		" (" + nodes [index] + ")");
	for (int cnt = 0 ; cnt <= index ; cnt++)
	{
	    if (nodes [cnt] != null)
	    {
		System.out.println ("N: " + cnt + " (" + nodes [cnt] +
			")  d: " + nodeDepth [cnt] + "  x: " +
			nodePos [cnt].x + "  y: " + nodePos [cnt].y);
	    }
	}
    }


    private void checkPos (int currentNode)
    {
	for (int cnt = 1 ; cnt <= currentNode ; cnt++)
	{
	    if (nodes [cnt] != null)
	    {
		// Check that we are not too close to a previous node
		int prevIndex = getPrevious (cnt);
		if (prevIndex != -1)
		{
		    int difference = nodePos [cnt].x - nodePos [prevIndex].x;
		    if (difference < (boxWidth + SPACE_BETWEEN))
		    {
			System.out.println ("PROBLEM (1) " + cnt + " " + difference);
			numNodes = currentNode + 1;
			return;
		    }
		}
		int parIndex = getParent (cnt);
		if (prevIndex != -1)
		{
		    boolean left = ((cnt % 2) == 1);
		    int difference = nodePos [cnt].x - nodePos [parIndex].x;
		    if (left)
		    {
			if (difference > (boxWidth + SPACE_BETWEEN) / 2)
			{
			    System.out.println ("PROBLEM (2) " + cnt + " " + difference);
			    numNodes = currentNode + 1;
			    return;
			}
		    }
		    else
		    {
			if (difference < (boxWidth + SPACE_BETWEEN) / 2)
			{
			    System.out.println ("PROBLEM (3) " + cnt + " " + difference);
			    numNodes = currentNode + 1;
			    return;
			}
		    } // if (left)
		} // if (prevIndex != -1)
	    } // if
	} // for
    } // checkPos method


    private void calcParentX (int nextIndex, int lastPositionedNode)
    {
	while (nextIndex >= 0)
	{
	    int index = nextIndex;
	    int left = 2 * index + 1;
	    int right = 2 * index + 2;
	    int prevX = nodePos [index].x;
	    int x;

	    nextIndex = getParent (index);

	    if (nodes [left] == null)
	    {
		if (nodes [right] == null)
		{
		    System.out.println ("Internal error in TreeUtil - " +
			    "calcParent called on node with no children");
		}
		x = nodePos [right].x - (boxWidth + SPACE_BETWEEN) / 2;
	    }
	    else
	    {
		if (nodes [right] == null)
		{
		    x = nodePos [left].x + (boxWidth + SPACE_BETWEEN) / 2;
		}
		else
		{
		    x = (nodePos [left].x + nodePos [right].x) / 2;
		}
	    } // if

	    // This node is getting shifted because one or more of its
	    // children were shifted.
	    if (x != prevX)
	    {
		// Both this node and the previous node are on right of centre
		shiftLeft (index, prevX - x, lastPositionedNode);
	    }

	    // Find the location of the previous node.
	    int prevIndex = getPrevious (index);
	    // prevIndex now points to the previous node or beginLine - 1
	    if (prevIndex == -1)
	    {
		// There is no previous node, don't worry about collision
		continue;
	    }

	    // difference = space between current node and previous node
	    int difference = nodePos [index].x - nodePos [prevIndex].x;
	    if (difference >= (boxWidth + SPACE_BETWEEN))
	    {
		// There's a big enough space
		continue;
	    }

	    // extraSpaceNeeded indicates how much extra space is needed
	    int extraSpaceNeeded = (boxWidth + SPACE_BETWEEN) - difference;

	    // Both this node and the previous node are on right of centre
	    shiftLeft (prevIndex, extraSpaceNeeded, lastPositionedNode);
	} // while
    } // calcParentX method


    private void shiftLeft (int index, int amount, int lastPositionedNode)
    {
	int depth = nodeDepth [index];
	int beginLine = (int) Math.round (Math.pow (2.0, depth)) - 1;

	// Shift all nodes at this depth the from index leftward
	for (int cnt = index ; cnt >= beginLine ; cnt--)
	{
	    if (nodes [cnt] != null)
	    {
		nodePos [cnt].x -= amount;
	    }
	}

	// Now calculate the new locations of the parents, if necessary.
	for (int cnt = index ; cnt >= beginLine ; cnt--)
	{
	    if (nodes [cnt] != null)
	    {
		calcParentX (getParent (cnt), lastPositionedNode);
	    }
	}
    } // shiftLeft method


    private void shiftChildren (int parent, int amount, int lastPositionedNode)
    {
	int left = 2 * parent + 1;
	int right = 2 * parent + 2;
	if ((left <= lastPositionedNode) && (nodes [left] != null))
	{
	    nodePos [left].x -= amount;
	    shiftChildren (left, amount, lastPositionedNode);
	}
	if ((right <= lastPositionedNode) && (nodes [right] != null))
	{
	    nodePos [right].x -= amount;
	    shiftChildren (right, amount, lastPositionedNode);
	}
    } // shiftChildren method


    private void drawToOffscreen ()
    {
	Graphics g = offscreen.getGraphics ();

	g.setFont (font);

	for (int cnt = 0 ; cnt < numNodes ; cnt++)
	{
	    if (nodes [cnt] == null)
	    {
		continue;
	    }
	    int x = nodePos [cnt].x;
	    int y = nodePos [cnt].y;
	    String s = nodes [cnt];
	    g.drawRect (x, y, boxWidth, boxHeight);
	    y += VERT_MARGIN + fm.getAscent ();
	    x = x + (boxWidth - fm.stringWidth (s)) / 2 + 1;
	    g.drawString (s, x, y);

	    // Draw connection to parent
	    if (cnt == 0)
	    {
		continue;
	    }
	    int x1 = nodePos [cnt].x + boxWidth / 2;
	    int y1 = nodePos [cnt].y;
	    int parent = (cnt - 1) / 2;
	    int leftRight = ((cnt + 1) % 2) + 1;
	    int x2 = nodePos [parent].x + (boxWidth * leftRight) / 3;
	    int y2 = nodePos [parent].y + boxHeight;
	    g.drawLine (x1, y1, x2, y2);
	} // for
    } // drawToOffscreen method


    public void addNotify ()
    {
	super.addNotify ();

	offscreen = createImage (xSize, ySize);
	drawToOffscreen ();
    } // addNotify method


    public void paint (Graphics g)
    {
	update (g);
    } // paint method


    public void update (Graphics g)
    {
	// Copy the offscreen image to the window.
	g.drawImage (offscreen, 0, 0, null, null);
    } // update method


    public Dimension getMinimumSize ()
    {
	return new Dimension (xSize, ySize);
    } // getMinimumSize method


    /**
     * Overrides the getPreferredSize method to specify the proper canvas size
     */
    public Dimension getPreferredSize ()
    {
	return getMinimumSize ();
    } // getPreferredSize method


    public Dimension getMaximumSize ()
    {
	return getMinimumSize ();
    } // getPreferredSize method


    //
    // Tree Functions
    //
    public int getDepth (Object node)
    {
	Object left, right;
	int leftDepth, rightDepth;

	if (node == null)
	{
	    return 0;
	}

	try
	{
	    left = getLeft.invoke (node, null);
	    right = getRight.invoke (node, null);
	}
	catch (Exception e)
	{
	    System.out.println ("Unable to invoke TreeNode method");
	    return 0;
	}

	leftDepth = getDepth (left);
	rightDepth = getDepth (right);

	return 1 + Math.max (leftDepth, rightDepth);
    } // getDepth method


    public int getWidestNode (Object node)
    {
	Object left, right;
	int width, leftWidth, rightWidth;

	if (node == null)
	{
	    return 0;
	}

	try
	{
	    width = fm.stringWidth (getValue.invoke (node, null).toString ());
	    left = getLeft.invoke (node, null);
	    right = getRight.invoke (node, null);
	}
	catch (Exception e)
	{
	    System.out.println ("Unable to invoke TreeNode method");
	    return 0;
	}
	leftWidth = getWidestNode (left);
	rightWidth = getWidestNode (right);

	return Math.max (width, Math.max (leftWidth, rightWidth));
    } // getWidestNode
} // TreeCanvas


