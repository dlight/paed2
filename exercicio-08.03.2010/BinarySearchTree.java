// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// BinarySearchTree: Implementa uma Arvore Binaria de Busca

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        root = new BinarySearchTreeNode();
    }

    public boolean isEmpty() {
        return root.isTerminal();
    }
    public boolean insert(String key, Aluno aluno) {
	return this.root.insert(key, aluno);
    }
    public boolean remove(String key) {
	return this.root.remove(key);
    }

    public Aluno search(String key) {
        return this.root.search(key);
    }

    public void print() {
	System.out.println(this.root.toString());
    }
}
