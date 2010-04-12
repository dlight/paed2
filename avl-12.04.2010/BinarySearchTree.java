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
		//System.out.println("\nInserindo " + obj);

		return insertRecursive(this.root, key, obj);
	}
	public boolean remove(K key){
		return removeRecursive(this.root, key);
	}

	public T search(K key) {
		return searchRecursive(this.root, key);
	}

	private T searchRecursive(BinarySearchTreeNode<K, T> node, K key) {
 		if (node.isTerminal())
			return null;

		int c = node.getKey().compareTo(key);

		if (c == 0)
			return node.getObject();
		else if (c < 0)
			return searchRecursive(node.getRight(), key);
		else
			return searchRecursive(node.getLeft(), key);
	}

	private BinarySearchTreeNode<K, T>
	findLeftmost(BinarySearchTreeNode<K, T> n) {
		if (n.isTerminal() || n.left.isTerminal())
		    return n;
		else
		    return n.left.findLeftmost();
	}

	private boolean removeRecursive(BinarySearchTreeNode<K, T> f, K key) {
		if (f.isTerminal()) {
	    	return false;
		}

		if (f.left.isTerminal() && f.right.isTerminal()) {
		    f.key = null;
		    f.aluno = null;
		    f.left = null;
		    f.right = null;
		}
		else if (f.getLeft.isTerminal() && !f.getRight.isTerminal()) {
			f.swap(f.getLeft());
			f.setLeft = new BinarySearchTreeNode<K, T>();
		}
		else if (!f.getLeft.isTerminal() && f.getRight.isTerminal()) {
			f.swap(f.getRight());
			f.setRight = new BinarySearchTreeNode<K, T>();
		}
		else {
			BinarySearchTreeNode<K, T> q = f.right.findLeftmost();
			f.key = q.getKey();
			f.aluno = q.getAluno();

			q.left = null;
			q.right = null;
		}
	}

	private boolean insertRecursive(BinarySearchTreeNode<K, T> node,
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
		//System.out.printf("\t%d, %d, [%d, %d], %s\n", node.getHeight(), node.getBalanceFactor(), node.getLeft().getHeight(), node.getRight().getHeight(), node.getObject());
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

	// aqui 5 inicialmente eh 'node'. depois do swap, vira 'old_node'
	// 3 eh o 'pivo', que ira virar 'node' depois do swap

	// node 5               node 3      ajeitar       3 node
	//     / \   swap           / \    pointeiros    / \
	//    3   C   ->  old_node 5   C       ->       A   5 old_node
	//   / \                  / \                      / \
	//  A   B                A   B                    B   C

	private void rotateRight(BinarySearchTreeNode<K, T> node) {
		System.out.println("Efetuando rotacao direita..\n");

		node.swap(node.getLeft());
		BinarySearchTreeNode<K, T> old_node = node.getLeft();

		node.setLeft(old_node.getLeft());		// A
		old_node.setLeft(old_node.getRight());	// B
		old_node.setRight(node.getRight());		// C

		node.setRight(old_node);

		old_node.adjustHeight();
		node.adjustHeight();
	}

	// aqui 3 inicialmente eh 'node'. depois do swap, vira 'old_node'
	// 5 eh o 'pivo', que ira virar 'node' depois do swap

	//    3 node          5 node         ajeitar          node 5
	//   / \     swap    / \            pointeiros            / \
	//  A   5     ->    A   3 old_node      ->      old_node 3   C
	//     / \             / \                              / \
	//    B   C           B   C                            A   B

	private void rotateLeft(BinarySearchTreeNode<K, T> node) {
		System.out.println("Efetuando rotacao esquerda..\n");

		node.swap(node.getRight());
		BinarySearchTreeNode<K, T> old_node = node.getRight();

		node.setRight(old_node.getRight());		// C
		old_node.setRight(old_node.getLeft());	// B
		old_node.setLeft(node.getLeft());		// A

		node.setLeft(old_node);

		old_node.adjustHeight();
		node.adjustHeight();
	}

	private void rotateDoubleLeft(BinarySearchTreeNode<K, T> node) {
		rotateRight(node.getRight());
		rotateLeft(node);
	}

	private void rotateDoubleRight(BinarySearchTreeNode<K, T> node) {
		rotateLeft(node.getLeft());
		rotateRight(node);
	}

	public void print() {
		System.out.println(this.root);
	}
}
