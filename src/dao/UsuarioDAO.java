package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuarios(nome, senha, email, cpf, tipo) VALUES (?, ?, ?, ?, 1)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getCpf());
			stm.setString(2, usuario.getSenha());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}
	
	public int criarAvaliador(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuarios(nome, senha, email, cpf, idEspecialidade, tipo, usuarios.status) VALUES (?, ?, ?, ?, ?, 2, 'ativo')";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSenha());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getCpf());
			stm.setInt(5, usuario.getIdEspecialidade());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuarios SET nome=?, email=?, cpf=? WHERE idUsuario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCpf());
			stm.setInt(4, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inativar(int id) {
		String sqlUpdate = "UPDATE usuarios SET usuarios.status= 'inativo' WHERE idUsuario="+id;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE from usuarios where idUsuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, email, senha, cpf from usuarios WHERE idusuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setCpf(rs.getString("senha"));
					usuario.setCpf(rs.getString("cpf"));
				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setCpf(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
	public boolean login(String usuario, String senha, HttpServletRequest request) {
		
		String sqlSelect = "SELECT idusuario, nome, email, cpf, tipo, idEspecialidade FROM usuarios WHERE Email = ? AND senha = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, usuario);
			stm.setString(2, senha);			
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					Usuario user = new Usuario();
					user.setId(rs.getInt("idusuario"));
					user.setNome(rs.getString("nome"));
					user.setEmail(rs.getString("email"));
					user.setCpf(rs.getString("cpf"));
					
					HttpSession sessao = request.getSession();
					sessao.setAttribute("tipousuario", rs.getInt("tipo"));
					sessao.setAttribute("idusuario", rs.getInt("idusuario"));
					sessao.setAttribute("ObjectUsuario", user);					
					sessao.setAttribute("idespecialidade", rs.getInt("idespecialidade"));
					
					return true;
					
				}else{
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			return false;
		}
		
	}
	
	
	public ArrayList<Usuario> listarAvaliador(String status) {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "select idUsuario, nome, email, especialidade.nomeEspecialidade as especialidade from usuarios join especialidade on especialidade.idEspecialidade = usuarios.idEspecialidade where usuarios.status "+status;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));;
					usuario.setNomeEspecialidade(rs.getString("especialidade"));;
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
