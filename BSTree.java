/**
 * Name: Christopher Meyer
 * Group Members: Joey Johnson, Shane Blankenship
 * Project: Trees Without Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 8 February 2024
 */

package trees;

public interface BSTree {
	
	/**
	 * method that adds Comparable c to the binary search tree, 
	 * unless it's a duplicate
	 * @param c
	 */
	void add(Comparable c);
	
	/**
	 * method that searches the binary search tree and returns true 
	 * if comparable c is found in it
	 * @param c
	 * @return
	 */
	boolean search(Comparable c);
	
	/**
	 * method that returns an integer height of the binary search tree 
	 * (only a root is a height of 1, each level after that adding 1 to the height)
	 * @return
	 */
	int height();
	
	/**
	 * method that returns a pre-order string of the binary search tree
	 * @return
	 */
	String toStringPreOrder();
	
	/**
	 * method that returns a in-order string of the binary search tree
	 * @return
	 */
	String toStringInOrder();
	
	/**
	 * method that removes any tree node with comparable c as its value from 
	 * the binary search tree
	 * @param c
	 */
	void remove(Comparable c);
}
