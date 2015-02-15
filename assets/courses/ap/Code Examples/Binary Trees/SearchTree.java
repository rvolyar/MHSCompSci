// The "SearchTree" class.
import hsa.TreeUtil;

public class SearchTree
{
    private static boolean search (TreeNode node,
	    Comparable searchItem)
    {
	if (node == null)
	{
	    return false;
	}
	else
	{
	    Comparable value = (Comparable) node.getValue ();

	    if (searchItem.equals (value))
	    {
		return true;
	    }
	    else if (searchItem.compareTo (value) < 0)
	    {
		return search (node.getLeft (), searchItem);
	    }
	    else
	    {
		return search (node.getRight (), searchItem);
	    }
	}
    } // search method


    public static void main (String[] args)
    {
	TreeNode root =
	    (TreeNode) TreeUtil.createBalancedLetterTree (15);
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	TreeUtil.displayTreeInWindow (root, "Created Tree", 24);

	System.out.print ("Found: ");
      /* DJF  for (int letter = 0 ; letter < alphabet.length () ;
		letter++)
	{
	    String searchData = alphabet.substring (letter,
		    letter + 1);

	    if (search (root, searchData))
	    {
		System.out.print (searchData + " ");
	    }
	} // for
	*/
	String searchData = "R";

	    if (search (root, searchData))
	    {
		System.out.print (searchData + " is In the Tree");
	    }
	    else
		System.out.println(searchData + "  is NOT in the Tree");
	
	
	System.out.println ();
    } // main method
} // SearchTree class
