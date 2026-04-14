package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorDeConexao {

	private static GestorDeConexao conAtiva;
	private Connection con;
	private String url;
	private String usuario;
	private String senha;
	
	private GestorDeConexao(String url, String usuario, String senha) {
		this.con = null;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.con = DriverManager.getConnection(
				this.url,
				this.usuario,
				this.senha
			);
		}catch (ClassNotFoundException ce) {
			System.err.println("Não achou a classe!");
		} catch (SQLException ce) {
			System.err.println("Deu erro no SQL!");
		}

	}
	
	public static Connection getConection() {
		if (GestorDeConexao.conAtiva == null) {
			GestorDeConexao.conAtiva = new GestorDeConexao(
				"jdbc:mariadb://localhost:3306/tcgSeller",
				"jbcnrlz",
				"a12b25c54"
			);
		}
		return GestorDeConexao.conAtiva.getCon();
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
