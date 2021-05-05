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
		
		Arvore tree = new Arvore();
		while (fila.peek() != null) {
			tree.adicionar((int) fila.remove());
		}
		
		System.out.println("-- Percurso em ordem -- \n");
		tree.emOrdemP(tree.getRaiz());
		
		
		
		int vetorq3[] = new int[size];
		Queue queue = new Queue(size);
		queue = tree.preOrdem(tree.getRaiz(), queue);
		for(int i=0;i<size;i++) {
			vetorq3[i] = (int) queue.remove();
		}
		
		quickSort(vetorq3, 0, size-1);
		
		System.out.println("Vetor q 3:");
		for(int i=0;i<size;i++) {
			System.out.println(vetorq3[i]);
		}

	}
	
	public static void quickSort(int[] dataset, int i, int j) {
		if (i < j) {
			int l = i;
			int p = j;
			int r = j - 1;
			while (l <= r) {
				while (l <= r && dataset[l] < dataset[p])
					l++;
				while (l <= r && dataset[r] > dataset[p])
					r--;
				if (l <= r) {
					swap(dataset, l, r);
					l++;
					r--;
				}
			}
			swap(dataset, l, p);
			quickSort(dataset, i, l - 1);
			quickSort(dataset, l + 1, j);
		}
	}
	
	private static void swap(int[] vetor, int x, int y) {
		int aux = vetor[x];
		vetor[x] = vetor[y];
		vetor[y] = aux;
	}
	
}
