package sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.LinkedList;
import dados.Genero;
import dao.GeneroDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaGeneros extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private LinkedList<Genero> ll;

	public void popularTabela() {
		ll = GeneroDAO.buscarTodos();
		AbstractTableModel atm = new GeneroTableModel(ll);
		this.table.setModel(atm);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaGeneros frame = new ListaGeneros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaGeneros() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[420.00,grow][grow]", "[][grow][]"));
		
		textField = new JTextField();
		panel.add(textField, "cell 0 0,growx");
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar, "cell 1 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 1 2 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Component c = (Component) arg0.getSource();
				JDesktopPane jp = (JDesktopPane) SwingUtilities.getAncestorOfClass(
					JDesktopPane.class,
					c
				);
				
				JInternalFrame jif = new TelaCadastroGenero();
				jp.add(jif);
				jif.setVisible(true);
				
			}
		});
		panel.add(btnNovo, "flowx,cell 0 2");
		
		JButton btnEditar = new JButton("Editar");
		panel.add(btnEditar, "cell 0 2");
		
		JButton btnNewButton = new JButton("Excluir");
		panel.add(btnNewButton, "cell 0 2 2 1,alignx right");
		
		popularTabela();

	}

}
