package tela;

import dados.Eletronico;
import dados.Televisao;

public class Principal {

	public static void main(String[] args) {
		Eletronico el = new Televisao("Samsung",40,"4K",true);
		System.out.println(el.exibirInformacoes());
	}
	
}
