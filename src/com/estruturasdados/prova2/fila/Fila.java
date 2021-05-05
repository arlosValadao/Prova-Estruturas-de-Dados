package com.estruturasdados.prova2.fila;
import com.estruturasdados.prova2.arvoreavl.NoArvore;

public class Fila {
    private ListaEncadeada myFila;

    public Fila() {
        myFila = new ListaEncadeada();
    }

    public void inserir(NoArvore data) {
        this.myFila.inserirFinal(data);
    }

    public No remover()
        { return this.myFila.removerInicio(); }

    public void mostrarFila()
        { this.myFila.mostrarLista(); }

    public boolean isEmpty()
        { return this.myFila.isEmpty(); }
    
    public No peek()
        { return this.myFila.getInicio(); }
}
