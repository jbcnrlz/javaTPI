package sistema;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import dados.Genero;

public class GeneroTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[] colunas = {"ID","Nome"};
	private LinkedList<Genero> jgs;

	public GeneroTableModel(LinkedList<Genero> g) {
		this.jgs = g;
	}
	
	@Override
	public int getColumnCount() {		
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.jgs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		if (colIndex == 0) {
			return this.jgs.get(rowIndex).getId();
		} else if (colIndex == 1) {
			return this.jgs.get(rowIndex).getNome();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
