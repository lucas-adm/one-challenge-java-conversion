package br.com.alura.challenge;

import javax.swing.JOptionPane;

public class Conversor {

	public static void main(String[] args) {

		Moeda moeda = new Moeda();

		String[] opcoes = { "Conversor de Moeda" };

		String opcaoSelecionada = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		boolean valorValido = false;
		double valorDeclarado = 0.0;

		while (!valorValido) {

			String valorCapturado = JOptionPane.showInputDialog("Insira um valor");

			try {
				valorDeclarado = Double.parseDouble(valorCapturado);
				valorValido = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Valor inválido! Digite um número válido, utilize 'ponto' ao invés de 'vírgula' para separar as casas decimais, se necessário.",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}

			String[] opcoesDeConversao = { "De Reais a Dólares", "De Reais a Euros", "De Reais a Libras Esterlinas",
					"De Reais a Pesos Argentino", "De Reais a Pesos Chileno",

					"De Dólares a Reais", "De Euros a Reais", "De Libras Esterlinas a Reais",
					"De Pesos Argentino a Reais", "De Pesos Chileno a Reais" };

			String conversaoSelecionada = (String) JOptionPane.showInputDialog(null,
					"Escolha a moeda para a qual você deseja girar seu dinheiro", "Moedas", JOptionPane.PLAIN_MESSAGE,
					null, opcoesDeConversao, opcoesDeConversao[0]);

			if (conversaoSelecionada != null) {
				switch (conversaoSelecionada) {

				// Conversão Internacional
				case "De Reais a Dólares":
					valorDeclarado /= moeda.getDolar();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: $ " + valorDeclarado);
					break;

				case "De Reais a Euros":
					valorDeclarado /= moeda.getEuro();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: € " + valorDeclarado);
					break;

				case "De Reais a Libras Esterlinas":
					valorDeclarado /= moeda.getLibraEsterlinas();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: £ " + valorDeclarado);
					break;

				case "De Reais a Pesos Argentino":
					valorDeclarado /= moeda.getPesoArgentino();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: $ " + valorDeclarado);
					break;

				case "De Reais a Pesos Chileno":
					valorDeclarado /= moeda.getPesoChileno();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: $ " + valorDeclarado);
					break;

				// Conversão Nacional
				case "De Dólares a Reais":
					valorDeclarado *= moeda.getDolar();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$ " + valorDeclarado);
					break;

				case "De Euros a Reais":
					valorDeclarado *= moeda.getEuro();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$ " + valorDeclarado);
					break;

				case "De Libras Esterlinas a Reais":
					valorDeclarado *= moeda.getLibraEsterlinas();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$ " + valorDeclarado);
					break;

				case "De Pesos Argentino a Reais":
					valorDeclarado *= moeda.getPesoArgentino();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$ " + valorDeclarado);
					break;

				case "De Pesos Chileno a Reais":
					valorDeclarado *= moeda.getPesoChileno();
					JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$ " + valorDeclarado);
					break;
				}
			}

			int opcaoFinal = JOptionPane.showOptionDialog(null, "Conversão concluída. Deseja converter outro valor?",
					"Conversão concluída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Sim", "Não" }, "Sim");

			if (opcaoFinal == JOptionPane.YES_OPTION) {
				valorValido = false; // Reiniciar o loop para obter um novo valor
			} else {
				break; // Encerrar o programa
			}

		}

	}

}
