package dados;

public class Marca {
	
	private String nome;
	
	public Marca(String n) {
		this.setNome(n);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Marca m = Marca.class.cast(obj);
		if (this.getNome().equals(m.getNome())) {
			return true;
		} else {
			return false;
		}
	}

}
