package br.com.projeto.modelo;

public class Moeda10 extends Dinheiro {

	private int valor;
	
	public Moeda10() {
		valor = 10;
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
