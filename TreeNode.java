/**
 * Name: Christopher Meyer
 * Group Members: Joey Johnson, Shane Blankenship
 * Project: Trees Without Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 8 February 2024
 */

package trees;

public class TreeNode {
	private Object value;
	private TreeNode left, right;
	
	/**
	 * basic constructor
	 * @param initValue
	 * @param initLeft
	 * @param initRight
	 */
	public TreeNode (Object initValue, TreeNode initLeft, TreeNode initRight) {
		value = initValue; left = initLeft; right=initRight;
	}
	
	/**
	 * getValue()
	 * @return
	 */
	public Object   getValue()                   {return value;}
	
	/**
	 * getLeft()
	 * @return
	 */
	public TreeNode getLeft()                    {return left;}
	
	/**
	 * getRight()
	 * @return
	 */
	public TreeNode getRight()                   {return right;}
	
	/**
	 * setValue()
	 * @param newValue
	 */
	public void     setValue (Object newValue)   {value = newValue;}
	
	/**
	 * setLeft()
	 * @param newLeft
	 */
	public void     setLeft (TreeNode newLeft)   {left  = newLeft;}
	
	/**
	 * setRight()
	 * @param newRight
	 */
	public void     setRight (TreeNode newRight) {right = newRight;}
}
