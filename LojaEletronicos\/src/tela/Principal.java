package tela;

import java.sql.Connection;

import dados.ConectorBancoDeDados;
import dados.Televisao;
import excecoes.ResolucaoInvalidaException;

public class Principal {

	public static void main(String[] args) {
		/*
		Eletronico el = new Televisao("Samsung",40,"4K",true);
		System.out.println(el.exibirInformacoes());
		
		Eletronico el2 = new Smartphone("Sansumg", "Galaxy S6", 4500, true);
		System.out.println(el2.exibirInformacoes());
		el2.ligar();
		System.out.println(el2.exibirInformacoes());
		*/
		
		ConectorBancoDeDados cdb = new ConectorBancoDeDados();
		Connection cn = cdb.startConnection();
		if (cn != null) {
			try {
				System.out.println("Conectou");
				Televisao t = new Televisao("Samsung",40,"BATATA",true);
				System.out.println("Antes de salvar: ");
				System.out.println(t.exibirInformacoes());
				if (t.save(cn)) {
					System.out.println("Salvo com sucesso!");
				} else {
					System.err.println("Erro ao salvar!");
				}
				System.out.println("Depois de salvar: ");
				System.out.println(t.exibirInformacoes());			
			}catch (ResolucaoInvalidaException e) {
				System.err.println("Você digitou uma resolução inválida!");
			}
		}
		
	}
	
}
