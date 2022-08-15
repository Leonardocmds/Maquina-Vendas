package br.com.projeto.modelo;

public class MoedaUmReal extends Dinheiro {

	private int valor;
	
	public MoedaUmReal() {
		valor = 100;
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
