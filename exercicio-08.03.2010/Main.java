// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// Main: ponto de entrada

public class Main {
    public static void main(String args[]) {
	Aluno aluno1 = new Aluno(123, "Pedro");
	Aluno aluno2 = new Aluno(124, "Maria");

	BinarySearchTree b = new BinarySearchTree();

	b.insert("aluno3", new Aluno(1, "Pedro I"));
 	b.insert("aluno1", new Aluno(2, "Maria I"));
	b.insert("aluno5", new Aluno(3, "Maria II"));
 	b.insert("aluno0", new Aluno(4, "Pedro II"));
	b.insert("aluno4", new Aluno(5, "Maria III"));
 	b.insert("aluno6", new Aluno(6, "Pedro III"));
	b.insert("aluno2", new Aluno(7, "Maria IV"));
 	b.insert("aluno7", new Aluno(8, "Pedro IV"));
	b.insert("aluno9", new Aluno(9, "Maria V"));
 	b.insert("aluno8", new Aluno(10, "Pedro V"));
	

	System.out.println("\nCada aluno e' representado por chave:rg nome.\n" +
			   "Os alunos a seguir foram inseridos, na ordem dada:");
	b.search("aluno3").print();
	b.search("aluno1").print();
	b.search("aluno5").print();
	b.search("aluno0").print();
	b.search("aluno4").print();
	b.search("aluno6").print();
	b.search("aluno2").print();
	b.search("aluno7").print();
	b.search("aluno9").print();
	b.search("aluno8").print();
	

	System.out.println("\nA estrutura da arvore pode ser representada por\n\n" +
			   "  (raiz sub-arvore-esquerda sub-arvore-direita)\n\n" +
			   "onde . representa um no terminal.\n" +
			   "e (a . .) e' representado como a.\n" +
			   "A estrutura da arvore e':\n");

	b.print();

	b.remove("aluno0");
 	b.remove("aluno1");
	b.remove("aluno2");
 	b.remove("aluno3");
	b.remove("aluno4");

	System.out.println("\nForam removidos os alunos de 0 a 4.\n" +
			   "A estrutura dela agora e':\n");

	b.print();

	b.remove("aluno5");
 	b.remove("aluno6");
	b.remove("aluno7");
 	b.remove("aluno8");
	b.remove("aluno9");

	System.out.printf("\nForam removidos os alunos de 5 a 9.\n" +
			  "Testando se a arvore agora e' vazia:\n\n%s\n",
			  b.isEmpty() ? "Sim" : "Nao");
    }
}
