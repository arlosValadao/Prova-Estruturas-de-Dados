package com.estruturasdados.prova2;

public class Random {
	
	public static int rand(int str, int end) {
		return (int) Math.ceil(Math.random() * (end - str + 1)) - 1 + str;
	}
}
