// Tarefa 1 de PAED II 2010.1 - Turma 5 - UFRN
// Elias Gabriel Amaral da Silva (matricula: 200619853)

// Parte de um programa que implementa e testa uma
// Arvore Binaria de Busca

// Aluno: dados armazenados na arvore

public class Aluno {
    private int rg;
    private String nome;

    public Aluno() {
        this.rg = 0;
        this.nome = "aaa";
    }

    public Aluno(int rg, String nome) {
        this.rg = rg;
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
	return String.format("%s %s", this.getRg(), this.getNome());
    }

    public void print() {
	System.out.println(this.toString());
    }
}
