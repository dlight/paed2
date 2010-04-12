// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore AVL

// BinarySearchTree: Arvore AVL

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
	public boolean remove(K key) {
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

	private void
	doOnLeftmost(BinarySearchTreeNode<K, T> f, BinarySearchTreeNode<K, T> i) {
		if (i.isTerminal() || i.getLeft().isTerminal()) {

			// caso mais simples: sem rotacoes
			//
			//     20 (f)            30 (i)            30 (i)
			//    /  \      swap    /  \              /  \
			//  10    30 (i)  ->  10    20 (f)   -> 10    40
			//          \                \
			//          40                40

			f.swap(i);

			removeCases(i);
		}
		else {
		    doOnLeftmost(f, i.getLeft());
			i.adjustHeight();
			this.balance(i);
		}
	}

	private void removeCases(BinarySearchTreeNode<K, T> f) {
		if (f.getLeft().isTerminal() && f.getRight().isTerminal()) {
		    f.delete();
		}
		else if (f.getLeft().isTerminal() && !f.getRight().isTerminal()) {
			BinarySearchTreeNode<K, T> q = f.getRight();
			f.swap(q);
			f.setRight(q.getRight());
			f.setLeft(q.getLeft());

			f.adjustHeight();
			this.balance(f);
		}
		else if (!f.getLeft().isTerminal() && f.getRight().isTerminal()) {
			BinarySearchTreeNode<K, T> q = f.getLeft();
			f.swap(q);
			f.setRight(q.getRight());
			f.setLeft(q.getLeft());

			f.adjustHeight();
			this.balance(f);
		}
		else {
			doOnLeftmost(f, f.getRight());
			f.adjustHeight();
			this.balance(f);
		}
	}

	private boolean removeRecursive(BinarySearchTreeNode<K, T> f, K key) {
		if (f.isTerminal()) {
	    	return false;
		}

		int c = f.getKey().compareTo(key);

		if (c < 0) {
			boolean q = removeRecursive(f.getRight(), key);
			f.adjustHeight();
			this.balance(f);
			return q;
		}
		else if (c > 0) {
			boolean q = removeRecursive(f.getLeft(), key);
			f.adjustHeight();
			this.balance(f);
			return q;
		}
		else {
			removeCases(f);
			return true;
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
			}
			this.balance(node);
			return inseriu;
		}
	}
	
	public void balance(BinarySearchTreeNode<K, T> node) {
		if (Math.abs(node.getBalanceFactor()) <= 1) {
			return;
		}

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
    //
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
    //
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

	public void preOrdemRecursivo(BinarySearchTreeNode<K, T> n) {
		if (n.isTerminal())
			return;

		System.out.print(n.getKey() + " ");

		preOrdemRecursivo(n.getLeft());
		preOrdemRecursivo(n.getRight());
	}

	public void preOrdem() {
		preOrdemRecursivo(this.root);

		if (!this.root.isTerminal())
			System.out.println("");
	}

	public void posOrdemRecursivo(BinarySearchTreeNode<K, T> n) {
		if (n.isTerminal())
			return;

		posOrdemRecursivo(n.getLeft());
		posOrdemRecursivo(n.getRight());

		System.out.print(n.getKey() + " ");
	}

	public void posOrdem() {
		posOrdemRecursivo(this.root);

		if (!this.root.isTerminal())
			System.out.println("");
	}

	public void inOrdemRecursivo(BinarySearchTreeNode<K, T> n) {
		if (n.isTerminal())
			return;

		inOrdemRecursivo(n.getLeft());
		System.out.print(n.getKey() + " ");
		inOrdemRecursivo(n.getRight());
	}

	public void inOrdem() {
		inOrdemRecursivo(this.root);

		if (!this.root.isTerminal())
			System.out.println("");
	}
}
