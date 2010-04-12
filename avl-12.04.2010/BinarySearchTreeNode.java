
public class BinarySearchTreeNode<K extends Comparable<K>, T> {
	private K key;
	private T object;
	private BinarySearchTreeNode<K, T> right;
	private BinarySearchTreeNode<K, T> left;
	private int height;

	public BinarySearchTreeNode() {
		height = 0;
	}

	public int getBalanceFactor() {
		return this.getLeft().getHeight() -
			this.getRight().getHeight();
	}
	public void adjustHeight() {
		if (this.getLeft().getHeight() >
			this.getRight().getHeight()){
			this.height = this.getLeft().getHeight() + 1;
		}
		else {
			this.height = this.getRight().getHeight() + 1;
		}
   }

	public boolean isTerminal(){
		return (this.right == null && this.left == null);
	}

	public int getHeight() {
		return height;
	}

	public K getKey() {
		return key;
	}
	public T getObject() {
		return object;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setObject(T obj) {
		this.object = obj;
	}

	public BinarySearchTreeNode<K, T> getRight() {
		return right;
	}
	public BinarySearchTreeNode<K, T> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode<K, T> left) {
		this.left = left;
	}

	public void setRight(BinarySearchTreeNode<K, T> right) {
		this.right = right;
	}

	private static String spaces(int level) {
		String c = "";
		for (int i = 0; i < level; i++)
			c += "\t";
		return c;
	}

	private String toString_level(int level) {
		String s = BinarySearchTreeNode.spaces(level);

		if (this.isTerminal())
			return ".";
		else if (this.left.isTerminal() && this.right.isTerminal())
			return String.format("%s",
				this.object.toString());
   		else
			return String.format("(%s\n%s%s\n%s%s)",
				this.object.toString(),
				s,
				this.left.toString_level(level+1),
				s,
				this.right.toString_level(level+1));
	}

	public String toString() {
		return this.toString_level(1);
	}
}