package dados;

import java.util.LinkedList;

public class Jogo {
	
	private int id;
	private String regras;
	private String nome;
	private LinkedList<Genero> generos;
	
	public Jogo(String r, String n) {
		this.setRegras(r);
		this.setNome(n);
		this.setId(-1);
		this.generos = new LinkedList<>();
	}
	
	public void vincularGenero(Genero g) {
		this.generos.add(g);
	}
	
	public void desvincularGenero(Genero g) {
		this.generos.remove(g);
	}
	
	public LinkedList<Genero> getGeneros(){
		return this.generos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegras() {
		return regras;
	}
	public void setRegras(String regras) {
		this.regras = regras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
