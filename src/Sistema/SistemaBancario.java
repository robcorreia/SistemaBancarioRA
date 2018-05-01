package Sistema;
import javax.swing.JOptionPane;

public class SistemaBancario {

	public static void main(String[] args) {

		JOptionPane.showConfirmDialog(null, "Bem vindo ao Sistema Bancário RA - Deseja continuar?");

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
		
		double saldo[] = new double [999999];
		
		String vetorConta[] = new String [9999999];
		String vetorNome [] = new String [9999999];
		String vetorCpf[] = new String [9999999];
		String vetorDataNas[] = new String[9999999];
		String vetorGenero[] = new String [9999999];
		String vetorSenha[] = new String [9999999];
		int validador[] = new int [9999999];
		int numConta = 0;
		
		
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
					JOptionPane.showMessageDialog(null,"Criando sua conta conta...");
					nome= JOptionPane.showInputDialog("Digite seu nome: ");  
					cpf=JOptionPane.showInputDialog("Digite seu CPF: ");
					dataNasc=JOptionPane.showInputDialog("Digite sua data de nascimento: (dd/mm/aaaa)");
					genero=JOptionPane.showInputDialog("Digite seu sexo:");
					senha=JOptionPane.showInputDialog("Digite sua senha: ");
					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta para ser criada: "));
					JOptionPane.showMessageDialog(null, "Seus dados:\nNome: "+nome+"\nCPF: "+cpf+"\nData de nascimento: "+dataNasc+"\nSexo: "+genero+"\n\nSaldo da conta: "+saldo+" reais.");
					vetorNome [numConta] = nome;
					vetorCpf[numConta] = cpf;
					vetorDataNas[numConta] = dataNasc;
					vetorGenero[numConta] = genero;
					vetorSenha[numConta] = senha;
					validador[numConta] = numConta;
					saldo[numConta] = 400;
					
					JOptionPane.showMessageDialog(null,
							"Seus dados:\nNome: " + nome + "\nCPF: " + cpf + "\nData de nascimento: " + dataNasc
									+ "\nSexo: " + genero + "\n\nSaldo da conta: " + saldo + " reais.");
				} else if (opcao == 2) {
					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
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

					saque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja sacar:"));
					while (saque > saldo[numConta] || saque <= 0) {
						saque = Double.parseDouble(
								JOptionPane.showInputDialog("Valor inválido, digite um valor acima de 0:"));
					}
					if (vetorSenha[numConta].equalsIgnoreCase(senha)) {
						while (saque > saldo[numConta] || saque <= 0) {
							saque = Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel!!"));
						}
						if (saque <= saldo[numConta] ) {
							JOptionPane.showMessageDialog(null, "Foram sacados R$ " + saque + " reais");
						} else if (saque > saldo[numConta]) {
							JOptionPane.showMessageDialog(null, "Impossível sacar, saldo indisponível");
						} else {
							JOptionPane.showMessageDialog(null, "Error inesperado em saque!!");
						}
					}
					
					saldo[numConta] = saldo[numConta] - saque;

				}

				else if (opcao == 3) {
					JOptionPane.showMessageDialog(null, "Opção de depósito selecionada...");
					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta para deposito: "));
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
					JOptionPane.showMessageDialog(null, "Saldo realizado com sucesso!");

				} else if (opcao == 4) {
					JOptionPane.showMessageDialog(null, "Transferência");

					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
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
							saque = Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel!!"));
						}
						if (tranferencia <= saldo[numConta] ) {
							JOptionPane.showMessageDialog(null, "Foram transferidos R$ " + tranferencia + " reais");
						} else if (tranferencia > saldo[numConta]) {
							JOptionPane.showMessageDialog(null, "Impossível transferir, saldo indisponível");
						} else {
							JOptionPane.showMessageDialog(null, "Error inesperado em transferir!!");
						}
					}
					

					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite a conta para transferir "));
					while(numConta != validador[numConta]) {
						numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
					}
					
					saldo[numConta] += tranferencia;
					JOptionPane.showMessageDialog(null, "Tranferencia realizada com sucesso!" + saldo[numConta]);
					
					
					

				} else if (opcao == 5) {
					JOptionPane.showMessageDialog(null, "Opção de investimento selecionada...");

					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
					while(numConta != validador[numConta]) {
						numConta=Integer.parseInt(JOptionPane.showInputDialog("Conta incorreta! Tente novamente: "));
					}

					vetorSenha[numConta] = JOptionPane.showInputDialog("Digite sua senha:");
					while (!vetorSenha[numConta].equalsIgnoreCase(senha)) {
						vetorSenha[numConta] = JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
					}
					
					
					if (saldo[numConta] > 0) {
						investimento = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do investimento? "));
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

				} else if (opcao == 6) {
					JOptionPane.showMessageDialog(null, "Opção de Aplicar no fundo selecionada...");

					numConta=Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));
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

				} else if (opcao == 7) {
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
					

				} else if (opcao == 8) {
					JOptionPane.showMessageDialog(null, "Verificar saldo");

				} else if (opcao == 9) {
					JOptionPane.showMessageDialog(null, "Histórico de transações");

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
