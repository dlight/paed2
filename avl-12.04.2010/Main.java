// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// Main: ponto de entrada

import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Main {
	static BinarySearchTree<Integer, Aluno> b;
	static BufferedReader stdin;
	static String input_str;
	static StringTokenizer input;

	public static void main(String args[]) {
		init();

		try {
			while (true)
				read();
		}
		catch (IOException e) {
			return;
		}
	}

	public static void init() {
		b = new BinarySearchTree<Integer, Aluno>();

		stdin = new BufferedReader (new InputStreamReader(System.in));

		out.println("Universidade Federal do Rio Grande do Norte");
		out.println("Departamento de Informatica e Matematica Aplicada");
		out.println("DIM0111.1 - Pratica de Algoritmos e Estruturas de " +
			"Dados II");
		out.println("Implementacao de Arvore AVL - periodo 2010.1\n");

		out.println("Este programa foi feito por " +
			"Elias Gabriel Amaral da Silva.\n");

		out.println("Digite help.\n");

		check_empty();
	}

	public static void read() throws IOException {
		out.print("> ");
		out.flush();

		String line = stdin.readLine();

		if (line == null) {
			out.println("");
			throw new IOException();
		}

		String[] lines = line.split(";");

		for (int i = 0; i < lines.length; i++) { 
			if (i > 0)
				out.println("");
			command(lines[i]);
		}
	}


	public static void command(String line) throws IOException {
		StringTokenizer input = new StringTokenizer(line);

		if (!input.hasMoreTokens())
			return;

		String cmd = input.nextToken();

		if (cmd.equals("add") || cmd.equals("a"))
			add(input);
		else if (cmd.equals("empty"))
			check_empty();
		else if (cmd.equals("exit"))
			exit();
		else if (cmd.equals("help"))
			show_help();
		else if (cmd.equals("search"))
			search(input);
		else if (cmd.equals("inordem"))
			b.inOrdem();
		else if (cmd.equals("posordem"))
			b.posOrdem();
		else if (cmd.equals("preordem"))
			b.preOrdem();
		else if (cmd.equals("print"))
			b.print();
		else if (cmd.equals("rem") || cmd.equals("r"))
			rem(input);
		else if (cmd.equals("reset"))
			reset();
		else if (cmd.equals("tests"))
			show_tests();
		else
			out.println(cmd + ": comando invalido.");
	}

	public static void show_help() {
		out.println("Os comandos disponiveis sao:\n\n" +
			"add chave obj\tAdiciona algo a arvore.\n" +
			"empty\t\tCheca se a arvore esta vazia.\n" +
			"exit\t\tSai do interpretador.\n" +
			"help\t\tEste comando :P\n" +
			"inordem\tExibe as chaves em in-ordem.\n" +
			"posordem\tExibe as chaves em pos-ordem.\n" +
			"preordem\tExibe as chaves em pre-ordem.\n" +
			"print\t\tExibe uma representacao da arvore.\n" +
			"rem chave\tRemove uma chave da arvore.\n" +
			"reset\t\tApaga a arvore.\n" +
			"search chave\tBusca uma chave na arvore.\n" +
			"tests\t\tExibe comandos de teste.\n");

		out.println("Comandos em uma mesma linha sao separados com ;");
		out.println("add e rem podem ser abreviados como a e r.\n\n");

		out.println("Uma arvore vazia eh exibida como \".\", e uma arvore " +
			"nao-vazia como:\n");

		out.println("\t(raiz sub-arvore-esquerda sub-arvore-direita)\n");

		out.println("(raiz . .) eh exibido como raiz. Cada no' eh exibido " +
			"como:\n");

		out.println("\tchave: dados [altura balanco]\n");

		out.println("Onde a chave e' um numero " +
			"inteiro nao-negativo (uma matricula), e os dados");
		out.println("armazenados sao referentes a um aluno.");
	}

	public static void show_tests() {
		out.println("Insercoes, 1 rotacao direita, 2 esquerdas:\n" +
				"\ta 3; a 2; a 1; a 4; a 5; a 6\n");

		out.println("Insercoes, rotacao dupla esquerda:\n" +
					"\ta 1; a 3; a 2\n" +
					"\ta 5; a 1; a 6; a 9; a 8\n");

		out.println("Insercoes, rotacao dupla direita:\n" +
					"\ta 3; a 1; a 2\n");

		out.println("Insercoes com rotacoes, remocao sem rotacao:\n" +
					"\ta 30; a 20; a 10; a 25; a 40; a 35; r 30\n");

		out.println("Remocao da raiz com 2 filhos, rotacao esquerda:\n" +
					"\ta 5; a 3; a 8; a 2; a 7; a 9; a 10; r 5\n");

		out.println("Remocao de uma folha, rotacao esquerda:\n" +
					"\ta 3; a 1; a 4; a 5; r 1\n" +
					"\ta 32; a 16; a 48; a 8; a 24; a 40; a 56; a 4; a 36; " +
					"a 44; a 52; a 60;\n" +
					"\t\ta 58; a 62; r 4\n");

		out.println("Remocao de uma folha, rotacao direita:\n" +
					"\ta 4; a 3; a 5; a 1; r 5\n");

		out.println("Remocao de uma folha, duas rotacoes esquerdas:\n" +
					"\ta 5; a 2; a 8; a 1; a 3; a 6; a 10; a 4; a 7; a 9; " +
					"a 11; a 12; r 1\n");

		out.println("Remocao de um no interno, uma rotacao esquerda:\n" +
					"\ta 5; a 2; a 8; a 1; a 3; a 6; a 10; a 4; a 7; a 9; " +
					"a 11; a 12; r 6\n");

		out.println("Remocao de uma folha, com 3 rotacoes direitas:\n" +
					"\ta 20; a 12; a 28; a 7; a 17; a 25; a 31; a 4; a 10; " +
					"a 15; a 19; a 23;\n" +
					"\t\ta 27; a 30; a 32; a 2; a 6; a 9; a 11; a 14; a 16; " +
					"a 18; a 22;\n" +
					"\t\ta 24; a 26; a 29; a 1; a 3; a 5; a 8; a 13; a 21; " +
					"a 0; a 32;\n" +
					"\t\tr 32");
	}

	public static void check_empty() {
		out.println(b.isEmpty() ?
			"A arvore esta vazia." :
			"A arvore nao esta vazia.");
	}

	public static void reset() {
		b = new BinarySearchTree<Integer, Aluno>();
		check_empty();
	}

	public static void exit() throws IOException {
		throw new IOException();
	}

	public static void insert(int mat, String nome) {
		out.printf("Elemento %d inserido:\n\n", mat);

		Integer m = new Integer(mat);
		b.insert(mat, new Aluno(mat, nome));
	}

	private static int read_int(String s) {
        try {
			return Integer.parseInt(s);
        }
		catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void entrada_invalida() {
			out.println("Entrada invalida.");
	}

	public static void add(StringTokenizer input) {
		if (! input.hasMoreTokens()) {
			entrada_invalida();
			return;
		}

		int key = read_int(input.nextToken());
		String obj = input.hasMoreTokens() ? input.nextToken() : "nome";

		if (key < 0) {
			entrada_invalida();
			return;
		}

		insert(key, obj);
		b.print();
	}

	public static void search(StringTokenizer input) {
		if (! input.hasMoreTokens()) {
			entrada_invalida();
			return;
		}

		int key = read_int(input.nextToken());
		if (key < 0) {
			entrada_invalida();
			return;
		}

		Aluno a = b.search(key);

		out.println(a == null ? "Nao encontrado." : a);
	}

	public static void rem(StringTokenizer input) {
		if (! input.hasMoreTokens()) {
			entrada_invalida();
			return;
		}

		int key = read_int(input.nextToken());
		if (key < 0) {
			entrada_invalida();
			return;
		}

		if (b.remove(key)) {
			out.printf("Elemento %d removido:\n\n", key);
			b.print();
		}
		else {
			out.println("Nao encontrado.");
		}
	}
		
}
