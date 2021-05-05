package com.estruturasdados.prova2;

public class No {
	private Object data; // dado do n�
	private No proximo; // pr�ximo n� que o ponteiro vai apontar.
	
	public No(Object data) {
		this.data = data;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	public No getProximo() {
		return this.proximo;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
}


