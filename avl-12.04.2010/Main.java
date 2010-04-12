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

	public static void command(String line) throws IOException {
		StringTokenizer input = new StringTokenizer(line);

		if (!input.hasMoreTokens())
			return;

		String cmd = input.nextToken();

		if (cmd.equals("add") || cmd.equals("a"))
			add(input);
		else if (cmd.equals("clear"))
			clear();
		else if (cmd.equals("empty"))
			check_empty();
		else if (cmd.equals("exit"))
			exit();
		else if (cmd.equals("help"))
			show_help();
		else if (cmd.equals("rem") || cmd.equals("r"))
			rem(input);
		else if (cmd.equals("search"))
			search(input);
		else if (cmd.equals("print"))
			b.print();
		else
			out.println(cmd + ": comando invalido.");
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

	public static void show_help() {
		out.println("Os comandos disponiveis sao:\n\n" +
			"add chave obj\tAdiciona algo a arvore.\n" +
			"clear\t\tApaga a arvore.\n" +
			"empty\t\tCheca se a arvore esta vazia.\n" +
			"exit\t\tSai do interpretador.\n" +
			"help\t\tEste comando :P\n" +
			"rem chave\tRemove uma chave da arvore.\n" +
			"search chave\tBusca uma chave na arvore.\n" +
			"print\t\tExibe uma representacao da arvore.\n");

		out.println("Comandos em uma mesma linha sao separados com ;\n");

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

	public static void check_empty() {
		out.println(b.isEmpty() ?
			"A arvore esta vazia." :
			"A arvore nao esta vazia.");
	}

	public static void clear() {
		b = new BinarySearchTree<Integer, Aluno>();
		check_empty();
	}

	public static void exit() throws IOException {
		throw new IOException();
	}

	//public static void insert(StringTokenizer input) {
	//	
	//}

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
