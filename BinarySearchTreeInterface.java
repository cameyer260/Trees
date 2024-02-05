package trees;

public interface BinarySearchTreeInterface {
	void add(Comparable c);
	boolean search(Comparable c);
	int height();
	String toStringPreOrder();
	String toStringInOrder();
	void remove(Comparable c);
}
