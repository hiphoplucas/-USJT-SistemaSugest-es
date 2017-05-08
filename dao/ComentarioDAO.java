package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentarios (idUsuario, idSugestao, comentario) VALUES (?, ?, ?);";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, 0);
			stm.setInt(2, comentario.getIdSugestao());
			stm.setString(3, comentario.getComentario());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getId();
	}
	public ArrayList<Comentario> ListarComentario(int id) {
		Comentario comentario = new Comentario();
		comentario.setIdSugestao(id);
		ArrayList<Comentario> listaComentario = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, nome, comentario FROM comentarios join usuarios on usuarios.idusuario = comentarios.idUsuario where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, comentario.getIdSugestao());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNomeColaborador(rs.getString("nome"));
					comentario.setComentario(rs.getString("comentario"));
				} else {
					comentario.setIdSugestao(-1);
					comentario.setNomeColaborador(null);
					comentario.setComentario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaComentario;
	}
}
