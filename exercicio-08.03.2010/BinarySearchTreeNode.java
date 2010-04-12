// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// BinarySearchTreeNode: no' de uma ABB

public class BinarySearchTreeNode {
    private String key;
    private Aluno aluno;
    private BinarySearchTreeNode right;
    private BinarySearchTreeNode left;

    private void terminalInsert(String key, Aluno aluno) {
	    this.key = key;
	    this.aluno = aluno;
	    this.left = new BinarySearchTreeNode();
	    this.right = new BinarySearchTreeNode();
    }

    private BinarySearchTreeNode nodeSearch(String key) {
        if (this.isTerminal() || this.key.equals(key))
            return this;
        else if (this.key.compareTo(key) < 0)
            return this.left.nodeSearch(key);
        else
            return this.right.nodeSearch(key);
    }

    public BinarySearchTreeNode(String key, Aluno aluno) {
	this.terminalInsert(key, aluno);
    }
    public BinarySearchTreeNode() {
	this.right = null;

	this.left = null;
    }

    public boolean isTerminal() {
	return (this.left == null && this.right == null);
    }

    public String getKey() {
	return this.key;
    }
    public Aluno getAluno() {
	return this.aluno;
    }
    public BinarySearchTreeNode getRight() {
        return this.right;
    }
    public BinarySearchTreeNode getLeft() {
	return this.left;
    }

    public boolean insert(String key, Aluno aluno) {
	BinarySearchTreeNode f = this.nodeSearch(key);

	if (! f.isTerminal()) {
	    return false;
	}
	else {
	    f.terminalInsert(key, aluno);
	    return true;
	}
    }

    private void copy(BinarySearchTreeNode n) {
	this.terminalInsert(n.getKey(), n.getAluno());
	this.left = n.getLeft();
	this.right = n.getRight();
    }

    private BinarySearchTreeNode findLeftmost() {
	if (this.isTerminal() || this.left.isTerminal())
	    return this;
	else
	    return this.left.findLeftmost();
    }

    public boolean remove(String key) {
	BinarySearchTreeNode f = this.nodeSearch(key);
    
	if (f.isTerminal()) {
	    return false;
	}
	if (f.left.isTerminal() && f.right.isTerminal()) {
	    f.key = null;
	    f.aluno = null;
	    f.left = null;
	    f.right = null;
	}
	else if (f.left.isTerminal() && !f.right.isTerminal()) {
	    f.copy(f.right);
	}
	else if (!f.left.isTerminal() && f.right.isTerminal()) {
	    f.copy(f.left);
	}
	else {
	    BinarySearchTreeNode q = f.right.findLeftmost();
	    f.key = q.getKey();
	    f.aluno = q.getAluno();

	    q.left = null;
	    q.right = null;
	}

	return true;
    }

    public Aluno search(String key) {
	BinarySearchTreeNode n = this.nodeSearch(key);

	if (n.isTerminal()) {
	    return null;
	}
	else {
	    return n.getAluno();
	}
    }

    private static String spaces(int level) {
	String c = "";
	for (int i = 0; i < level; i++)
	    c += "    ";
	return c;
    }

    private String toString_level(int level) {
	String s = BinarySearchTreeNode.spaces(level);

    	if (this.isTerminal())
    	    return ".";
	else if (this.left.isTerminal() && this.right.isTerminal())
	    return String.format("%s:%s",
				 this.getKey(),
				 this.aluno.toString());
   	else
    	    return String.format("(%s:%s\n%s%s\n%s%s)",
				 this.getKey(),
				 this.aluno.toString(),
				 s,
				 this.left.toString_level(level+1),
				 s,
				 this.right.toString_level(level+1));
    }

    public String toString() {
	return this.toString_level(1);
    }
}
