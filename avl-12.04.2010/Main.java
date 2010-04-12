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

	public static void print() {
		b.print();
	}

	public static void check_empty() {
		out.println(b.isEmpty() ?
			"A arvore esta vazia." :
			"A arvore nao esta vazia.");
	}

	public static void init() {
		b = new BinarySearchTree<Integer, Aluno>();

		stdin = new BufferedReader (new InputStreamReader(System.in));

		out.print("Bem vindo a implementacao de Elias da Arvore AVL.\n\n");

		out.print("Este interpretador possui diversos comandos.\n");
		out.print("Digite help para ve-los.\n\n");

		check_empty();
	}

	public static void show_help() {
		out.print("Os comandos disponiveis sao:\n\n" +
			"add chave obj\t\tAdiciona algo a arvore.\n" +
			"empty\t\t\tCheca se a arvore esta vazia.\n" +
			"exit\t\t\tSai do interpretador.\n" +
			"help\t\t\tEste comando :P\n" +
			"print\t\t\tImprime a arvore.\n");
	}

	public static void exit() throws IOException {
		throw new IOException();
	}

	//public static void insert(StringTokenizer input) {
	//	
	//}

	public static void insert(int mat, String nome) {
		Integer m = new Integer(mat);
		b.insert(mat, new Aluno(mat, nome));
	}

	public static int read_int(String s) {
        try {
			return Integer.parseInt(s);
        }
		catch (NumberFormatException e) {
			return -1;
		}
	}

	public static void add(StringTokenizer input) {
		if (input.countTokens() < 2) {
			out.println("Entrada invalida.");
			return;
		}

		int key = read_int(input.nextToken());
		String obj = input.nextToken();

		if (key < 0) {
			out.println("Entrada invalida.");
			return;
		}

		insert(key, obj);
		print();
	}

	public static void read() throws IOException {
		out.print("> ");
		out.flush();

		String line = stdin.readLine();

		if (line == null) {
			out.println("");
			throw new IOException();
		}

		StringTokenizer input = new StringTokenizer(line);

		if (!input.hasMoreTokens())
			return;

		String cmd = input.nextToken();

		if (cmd.equals("help"))
			show_help();
		else if (cmd.equals("exit"))
			exit();
		else if (cmd.equals("empty"))
			check_empty();
		else if (cmd.equals("print"))
			print();
		else if (cmd.equals("add") || cmd.equals("a"))
			add(input);
		else
			out.println(cmd + ": comando invalido.");
	}

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
}
