package br.com.alura.challenge;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {

		String opcoes[] = { "Somar", "Subtrair" };

		String opcaoSelecionada = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		String input = JOptionPane.showInputDialog("Insira um valor");
		Double inputTratado = Double.parseDouble(input);

		String[] opcoesDeConversao = { "Somar", "Subtrair" };

		String conversaoSelecionada = (String) JOptionPane.showInputDialog(null,
				"Escolha a operação que desejar", "Ação", JOptionPane.PLAIN_MESSAGE, null,
				opcoesDeConversao, opcoesDeConversao[0]);
		
		switch(conversaoSelecionada) {
		case "Somar":
			double soma = inputTratado * 2;
			
		case "Subtrair":
			double subtracao = inputTratado - inputTratado;
		}
		
		int opcaoFinal = JOptionPane.showOptionDialog(null,
				"Conversão concluída. Deseja converter outro valor?", "Conversão concluída",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Sim", "Não" }, "Sim");
		
		
		
		

	}

}
