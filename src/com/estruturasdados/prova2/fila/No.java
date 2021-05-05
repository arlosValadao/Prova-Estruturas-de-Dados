package com.estruturasdados.prova2.fila;
import com.estruturasdados.prova2.Elemento;

public class No {
    private Elemento data;
    private No proximo;

    public No(Elemento data) {
        this.data = data;
        this.proximo = null;
    }

    public void setData(Elemento data) {
        this.data = data;
    }

    public Elemento getData() {
        return this.data;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void mostrarNo() {
        System.out.println("{" + this.data.getValor() +"}");
    }
}