package dados;

public class Carro {
	
	private Marca marca;
	private String modelo;
	private int ano;
	private String cor;
	private static int qtdCriados = 0; 
	
	public static void aumentaCriados() {
		Carro.qtdCriados += 1;
	}
	
	public static int getQtdCriados() {
		return Carro.qtdCriados;
	}
	
	public Carro(String m, String mo, int ano, String cor) {
		this.setMarca(m);
		this.setModelo(mo);
		this.setAno(ano);
		this.setCor(cor);
		Carro.aumentaCriados();
	}
	
	@Override
	public String toString() {
		String retorno = this.getMarca().getNome() ;
		retorno = retorno + " - " + this.getModelo();
		retorno = retorno + " - " + Integer.toString(this.getAno());
		retorno = retorno + " - " + this.getCor();
		return retorno;
	}
	
	@Override
	public boolean equals(Object obj) {
		Carro cComp = Carro.class.cast(obj);		
		if (
			(this.getAno() == cComp.getAno()) &&
			(this.getCor().equals(cComp.getCor())) &&
			(this.getMarca().equals(cComp.getMarca())) &&
			(this.getModelo().equals(cComp.getModelo()))
		) {
			return true;
		} else {
			return false;
		}
	}
	
	public Marca getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		Marca m = new Marca(marca);
		this.marca = m;
	}
	
	public void setMarca(Marca m) {
		this.marca = m;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

}
