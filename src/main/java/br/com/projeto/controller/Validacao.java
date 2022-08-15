package br.com.projeto.controller;

public class Validacao {
	
	public int validaMoedas(int valor) {
		if((valor == 10) || (valor == 25) || (valor == 50) || (valor == 100)) {
			return valor;
		}
		System.out.println("moeda invalida");
		return 0;
	}

}
