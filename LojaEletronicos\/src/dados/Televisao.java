package dados;

public class Televisao implements Eletronico{
	
	private String marca;
	private int polegadas;
	private String resolucao;
	private boolean smart;
	private boolean ligado;
	
	public Televisao(String m, int p, String r, boolean s) {
		this.setMarca(m);
		this.setPolegadas(p);
		this.setResolucao(r);
		this.setSmart(s);
		this.desligar();
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPolegadas() {
		return polegadas;
	}
	public void setPolegadas(int polegadas) {
		this.polegadas = polegadas;
	}
	public String getResolucao() {
		return resolucao;
	}
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public boolean isSmart() {
		return smart;
	}
	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	@Override
	public void ligar() {
		if (this.isLigado()) {
			System.err.println("TV já está ligada!");			
		} else {
			this.setLigado(true);
		}
	}
	@Override
	public void desligar() {
		if (this.isLigado()) {
			this.setLigado(false);
		} else {
			System.err.println("Já está desligada!");
		}
	}
	@Override
	public String exibirInformacoes() {
		String retorno = "";
		retorno += "Marca: " + this.getMarca() + "\n";
		retorno += "Polegadas: " + Integer.toString(this.getPolegadas()) + "\n";
		retorno += "Resolução: " + this.getResolucao() + "\n";
		if (this.isSmart()) {
			retorno += "É smart!\n";
		} else {
			retorno += "Não é smart!\n";
		}
		if (this.isLigado()) {
			retorno += "Está ligada!\n";
		} else {
			retorno += "Não está ligada!\n";
		}
		return retorno;
	}

}
