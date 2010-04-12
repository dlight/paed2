// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// Aluno: dados armazenados na arvore

public class Aluno {
	private int matricula;
	private String nome;

	public Aluno() {
		this.matricula = 0;
		this.nome = "aaa";
	}

	public Aluno(int matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	public int getmatricula() {
		return matricula;
	}

	public void setmatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return String.format("%s: %s", this.getmatricula(), this.getNome());
	}

	public void print() {
		System.out.println(this.toString());
	}
}
