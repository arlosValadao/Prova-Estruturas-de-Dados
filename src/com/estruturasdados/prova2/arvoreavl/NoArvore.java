package com.estruturasdados.prova2.arvoreavl;

public class NoArvore {
    private int data;
    private NoArvore pai;
    private NoArvore esquerda;
    private NoArvore direita;

    public NoArvore(int data) {
        this.data = data;
        this.pai = null;
        this.esquerda = null;
        this.direita = null;
    }

    public NoArvore getPai() {
        return pai;
    }

    public void setPai(NoArvore pai) {
        this.pai = pai;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NoArvore getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoArvore esquerdo) {
        this.esquerda = esquerdo;
    }

    public NoArvore getDireita() {
        return this.direita;
    }

    public void setDireita(NoArvore direito) {
        this.direita = direito;
    }

    public boolean has2Children()
        { return esquerda != null && direita != null; }

    public boolean isLeaf()
        { return esquerda == null && direita == null; }

    public boolean hasChild()
        { return esquerda != null || direita != null; }
}