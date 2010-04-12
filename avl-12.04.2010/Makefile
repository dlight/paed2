OBJS = Main.class Aluno.class BinarySearchTree.class BinarySearchTreeNode.class

all : $(OBJS)

run : all
	rlwrap java Main

%.class : %.java
	javac $< # -o $@

#Main.class : Aluno.java BinarySearchTree.java BinarySearchTreeNode.java Main.java
#	javac $^

clean :
	rm *.class
