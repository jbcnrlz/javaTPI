package dados;

public class Smartphone implements Eletronico{

	private String marca;
	private String modelo;
	private int bateria;
	private boolean ligado;
	private boolean cincoG;
	
	public Smartphone(String m, String mo, int b, boolean c) {
		this.setBateria(b);
		this.setCincoG(c);
		this.setLigado(false);
		this.setMarca(m);
		this.setModelo(mo);
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getBateria() {
		return bateria;
	}
	public void setBateria(int bateria) {
		this.bateria = bateria;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public boolean isCincoG() {
		return cincoG;
	}
	public void setCincoG(boolean cincoG) {
		this.cincoG = cincoG;
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
		retorno += "Modelo: " + this.getModelo()+"\n";
		retorno += "Bateria: " + Integer.toString(this.getBateria()) + "mHa\n";
		if (this.isCincoG()) {
			retorno += "Tem 5G\n";
		} else {
			retorno += "Não tem 5G\n";
		}
		if (this.isLigado()) {
			retorno += "Está ligado!\n";
		} else {
			retorno += "Não está ligado!\n";
		}
		return retorno;
	}
	
}
