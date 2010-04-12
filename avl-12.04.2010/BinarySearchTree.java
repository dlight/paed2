public class BinarySearchTree<K extends Comparable<K>, T> {
	private BinarySearchTreeNode<K, T> root;

	public BinarySearchTree() {
		root = new BinarySearchTreeNode<K, T>();
	}

	public boolean isEmpty() {
		return this.root.isTerminal();
	}

	public int getHeight() {
		return this.root.getHeight();
	}

	public boolean insert(K key, T obj) {
		return insertRecursive(this.root, key, obj);
	}
	//public boolean remove(K key){ ... }
	//public T search(K key){ ... }

	public boolean insertRecursive(BinarySearchTreeNode<K, T> node,
		K key, T obj) {

		if (node.isTerminal()) {
			node.setKey(key);
			node.setObject(obj);

			node.setLeft(new BinarySearchTreeNode<K, T>());
			node.setRight(new BinarySearchTreeNode<K, T>());

			node.adjustHeight();

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
		System.out.printf("%d, %d, [%d, %d], %s, %s\n", node.getHeight(), node.getBalanceFactor(), node.getLeft().getHeight(), node.getRight().getHeight(), node.getObject(), obj);
			}
			if (Math.abs(node.getBalanceFactor()) > 1) {
		System.out.println(node.getBalanceFactor());
				this.balance(node);
			}
			return inseriu;
		}
	}
	
	public void balance(BinarySearchTreeNode<K, T> node) {
		System.out.println("q..");

		if (node.getLeft().getHeight() > node.getRight().getHeight()) {
			if (node.getLeft().getLeft().getHeight() >
				node.getLeft().getRight().getHeight()) {	

				this.rotateRight(node);
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

	// aqui 5 eh 'node', que depois do swap, vira 'old_node'

	//          5             3    ajeitar        3
	//         / \   swap    / \   pointeiros    / \
	//        3   C   ->    5   C     ->        A   5
	//       / \           / \                     / \
	//      A   B         A   B                   B   C

	private void rotateRight(BinarySearchTreeNode<K, T> node) {
		System.out.println("Ha..");

		node.swap(node.getLeft());
		BinarySearchTreeNode<K, T> old_node = node.getLeft();

		node.setLeft(old_node.getLeft());		// A
		old_node.setLeft(old_node.getRight());	// B
		old_node.setRight(node.getRight());		// C

		node.setRight(old_node);
	}

	public void print() {
		System.out.println(this.root);
	}
}
