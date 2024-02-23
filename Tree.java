/**
 * Name: Christopher Meyer
 * Group Members: Joey Johnson, Shane Blankenship
 * Project: Trees Without Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 8 February 2024
 */

package trees;

public class Tree implements BSTree {
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
    	if(cmp == null) {
    		return;
    	}
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
    	TreeNode removeNode = this.searchNode(c);
    	TreeNode parentNode = this.searchParentNode(c);
    	TreeNode smallestGreater = this.smallestGreater(removeNode);
    	TreeNode parentSG = searchParentNode((Comparable) smallestGreater.getValue()); //parent of smallest greater
    	
    	//case 0- removeNode is a root
    	if(parentNode == null) {
    		if(smallestGreater.getRight() == null) {
    			parentSG.setLeft(null);
    			smallestGreater.setRight(removeNode.getRight());
    			smallestGreater.setLeft(removeNode.getLeft());
    			myRoot = smallestGreater;
    		} else {
    			parentSG.setLeft(smallestGreater.getRight());
    			smallestGreater.setRight(removeNode.getRight());
    			smallestGreater.setLeft(removeNode.getLeft());
    			myRoot = smallestGreater;
    		}
    		return;
    	}
    	
    	//onLeft is true if the remove node is to the left of parent node, false otherwise
    	//this will be used to determine whether to set the right or left of the parent node
    	//to the new node or null depending on the child node of removeNode
    	boolean onLeft = false;
    	if(c.compareTo((Comparable) parentNode.getValue()) < 0) {
        	onLeft = true;
        }
        
    	//case 1- removeNode has at most one child
    	//instance 1- remove node has a node to the right
    	if ((removeNode.getLeft() == null) &&
        	(removeNode.getRight() != null)) {
    		if(onLeft) {
    			parentNode.setLeft(removeNode.getRight());
    			return;
    		} else {
    			parentNode.setRight(removeNode.getRight());
    			return;
    		}
    	}
    	
    	//instance 2- remove node has a node to the left
    	if((removeNode.getLeft() != null) &&
    	   (removeNode.getRight() == null)) {
    		if(onLeft) {
    			parentNode.setLeft(removeNode.getLeft());
    			return;
    		} else {
    			parentNode.setRight(removeNode.getLeft());
    			return;
    		}
    	}
    	
    	//instance 3- remove node has no child nodes
    	if((removeNode.getLeft() == null) &&
    	   (removeNode.getRight() == null)) {
    		if(onLeft) {
    			parentNode.setLeft(null);
    			return;
    		} else {
    			parentNode.setRight(null);
    			return;
    		}
    	}
    	
    	//case 2- remove node has 2 child nodes
    	if((removeNode.getLeft() != null) && 
    	   (removeNode.getRight() != null)) {
    		//instance 1- smallestGreater is the right child of delete note
    		if(removeNode.getRight() == smallestGreater) {
    			smallestGreater.setLeft(removeNode.getLeft());
    			if(onLeft) {
    				parentNode.setLeft(smallestGreater);
    				return;
    			} else {
    				parentNode.setRight(smallestGreater);
    				return;
    			}
    		}
    		
    		//instance 2- smallestGreater does not have a right child
    		if(smallestGreater.getRight() == null) {
    			parentSG.setLeft(null);
    			smallestGreater.setRight(removeNode.getRight());
    			smallestGreater.setLeft(removeNode.getLeft());
    			if(onLeft) {
    				parentNode.setLeft(smallestGreater);
    				return;
    			} else {
    				parentNode.setRight(smallestGreater);
    				return;
    			}
    		}
    		
    		//instance 3- smallestGreater has a right child
    		else { 
    			parentSG.setLeft(smallestGreater.getRight());
    			smallestGreater.setRight(removeNode.getRight());
    			smallestGreater.setLeft(removeNode.getLeft());
    			if(onLeft) {
    				parentNode.setLeft(smallestGreater);
    				return;
    			} else {
    				parentNode.setRight(smallestGreater);
    				return;
    			}
    		}		
    	}
    }
    
    public TreeNode smallestGreater(TreeNode node) {
    	return privateSmallestGreater(node);
    }
    
    private TreeNode privateSmallestGreater(TreeNode node) {
    	TreeNode temp = node;
    	if(node.getRight() != null) {
    		temp = node.getRight();
    		while(temp.getLeft() != null) {
    			temp = temp.getLeft();
    		}
    	}
    	return temp;
    }
    
    public TreeNode searchNode(Comparable c) {
    	return searchNode(c, myRoot);
    }
    
    /**
     * searchNode method, searches for a comparable
     * private helper method for remove
     * @param c
     * @return
     */
    private TreeNode searchNode(Comparable c, TreeNode root) {
    	if(root.getValue() == c) {
    		return root;
    	}
    	
    	if((c.compareTo((Comparable) root.getValue()) < 0)) {
    		return searchNode(c, root.getLeft());
    	}
    	
    	if((c.compareTo((Comparable) root.getValue()) > 0 )) {
    		return searchNode(c, root.getRight());
    	}
    	
    	return root;
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
}
