package br.com.projeto.controller;

import br.com.projeto.modelo.Caixa;

public class MaquinaDeVendas {

	private Caixa caixa;
	private double valorQueSobrouDeTroco;
	private double valorQueFalta;
	private double valorADevolver;

	public MaquinaDeVendas() {
		this.caixa = new Caixa();
	}

	public double valorRecebido(double valorDigitado, double valorDoProduto) {
		if (valorDigitado < valorDoProduto) {
			valorQueFalta = valorDoProduto - valorDigitado;
			return -1;
		}
		if (valorDigitado > valorDoProduto) {
			valorADevolver = valorDigitado - valorDoProduto;
			return 1;
		}

		System.out.println("Produto pago.");
		return 0;
	}

	public boolean ePossivelDarTroco() {
		boolean troco10 = verificaTrocoNoCaixa(10);
		boolean troco25 = verificaTrocoNoCaixa(25);
		boolean troco50 = verificaTrocoNoCaixa(50);
		boolean trocoUmReal = verificaTrocoNoCaixa(100);

		if (troco10 == true && troco25 == true && troco50 == true && trocoUmReal == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verificaTrocoNoCaixa(double valor) {
		int moeda10 = caixa.getMoedasDe10().size();
		int moeda25 = caixa.getMoedasDe25().size();
		int moeda50 = caixa.getMoedasDe50().size();
		int moedaUmReal = caixa.getMoedasDeUmReal().size();

		if ((valor == 10) && (moeda10 >= 1)) {
			return true;
		} else if ((valor == 20) && (moeda10 >= 2)) {
			return true;
		} else if ((valor == 25) && (moeda25 >= 1)) {
			return true;
		} else if ((valor == 50) && ((moeda50 >= 1) || (moeda25 >= 2))) {
			return true;
		} else if ((valor == 75) && ((moeda50 >= 1) && (moeda25 >= 1) || (moeda25 >= 3))) {
			return true;
		} else if ((valor == 100) && ((moeda25 >= 4) || (moeda10 >= 10) || (moeda50 >= 2) || (moedaUmReal >= 1))) {
			return true;
		}
		return false;

	}

	public void devolveTroco() {

		this.getValorADevolver();

		if (this.verificaTrocoNoCaixa(this.getValorADevolver()) == true) {

			if (this.getValorADevolver() == 100) {
				this.setValorADevolver(this.getValorADevolver() - 100);
				if (caixa.getMoedasDeUmReal().size() == 0) {
					caixa.removeMoeda50();
					caixa.removeMoeda50();
				} else {
					caixa.removeMoedaUmReal();
				}

			}
			if (this.getValorADevolver() == 75) {
				this.setValorADevolver(this.getValorADevolver() - 75);
				if (caixa.getMoedasDe50().size() == 0) {
					caixa.removeMoeda25();
					caixa.removeMoeda25();
					caixa.removeMoeda25();
				} else {
					caixa.removeMoeda25();
					caixa.removeMoeda50();
				}
			}
			if (this.getValorADevolver() == 50) {
				this.setValorADevolver(this.getValorADevolver() - 50);
				if (caixa.getMoedasDe50().size() == 0) {
					caixa.removeMoeda25();
					caixa.removeMoeda25();
				} else {
					caixa.removeMoeda50();
				}

			}
			if (this.getValorADevolver() == 25) {
				this.setValorADevolver(this.getValorADevolver() - 25);
				caixa.removeMoeda25();
			}
			if (this.getValorADevolver() == 20) {
				this.setValorADevolver(this.getValorADevolver() - 20);
				caixa.removeMoeda10();
				caixa.removeMoeda10();
			}

			if (this.getValorADevolver() == 10) {
				this.setValorADevolver(this.getValorADevolver() - 10);
				caixa.removeMoeda10();
			}

		} else {
			System.out.println("A máquina não tem troco.");

		}
	}

	public double getValorADevolver() {
		return valorADevolver;
	}

	public void setValorADevolver(double valorADevolver) {
		this.valorADevolver = valorADevolver;
	}

	public double getValorQueFalta() {
		return valorQueFalta;
	}
}
