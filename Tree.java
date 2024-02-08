/**
 * Name: Christopher Meyer
 * Group Members: Joey Johnson, Shane Blankenship
 * Project: Trees Without Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 8 February 2024
 */

package trees;

public class Tree implements BinarySearchTreeInterface {
    private TreeNode myRoot;
    
    /**
     * basic constructor method, root is automatically null
     */
    public Tree() {
      myRoot = null;
    }
    
    /**
     * add method, calls private help method
     */
    public void add(Comparable cmp) {
    	myRoot = add(myRoot, cmp);
    }
    
    /**
     * private helper method for add method
     * if r is null, sets r to new TreeNode with the cmp parameter
     * as its value
     * otherwise, puts it where it belongs
     * @param r
     * @param cmp
     * @return
     */
    private TreeNode add(TreeNode r, Comparable cmp) {
    	if (r == null) { 
			r = new TreeNode(cmp, null, null);
		}
		else {
			if(cmp.compareTo((Comparable) r.getValue()) == 0) {
				return r;
			}
			if(cmp.compareTo((Comparable) r.getValue()) < 0) {
				r.setLeft(add(r.getLeft(), cmp));
			}
			else {
				r.setRight(add(r.getRight(), cmp));
			}
		}
	    return r;
    }
    
    /**
     * remove method
     */
    public void remove(Comparable c) {
    	remove(myRoot, c);
    }
    
    /**
     * remove method private helper method
     * @param root
     * @param c
     */
    private void remove(TreeNode root, Comparable c) {
    	//case 1
    	TreeNode parentNode = searchParentNode(c);
    	TreeNode deleteNode = searchNode(c);
    	TreeNode childNode;
    	if(((deleteNode.getLeft() == null) &&
    	   (deleteNode.getRight() != null)) ||
    	   ((deleteNode.getLeft() != null) &&
    	    (deleteNode.getRight() == null))) {
    		if(deleteNode.getLeft() == null) {
    			childNode = deleteNode.getRight();
    		} else {
    			childNode = deleteNode.getLeft();
    		}
    		
    		
    	}
    }
    
    /**
     * searchNode method, searches for a comparable
     * private helper method for remove
     * @param c
     * @return
     */
    private TreeNode searchNode(Comparable c) {
    	
    	return null;
    }
    
    /**
     * height method, calls private helper
     */
    public int height() {
    	return height(myRoot);
    }
    
    /**
     * private helper method for height method
     * returns the integer value of the height for the tree
     * @param r
     * @return
     */
    private int height(TreeNode r) {
    	if(r == null) return 0;
    	return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }
    
    /**
     * search method
     */
    public boolean search(Comparable c) {
    	return search(c, myRoot);
    }
    
    /**
     * private helper method for search method
     * return true if the comparable is found, false otherwise
     * @param c
     * @param n
     * @return
     */
    private boolean search(Comparable c, TreeNode n) {
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
     * searchParentNode method
     * @param c
     * @return
     */
    public TreeNode searchParentNode(Comparable c) {
    	return searchParentNode(c, myRoot);
    }
    
    /**
     * searchParentNode private helper method
     * returns the parent TreeNode of the comparable you put in the parameter
     * @param c
     * @param root
     * @return
     */
    private TreeNode searchParentNode(Comparable c, TreeNode root) {
    	// check if null then return null 
    	if (root == null || root.getValue().equals(c)) {
    		return null;
    	}

    	// checks if getLeft() or getRight() equals(c) 
    	if ((root.getLeft()  != null && root.getLeft().getValue().equals (c))  ||
    	    (root.getRight() != null && root.getRight().getValue().equals(c))) {
    		return root;
    	}

    	// if it does not equal c and less than 0 gets the left side else gets the right side
    	if (c.compareTo((Comparable) root.getValue()) < 0) {
    		return searchParentNode(c, root.getLeft());
    	} else {
    		return searchParentNode(c, root.getRight());
    	}
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
     * @param root
     * @param sb
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
     * @param root
     * @param sb
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
}
