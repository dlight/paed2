OBJS = BinarySearchTreeNode.java BinarySearchTree.java Aluno.class Main.class

all : $(OBJS)

run : all
	rlwrap java Main

%.class : %.java
	javac -source 1.6 $< # -o $@

#Main.class : Aluno.java BinarySearchTree.java BinarySearchTreeNode.java Main.java
#	javac $^

clean :
	rm *.class
