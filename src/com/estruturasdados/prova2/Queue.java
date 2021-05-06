package com.estruturasdados.prova2;

public class Queue{
	private No head;
	private No tail;
	private int size;
	private final int MAX_SIZE;
	
	//Questão 1
	public Queue(int size) {
		this.size = 0;
		this.MAX_SIZE = size;
	}

	//Preenche a fila com a quantidade MAX_SIZE
	//de valores aleatorios
	public void add_random() {
		int data = Random.rand(100, 200);
		for (int i =0; i < this.MAX_SIZE;i++) {
			add(data);
			data = Random.rand(100, 200);
		}
		
	}
	
	public void add(Object data) {
		if(isEmpty()) {
			head = tail = new No(data);
		}else if(size < MAX_SIZE) {
			No temp = tail;
			tail = new No(data);
			temp.setProximo(tail);
		}
	}
	
	public Object remove() {
		Object data = null;
		if(!isEmpty()){
			data = this.head.getData();
			if(this.size == 1) {
				head = tail = null;
			}else {
				head = head.getProximo();
			}
		}
		this.size--;
		return data;
	}


	public Object peek() {
		return isEmpty()? null:this.head.getData();
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public int size() {
		return this.size;
	}

	public void imprime() {
		Queue aux = this;
		while(aux.head != null) {
			System.out.println(aux.head.getData());
			aux.remove();
		}
	}
}
