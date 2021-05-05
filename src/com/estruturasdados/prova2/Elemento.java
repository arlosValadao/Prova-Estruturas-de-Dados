package com.estruturasdados.prova2;


public class Elemento {
	private int valor;
	private Elemento pai;
	private Elemento esquerda;
	private Elemento direita;
	
	public Elemento(int novoValor) {
		this.valor = novoValor;
		this.esquerda = null;
		this.direita = null;
	}


	public Elemento getPai() {
		return pai;
	}

	public void setPai(Elemento pai) {
		this.pai = pai;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Elemento getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Elemento esquerda) {
		this.esquerda = esquerda;
	}

	public Elemento getDireita() {
		return direita;
	}

	public void setDireita(Elemento direita) {
		this.direita = direita;
	}
	
	
}
