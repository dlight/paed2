public class BinarySearchTree<K extends Comparable<K>, T> {
	private BinarySearchTreeNode<K, T> root;

	public BinarySearchTree() {
		root = new BinarySearchTreeNode();
	}

	public boolean isEmpty() {
		return this.root.isTerminal();
	}
	public boolean insert(K key, T obj) {
		return insertRecursive(this.root, key, obj);
	}
	//public boolean remove(K key){ ... }
	//public T search(K key){ ... }

	public bool insertRecursive(BinarySearchTreeNode<K, T> node, K key, T obj) {
		if (node.isTerminal()) {
			node.setKey(key);
			node.setObject(aluno);

			node.left = new BinarySearchTreeNode();
			node.right = new BinarySearchTreeNode();

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
	
	public void balance(AVLSearchTreeNode<K, T> node) {
	if (node.getLeft().getHeight() > node.getRight().getHeight()) {
		if (node.getLeft().getLeft().getHeight() >
		node.getLeft().getRight().getHeight()) {
		this.rotateRight(node);
		}
		else {
		this.rotateDoubleRight(node);
		}
	}
	else {
		if (node.getRight().getRight().getHeight() >
		node.getRight().getLeft().getHeight()) {
		this.rotateLeft(node);
		}
		else {
		this.rotateDoubleLeft(node);
		}
	}
	}
}
