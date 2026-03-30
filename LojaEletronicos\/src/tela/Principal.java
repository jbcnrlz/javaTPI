package tela;

import java.sql.Connection;

import dados.ConectorBancoDeDados;
import dados.Eletronico;
import dados.Smartphone;
import dados.Televisao;

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
			System.out.println("Conectou");
			Televisao t = new Televisao("Samsung",40,"4K",true);
			System.out.println("Antes de salvar: ");
			System.out.println(t.exibirInformacoes());
			if (t.save(cn)) {
				System.out.println("Salvo com sucesso!");
			} else {
				System.err.println("Erro ao salvar!");
			}
			System.out.println("Depois de salvar: ");
			System.out.println(t.exibirInformacoes());			
		}
		
	}
	
}
