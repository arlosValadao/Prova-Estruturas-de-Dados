package com.estruturasdados.prova2;

import java.util.Scanner;

import com.estruturasdados.prova2.arvoreavl.ArvoreAVL;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		/*
			Questao 1 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 1 - INICIO");
		System.out.print("Tamanho da fila: ");
		int size = entrada.nextInt();
		while(size > 20 || size < 8) {
			System.out.println("A fila deve ter um tamanho entre 8 e 20, inclusos!");
			System.out.print("Tamanho da fila: ");
			size = entrada.nextInt();
		}
		Queue fila = new Queue(size);
		fila.add_random();
		System.out.println("\t\t\t QUESTAO 1 - FIM\n\n\n");
		/*
			Questao 1 - fim
		*/
		

		
		/*
			Questao 2 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 2 - INICIO");
		Arvore tree = new Arvore();
		//Adicionando os elementos da fila na arvore
		while (fila.peek() != null) {
			tree.adicionar((int) fila.remove());
		}

		// Imprimindo a arvore em ordem
		System.out.println("-- Percurso em ordem -- \n");
		tree.emOrdemP(tree.getRaiz());
		System.out.println("\t\t\t QUESTAO 2 - FIM\n\n\n");
		/*
			Questao 2 - fim
		*/
		


		/*
			Questao 3 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 3 - INICIO");
		int vetorQuestao3[] = new int[size];
		Queue queue = new Queue(size);
		queue = tree.preOrdem(tree.getRaiz(), queue);
		for(int i=0;i<size;i++) {
			vetorQuestao3[i] = (int) queue.remove();
		}

		//Imprimindo vetorQuestao3 desordenado
		System.out.println("vetorQuestao3 desordenado:");
		System.out.println();
		for(int i=0; i < vetorQuestao3.length; i++) {
			System.out.println(vetorQuestao3[i]);
		}

		//Ordenando o vetor com o quick sort
		quickSort(vetorQuestao3, 0, size-1);

		//Imprimindo o vetorQuestao3 ordenado
		System.out.println("vetorQuestao3 ordenado:");
		for(int i=0; i < vetorQuestao3.length; i++) {
			System.out.println(vetorQuestao3[i]);
		}

		System.out.println("\t\t\t QUESTAO 3 - FIM\n\n\n");
		/*
			Questao 3 - fim
		*/



		/*
			Questao 4 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 4 - INICIO");
		Arvore arvorE = new Arvore();
		arvorE.adicionar(10);
		arvorE.adicionar(3);
		arvorE.adicionar(6);
		arvorE.adicionar(12);
		arvorE.adicionar(1);
		arvorE.adicionar(15);
		System.out.println("Multiplos de 3:");
		arvorE.removerMultiplosDe3();

		//Imprimindo a árvore em ordem, apos as remocoes
		System.out.println("Arvore no percurso em ordem após remover os multiplos de 3:");
		arvorE.percusoEmOrdem(arvorE.getRaiz());

		System.out.println("\t\t\t QUESTAO 4 - FIM\n\n\n");
		/*
			Questao 4 - fim
		*/

		

		/*
			Questao 5 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 5 - INICIO");
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
		
			System.out.println("\t\t\t QUESTAO 5 - FIM\n\n\n");
		/*
			Questao 5 - fim
		*/



		/*
			Questao 6 - inicio
		*/
		System.out.println("\t\t\t QUESTAO 6 - INICIO");
		//Imprimindo a arvore em pre ordem
		System.out.println("Arvore NAO AVL em pre ordem:");
		tree.percusoPreOrdem(tree.getRaiz());

		//Adicionando os elementos em pre ordem num vetor
		int vetorQuestao6[] = new int[size];
		Queue queueQuestao6 = new Queue(size);

		//Transferindo o conteudo da arvore para a fila queueQuestao6
		queueQuestao6 = tree.preOrdem(tree.getRaiz(), queueQuestao6);
		//Transferindo o conteudo da fila para o vetor vetorQuestao6
		for(int i=0;i<size;i++) {
			vetorQuestao6[i] = (int) queueQuestao6.remove();
		}

		//Adicionando os elementos do vetor na arvore AVL
		ArvoreAVL minhaArvoreAVL = new ArvoreAVL();
		for(int i = 0; i < vetorQuestao6.length; i++)
			minhaArvoreAVL.adicionar(vetorQuestao6[i]);

		// Imprimindo a arvore AVL resultante em pre ordem
		System.out.println("Arvore AVL em pre ordem:");
		minhaArvoreAVL.percursoPreOrdem();

		// Imprimindo a quantidade total de cada tipo de rotacao feita durante
		// o balanceamento apos cada insercao
		System.out.println("Quantidade de rotacoes realizadas");
		System.out.println(minhaArvoreAVL.qtdRotacaoDireita + " a direita");
		System.out.println(minhaArvoreAVL.qtdRotacaoEsquerda + " a esquerda");
		System.out.println(minhaArvoreAVL.qtdRotacaoDireitaEsquerda + " direita-esquerda");
		System.out.println(minhaArvoreAVL.qtdRotacaoEsquerdaDireita + " esquerda-direta");

		System.out.println("\t\t\t QUESTAO 6 - FIM\n\n\n");
		/*
			Questao 6 - fim
		*/


	}// Fim de main

	
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

	
}// Fim da classe Main
