/**
 * Group Members: Christopher Meyer, Joey Johnson, Shane Blankenship
 * Project: Trees With Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 12 February 2024
 */

package trees; 

public class Tree implements BinarySearchTreeInterface
{
    private TreeNode myRoot;
 
    /**
     * constructor method for Tree()
     */
    public Tree() 
    {
      myRoot = null;
    }
    
    /**
     * add method creates and adds a new node to the tree 
     */
    public void add(@SuppressWarnings("rawtypes") Comparable cmp) 
    {
		// if cmp == null don't add 
		if(cmp == null) {return;}

		// if cmp is int, double, float, long, char
		// change it to a string this tree will only use strings as Comparables
		if (cmp.getClass() == Integer.class) 	{ cmp = cmp+""; }
        if (cmp.getClass() == Double.class ) 	{ cmp = cmp+""; }
		if (cmp.getClass() == Float.class  ) 	{ cmp = cmp+""; }
		if (cmp.getClass() == Long.class   ) 	{ cmp = cmp+""; }
		if (cmp.getClass() == Character.class)	{ cmp = cmp+""; }

		myRoot = add(myRoot, cmp);
    }
    
    /**
    * private helper method for add method
    * if r is null, sets r to new TreeNode with the cmp parameter
    * as its value
    * otherwise, puts it where it belongs
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private TreeNode add(TreeNode r, Comparable cmp) 
    {
		if (r == null) { 
			r = new TreeNode(cmp, null, null);
		}
		else {
			if(cmp.compareTo((Comparable) (r.getValue())) < 0) {
				r.setLeft(add(r.getLeft(), cmp));
			}
			else {
				r.setRight(add(r.getRight(), cmp));
			}
		}
	    return r;
    }
 
    /**
     * gets the height of the tree
     */
    public int height() {
    	return height(myRoot);
    }
    
    /**
     * private helper method for height method
     * returns the integer value of the height for the tree
     */
    private int height(TreeNode r) {
    	if(r == null) return 0;
    	return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }
    
    /**
     * search for a node with a given value
     */
    @SuppressWarnings("rawtypes")
	public boolean search(Comparable c) 
    {
    	if(c == null) {return false;}

		if (c.getClass() == Integer.class) 		{ c = c+""; }
        if (c.getClass() == Double.class ) 		{ c = c+""; }
		if (c.getClass() == Float.class  ) 		{ c = c+""; }
		if (c.getClass() == Long.class   ) 		{ c = c+""; }
		if (c.getClass() == Character.class)	{ c = c+""; }
		return search(c, myRoot);
    }
    
    /**
     * private helper method for search method
     * return true if the comparable is found, false otherwise
     */
    @SuppressWarnings("rawtypes")
	private boolean search(Comparable c, TreeNode n) 
    {
    	if (n == null) {return false;}
    	if(c.equals((Comparable) n.getValue())) {
    		return true;
    	}
    	if(n.getLeft() != null && search(c, n.getLeft())) {
    		return true; 
    	}
    	if(n.getRight() != null && search(c, n.getRight())) {
    		return true; 
    	}
    	return false;
    }
 
    /**
     * toStringPreOrder method
     */
    public String toStringPreOrder() {
    	StringBuilder sb = new StringBuilder();
    	toStringPreOrder(myRoot, sb);
    	return sb.toString();
    }
    
    /**
     * toStringPreOrder private helper method
     */
    private void toStringPreOrder(TreeNode root, StringBuilder sb) {
    	if (root != null) {
            sb.append("(");
            sb.append(root.getValue());
            toStringPreOrder(root.getLeft(), sb);
            toStringPreOrder(root.getRight(), sb);
            sb.append(")");
        }
    }
    
    /**
     * toStringInOrder method
     */
    public String toStringInOrder() {
    	StringBuilder sb = new StringBuilder();
    	toStringInOrder(myRoot, sb);
    	return sb.toString();
    }
    
    /**
     * toStringInOrder private helper method
     */
    private void toStringInOrder(TreeNode root, StringBuilder sb) {
    	if (root != null) {
    		sb.append("(");
            toStringInOrder(root.getLeft(), sb);
            sb.append(root.getValue());
            toStringInOrder(root.getRight(), sb);
            sb.append(")");
        }
    }
  
	/**
	 * 	removes a node with a given value
	 */
    @SuppressWarnings("rawtypes")
	public void remove(Comparable c) 
    {
    	if (c == null) {return;}

		if (c.getClass() == Integer.class) 		{ c = c+""; }
        if (c.getClass() == Double.class ) 		{ c = c+""; }
		if (c.getClass() == Float.class  ) 		{ c = c+""; }
		if (c.getClass() == Long.class   ) 		{ c = c+""; }
		if (c.getClass() == Character.class)	{ c = c+""; }

		remove(c, myRoot);
    }
    
    /**
     * private helper method to remove a node from the tree
     */
	@SuppressWarnings({ "rawtypes", "unused" })
	private void remove(Comparable c, TreeNode t) 
	 {
		//if a node with value c exists
		if(search(c) && t != null && searchParentNode(c) != null)
		{
			TreeNode tempNode = searchNode(c);
			TreeNode parentNode = searchParentNode(c);

			// case 1 if node that you are deleting has no tree nodes 
			//if temp has no branches and is on the left side
			if(parentNode.getLeft() != null && 
				tempNode.getLeft() == null && tempNode.getRight() == null) {

				parentNode.setLeft(null); 
				return;
			} 
			// if temp has no branches and is on the right side
			if(parentNode.getRight() != null &&
				tempNode.getLeft() == null && tempNode.getRight() == null) {
					
					parentNode.setRight(null); 
					return; 
			}

			// case 2: if the temp node has only one node on the left side
			// either to the right or to the left
			if(tempNode.getLeft() != null && tempNode.getRight() == null) {
				TreeNode leftNode = tempNode.getLeft(); 
				parentNode.setRight(leftNode); 
				return; 
			}

			// temp node has only one node on the right side
			if(tempNode.getRight() != null && tempNode.getLeft() == null) {
				TreeNode rightNode = tempNode.getRight(); 
				parentNode.setRight(rightNode); 
				return; 
			}

			if(parentNode != null && tempNode.getLeft() != null && tempNode.getRight() != null) {
				TreeNode leftNodeRightSide = getLeftBiggest(tempNode.getLeft()); 
				parentNode.setLeft(leftNodeRightSide); 
				return; 
			}	


			// might need another senario not sure yet ... 
			// if(parentNode != null && tempNode.getLeft() == null && tempNode.getRight() == null) {
			// 	parentNode.set
			// }
		}
	 else {

			// idk do smth & hope for the best :)

			TreeNode tempNode = searchNode(c);
			TreeNode parentNode = searchParentNode(c);

			TreeNode nextRoot = getLeftBiggest(tempNode.getRight()); 

			if(nextRoot != null) {
				TreeNode smallParent = searchParentNode((Comparable) nextRoot.getValue()); 
			}

			// char clover = 5; 
			// System.out.println("help you have found an error "+ clover);

			// go down one time to the right side then go all the way down to the left side to get the smallest
			// then replace parentNode with that TreeNode

			// Inside the else block where parentNode is null
			if (parentNode == null && tempNode.getLeft() != null && tempNode.getRight() != null) {
				TreeNode rightNode = tempNode.getRight(); 

				if (rightNode != null && rightNode.getLeft() != null) {
					TreeNode leftBiggest = getLeftBiggest(rightNode); 
					myRoot = leftBiggest; 
					return; 
				}		
			}

			// checks to see if it is the front root and if there is a node on the left
			if(parentNode == null && tempNode.getLeft() != null && tempNode.getRight() == null) {
				TreeNode tempLeftNode = tempNode.getLeft(); 
				TreeNode tempRightSide= getRightBiggest(tempLeftNode); 

				myRoot = tempRightSide; 
				return; 
			}
	}
}
	
	/**
	 * Returns a TreeNode with a given value
	 */
    @SuppressWarnings("rawtypes")
	public TreeNode searchNode(Comparable c) 
    {
		if(c == null) {return null;}

		if (c.getClass() == Integer.class) 		{ c = c+""; }
        if (c.getClass() == Double.class ) 		{ c = c+""; }
		if (c.getClass() == Float.class  ) 		{ c = c+""; }
		if (c.getClass() == Long.class   ) 		{ c = c+""; }
		if (c.getClass() == Character.class)	{ c = c+""; }

		return searchNode(c, myRoot);
    }
	
    /**
     * private helper method that returns a TreeNode with a given value
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TreeNode searchNode(Object c, TreeNode root)
	{
		if (root != null && root.getValue() == (c))
		{
			return root;
		}

		if (root != null && ((Comparable) c).compareTo(root.getValue())
			< 0 && myRoot != null) {
			return searchNode(c, root.getLeft());
		} 
		
		if (root != null && ((Comparable) c).compareTo(root.getValue()) 
			> 0 && myRoot != null)
		{
			return searchNode(c, root.getRight());
		}
		return root;
	}
	
 	/**
	* returns the smallest left node in the tree
	*/
	private TreeNode getLeftBiggest(TreeNode r) {
		if(r == null){return null;}
	   		while(r.getLeft() != null) {
		   		r = r.getLeft();
	   		}
		return r;
   	} 

	/**
	* returns the smallest left node in the tree
	*/
	private TreeNode getRightBiggest(TreeNode r) {
		if(r == null){return null;}
	   		while(r.getRight() != null) {
		   		r = r.getRight();
	   		}
		return r;
   	} 
    
    /**
     * searches for a TreeNode's parent node
     */
    @SuppressWarnings("rawtypes")
	public TreeNode searchParentNode(Comparable c) 
    {
		if(c == null) {return null;}

		if (c.getClass() == Integer.class) 		{ c = c+""; }
        if (c.getClass() == Double.class ) 		{ c = c+""; }
		if (c.getClass() == Float.class  ) 		{ c = c+""; }
		if (c.getClass() == Long.class   ) 		{ c = c+""; }
		if (c.getClass() == Character.class)	{ c = c+""; }

		return searchParentNode(c, myRoot);
    }
    
    /**
     * private helper method to return a node's parent node
     */
    @SuppressWarnings("unchecked")
	private TreeNode searchParentNode(@SuppressWarnings("rawtypes") Comparable c, TreeNode root) {
    	// check if null then return null 
    	if (root == null || root.getValue().equals(c)) {
    		return null;
    	}

    	// checks if getLeft() or getRight() equals(c) 
    	if ((root.getLeft()  != null && root.getLeft().getValue()
    			.equals (c)) || (root.getRight() != null && 
    			root.getRight().getValue().equals(c))) {
    		return root;
    	}

    	// if it does not equal c and less than 0 gets the left side 
    	//else gets the right side
    	if (c.compareTo(root.getValue()) < 0) {
    		return searchParentNode(c, root.getLeft());
    	} else {
    		return searchParentNode(c, root.getRight());
    	}
    }
}

