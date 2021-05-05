package com.estruturasdados.prova2.fila;
import com.estruturasdados.prova2.arvoreavl.NoArvore;

public class No {
    private NoArvore data;
    private No proximo;

    public No(NoArvore data) {
        this.data = data;
        this.proximo = null;
    }

    public void setData(NoArvore data) {
        this.data = data;
    }

    public NoArvore getData() {
        return this.data;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void mostrarNo() {
        System.out.println("{" + this.data.getData() +"}");
    }
}