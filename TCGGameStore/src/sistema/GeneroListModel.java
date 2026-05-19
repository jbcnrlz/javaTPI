package sistema;

import java.util.LinkedList;

import javax.swing.AbstractListModel;

import dados.Genero;

public class GeneroListModel extends AbstractListModel<Genero>{
	
	private static final long serialVersionUID = 1L;
	private LinkedList<Genero> ges;

	public GeneroListModel(LinkedList<Genero> g) {
		this.ges = g;
	}
	
	@Override
	public Genero getElementAt(int arg0) {
		return this.ges.get(arg0);
	}

	@Override
	public int getSize() {
		return this.ges.size();
	}

}
