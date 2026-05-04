package sistema;

import java.util.LinkedList;
import dados.Jogo;
import javax.swing.table.AbstractTableModel;

public class JogosTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[] colunas = {"ID","Nome"};
	private LinkedList<Jogo> jgs;
	
	public JogosTableModel(LinkedList<Jogo> j) {
		this.jgs = j;
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
