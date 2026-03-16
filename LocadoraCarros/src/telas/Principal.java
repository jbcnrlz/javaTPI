package telas;

import dados.Carro;

public class Principal {

	public static void main(String args[]) {
		Carro[] cars = new Carro[5];
		for (int i = 0;i < cars.length;i += 1) {
			cars[i] = new Carro("Wolksvagem","Teste",2015+i,"Preto");
		}
		
		for (Carro c : cars) {
			System.out.println(c);
		}
		
		System.out.print("Quantidade de objetos de carros criados: ");
		System.out.println(Carro.getQtdCriados());
		
	}
	
}
