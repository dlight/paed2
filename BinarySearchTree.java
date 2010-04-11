public class BinarySearchTree<K extends Comparable<K>, T> {
    public bool insertRecursive(BinarySearchTreeNode<K, T> node, key, T obj) {
	if (key.compareTo(node.getKey()) == 0) {
	    return false;
	}
	else {
	    boolean inseriu = false;
	    if (key.compareTo(node.getKey()) < 0) {
		inseriu = this.insertRecursive(node.getLeft(), key, obj);
	    } else if (key.compareTo(node.getKey()) > 0) {
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