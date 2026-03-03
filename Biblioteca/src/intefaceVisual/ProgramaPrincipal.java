package intefaceVisual;

import dados.Livro;
import dados.LivroDigital;

public class ProgramaPrincipal {

	public static void main(String args[]) {
		Livro l1 = new Livro("Livro 1","Autor 1",150);
		Livro l2 = new Livro("Segundo livro","Segundo autor",300);		
		Livro l3 = new Livro("Terceiro Livro","Terceiro Autor",450);
		Livro l4 = new Livro("Quarto Livro","Quarto autor");
		Livro l5 = new LivroDigital("Livro 1 - Versão Digital", "Autor 1", 150, 3.5f);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		System.out.println(l5);	
	}
	
}
