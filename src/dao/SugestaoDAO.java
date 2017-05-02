package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Sugestao> listarTopSugestao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "SELECT sugestao.idSugestao, count(comentarios.comentario) as qtd, titulo, sugestao from sugestao join comentarios on comentarios.idSugestao = sugestao.idSugestao order by qtd desc limit 5";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					listaTop.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaTop;
	}
}
