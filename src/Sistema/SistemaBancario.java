package Sistema;

import javax.swing.JOptionPane;

public class SistemaBancario {

	public static void main(String[] args) {
		/*Desenvolver um algoritmo que
defina um menu para o sistema
bancário, seguindo o padrão:
1- Criar conta;
2- Saque;
3- Depósito;
4- Transferência;
5- Aplicar na poupança;
6- Aplicar no fundo;
7- Simulação;
8- Verificar Saldo;
9- Histórico de transações;
10-Sair.
Postar o projeto compactado no
Moodle.*/
		
		
		JOptionPane.showConfirmDialog(null, "Bem vindo ao Sistema Bancário RA - Deseja continuar?");
		
		
		int opcao;
		
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
		
		if(opcao==1) {
			JOptionPane.showMessageDialog(null,"Criar conta");
		}else if(opcao==2) {
			JOptionPane.showMessageDialog(null,"Saque");
			
		}else if(opcao==3) {
			JOptionPane.showMessageDialog(null,"Depósito");
		
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
