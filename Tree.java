package trees;

public class Tree implements BinarySearchTreeInterface{
    private TreeNode myRoot;
 
    public Tree() {
      myRoot = null;
    }
    
    public void add(Comparable cmp) {
    	myRoot = add(myRoot, cmp);
    }
    
    private TreeNode add(TreeNode r, Comparable cmp) {
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
    
    public void remove(Comparable c) {
    	remove(c, myRoot);
    }
    
    private void remove(Comparable c, TreeNode root) {
    	
    }
 
    public int height() {
    	return height(myRoot);
    }
    
    private int height(TreeNode r) {
    	if(r == null) return 0;
    	return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }
    
    public boolean search(Comparable c) {
    	return search(c, myRoot);
    }
    
    private boolean search(Comparable c, TreeNode n) {
    	if(c.equals((Comparable) n.getValue())) {
    		return true;
    	}
    	if(n.getLeft() != null  && search(c, n.getLeft()) {
    		return true; 
    	}
    	if(n.getRight() != null && search(c, n.getRight()) {
    		return true; 
    	}
    	return false;
    }
    
    public TreeNode searchParentNode(Comparable c) {
    	return searchParentNode(c, myRoot);
    }
    
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
	if (c.compareTo(root.getValue()) < 0) {
		return searchParentNode(c, root.getLeft());
	} else {
		return searchParentNode(c, root.getRight());
	}
    }
    
    public String toStringPreOrder() {
    	StringBuilder s = new StringBuilder("(");
    	toStringPreOrder(myRoot, s);
    	return s.toString();
    }
    
    private void toStringPreOrder(TreeNode root, StringBuilder s) {
    	s.append(root.getValue().toString());
    	if(root.getLeft() != null) {
    		s.append("(");
    		toStringPreOrder(root.getLeft(), s);
    	}
    	if(root.getRight() != null) {
    		s.append("(");
    		toStringPreOrder(root.getRight(), s);
    	}
    	s.append(")");
    }
    
    public String toStringInOrder() {
    	StringBuilder s = new StringBuilder("(");
    	toStringInOrder(myRoot, s);
    	return s.toString();
    }
    
    private void toStringInOrder(TreeNode root, StringBuilder s) {
    	if(root.getLeft() != null) {
    		s.append("(");
    		toStringInOrder(root.getLeft(), s);
    	}
    	s.append(root.getValue().toString());
    	if(root.getRight() != null) {
    		s.append("(");
    		toStringInOrder(root.getRight(), s);
    	}
    	s.append(")");
    } 
}
