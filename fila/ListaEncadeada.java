package fila;
import arvore.NoArvore;

public class ListaEncadeada {
    private No inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public No getInicio() {
        return this.inicio;
    }

    public void inserirFinal(NoArvore data) {
        No novoNo = new No(data);
        if(this.inicio != null) {
            No aux = this.inicio;
            No prev = null;
            while(aux != null) {
                prev = aux;
                aux = aux.getProximo();
            }
            prev.setProximo(novoNo);
            return;
        }
        this.inicio = novoNo;
    }

    public No removerInicio() {
        if(this.inicio != null) {
            No temp = this.inicio;
            this.inicio = this.inicio.getProximo();
            return temp;
        }
        return null;
    }

    public boolean isEmpty()
        { return this.inicio == null; }

    public void mostrarLista() {
        No aux = this.inicio;
        System.out.println("###############");
        while(aux != null) {
            aux.mostrarNo();
            aux = aux.getProximo();
        }
        System.out.println("###############");
    }
}
