package dados;

public class Livro {

	private String titulo;
	private String autor;
	private int nPags;
	
	public Livro(String tit, String aut, int n) {
		this.setTitulo(tit);
		this.setAutor(aut);
		this.setnPags(n);
	}
	
	public Livro(String tit, String aut) {
		this.setTitulo(tit);
		this.setAutor(aut);
		this.setnPags(0);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getnPags() {
		return nPags;
	}
	public void setnPags(int nPags) {
		this.nPags = nPags;
	}
	
	@Override
	public String toString() {
		String desc = "Livro " + this.getTitulo() + "\n";
		desc += "Autor " + this.getAutor() + "\n";
		desc += "Número de páginas " + Integer.toString(this.getnPags()) + "\n";
		return desc;
	}
	
}
