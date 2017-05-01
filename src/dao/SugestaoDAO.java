package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Sugestao;

public class SugestaoDAO {
	Sugestao sugestao = new Sugestao();
	public int novaSugestao(Sugestao sugestao) {
		String sqlInsert = "INSERT INTO sugestao(colaborador, titulo, sugestao, especialidade, status, Data) VALUES (?, ?, ?, ?, 'inativo', NOW())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, sugestao.getColaborador());
			stm.setString(2, sugestao.getTitulo());
			stm.setString(3, sugestao.getSugestao());
			stm.setInt(4, sugestao.getEspecialidade());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					sugestao.setIdSugestao(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sugestao.getIdSugestao();
	}
}
