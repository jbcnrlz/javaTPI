package regrasDeNegocio;

public abstract class Funcionario {
	
	private int id;
	private String nome;
	
	public abstract double calcularSalario();
	
	public Funcionario(int i, String n) {
		this.setId(i);
		this.setNome(n);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
