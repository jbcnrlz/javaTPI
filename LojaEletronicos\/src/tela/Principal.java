package tela;

import dados.Eletronico;
import dados.Smartphone;
import dados.Televisao;

public class Principal {

	public static void main(String[] args) {
		Eletronico el = new Televisao("Samsung",40,"4K",true);
		System.out.println(el.exibirInformacoes());
		
		Eletronico el2 = new Smartphone("Sansumg", "Galaxy S6", 4500, true);
		System.out.println(el2.exibirInformacoes());
		el2.ligar();
		System.out.println(el2.exibirInformacoes());
	}
	
}
