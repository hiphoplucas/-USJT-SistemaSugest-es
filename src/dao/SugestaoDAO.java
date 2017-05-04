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
		String sqlSelect = "select comentarios.idSugestao,DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, count(comentarios.id),sugestao.titulo as titulo,sugestao.Sugestao as sugestao,especialidade.nomeEspecialidade as especialidade from comentarios join sugestao on sugestao.idSugestao = comentarios.idSugestao join especialidade on especialidade.idEspecialidade = sugestao.especialidade group by comentarios.idSugestao order by count(comentarios.id) desc limit 0,5";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
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
	public ArrayList<Sugestao> listarSugestao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaSugestao = new ArrayList<>();
		String sqlSelect = "SELECT s.*, e.corEspecialidade, e.nomeEspecialidade, DATE_FORMAT(s.data, '%d/%m/%y') as dataF FROM sugestao s INNER JOIN especialidade e ON s.Especialidade=e.idEspecialidade WHERE status='ativo'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					sugestao.setData(rs.getString("dataF"));
					sugestao.setNomeEspecialidade(rs.getString("nomeEspecialidade"));
					sugestao.setCorEspecialidade(rs.getString("corEspecialidade"));
					listaSugestao.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestao;
	}
}
