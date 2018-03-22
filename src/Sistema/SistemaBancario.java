package Sistema;

import javax.swing.JOptionPane;

public class SistemaBancario {

	public static void main(String[] args) {
		
		
		JOptionPane.showConfirmDialog(null, "Bem vindo ao Sistema Bancário RA - Deseja continuar?");
		
		
		Integer opcao;
		String nome, cpf, dataNasc, genero;
		String senha="0000";
		double saldo=400, saque=0;
		opcao=Integer.parseInt(JOptionPane.showInputDialog(
				"1- Criar conta\r\n" + 
				"2- Saque\r\n" + 
				"3- Depósito\r\n" + 
				"4- Transferência\r\n" + 
				"5- Aplicar na poupança\r\n" + 
				"6- Aplicar no fundo\r\n" + 
				"7- Simulação\r\n" + 
				"8- Verificar Saldo\r\n" + 
				"9- Histórico de transações\r\n" + 
				"10-Sair\n\n Digite a opção desejada: "));
			while(opcao > 10 || opcao <= 0 || opcao != opcao) {
				opcao=Integer.parseInt(JOptionPane.showInputDialog(
						"1- Criar conta\r\n" + 
						"2- Saque\r\n" + 
						"3- Depósito\r\n" + 
						"4- Transferência\r\n" + 
						"5- Aplicar na poupança\r\n" + 
						"6- Aplicar no fundo\r\n" + 
						"7- Simulação\r\n" + 
						"8- Verificar Saldo\r\n" + 
						"9- Histórico de transações\r\n" + 
						"10-Sair\n\n Digite a opção desejada: "));
			}
		
		if(opcao==1) {
			JOptionPane.showMessageDialog(null,"Criando sua conta conta...");
			nome=JOptionPane.showInputDialog("Digite seu nome: ");
			cpf=JOptionPane.showInputDialog("Digite seu CPF: ");
			dataNasc=JOptionPane.showInputDialog("Digite sua data de nascimento: (dd/mm/aaaa)");
			genero=JOptionPane.showInputDialog("Digite seu sexo:");
			senha=JOptionPane.showInputDialog("Digite sua senha: ");
			
			JOptionPane.showMessageDialog(null, "Seus dados:\nNome: "+nome+"\nCPF: "+cpf+"\nData de nascimento: "+dataNasc+"\nSexo: "+genero+"\n\nSaldo da conta: "+saldo+" reais.");
		}else if(opcao==2) {
			String s = "0";
			JOptionPane.showMessageDialog(null,"Opção saque selecionada...");
			s=JOptionPane.showInputDialog("Digite sua senha:");
			while(!s.equalsIgnoreCase(senha)) {
				s=JOptionPane.showInputDialog("Senha incorreta. Digite sua senha novamente:");
			}
			
			saque=Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja sacar:"));
						while(saque > saldo || saque <= 0) {
							saque=Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel ou (verifique se o valor digitado e superior á 0)"));
						}
					if(s.equalsIgnoreCase(senha)) {
								while(saque > saldo || saque <= 0) {
									saque=Double.parseDouble(JOptionPane.showInputDialog("Saldo indisponivel!!"));
								}
								if(saque<=saldo) {
									JOptionPane.showMessageDialog(null,"Foram sacados R$ "+saque+" reais");
								}else if(saque > saldo){
									JOptionPane.showMessageDialog(null,"Impossível sacar, saldo indisponível");
								}else {
									JOptionPane.showMessageDialog(null, "Error inesperado em saque!!");
								}
					}
			}
		
			else if(opcao==3) {
				double deposito;
				JOptionPane.showMessageDialog(null,"Opção de depósito selecionada...");
				deposito=Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar:"));
					while(deposito <= 0) {
						deposito=Double.parseDouble(JOptionPane.showInputDialog("Error DEPOSITO(valor inferior ouu igual á 0). Tente novamente:"));
					}
				saldo+=deposito;
				JOptionPane.showMessageDialog(null, "Saldo realizado com sucesso!");
				
				
			}else if(opcao==4) {
				JOptionPane.showMessageDialog(null,"Transferência");
					
			}else if(opcao==5) {
				JOptionPane.showMessageDialog(null,"Aplicar na poupança");
					
			}else if(opcao==6) {
				JOptionPane.showMessageDialog(null,"Aplicar no fundo");
					
			}else if(opcao==7) {
				JOptionPane.showMessageDialog(null,"Simulação");
					
			}else if(opcao==8) {
				JOptionPane.showMessageDialog(null,"Verificar saldo");
					
			}else if(opcao==9) {
				JOptionPane.showMessageDialog(null,"Histórico de transações");
				
			}else if(opcao==10) {
				JOptionPane.showMessageDialog(null,"Sair");
			return;
				
			}else {
				JOptionPane.showMessageDialog(null,"Operação inválida, tente novamente!");
			}
	

	}
}