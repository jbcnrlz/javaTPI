package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Televisao implements Eletronico{
	
	private int id;
	private String marca;
	private int polegadas;
	private String resolucao;
	private boolean smart;
	private boolean ligado;
	
	private int buscarID(Connection cn) {
		try {
			PreparedStatement ps = cn.prepareStatement(
				"SELECT id FROM televisao where marca = ? and polegadas = ? " +
				"and resolucao = ? and smart = ? ORDER BY id DESC;"
			);
			ps.setString(1, this.getMarca());
			ps.setInt(2, this.getPolegadas());
			ps.setString(3, this.getResolucao());
			if (this.isSmart()) {
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch (SQLException e) {
			System.err.println("Erro ao buscar o item.");
		}
		return -1;
	}
	
	public boolean save(Connection cn) {
		try {
			PreparedStatement ps = cn.prepareStatement(
				"INSERT INTO televisao(marca,polegadas,resolucao,smart)"+
				"values(?,?,?,?);"
			);
			ps.setString(1, this.getMarca());
			ps.setInt(2, this.getPolegadas());
			ps.setString(3, this.getResolucao());
			if (this.isSmart()) {
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			ps.execute();
			this.id = this.buscarID(cn);
		}catch (SQLException e) {
			System.err.println("Erro ao fazer o insert");
			return false;
		}
		return true;
	}
	
	public Televisao(String m, int p, String r, boolean s) {
		this.setMarca(m);
		this.setPolegadas(p);
		this.setResolucao(r);
		this.setSmart(s);
		//this.desligar();
		this.id = -1;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPolegadas() {
		return polegadas;
	}
	public void setPolegadas(int polegadas) {
		this.polegadas = polegadas;
	}
	public String getResolucao() {
		return resolucao;
	}
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public boolean isSmart() {
		return smart;
	}
	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	@Override
	public void ligar() {
		if (this.isLigado()) {
			System.err.println("TV já está ligada!");			
		} else {
			this.setLigado(true);
		}
	}
	@Override
	public void desligar() {
		if (this.isLigado()) {
			this.setLigado(false);
		} else {
			System.err.println("Já está desligada!");
		}
	}
	@Override
	public String exibirInformacoes() {
		String retorno = "ID da Televisão -> " + Integer.toString(this.id) + "\n";
		retorno += "Marca: " + this.getMarca() + "\n";
		retorno += "Polegadas: " + Integer.toString(this.getPolegadas()) + "\n";
		retorno += "Resolução: " + this.getResolucao() + "\n";
		if (this.isSmart()) {
			retorno += "É smart!\n";
		} else {
			retorno += "Não é smart!\n";
		}
		if (this.isLigado()) {
			retorno += "Está ligada!\n";
		} else {
			retorno += "Não está ligada!\n";
		}
		return retorno;
	}

}
