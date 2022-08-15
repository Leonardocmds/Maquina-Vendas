package br.com.projeto.main;

import java.util.Scanner;

import br.com.projeto.controller.ListaDeProdutos;
import br.com.projeto.controller.MaquinaDeVendas;
import br.com.projeto.controller.Validacao;

public class MaquinaDeVendaMain {

	public static void main(String[] args) {

		boolean maquinaLigada = true;

		// Crio a lista de produtos
		ListaDeProdutos listaProdutos = new ListaDeProdutos();

		// Cria as rotinas de uma maquina de venda
		MaquinaDeVendas maquina = new MaquinaDeVendas();

		// fa�o as valida��es de campo
		Validacao validador = new Validacao();

		// rodar os dados no cache
		
		
		while (maquinaLigada) {

			if (maquina.ePossivelDarTroco() == true) {

				System.out.println("A seguir ser� exibida a lista de produtos da m�quina: ");

				// Mostra Lista de Produtos na tela

				listaProdutos.mostraProdutos();

				System.out.println("Selecione um produto digitando o c�digo do produto ");

				Scanner scan = new Scanner(System.in);

				// recebe o c�digo do produto

				int codigo = 0;
				
				try {
					 codigo = scan.nextInt();
					 
				} catch (Exception e) {
					
					e.getMessage();

				}

				// verifica se a busca pelo produto foi bem sucedida
				boolean buscaProdutoPorCodigo = listaProdutos.buscarPorCodigo(codigo);

				if (buscaProdutoPorCodigo) {

					double valorProdutoEscolhido = listaProdutos.valorProdutoEscolhido();

					System.out.println("Insira o valor: " + valorProdutoEscolhido);

					int valorDigitadoAValidar = scan.nextInt();

					// valida��o para s� conseguir digitar moedas que existam
					int valorValidado = validador.validaMoedas(valorDigitadoAValidar);

					while (valorValidado == 0) {

						System.out.println("Coloque uma moeda v�lida");

						valorDigitadoAValidar = scan.nextInt();

						valorValidado = validador.validaMoedas((valorDigitadoAValidar));

					}

					// recebe os valores digitado e o o valor do produto que foi selecionado
					double verificaValorRecebidoNaMaquina =  maquina.valorRecebido(
							 valorDigitadoAValidar, listaProdutos.valorProdutoEscolhido());

					while (verificaValorRecebidoNaMaquina != 0) {

						if (verificaValorRecebidoNaMaquina > 0) {

							System.out.println("Voc� tem troco ");

							maquina.devolveTroco();

							verificaValorRecebidoNaMaquina = (int) maquina.getValorADevolver();

						} else if (verificaValorRecebidoNaMaquina < 0) {

							while (verificaValorRecebidoNaMaquina < 0) {

								System.out.println("Ainda falta dinheiro: " + maquina.getValorQueFalta()
										+ " coloque a proxima Moeda");

								int valorFaltanteDigitado = scan.nextInt();

								// valida��o para s� conseguir digitar moedas que existam
								int validadorNumero = validador.validaMoedas(valorFaltanteDigitado);

								while (validadorNumero == 0) {

									System.out.println("Coloque uma moeda v�lida");

									valorDigitadoAValidar = scan.nextInt();

									validadorNumero = validador.validaMoedas(valorDigitadoAValidar);

								}

								valorFaltanteDigitado = validadorNumero;

								verificaValorRecebidoNaMaquina = maquina.valorRecebido(
										 valorFaltanteDigitado, maquina.getValorQueFalta());

							}

						} else {

							System.out.println("Produto Pago!! ");

						}
					}

				}
			} else {

				System.out.println(
						"M�quina n�o tem mais troco, ent�o ser� desligada para evitar problemas financeiros ao cliente");

				maquinaLigada = false;

			}

		}
	}

}
