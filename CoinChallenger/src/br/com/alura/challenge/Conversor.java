package br.com.alura.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

public class Conversor {

	public static void main(String[] args) {

		Moeda moeda = new Moeda();

		String[] opcoes = { "Conversor de Moeda", "Conversor de Temperatura" };

		boolean loop = false;

		while (!loop) {

			try {
				String opcaoSelecionada = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
						JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

				switch (opcaoSelecionada) {
				case "Conversor de Moeda":

					String valorCapturado = null;

					do {

						boolean valorValido = false;

						while (!valorValido) {

							valorCapturado = JOptionPane.showInputDialog("Insira um valor");

							try {
								BigDecimal valorDeclarado = new BigDecimal(valorCapturado);
								valorValido = true;

								String[] opcoesDeConversao = { "De Reais a Dólares", "De Reais a Euros",
										"De Reais a Libras Esterlinas", "De Reais a Pesos Argentino",
										"De Reais a Pesos Chileno",

										"De Dólares a Reais", "De Euros a Reais", "De Libras Esterlinas a Reais",
										"De Pesos Argentino a Reais", "De Pesos Chileno a Reais" };

								String conversaoSelecionada = (String) JOptionPane.showInputDialog(null,
										"Escolha a moeda para a qual você deseja girar seu dinheiro", "Moedas",
										JOptionPane.PLAIN_MESSAGE, null, opcoesDeConversao, opcoesDeConversao[0]);

								switch (conversaoSelecionada) {

								// Conversão Internacional
								case "De Reais a Dólares":
									valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getDolar()), 2,
											RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: $ " + valorDeclarado);
									break;

								case "De Reais a Euros":
									valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getEuro()), 2,
											RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: € " + valorDeclarado);
									break;

								case "De Reais a Libras Esterlinas":
									valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getLibraEsterlinas()),
											2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: £ " + valorDeclarado);
									break;

								case "De Reais a Pesos Argentino":
									valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getPesoArgentino()), 2,
											RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: $ " + valorDeclarado);
									break;

								case "De Reais a Pesos Chileno":
									valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getPesoChileno()), 2,
											RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: $ " + valorDeclarado);
									break;

								// Conversão Nacional
								case "De Dólares a Reais":
									valorDeclarado = valorDeclarado.multiply(new BigDecimal(moeda.getDolar()));
									valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: R$ " + valorDeclarado);
									break;

								case "De Euros a Reais":
									valorDeclarado = valorDeclarado.multiply(new BigDecimal(moeda.getEuro()));
									valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: R$ " + valorDeclarado);
									break;

								case "De Libras Esterlinas a Reais":
									valorDeclarado = valorDeclarado
											.multiply(new BigDecimal(moeda.getLibraEsterlinas()));
									valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: R$ " + valorDeclarado);
									break;

								case "De Pesos Argentino a Reais":
									valorDeclarado = valorDeclarado.multiply(new BigDecimal(moeda.getPesoArgentino()));
									valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: R$ " + valorDeclarado);
									break;

								case "De Pesos Chileno a Reais":
									valorDeclarado = valorDeclarado.multiply(new BigDecimal(moeda.getPesoChileno()));
									valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
									JOptionPane.showMessageDialog(null,
											"O valor da conversão é de: R$ " + valorDeclarado);
									break;
								}

//								if (conversaoSelecionada == null) {
//									valorValido = true;
//								}

								int opcaoFinal = JOptionPane.showOptionDialog(null,
										"Conversão concluída. Deseja converter outro valor?", "Conversão concluída",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
										new Object[] { "Sim", "Não" }, "Sim");

								if (opcaoFinal == JOptionPane.YES_OPTION) {
									loop = false; // Retorna à lista
								} else {
									return; // Encerra a aplicação
								}

								// Valor inválido inserido
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"Valor inválido! Digite um número válido, utilize 'ponto' ao invés de 'vírgula' para separar as casas decimais, se necessário.",
										"Erro", JOptionPane.ERROR_MESSAGE);
							} catch (NullPointerException e) {
								valorValido = true;
							}

						} // while

					} while (valorCapturado != null); // do

				case "Conversor de Temperatura":
					break;
				}

				// if (opcaoSelecionada == null) {
			} catch (NullPointerException ex) {
				int opcaoSair = JOptionPane.showOptionDialog(null, "Você realmente desejar cancelar a execução?",
						"Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new Object[] { "Sim", "Não" }, "Não");

				if (opcaoSair == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					loop = false;
				}

			} // try-catch

		} // loop

	} // main

} // class