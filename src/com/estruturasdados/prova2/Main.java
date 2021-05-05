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

		//Beginning question 1
		System.out.print("Tamanho da fila: ");
		int size = scanner.nextInt();
		Queue fila = new Queue(size);
		fila.add_random();
		//End question 1
		
		//Beginning question 2
		Arvore tree = new Arvore();
		while (fila.peek() != null) {
			tree.adicionar((int) fila.remove());
		}
		
		System.out.println("-- Percurso em ordem -- \n");
		tree.emOrdemP(tree.getRaiz());
		//End question 2
		
		//Beginning question 3
		int vetorq3[] = new int[size];
		Queue queue = new Queue(size);
		queue = tree.preOrdem(tree.getRaiz(), queue);
		for(int i=0;i<size;i++) {
			vetorq3[i] = (int) queue.remove();
		}
		
		quickSort(vetorq3, 0, size-1);
		
		System.out.println("Vetor q 3 ordenado:");
		for(int i=0;i<size;i++) {
			System.out.println(vetorq3[i]);
		}
		//End question 3
		System.out.println("\n\n\n");
		Arvore minhaArvore = new Arvore();
		// Arvore cuja os nos 50 e 70 estao desbalanceados
		minhaArvore.adicionar(20);			
		minhaArvore.adicionar(10);			
		minhaArvore.adicionar(5);			
		minhaArvore.adicionar(0);
		minhaArvore.adicionar(6);
		minhaArvore.adicionar(11);
		minhaArvore.adicionar(50);
		minhaArvore.adicionar(70);
		minhaArvore.adicionar(80);
		minhaArvore.adicionar(90);

		//Verificando se avore e AVL
		if(isAVL(minhaArvore.getRaiz()))
			System.out.println("A arvore e uma AVL");
		else
			System.out.println("A arvore NAO e uma AVL");

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
	
	// Calcula altura de um determinado no
		private static int getAltura(Elemento atual) {
	        if(atual==null) {
	            return-1;
	        }
	        else {
	            return 1 + Math.max(getAltura(atual.getEsquerda()),getAltura(atual.getDireita()));
	        }
	    }
	
	// Retorna tre caso a arvore atendas os requisitos de uma arvore AVL
		// e imprime na tela os nos desbalanceados e retorna false caso contrário.
		public static boolean isAVL(Elemento atual) {
	        if(atual != null) {
				// Calculando o fator de balanceamento
	            int FB = getAltura(atual.getEsquerda()) - getAltura(atual.getDireita());
				// Caso o fator de balanceamento(FB) esteja entre -1 e 1, inclusos
	            if(FB >= -1 && FB <= 1) {
	                return true && isAVL(atual.getEsquerda()) && isAVL(atual.getDireita());
	            }
				// Caso o fator de balanceamento não esteja entre -1 e 1, inclusos
	            else {
					System.out.println("O no" + " { " + atual.getValor() + " } " + "esta desbalanceado");
	                return isAVL(atual.getEsquerda()) && isAVL(atual.getDireita()) && false;
				}
	        }
	        return true;
	    }
	
}
