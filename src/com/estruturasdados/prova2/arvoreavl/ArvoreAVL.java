package com.estruturasdados.prova2.arvoreavl;
import java.lang.Math;


public class ArvoreAVL {
    private NoArvore raiz;
    public int qtdRotacaoDireita = 0;
    public int qtdRotacaoEsquerda = 0;
    public int qtdRotacaoDireitaEsquerda = 0;
    public int qtdRotacaoEsquerdaDireita = 0;

    public ArvoreAVL() {
        this.raiz = null;
    }
    
    public NoArvore getRaiz() {
        return this.raiz;
    }

    public NoArvore encontrar(int key) {
        NoArvore aux = this.raiz;
        while(aux != null && aux.getData() != key) {
            if(aux.getData() > key)
                aux = aux.getEsquerda();
            else
                aux = aux.getDireita();
        }
        return aux;
    }

    private void percursoPreOrdem(NoArvore atual) {
        if(atual != null) {
            System.out.println(atual.getData());
            percursoPreOrdem(atual.getEsquerda());
            percursoPreOrdem(atual.getDireita());
        }
    }

    public void percursoPreOrdem() {
        percursoPreOrdem(getRaiz());
    }

    public void adicionar(int data) {
        NoArvore novoNo = new NoArvore(data);
        NoArvore atual = getRaiz();
        if(getRaiz() == null) {
            this.raiz = novoNo;
        }
        while(atual != null) {
            if(atual.getData() > novoNo.getData()) {
                if(atual.getEsquerda() == null) {
                    novoNo.setPai(atual);
                    atual.setEsquerda(novoNo);
                    break;
                }
                else
                    atual = atual.getEsquerda();
            }
            else {
                if(atual.getDireita() == null) {
                    novoNo.setPai(atual);
                    atual.setDireita(novoNo);
                    break;
                }
                else
                    atual = atual.getDireita();
            }
        }
        // Balancear a arvore apos a insercao
        balance(novoNo.getPai());
    }


    // Calcular a altura de um determinado no
    public int getAltura(NoArvore atual) {
        if(atual==null) {
            return-1;
        }
        else {
            return 1 + Math.max(getAltura(atual.getEsquerda()),getAltura(atual.getDireita()));
        }
    }

    // O pai de n passa a ser pai de c
    private void replace(NoArvore n, NoArvore c) {
        if(n == getRaiz()) {
            this.raiz = c;
        }
        else {
            if(n == n.getPai().getEsquerda())
                n.getPai().setEsquerda(c);
            else
                n.getPai().setDireita(c);
        }
    }

    // Realiza a rotacao a esquerda
    public void rotacaoEsquerda(NoArvore a) {
        NoArvore b = a.getDireita();
        replace(a,b);
        b.setPai(a.getPai());
        a.setPai(b);
        a.setDireita(b.getEsquerda());
        if(b.getEsquerda() != null) {
            b.getEsquerda().setPai(a);
        }
        b.setEsquerda(a);
    }

    // Realiza a rotacao a direita
    public void rotacaoDireita(NoArvore c) {
        NoArvore b = c.getEsquerda();
        replace(c, b);
        b.setPai(c.getPai());
        c.setPai(b);
        c.setEsquerda(b.getDireita());
        if(b.getDireita() != null) {
            b.getDireita().setPai(c);
        }
        b.setDireita(c);
    }

    private boolean isNotBalanced(NoArvore atual) {
        return Math.abs(getAltura(atual.getEsquerda()) - getAltura(atual.getDireita())) >= 2;
    }

    public void balance(NoArvore atual) {
        if (atual != null) {
            if(isNotBalanced(atual)) {
                //esquerda desbalanceada
                if (getAltura(atual.getEsquerda()) > getAltura(atual.getDireita())) {
                    if (getAltura(atual.getEsquerda().getDireita()) > getAltura(atual.getEsquerda().getEsquerda())) {
                        rotacaoEsquerda(atual.getEsquerda()); //rotação esquerda direita
                        rotacaoDireita(atual);
                        qtdRotacaoEsquerdaDireita++;
                    }
                    else {
                        rotacaoDireita(atual);
                        qtdRotacaoDireita++;
                    }
                } else { //direita desbalanceada
                    if (getAltura(atual.getDireita().getEsquerda()) > getAltura(atual.getDireita().getDireita())) {
                        rotacaoDireita(atual.getDireita()); //rotação direita esquerda
                        rotacaoEsquerda(atual);
                        qtdRotacaoDireitaEsquerda++;
                    }
                    else {
                        rotacaoEsquerda(atual);
                        qtdRotacaoEsquerda++;
                    }
                }
            }
            balance(atual.getPai());
        }
    }
    

}//end class
