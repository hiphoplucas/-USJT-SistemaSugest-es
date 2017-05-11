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
		String sqlSelect = "select comentarios.idSugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, count(comentarios.id),sugestao.titulo as titulo,sugestao.Sugestao as sugestao,especialidade.nomeEspecialidade as especialidade from comentarios join sugestao on sugestao.idSugestao = comentarios.idSugestao join especialidade on especialidade.idEspecialidade = sugestao.especialidade group by comentarios.idSugestao order by count(comentarios.id) desc limit 0,5";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
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
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE status='ativo' order by data desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 95){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 95)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
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
	public ArrayList<Sugestao> listarSugestaoCategoria(String idEspecialidade) {
		Sugestao sugestao;
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE status='ativo' and sugestao.Especialidade = ? order by data desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, idEspecialidade);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 95){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 95)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
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
	public ArrayList<Sugestao> listarSugestaoAvalia(int idEspecialidade) {
		Sugestao sugestao = new Sugestao();
		ArrayList<Sugestao> listaSugestaoAvalia = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor, sugestao.status as status FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE especialidade.idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idEspecialidade);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 145){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 145)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					sugestao.setStatus(rs.getString("status"));
					listaSugestaoAvalia.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestaoAvalia;
	}
	public ArrayList<Sugestao> listarSugestaoUsuario(int idUsuario) {
		Sugestao sugestao = new Sugestao();
		ArrayList<Sugestao> listaSugestaoUsuario = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor, sugestao.status as status FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE sugestao.Colaborador = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idUsuario);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 150){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 150)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					sugestao.setStatus(rs.getString("status"));
					listaSugestaoUsuario.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestaoUsuario;
	}
	public Sugestao carregar(int id) {
		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(id);
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, status, feedback FROM sugestao WHERE idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, sugestao.getIdSugestao());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					sugestao.setStatus(rs.getString("status"));
					if(rs.getString("feedback") == null ){
						sugestao.setFeedback("O avaliador responsável ainda não passou um feedback para a sua sugestão.");
					}else{
						sugestao.setFeedback(rs.getString("feedback"));
					}
				} else {
					sugestao.setIdSugestao(-1);
					sugestao.setTitulo(null);
					sugestao.setSugestao(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return sugestao;
	}
	
	public ArrayList<Sugestao> participacao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaParticipacao = new ArrayList<>();
		String sqlSelect = "SELECT usuarios.nome as nome, count(sugestao.Colaborador) as quantidade from sugestao join usuarios on usuarios.idusuario = sugestao.Colaborador group by sugestao.Colaborador order by quantidade desc;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setNomeColaborador(rs.getString("nome"));
					sugestao.setpQuantidade(rs.getInt("quantidade"));
					listaParticipacao.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaParticipacao;
	}
	
	public void aprovar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'ativo' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void inativar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'inativa' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void recusar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'recusada' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizaFeedback(int idSugestao, String feedback) {
		String sqlUpdate = "update sugestao set feedback = ? where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, feedback);
			stm.setInt(2, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
