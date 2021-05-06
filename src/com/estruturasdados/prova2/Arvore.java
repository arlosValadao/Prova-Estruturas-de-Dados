package com.estruturasdados.prova2;
import com.estruturasdados.prova2.fila.Fila;


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

	public void adicionar(int data) {
        Elemento novoNo = new Elemento(data);
        Elemento atual = getRaiz();
        while(atual != null) {
            if(atual.getValor() > novoNo.getValor()) {
                if(atual.getEsquerda() == null) {
                    novoNo.setPai(atual);
                    atual.setEsquerda(novoNo);
                    return;
                }
                else
                    atual = atual.getEsquerda();
            }
            else {
                if(atual.getDireita() == null) {
                    novoNo.setPai(atual);
                    atual.setDireita(novoNo);
                    return;
                }
                else
                    atual = atual.getDireita();
            }
        }
        this.raiz = novoNo;
    }

	public void emOrdemP(Elemento atual) {
		if (atual != null) {
			emOrdemP(atual.getEsquerda());
			System.out.println(atual.getValor());
			emOrdemP(atual.getDireita());
		}

	}
	
	public Queue preOrdem(Elemento atual, Queue queue) {
		if (atual != null) {
			//System.out.println(atual.getValor());
			queue.add(atual.getValor());
			preOrdem(atual.getEsquerda(), queue);
			preOrdem(atual.getDireita(), queue);
		}
		return queue;

	}
	
	public int getAltura(Elemento atual) {
        if(atual==null) {
            return-1;
        }
        else {
            return 1 + Math.max(getAltura(atual.getEsquerda()),getAltura(atual.getDireita()));
        }
    }
	
	public boolean remover(int valor) {
        Elemento atual = encontrar(valor);
        if (atual == null) {
            return false;
        } else {
            if (atual.getDireita() != null && atual.getEsquerda() != null) {
                Elemento substituto = encontrarSubstituto(atual);

                if (atual.getPai() != null) {// verifica se não é raiz
                    // realocação do substituto
                    if (atual.getValor() < atual.getPai().getValor()) {
                        atual.getPai().setEsquerda(substituto);
                    } else {
                        atual.getPai().setDireita(substituto);
                    }
                } else {
                    this.raiz = substituto;
                }
            } else if (atual.getDireita() != null || atual.getEsquerda() != null) {
                if (atual.getDireita() != null) {

                    if (atual.getPai() != null) {
                        if (atual.getValor() < atual.getPai().getValor()) {
                            atual.getPai().setEsquerda(atual.getDireita());
                        } else {
                            atual.getPai().setDireita(atual.getDireita());
                        }
                    } else {
                        this.raiz = atual.getDireita();
                    }
                } else {
                    if (atual.getPai() != null) {
                        if (atual.getValor() < atual.getPai().getValor()) {
                            atual.getPai().setEsquerda(atual.getEsquerda());
                        } else {
                            atual.getPai().setDireita(atual.getEsquerda());
                        }
                    } else {
                        this.raiz = atual.getEsquerda();
                    }
                }

            } else {
                if (atual.getPai() != null) {
                    if (atual.getValor() >= atual.getPai().getValor()) {
                        atual.getPai().setDireita(null);
                    } else {
                        atual.getPai().setEsquerda(null);
                    }
                } else {
                    this.raiz = null;
                }
            }

            return true;
        }
    }

    private Elemento encontrarSubstituto(Elemento atual) {
        Elemento substituto = atual.getDireita();
        substituto.setPai(atual);
        while (substituto.getEsquerda() != null) {

            Elemento aux = substituto;
            substituto = substituto.getEsquerda();
            substituto.setPai(aux);
        }
        if (substituto != atual.getDireita()) {
            substituto.getPai().setEsquerda(substituto.getDireita());
            substituto.setDireita(atual.getDireita());
        }
        return substituto;
    }

    public void removerMultiplosDe3() {
        if(getRaiz() != null) {
            Fila minhaFila = new Fila();
            minhaFila.inserir(getRaiz());
            while(!minhaFila.isEmpty()) {
                Elemento atual = minhaFila.remover().getData();
                if(atual.getDireita() != null)
                    minhaFila.inserir(atual.getDireita());
                if(atual.getEsquerda() != null)
                    minhaFila.inserir(atual.getEsquerda());
				if(atual.getValor() % 3 == 0) {
					System.out.println("{ " + atual.getValor() + " }");
					remover(atual.getValor());
				}
            }
        }
    }
}