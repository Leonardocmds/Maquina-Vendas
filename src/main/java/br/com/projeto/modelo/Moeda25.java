package br.com.projeto.modelo;

public class Moeda25 extends Dinheiro {

	private int valor;
	
	public Moeda25() {
		valor = 25;
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
