package dados;

public class Jogo {
	
	private int id;
	private String regras;
	private String nome;
	
	public Jogo(String r, String n) {
		this.setRegras(r);
		this.setNome(n);
		this.setId(-1);
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
