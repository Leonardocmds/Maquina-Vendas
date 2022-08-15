package br.com.projeto.modelo;

public class Produto {
	
	private int codigo;
	private int quantidade;
	private double valor;
	
	public Produto(int codigo, int quantidade, double valor) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Produto() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Produto - Código:" + codigo + ",Quantidade: " + quantidade + ", Valor: " + valor;
	}
	

}
