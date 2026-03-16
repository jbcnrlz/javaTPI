package telas;

import dados.Animal;
import dados.Cachorro;
import dados.HomemMacaco;
import dados.Ornitorrinco;

public class Principal {

	public static void main(String args[]) {
		Animal a;
		a = new Cachorro();
		System.out.println(a.emitirSom());
		a = new Ornitorrinco();
		System.out.println(a.emitirSom());
		a = new HomemMacaco();
		System.out.println(a.emitirSom());
	}
	
}
