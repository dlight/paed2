// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// Main: ponto de entrada

public class Main {
	static BinarySearchTree<Integer, Aluno> b;

	public static void add(int mat, String nome) {
		Integer m = new Integer(mat);
		b.insert(mat, new Aluno(mat, nome));
	}

	public static void print() {
		b.print();
	}

	public static void main(String args[]) {
		b = new BinarySearchTree<Integer, Aluno>();

		add(1, "Elias");
		add(2, "Paulo");

		print();
	}
}
