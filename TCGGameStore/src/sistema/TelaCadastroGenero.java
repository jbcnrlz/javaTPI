package sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dados.Genero;
import dao.GeneroDAO;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroGenero extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nomeGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroGenero frame = new TelaCadastroGenero();
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
	public TelaCadastroGenero() {
		setClosable(true);
		setBounds(100, 100, 335, 96);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblNome = new JLabel("Nome:");
		panel.add(lblNome, "cell 0 0,alignx trailing");
		
		nomeGenero = new JTextField();
		panel.add(nomeGenero, "cell 1 0,growx");
		nomeGenero.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeGenero.getText();
				Genero g = new Genero(nome);
				
				GeneroDAO gd = new GeneroDAO();
				if (gd.salvar(g)) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					
					Component c = (Component) e.getSource();
					JDesktopPane jp = (JDesktopPane) SwingUtilities.getAncestorOfClass(
						JDesktopPane.class,
						c
					);
					
					JInternalFrame[] fs = jp.getAllFrames();
					for (JInternalFrame f : fs) {
						if ( f instanceof ListaGeneros) {
							ListaGeneros lg = (ListaGeneros) f;
							lg.popularTabela();
						}
					}
					
					TelaCadastroGenero tcg = (TelaCadastroGenero) SwingUtilities.getAncestorOfClass(
						TelaCadastroGenero.class,
						c
					);
					tcg.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}
				
			}
		});
		panel.add(btnNewButton, "cell 1 1,alignx right");

	}

}
