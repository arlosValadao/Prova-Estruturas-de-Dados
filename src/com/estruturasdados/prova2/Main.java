package com.estruturasdados.prova2;

import java.util.Scanner;

public class Main {
	/*
	 * Questão 1: Main.java = line x - y | Queue.java = x1 - y1 Questão 2: Main.java
	 * = line x2 - y2
	 * 
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Tamanho da fila: ");
		int size = scanner.nextInt();
		Queue fila = new Queue(size);
		fila.add_random();
		add_tree(fila);

	}

	public static void add_tree(Queue queue) {
		// Instancia um objeto da classe arvore
		Arvore tree = new Arvore();
		// Enquanto o primeiro elemento da fila não for vazio
		// um elemento da fila será removido e adicionado na árvore
		while (queue.peek() != null) {
			tree.adicionar((int) queue.remove());
		}
		System.out.println("-- Percurso em ordem -- \n");
		tree.emOrdemP(tree.getRaiz());
	}
}
