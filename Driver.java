/**
 * Name: Christopher Meyer
 * Group Members: Joey Johnson, Shane Blankenship
 * Project: Trees Without Removal
 * Teacher: Mr. Meinzen
 * Class: AP Computer Science A
 * Date: 8 February 2024
 */

package trees;

public class Driver {
	
	/**
	 * main()
	 * @param args
	 */
	public static void main(String[] args) {

		Tree myTree1 = new Tree();
		myTree1.add("L");
		myTree1.add("D");
		myTree1.add("A");
		myTree1.add("F");
		myTree1.add("B");
		myTree1.add("R");
		myTree1.add("M");
		myTree1.add("U");
		myTree1.add("T");
		myTree1.add("V");

		//printout tree toStrings() before removal
		System.out.println("inOrder" + myTree1.toStringInOrder());
		System.out.println("preOrder" + myTree1.toStringPreOrder());
		
		myTree1.remove("A");
		myTree1.remove("B");
		myTree1.remove("U");
		myTree1.remove("R");
		myTree1.remove("L");
		
		//printout tree toStrings() after removal
		System.out.println("inOrder" + myTree1.toStringInOrder());
		System.out.println("preOrder" + myTree1.toStringPreOrder());
	}
}
