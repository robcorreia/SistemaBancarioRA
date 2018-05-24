package Sistema;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Sistema {
	
	public static double saldo[] = new double [999999];
	
	public static String vetorConta[] = new String [9999999];
	public static String vetorNome [] = new String [9999999];
	public static String vetorCpf[] = new String [9999999];
	public static String vetorDataNas[] = new String[9999999];
	public static String vetorGenero[] = new String [9999999];
	public static String vetorSenha[] = new String [9999999];
	public static int validador[] = new int [9999999];
	public static int valorSaque = 0;
	static double val = 0; 
	
	static int numTrasa = 0;
	public static String historico[] = new String[10];
	
	

	static int cont = 0;
	
	public static void vetorVazio(int num) {
		for(int i = 0; i > historico.length; i++) {
			if(historico[num] == null) {
				cont= i;
			}
		}
	}
	
	
	public static void historicos(int num) {
				switch (num) {
					case 1:
						numTrasa = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da tração: "));
						historico[numTrasa] = "Deposito no valor de: " + val;
						System.out.println("Saque no valor de: " + val);
						break;
					case 2:
						numTrasa = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da tração: "));
						historico[numTrasa] = "Deposito no valor de: " + val;
						System.out.println("Deposito no valor de: " + val);
						break;
					case 3:
						numTrasa = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da tração: "));
						historico[numTrasa] = "Tranferencia no valor de: " + val;
						System.out.println("Tranferencia no valor de: " + val);
						break;
					case 4:
						numTrasa = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da tração: "));
						historico[numTrasa] = "Aplicação no valor de: " + val;
						System.out.println("Aplicação no valor de: " + val);
						break;
					default:
						System.out.println("Este não é um dia válido!");
				}
		
}
	
	
	public static void criarConta() {
		
		JOptionPane.showMessageDialog(null,"Criando sua conta conta...");
		String nome= JOptionPane.showInputDialog("Digite seu nome: ");  
		String cpf=JOptionPane.showInputDialog("Digite seu CPF: ");
		String dataNasc=JOptionPane.showInputDialog("Digite sua data de nascimento: (dd/mm/aaaa)");
		String genero=JOptionPane.showInputDialog("Digite seu sexo:");
		String senha=JOptionPane.showInputDialog("Digite sua senha: ");
		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta para ser criada: "));
		JOptionPane.showMessageDialog(null, "Seus dados:\nNome: "+nome+"\nCPF: "+cpf+"\nData de nascimento: "+dataNasc+"\nSexo: "+genero+"\n\nSaldo da conta: "+saldo+" reais.");
		vetorNome [numConta] = nome;
		vetorCpf[numConta] = cpf;
		vetorDataNas[numConta] = dataNasc;
		vetorGenero[numConta] = genero;
		vetorSenha[numConta] = senha;
		validador[numConta] = numConta;
		saldo[numConta] = 400;
		
		
		numConta = 1;
		vetorNome [numConta] = "Antonio";
		vetorCpf[numConta] = "12312323";
		vetorDataNas[numConta] = "20/12/1990";
		vetorGenero[numConta] = "M";
		vetorSenha[numConta] = "0000";
		saldo[numConta] = 400;	
		
		numConta = 2;
		vetorNome [numConta] = "Rob";
		vetorCpf[numConta] = "12312323";
		vetorDataNas[numConta] = "20/12/1990";
		vetorGenero[numConta] = "M";
		vetorSenha[numConta] = "0000";
		saldo[numConta] = 400;	
		JOptionPane.showMessageDialog(null,
				"Seus dados:\nNome: " + nome + "\nCPF: " + cpf + "\nData de nascimento: " + dataNasc
						+ "\nSexo: " + genero + "\n\nSaldo da conta: " + saldo + " reais.");
		
	}
	
	public static void saque(String senha) {
		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
		saldo[numConta] = saldo[numConta];
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
		}
		
		while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}
		
		
		JOptionPane.showMessageDialog(null, "Opção saque selecionada...");
		vetorSenha[numConta] = JOptionPane.showInputDialog("Digite sua senha:");
		while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}

		double saque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja sacar:"));
		while (saque > saldo[numConta] || saque <= 0) {
			saque = Double.parseDouble(
					JOptionPane.showInputDialog("Valor inválido, digite um valor acima de 0:"));
		}
		if (vetorSenha[numConta].equalsIgnoreCase(senha)) {
			while (saque > saldo[numConta] || saque <= 0) {
				val = saque;
				historicos(1);
				saque = Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel!!"));
			}
			if (saque <= saldo[numConta] ) {
				JOptionPane.showMessageDialog(null, "Foram sacados R$ " + saque + " reais");
				val = saque;
			} else if (saque > saldo[numConta]) {
				JOptionPane.showMessageDialog(null, "Impossível sacar, saldo indisponível");
			} else {
				JOptionPane.showMessageDialog(null, "Error inesperado em saque!!");
			}
		}
		
		saldo[numConta] = saldo[numConta] - saque;
	}
	
	public static void deposito() {
		JOptionPane.showMessageDialog(null, "Opção de depósito selecionada...");
		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta para deposito: "));
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
		}
		
		double deposito;
		deposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar:"));
		while (deposito <= 0) {
			deposito = Double.parseDouble(JOptionPane
					.showInputDialog("Error DEPOSITO(valor inferior ouu igual á 0). Tente novamente:"));
		}
		saldo[numConta] += deposito;
		JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");
	}
	
	public static void transferencia(String senha) {
		
		JOptionPane.showMessageDialog(null, "Transferência");

		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
		saldo[numConta] = saldo[numConta];
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta ou inexistente! Tente novamente: "));
		}
		
		while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}
		
		double tranferencia = 0;
		tranferencia = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja tranferir:"));
		while (tranferencia > saldo[numConta] || tranferencia <= 0) {
			tranferencia = Double.parseDouble(
					JOptionPane.showInputDialog("Valor inválido, digite um valor acima de 0:"));
		}
		if (vetorSenha[numConta].equalsIgnoreCase(senha)) {
			while (tranferencia > saldo[numConta] || tranferencia <= 0) {
				double saque = Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel!!"));
			}
			if (tranferencia > saldo[numConta]) {
				JOptionPane.showMessageDialog(null, "Impossível transferir, saldo indisponível");
			}
		}
		

		numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite a conta para transferir "));
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
		}
		
		saldo[numConta] += tranferencia;
		JOptionPane.showMessageDialog(null, "Tranferencia realizada com sucesso!" + saldo[numConta]);
		
		
		

	}
	
	public static void investimento(String senha) {
		double totalInvestimento = 0.02;
		double redimentoPoupaca= 0.02;
		JOptionPane.showMessageDialog(null, "Opção de investimento selecionada...");

		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
		}

		vetorSenha[numConta] = JOptionPane.showInputDialog("Digite sua senha:");
		while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}
		
		
		if (saldo[numConta] > 0) {
			double investimento = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do investimento? "));
			while (investimento > saldo[numConta]) {
				investimento = Double.parseDouble(JOptionPane
						.showInputDialog("Valor de investimento maior que saldo! Tente novamente."));
			}
			while (investimento <= 0 || investimento > saldo[numConta]) {
				investimento = Double.parseDouble(
						JOptionPane.showInputDialog("Valor de investimento inválido! Tente novamente."));
			}
			saldo[numConta] = saldo[numConta] - investimento;
			totalInvestimento = (investimento * redimentoPoupaca);
			JOptionPane.showMessageDialog(null,
					"Valor do investimento: " + investimento + ", rendimento diário: " + totalInvestimento);
		} else {
			JOptionPane.showMessageDialog(null, "Saldo indisponivel!!");
		}
	}
	
	public static void aplicacao(String senha) {
		double rendimentoAplicacaoFundo = 0.02;
		double fundo = 0;
		JOptionPane.showMessageDialog(null, "Opção de Aplicar no fundo selecionada...");

		int numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
		saldo[numConta] = saldo[numConta];
		while(numConta != validador[numConta]) {
			numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta ou inexistente! Tente novamente: "));
		}
		
		while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}
		
		
		
		
		double valorAplicar = Double
				.parseDouble(JOptionPane.showInputDialog("Digite o valor que você deseja aplicar:"));
		while (valorAplicar > saldo[numConta] || valorAplicar < 0) {
			valorAplicar = Double.parseDouble(
					JOptionPane.showInputDialog("Valor indisponível na conta, digite um valor válido:"));
		}
		if (valorAplicar < saldo[numConta]) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Digite sua senha:");
			while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
			vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
		}
		
			if (vetorSenha[numConta].equalsIgnoreCase(senha)) {
				fundo = fundo + valorAplicar;
				saldo[numConta] = saldo[numConta] - valorAplicar;
			}
		}
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso! Seu rendimento será de "
				+ rendimentoAplicacaoFundo + " diário.");

	}
	public static void simulação() {
		int contRedimenPoupa = 0;
		float operaFinancia = 0;
		final float taxaImovel = 0.02f;
		final float taxaAutomo = 0.04f;
		float valorFina = 0f;
		int quantParcelas = 0;
		float juros = 0f;
		while (operaFinancia  <1 || operaFinancia  > 2) {
			operaFinancia = Float.parseFloat(JOptionPane.showInputDialog(
					"Digite 1 - Financiamento Imóvel \nDigite 2 - Financiamento Veículo"));
		}
		

		
		while (valorFina < 1) {
			valorFina = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do finasciamento: "));
		}
		while (quantParcelas < 1) {
			quantParcelas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de parcelas: "));
		}

		if (operaFinancia == 1) {
			juros = (taxaImovel * valorFina);
			JOptionPane.showMessageDialog(null, "Valor do finasciamento do imovel: R$ " + valorFina
					+ "reais.\n" + "Valor do juros em "+quantParcelas+" de R$ "+valorFina/quantParcelas+"reais.\n"  + juros + " Ao mês! "+"\n" + "Valor total: R$ " + juros+valorFina+" reais.");
		} else if (operaFinancia  == 2) {
			juros = (taxaAutomo * valorFina);
			JOptionPane.showMessageDialog(null, "Valor do finasciamento do carro: R$ " + valorFina
					+ " reais.\n" + "Valor do juros em "+quantParcelas+" de R$ "+valorFina/quantParcelas+" reais.\n"  + juros + " Ao mês! "+"\n" + "Valor total: R$ " + juros+valorFina+" reais.");
		} else {
			JOptionPane.showMessageDialog(null, "Error no finasciamento!!!");
		}
		System.out.println("Op: " + operaFinancia);

		System.out.println(saldo);

		contRedimenPoupa++;
		
	}
	
	public static void main(String[] args) {

		
		
		JOptionPane.showConfirmDialog(null, "Bem vindo ao Sistema Bancário RA - Deseja continuar?");

		vetorVazio(1);
		Integer opcao;
		double investimento = 0; // antonio
		final float redimentoPoupaca = 0.002f; // antonio
		double totalInvestimento = 0; // antonio
		final float rendimentoAplicacaoFundo = 0.002f;
		double fundo = 0;
		String nome, cpf, dataNasc, genero;
		String senha = "0000";
		double saque = 0;
		int menu = 0;
		int contRedimenPoupa = 0;
		int contRedimenAplic = 0;
		int numConta = 0;
		
		numConta = 1;
		vetorNome [numConta] = "Antonio";
		vetorCpf[numConta] = "12312323";
		vetorDataNas[numConta] = "20/12/1990";
		vetorGenero[numConta] = "M";
		vetorSenha[numConta] = "0000";
		saldo[numConta] = 400;	
		validador[numConta] = numConta;
		
		numConta = 2;
		vetorNome [numConta] = "Rob";
		vetorCpf[numConta] = "12312323";
		vetorDataNas[numConta] = "20/12/1990";
		vetorGenero[numConta] = "M";
		vetorSenha[numConta] = "0000";
		saldo[numConta] = 400;	
		validador[numConta] = numConta;
		
		
		
		
		
		
		
		
		opcao = 0;
		do {
			while (opcao != 10) {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1- Criar conta\r\n" + "2- Saque\r\n"
						+ "3- Depósito\r\n" + "4- Transferência\r\n" + "5- Aplicar na poupança\r\n"
						+ "6- Aplicar no fundo\r\n" + "7- Simulação\r\n" + "8- Verificar Saldo\r\n"
						+ "9- Histórico de transações\r\n" + "10-Sair\n\n Digite a opção desejada: "));
				if (opcao > 10 && opcao < 1) {
					JOptionPane.showMessageDialog(null, "Operação inválida, tente novamente.");
				}

				if (opcao == 1) {
					criarConta();
					
				} else if (opcao == 2) {
					saque(senha);
				}

				else if (opcao == 3) {
					deposito();

				} else if (opcao == 4) {
					transferencia(senha);
				} else if (opcao == 5) {
					investimento(senha);
				} else if (opcao == 6) {
					aplicacao(senha);
				} else if (opcao == 7) {
					simulação();
				} else if (opcao == 8) {
					JOptionPane.showMessageDialog(null, "Verificar saldo");

				} else if (opcao == 9) {
					JOptionPane.showMessageDialog(null, "Histórico de transações");
					for(int i =0; i <= historico.length; i++) {
						System.out.println("Array vazio");
					}
					

				} else if (opcao == 10) {
					menu = 10;
					JOptionPane.showMessageDialog(null, "Sair");
					return;

				} else {
					JOptionPane.showMessageDialog(null, "Operação inválida, tente novamente!");
				}
				System.out.println("Aqui " + -saldo[numConta]);
				contRedimenAplic++;
				contRedimenPoupa++;
				if (contRedimenAplic > 2 && contRedimenAplic % 3 == 0) {
					saldo[numConta] = ((rendimentoAplicacaoFundo * saldo[numConta]) + ((redimentoPoupaca * saldo[numConta]) + saldo[numConta]));
					System.out.println(saldo);
				}
				/* Apagar depois */
				System.out.println("Aqui " + -saldo[numConta]);
				System.out.println(contRedimenAplic);
				System.out.println(contRedimenPoupa);
				System.out.println(saldo);

			}
		} while (menu != 11);
	}

}