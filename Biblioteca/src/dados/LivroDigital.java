package dados;

public class LivroDigital extends Livro{

	private float tamanhoEmMB;
	
	public LivroDigital(String tit, String aut, int nPags, float tam) {
		super(tit,aut,nPags);
		this.setTamanhoEmMB(tam);
	}

	public float getTamanhoEmMB() {
		return tamanhoEmMB;
	}

	public void setTamanhoEmMB(float tamanhoEmMB) {
		this.tamanhoEmMB = tamanhoEmMB;
	}
	
	@Override
	public String toString() {
		String desc = super.toString();
		desc += "Tamanho em MB " + Float.toString(this.getTamanhoEmMB()) + "\n";
		return desc;
	}
	
}
