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
		//case 1
		Tree myTree1 = new Tree();
		myTree1.add("Bill");
		myTree1.add("Fred");
		myTree1.add("Joe");
		myTree1.add("Henrietta");
		myTree1.add("Mr. M");
		myTree1.add("Noman");
		myTree1.add("Alfred");
		myTree1.add("Al");
		myTree1.add("Fred");
		
		//case 2 (Henrietta and Fred added to the tree in swapped order
		Tree myTree2 = new Tree();
		myTree2.add("Bill");
		myTree2.add("Henrietta");
		myTree2.add("Joe");
		myTree2.add("Fred");
		myTree2.add("Mr. M");
		myTree2.add("Noman");
		myTree2.add("Alfred");
		myTree2.add("Al");
		myTree2.add("Fred");
		
		//case 1
		System.out.println("Case 1: ");
		System.out.println(myTree1.toStringInOrder());
		System.out.println(myTree1.toStringPreOrder());
		System.out.println("");
		
		//case 2
		System.out.println("Case 2: ");
		System.out.println(myTree2.toStringInOrder());
		System.out.println(myTree2.toStringPreOrder());
	}
}
