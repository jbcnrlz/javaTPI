package sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dados.Jogo;
import dao.GestorDeConexao;
import dao.JogoDAO;
import java.sql.Connection;

public class TelaCadastroJogos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nomeJogo;
	private JTextArea regrasJogo;
	private Jogo jogoEditar = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroJogos frame = new TelaCadastroJogos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void sair() {
		this.dispose();
	}
	
	public TelaCadastroJogos(int id) {
		this();
		this.jogoEditar = JogoDAO.buscarPorID(id);
		this.nomeJogo.setText(this.jogoEditar.getNome());
		this.regrasJogo.setText(this.jogoEditar.getRegras());
	}
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroJogos() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(238, 238, 238));
		setBounds(100, 100, 450, 219);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][grow]", "[][grow][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		nomeJogo = new JTextField();
		panel.add(nomeJogo, "cell 1 0,growx");
		nomeJogo.setColumns(10);
		
		JLabel lblRegras = new JLabel("Regras:");
		panel.add(lblRegras, "cell 0 1");
		
		regrasJogo = new JTextArea();
		panel.add(regrasJogo, "cell 0 2 2 4,grow");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome;
				String regras;
				nome = nomeJogo.getText();
				regras = regrasJogo.getText();
				Jogo j;
				if (jogoEditar == null) {
					j = new Jogo(regras,nome);
				} else {
					j = jogoEditar;
					j.setNome(nome);
					j.setRegras(regras);
				}
				JogoDAO jd = new JogoDAO();
				if (jd.salvar(j)) {
					JOptionPane.showMessageDialog(null,"Salvou com sucesso!");
					
					Component c = (Component) arg0.getSource();
					TelaCadastroJogos tj = (TelaCadastroJogos) SwingUtilities.getAncestorOfClass(
						TelaCadastroJogos.class,
						c
					);
					
					JDesktopPane jp = (JDesktopPane) SwingUtilities.getAncestorOfClass(
						JDesktopPane.class,
						c
					);
					
					JInternalFrame[] fs = jp.getAllFrames();
					for (JInternalFrame lst : fs) {
						if ( lst instanceof ListaJogos ) {
							ListaJogos ljgs = (ListaJogos) lst;
							ljgs.popularTabela();
						}
					}
 					
					tj.dispose();
										
				} else {
					JOptionPane.showMessageDialog(null, "Não salvou!");
				}
			}
		});
		panel.add(btnSalvar, "cell 1 6,alignx right");
	}

}
