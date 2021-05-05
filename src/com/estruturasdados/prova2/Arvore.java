package com.estruturasdados.prova2;

public class Arvore {
	private Elemento raiz;

	public Arvore() {
		this.raiz = null;
	}

	public Elemento getRaiz() {
		return raiz;
	}

	public Elemento encontrar(int key) {
		Elemento atual = raiz;
		while (atual.getValor() != key) {
			if (key < atual.getValor()) {
				atual = atual.getEsquerda();
			} else {
				atual = atual.getDireita();
			}
			if (atual == null) {
				return null;
			}
		}
		return atual;
	}

	public void adicionar(int valor) {
		Elemento novoElemento = new Elemento(valor);
		if (this.raiz == null) {
			this.raiz = novoElemento;
		} else {
			Elemento atual = raiz;
			while (true) {
				if (novoElemento.getValor() < atual.getValor()) {
					if (atual.getEsquerda() != null) {
						atual = atual.getEsquerda();
					} else {
						atual.setEsquerda(novoElemento);
						break;
					}
				} else {
					if (atual.getDireita() != null) {
						atual = atual.getDireita();
					} else {
						atual.setDireita(novoElemento);
						break;
					}
				}
			}
		}
	}

	public void emOrdemP(Elemento atual) {
		if (atual != null) {
			emOrdemP(atual.getEsquerda());
			System.out.println(atual.getValor());
			emOrdemP(atual.getDireita());
		}

	}
}