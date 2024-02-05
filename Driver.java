package trees;

public class Driver {
	
	public static void main(String[] args) {
		Tree myTree = new Tree();
//		myTree.add(7);
//		myTree.add(4);
//		myTree.add(12);
//		myTree.add(2);
//		myTree.add(5);
//		myTree.add(6);
//		myTree.add(8);
//		myTree.add(14);
		
		myTree.add("hayden");
		myTree.add("is");
		myTree.add("so");
		myTree.add("annoying");
		myTree.add("what");
		myTree.add("a");
		myTree.add("geek");
		
		
		System.out.println(myTree.toStringInOrder());
		System.out.println(myTree.toStringPreOrder());
	}
}
