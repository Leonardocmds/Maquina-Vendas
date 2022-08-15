package br.com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.modelo.Produto;

public class ListaDeProdutos {

	List<Produto> listaDeProdutos = new ArrayList<Produto>();
	private double valor;
	private Produto produtoSelecionado;

	public ListaDeProdutos() {
		Produto produto = new Produto();
		
		listaDeProdutos.add(new Produto(1, 5, 150));
		listaDeProdutos.add(new Produto(2, 5, 50));
		listaDeProdutos.add(new Produto(3, 5, 200));
		listaDeProdutos.add(new Produto(4, 5, 180));
		listaDeProdutos.add(new Produto(5, 1, 100));
		
		if(produto.getQuantidade() < 1) {
			listaDeProdutos.remove(Integer.valueOf(1));
		}
		
	}

	@Override
	public String toString() {
		return "Lista: " + listaDeProdutos;
	}

	public void mostraProdutos() {
		for (Produto produto : listaDeProdutos) {
			if(produto.getQuantidade() < 1) {
				listaDeProdutos.remove(Integer.valueOf(1));
			}else {
				System.out.println(produto);
			}
		}
	}

	public boolean quantidadeProdutosNaMaquina() {
		if (listaDeProdutos.size() < 0) {
			return true;
		}

		return false;

	}

	public boolean diminuiQuantidade(Produto produto) {

		if (produto.getQuantidade() >= 1) {
			int quantidade = produto.getQuantidade();
			int quantidadeNova = quantidade - 1;
			produto.setQuantidade(quantidadeNova);
			return true;
		} else {
			System.out.println("Não há produtos");
			return false;

		}

	}

	public boolean buscarPorCodigo(int codigo) {

		for (Produto produto : listaDeProdutos) {
			if (produto.getCodigo() == codigo && produto.getQuantidade() > 0) {
				System.out.println("O produto escolhido é: " + produto);
				diminuiQuantidade(produto);
				this.produtoSelecionado = produto;
				this.valor = produto.getValor();
				return true;
			}
		}
		System.out.println("Código inválido");
		return false;
	}
	


	public double valorProdutoEscolhido() {
		return valor;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
}
