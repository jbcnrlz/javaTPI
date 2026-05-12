package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import dados.Genero;
import dados.Jogo;

public class GeneroDAO implements Persistir<Genero>{

	@Override
	public boolean salvar(Genero objeto) {
		Connection cn = GestorDeConexao.getConection();
		try {
			if (objeto.getId() == -1) {
				PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO genero(nome)"+
					"values(?);"
				);
				ps.setString(1, objeto.getNome());
				ps.execute();
				objeto.setId(this.buscarIDBanco(objeto));
			} else {
				PreparedStatement ps = cn.prepareStatement(
						"UPDATE genero SET nome = ?"+
						"WHERE id = ?;"
				);
				ps.setString(1, objeto.getNome());
				ps.setInt(2, objeto.getId());
				ps.execute();
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.err.println("Erro de integridade dos dados!");
			return false;
		}catch (SQLException e) {
			System.err.println("Erro ao fazer o insert");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int buscarIDBanco(Genero objeto) {
		Connection cn = GestorDeConexao.getConection();
		try {
			PreparedStatement ps = cn.prepareStatement(
				"SELECT id FROM genero where nome = ? " +
				"ORDER BY id DESC;"
			);
			ps.setString(1, objeto.getNome());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}catch (SQLException e) {
			System.err.println("Erro ao buscar o item.");
		}
		return -1;
	}
	
	public static LinkedList<Genero> buscarTodos(){
		LinkedList<Genero> llj = new LinkedList<>();
		Connection cn = GestorDeConexao.getConection();
		try {
			PreparedStatement ps = cn.prepareStatement(
				"SELECT id, nome FROM genero;"
			);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Genero j = new Genero(rs.getString(2));
				j.setId(rs.getInt(1));
				llj.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return llj;
	}
	

}
