package telas;

import java.util.Scanner;

import regrasDeNegocio.FolhaDePagamento;
import regrasDeNegocio.Funcionario;
import regrasDeNegocio.FuncionarioAssalariado;
import regrasDeNegocio.FuncionarioComissionado;
import regrasDeNegocio.FuncionarioPorHora;

public class Principal {

	public static void main(String args[]) {
		int id=1, opt=1;
		Scanner sc = new Scanner(System.in);
		FolhaDePagamento fp = new FolhaDePagamento();
		while (opt > 0) {
			System.out.println("Super sistema de folha de pagamento!");
			System.out.println("Digite sua opção: ");
			System.out.println("1 - Cadastrar novo funcionário");
			System.out.println("2 - Imprimir folha de pagamento");
			System.out.println("0 - Sair");
			
			opt = Integer.parseInt(sc.nextLine());
			
			if (opt == 1) {
				System.out.println("Cadastre o funcionário: ");
				System.out.println("1 - Assalariado");
				System.out.println("2 - Horista");
				System.out.println("3 - Comissionado");
				opt = Integer.parseInt(sc.nextLine());
				Funcionario fc = null;
				System.out.println("Perfeito. Digite o nome do funcionário: ");
				String nome = sc.nextLine();			
				if (opt == 1) {
					System.out.println("Digite o salário do funcionário: ");
					double sal = Double.parseDouble(sc.nextLine());	
					fc = new FuncionarioAssalariado(id, nome, sal);
				} else if (opt == 2) {
					System.out.println("Digite a quantidade de horas trabalhadas: ");
					int hTrabs = Integer.parseInt(sc.nextLine());
					System.out.println("Digite o valor da hora: ");
					double valHora = Double.parseDouble(sc.nextLine());
					fc = new FuncionarioPorHora(id, nome, hTrabs, valHora);
				} else if (opt == 3) {
					System.out.println("Digite o montante de vendas: ");
					double vendasVal = Double.parseDouble(sc.nextLine());
					System.out.println("Digite a porcentagem de comissão: ");
					double pCom = Double.parseDouble(sc.nextLine());
					fc = new FuncionarioComissionado(id, nome, vendasVal, pCom);
				}
				fp.addFuncionario(fc);
				id += 1;
			} else if (opt == 2) {
				System.out.println(fp.imprimirSalario());
			}
			
		}
	}
	
}
