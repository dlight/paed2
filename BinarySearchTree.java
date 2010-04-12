public class BinarySearchTree<K extends Comparable<K>, T> {
	private BinarySearchTreeNode<K, T> root;

	public BinarySearchTree() {
		root = new BinarySearchTreeNode<K, T>();
	}

	public boolean isEmpty() {
		return this.root.isTerminal();
	}
	public boolean insert(K key, T obj) {
		return insertRecursive(this.root, key, obj);
	}
	//public boolean remove(K key){ ... }
	//public T search(K key){ ... }

	public boolean insertRecursive(BinarySearchTreeNode<K, T> node, K key, T obj) {
		if (node.isTerminal()) {
			node.setKey(key);
			node.setObject(obj);

			node.setLeft(new BinarySearchTreeNode<K, T>());
			node.setRight(new BinarySearchTreeNode<K, T>());

			return true;
		}
		else if (key.compareTo(node.getKey()) == 0) {
			return false;
		}
		else {
			boolean inseriu = false;
			if (key.compareTo(node.getKey()) < 0) {
				inseriu = this.insertRecursive(node.getLeft(), key, obj);
			}
			else if (key.compareTo(node.getKey()) > 0) {
				inseriu = this.insertRecursive(node.getRight(), key, obj);
			}

			if (inseriu) {
				node.adjustHeight();
			}
			if (Math.abs(node.getBalanceFactor()) > 1) {
				this.balance(node);
			}
			return inseriu;
		}
	}
	
	public void balance(BinarySearchTreeNode<K, T> node) {
		if (node.getLeft().getHeight() > node.getRight().getHeight()) {
			if (node.getLeft().getLeft().getHeight() >
				node.getLeft().getRight().getHeight()) {	

				return;//this.rotateRight(node);
			}
			else {
				return;//this.rotateDoubleRight(node);
			}
		}
		else {
			if (node.getRight().getRight().getHeight() >
				node.getRight().getLeft().getHeight()) {	

				return;//this.rotateLeft(node);
			}
			else {
				return;//this.rotateDoubleLeft(node);
			}
		}
	}

	public void print() {
		System.out.println(this.root.toString());
	}
}
