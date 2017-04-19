package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.Usuario;


public class CategoriaDAO {
	public int criar(Categoria categoria) {
		String sqlInsert = "INSERT INTO especialidade(nomeEspecialidade, corEspecialidade) VALUES(?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, categoria.getCategoria());
			stm.setString(2, categoria.getCor());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					categoria.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria.getId();
	}
	
	public Categoria carregar(int id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		String sqlSelect = "select nomeEspecialidade, corEspecialidade from especialidade where idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, categoria.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					categoria.setCategoria(rs.getString("nomeEspecialidade"));
					categoria.setCor(rs.getString("corEspecialidade"));
				} else {
					categoria.setId(-1);
					categoria.setCategoria(null);
					categoria.setCor(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return categoria;
	}
}
