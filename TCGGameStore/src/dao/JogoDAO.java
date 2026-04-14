package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;

import dados.Jogo;

public class JogoDAO implements Persistir<Jogo> {

	@Override
	public boolean salvar(Jogo objeto) {
		Connection cn = GestorDeConexao.getConection();
		try {
			if (objeto.getId() == -1) {
				PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO jogo(regras,nome)"+
					"values(?,?);"
				);
				ps.setString(1, objeto.getRegras());
				ps.setString(2, objeto.getNome());
				ps.execute();
				objeto.setId(this.buscarIDBanco(objeto));
			} else {
				PreparedStatement ps = cn.prepareStatement(
						"UPDATE jogo SET regras = ?, nome = ?"+
						"WHERE id = ?;"
				);
				ps.setString(1, objeto.getRegras());
				ps.setString(2, objeto.getNome());
				ps.setInt(3, objeto.getId());
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
		Connection cn = GestorDeConexao.getConection();
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(
				"DELETE FROM jogo where id = ?;"
			);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int buscarIDBanco(Jogo objeto) {
		Connection cn = GestorDeConexao.getConection();
		try {
			PreparedStatement ps = cn.prepareStatement(
				"SELECT id FROM jogo where regras = ? and nome = ? " +
				"ORDER BY id DESC;"
			);
			ps.setString(1, objeto.getRegras());
			ps.setString(2, objeto.getNome());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch (SQLException e) {
			System.err.println("Erro ao buscar o item.");
		}
		return -1;
	}

}
