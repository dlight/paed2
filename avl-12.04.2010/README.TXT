Uversidade Federal do Rio Grande do Norte
Departamento de Informatica e Matematica Aplicada
DIM0111.1 - Pratica de Algoritmos e Estruturas de Dados II
Implementacao de Arvore AVL - periodo 2010.1

Este programa foi feito por Elias Gabriel Amaral da Silva, como tarefa da
turma 5 da disciplina PAED 2, ministrada por Marcia Jacyntha Nunes Rodrigues
Lucena

Este programa eh um pequeno interpretador, que aceita comandos que operam sob
uma arvore avl. Ele aceita comandos de insercao, remocao, busca, varias formas
de impressao: pre-ordem, pos-ordem, in-ordem, e uma representacao atraves de
Expressoes-S, mostrada automaticamente a cada modificacao. Expressoes-S posuem
uma estrutura semelhante ao xml[1], porem sao mais compactas.

O interpretador em si nao faz parte da tarefa pedida, mas somente a
implementacao da Arvore AVL. Mas um interpretador torna mais dinamico o
processo de teste do software, facilitando o trabalho de testar partes
independentes do codigo. Isso da melhores garantias de que todas as operacoes
serao realizadas de forma correta, e que a arvore mantera as invariantes da
Arvore AVL.

O programa acompanha um Makefile, para facilitar a sua compilacao. Em um
terminal, o comando make compila todos os arquivos necessarios, enquanto o
comando make run executa o programa. (E' necessario ter o make instalado;
sistemas como o Ubuntu possuem o make instalado por padrao. No caso do windows,
pode-se compilar manualmente os programas terminados em .java, e executar a
classe Main, ou instalar o programa Cygwin)

Se o programa rlwrap estiver instalado, o interpretador ganha capacidades de
edicao, o que permite utilizar as setas para cima e baixo para navegar no
historico de comandos, e as setas laterais para corrigir algo digitado
anteriormente, etc)

Ao entrar no interpretador, pode-se digitar o comando help (e apertar enter),
para saber quais sao os comandos disponiveis. Usa-se o comando add para inserir
elementos na arvore; Digita-se add matricula nome, para adicionar alguem de
certa matricula, e com certo nome. Ao se omitir o nome, usa-se um nome padrao.
Outros comandos podem ser consultados no help.

[1] A arvore com as seguintes chaves (e outros dados iguais a "nome")

        1
       / \
      0   3
         / \
        2   4

E' representada pelo programa como:

(1: nome [3 -1]
	0: nome [1 0]
	(3: nome [2 0]
		2: nome [1 0]
		4: nome [1 0]))

O equivalente em XML disso poderia ser, por exemplo:

<no chave='1' altura='3' balanco='-1'>
  <dados>nome</dados>
  <filho pos='esquerdo'>
    <no chave='0' altura='1' balanco='0'><dados>nome</dados></no>
  </filho>
  <filho pos='direito'>
    <no chave='3' altura='2' balanco='0'>
      <dados>nome</dados>
      <filho pos='esquerdo'>
        <no chave='2' altura='1' balanco='0'><dados>nome</dados></no>
      </filho>
      <filho pos='direito'>
        <no chave='4' altura='1' balanco='0'><dados>nome</dados></no>
      </filho>
    </no>
  </filho>
</no>

Pode-se construir essa arvore, dentro do programa, digitando:

a 1; a 0; a 3; a 2; a 4

(Os ; separam comandos; a eh uma abreviacao de add. O comando tests possui
outros exemplos)
