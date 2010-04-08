
public class BinarySearchTreeNode<K extends Comparable<K>, T> {
    private K key;
    private T object;
    private BinarySearchTreeNode<K, T> right;
    private BinarySearchTreeNode<K, T> left;
    private int height;
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
}