package br.com.projeto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Caixa {

	private List<Dinheiro> moedasDe10;
	private List<Dinheiro> moedasDe25;
	private List<Dinheiro> moedasDe50;
	private List<Dinheiro> moedasDeUmReal;
	
	public Caixa() {
		this.moedasDe10 = new ArrayList<Dinheiro>();
		this.moedasDe25 = new ArrayList<Dinheiro>();;
		this.moedasDe50 = new ArrayList<Dinheiro>();;
		this.moedasDeUmReal = new ArrayList<Dinheiro>();;
		
		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());
		
		moedasDe25.add(new Moeda25());
		moedasDe25.add(new Moeda25());
		
		
		moedasDe50.add(new Moeda50());
		
		
		moedasDeUmReal.add(new MoedaUmReal());
		
		
	}

	public List<Dinheiro> getMoedasDe10() {
		return moedasDe10;
	}

	public List<Dinheiro> getMoedasDe25() {
		return moedasDe25;
	}

	public List<Dinheiro> getMoedasDe50() {
		return moedasDe50;
	}

	public List<Dinheiro> getMoedasDeUmReal() {
		return moedasDeUmReal;
	}
	
	public boolean removeMoeda10() {
		int moeda = 0;
		
		if(moedasDe10.size() > 0) {
			moedasDe10.remove(moeda);
			System.out.println("Você recebeu 10 centavos de troco.");
			return true;
		}
		System.out.println("Não há moedas de 10 centavos para troco.");
		return false;
	}
	
	public boolean removeMoeda25() {
		int moeda = 0;
		
		if(moedasDe25.size() > 0) {
			moedasDe25.remove(moeda);
			System.out.println("Você recebeu 25 centavos de troco.");
			return true;
		}
		System.out.println("Não há moedas de 25 centavos para troco.");
		return false;
	}
	
	public boolean removeMoeda50() {
		int moeda = 0;
		
		if(moedasDe50.size() > 0) {
			moedasDe50.remove(moeda);
			System.out.println("Você recebeu 50 centavos de troco.");
			return true;
		}
		System.out.println("Não há moedas de 50 centavos para troco.");
		return false;
	}
	
	public boolean removeMoedaUmReal() {
		int moeda = 0;
		
		if(moedasDeUmReal.size() > 0) {
			moedasDeUmReal.remove(moeda);
			System.out.println("Você recebeu Um real de troco.");
			return true;
		}
		System.out.println("Não há moedas de Um real para troco.");
		return false;
	}
	
}
