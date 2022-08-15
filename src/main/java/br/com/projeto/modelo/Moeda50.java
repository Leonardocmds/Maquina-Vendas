package br.com.projeto.modelo;

public class Moeda50 extends Dinheiro {

	private int valor;
	
	public Moeda50() {
		valor = 50;
	}
	
	@Override
	public int getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "Valor moeda:" + valor;
	}
	
}
