package br.com.alura.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Conversor {

	public static void main(String[] args) {

		Moeda moeda = new Moeda();

		String[] opcoes = { "Conversor de Moeda", "Conversor de Temperatura" };

		boolean loop = false;

		while (!loop) {

			try {

				UIManager.put("OptionPane.okButtonText", "Avançar");
				UIManager.put("OptionPane.cancelButtonText", "Sair");
				String opcaoSelecionada = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Menu",
						JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

				switch (opcaoSelecionada) {
				case "Conversor de Moeda":

					String valorCapturado = null;
					boolean valorValido = false;

					do {

						while (!valorValido) {

							UIManager.put("OptionPane.okButtonText", "Avançar");
							UIManager.put("OptionPane.cancelButtonText", "Voltar");
							valorCapturado = JOptionPane.showInputDialog("Insira um valor:");

							try {
								BigDecimal valorDeclarado = new BigDecimal(valorCapturado);
								valorValido = true;

								String[] opcoesDeConversao = { "De Reais a Dólares", "De Reais a Euros",
										"De Reais a Libras Esterlinas", "De Reais a Pesos Argentino",
										"De Reais a Pesos Chileno",

										"De Dólares a Reais", "De Euros a Reais", "De Libras Esterlinas a Reais",
										"De Pesos Argentino a Reais", "De Pesos Chileno a Reais" };

								String conversaoSelecionada = (String) JOptionPane.showInputDialog(null,
										"Escolha a moeda para a qual você deseja girar seu dinheiro:", "Moedas",
										JOptionPane.PLAIN_MESSAGE, null, opcoesDeConversao, opcoesDeConversao[0]);

								try {

									UIManager.put("OptionPane.okButtonText", "Finalizar");

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
										valorDeclarado = valorDeclarado.divide(
												new BigDecimal(moeda.getLibraEsterlinas()), 2, RoundingMode.DOWN);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: £ " + valorDeclarado);
										break;

									case "De Reais a Pesos Argentino":
										valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getPesoArgentino()),
												2, RoundingMode.DOWN);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: $ " + valorDeclarado);
										break;

									case "De Reais a Pesos Chileno":
										valorDeclarado = valorDeclarado.divide(new BigDecimal(moeda.getPesoChileno()),
												2, RoundingMode.DOWN);
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
										valorDeclarado = valorDeclarado
												.multiply(new BigDecimal(moeda.getPesoArgentino()));
										valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: R$ " + valorDeclarado);
										break;

									case "De Pesos Chileno a Reais":
										valorDeclarado = valorDeclarado
												.multiply(new BigDecimal(moeda.getPesoChileno()));
										valorDeclarado = valorDeclarado.setScale(2, RoundingMode.DOWN);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: R$ " + valorDeclarado);
										break;
									}
								} catch (NullPointerException ex) {
									valorValido = false; // reseta o while
									break; // trava o while
								}

								int opcaoFinal = JOptionPane.showOptionDialog(null, "Deseja continuar?",
										"Selecione uma opção:", JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sim", "Não", "Cancelar" },
										"Sim");

								if (opcaoFinal == JOptionPane.YES_OPTION) {
									loop = false; // Retorna à lista
								}
								if (opcaoFinal == JOptionPane.NO_OPTION) {
									UIManager.put("OptionPane.okButtonText", "Sair");
									JOptionPane.showMessageDialog(null, "Programa finalizado.");
									return; // Encerra a aplicação
								}
								if (opcaoFinal == JOptionPane.CANCEL_OPTION) {
									UIManager.put("OptionPane.okButtonText", "Sair");
									JOptionPane.showMessageDialog(null, "Programa concluído.");
									return; // Encerra a aplicação
								}

								// Valor inválido inserido
							} catch (NumberFormatException e) {
								UIManager.put("OptionPane.okButtonText", "Tentar novamente");
								JOptionPane.showMessageDialog(null,
										"Digite apenas números e separe as casas decimais com ' . '", "Valor inválido",
										JOptionPane.ERROR_MESSAGE);
							} catch (NullPointerException e) {
								valorValido = true;
							}

						} // while

						// retorna à lista
					} while (!valorValido); // do

					break; // case1

				case "Conversor de Temperatura":

					String grauCapturado = null;
					boolean grauValido = false;

					do {

						while (!grauValido) {

							UIManager.put("OptionPane.okButtonText", "Avançar");
							UIManager.put("OptionPane.cancelButtonText", "Voltar");
							grauCapturado = JOptionPane.showInputDialog("Insira um grau:");

							try {

								BigDecimal grauDeclarado = new BigDecimal(grauCapturado);
								grauValido = true;

								String[] opcoesDeConversao = { "De Celsius para Fahrenheit", "De Celsius para Kelvin",

										"De Fahrenheit para Celsius", "De Fahrenheit para Kelvin",

										"De Kelvin para Celsius", "De Kelvin para Fahrenheit" };

								String conversaoSelecionada = (String) JOptionPane.showInputDialog(null,
										"Escolha a escala para a qual você deseja converter:", "Escalas",
										JOptionPane.PLAIN_MESSAGE, null, opcoesDeConversao, opcoesDeConversao[0]);

								try {

									UIManager.put("OptionPane.okButtonText", "Finalizar");

									switch (conversaoSelecionada) {

									case "De Celsius para Fahrenheit":
										grauDeclarado = grauDeclarado.multiply(new BigDecimal("1.8"))
												.add(new BigDecimal("32"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °F " + grauDeclarado);
										break;

									case "De Celsius para Kelvin":
										grauDeclarado = grauDeclarado.add(new BigDecimal("273.15"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °K " + grauDeclarado);
										break;

									case "De Fahrenheit para Celsius":
										grauDeclarado = grauDeclarado.subtract(new BigDecimal("32"))
												.multiply(new BigDecimal("0.55"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °C " + grauDeclarado);
										break;

									case "De Fahrenheit para Kelvin":
										grauDeclarado = grauDeclarado.subtract(new BigDecimal("32"))
												.multiply(new BigDecimal("0.55")).add(new BigDecimal("273.15"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °K " + grauDeclarado);
										break;

									case "De Kelvin para Celsius":
										grauDeclarado = grauDeclarado.subtract(new BigDecimal("273.15"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °C " + grauDeclarado);
										break;

									case "De Kelvin para Fahrenheit":
//										(1 K − 273,15) × 9/5 + 32 = -457,7 °F
										grauDeclarado = grauDeclarado.subtract(new BigDecimal("273.15"))
												.multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
										grauDeclarado = grauDeclarado.setScale(1, RoundingMode.UP);
										JOptionPane.showMessageDialog(null,
												"O valor da conversão é de: °F " + grauDeclarado);
										break;

									} // switch

								} catch (NullPointerException eX) { // try-catch da conversão
									grauValido = false; // reseta o while
									break; // trava o while
								}

								int opcaoFinal = JOptionPane.showOptionDialog(null, "Deseja continuar?",
										"Selecione uma opção:", JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sim", "Não", "Cancelar" },
										"Sim");

								if (opcaoFinal == JOptionPane.YES_OPTION) {
									loop = false; // Retorna à lista
								}
								if (opcaoFinal == JOptionPane.NO_OPTION) {
									UIManager.put("OptionPane.okButtonText", "Sair");
									JOptionPane.showMessageDialog(null, "Programa finalizado.");
									return; // Encerra a aplicação
								}
								if (opcaoFinal == JOptionPane.CANCEL_OPTION) {
									UIManager.put("OptionPane.okButtonText", "Sair");
									JOptionPane.showMessageDialog(null, "Programa concluído.");
									return; // Encerra a aplicação
								}

								// try-catch do input
							} catch (NumberFormatException e) {
								UIManager.put("OptionPane.okButtonText", "Tentar novamente");
								JOptionPane.showMessageDialog(null,
										"Digite apenas números e separe as casas decimais com ' . '", "Grau inválido",
										JOptionPane.ERROR_MESSAGE);
							} catch (NullPointerException e) {
								grauValido = true;
							}

						} // while

					} while (!grauValido); // do

					break; // case2
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