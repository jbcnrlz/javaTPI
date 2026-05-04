package sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import dados.Jogo;
import dao.JogoDAO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ListaJogos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTable table;
	private LinkedList<Jogo> ll;
	
	public void popularTabela() {
		ll = JogoDAO.buscarTodos();
		AbstractTableModel atm = new JogosTableModel(ll);
		this.table.setModel(atm);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaJogos frame = new ListaJogos();
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
	public ListaJogos() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		textField = new JTextField();
		panel.add(textField, "flowx,cell 0 0,growx");
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar, "cell 0 0");
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		this.popularTabela();
		btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component c = (Component) e.getSource();
				JDesktopPane jp = (JDesktopPane) SwingUtilities.getAncestorOfClass(
					JDesktopPane.class,
					c
				);
				
				JInternalFrame jif = new TelaCadastroJogos();
				jp.add(jif);
				jif.setVisible(true);
				
			}
		});
		panel.add(btnNewButton, "flowx,cell 0 2,alignx right");
		
		btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1, "cell 0 2,alignx right");
		
		btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component c = (Component) e.getSource();
				ListaJogos jif = (ListaJogos) SwingUtilities.getAncestorOfClass(
					ListaJogos.class,
					c
				);
				
				int opt = JOptionPane.showConfirmDialog(jif, "Deseja realmente excluir?");
				if (opt == 0) {
					int linhaSelecionada = table.getSelectedRow();
					Jogo j = ll.get(linhaSelecionada);
					
					JogoDAO jd = new JogoDAO();
					if (jd.excluir(j.getId())) {
						JOptionPane.showMessageDialog(jif, "Excluído com sucesso!");
						popularTabela();
					} else {
						JOptionPane.showMessageDialog(jif, "Erro ao excluir.");
					}
					
				}
			}
		});
		panel.add(btnNewButton_2, "cell 0 2,alignx right");

	}
}
