package telas;

import dados.Carro;

public class Principal {

	public static void main(String args[]) {
		Carro c1 = new Carro("GM", "Onyx", 2017, "Preto");
		Carro c2 = new Carro("Wolksvagem","UP",2015,"Vermelho");
		Carro c3 = new Carro("Toyota","Yaris",2017,"Vermelho");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		if (c1.equals(c2)) {
			System.out.println("São iguais!");
		} else {
			System.out.println("São diferentes!");
		}
		
		Carro c4 = new Carro("GM", "Onyx", 2017, "Preto");
		if (c1.equals(c4)) {
			System.out.println("São iguais!");
		} else {
			System.out.println("São diferentes!");
		}
		
	}
	
}
