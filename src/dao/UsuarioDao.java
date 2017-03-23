package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MD5;
import model.Usuario;

public class UsuarioDao {
	
	public UsuarioDao() {
	}
	
	public void IncluirColaborador(Connection conn, Usuario usuario){
	      String sqlInsertColaborador= "INSERT INTO usuarios(nome, cpf, senha, email, tipo) VALUES (?, ?, ?, ?, 1)";      
	      PreparedStatement stm = null;
	      
	      try{
	         stm = conn.prepareStatement(sqlInsertColaborador);
	                  
	         stm.setString(1, usuario.getNome());
	         stm.setString(2, usuario.getCpf());         
	         stm.setString(3, usuario.getSenha());
	         stm.setString(4, usuario.getEmail());         
	         stm.execute();
	         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	         
	         try{
	            conn.rollback();
	         }
	         catch(Exception e1){
	            System.out.print(e1.getStackTrace());
	         }
	      }
	      finally{
	         if(stm!=null){
	            try{
	               stm.close();
	            }
	            catch(Exception e1){
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	   
	   }
	   
	   public void IncluirAvaliador(Connection conn, Usuario usuario){
	      String sqlInsertAvaliador= "INSERT INTO usuarios(nome, cpf, senha, email, tipo, idEspecialidade) VALUES (?, ?, ?, ?, 2, ?)";
	      
	      PreparedStatement stm = null;
	      
	      try{
	         stm = conn.prepareStatement(sqlInsertAvaliador);
	         
	         stm.setString(1, usuario.getNome());
	         stm.setString(2, usuario.getCpf());         
	         stm.setString(3, usuario.getSenha());
	         stm.setString(4, usuario.getEmail());
	         stm.setInt(5, usuario.getIdEspecialidade());
	         
	         stm.execute();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	         
	         try{
	            conn.rollback();
	         }
	         catch(Exception e1){
	            System.out.print(e1.getStackTrace());
	         }
	      }
	      finally{
	         if(stm!=null){
	            try{
	               stm.close();
	            }
	            catch(Exception e1){
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	   
	   }
	   
	   public void ExcluirColaborador(Connection conn, int id){
	      String sqlDelete = "DELETE FROM usuarios WHERE id = ? and tipo = 1";
	      
	      PreparedStatement stm = null;
	      
	      try{
	         stm = conn.prepareStatement(sqlDelete);
	         stm.setInt(1, id);
	         stm.execute();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	         
	         try{
	            conn.rollback();
	         }
	         catch(SQLException e1){
	            System.out.print(e1.getStackTrace());
	         }
	      }
	      finally{
	         if(stm!=null){
	            try{
	               stm.close();
	            }
	            catch(SQLException e1){
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	   }
	   
	   public void Login(Connection conn, Usuario usuario){
	      String sqlLogin = "SELECT * FROM usuarios WHERE email=? and senha=?";
	   
	      PreparedStatement stm = null;
	      ResultSet rs = null;
	      
	      try {
	         stm = conn.prepareStatement(sqlLogin);
	         
	         String passwordHash = MD5.MD5(usuario.getSenha());

	         stm.setString(1, usuario.getEmail());
	         stm.setString(2, passwordHash);
	         rs = stm.executeQuery();
	         
	         if(rs.next()){
	        	usuario.setEmail(rs.getString("email"));
	        	usuario.setSenha(rs.getString("senha")); 
	                    
	        	usuario.setIdUsuario(rs.getInt(1));
	        	usuario.setIdEspecialidade(rs.getInt("idEspecialidade"));
	        	usuario.setTipoUsuario(rs.getInt("tipo"));
	        	usuario.setNome(rs.getString("nome"));
	            //JOptionPane.showMessageDialog(null, "Bem vindo "+rs.getString(2)+"!"+"\n Login Realizado");            
	         }else{
	             
	        	 //JOptionPane.showMessageDialog(null, "Email e/ou Senha estão incorretos.");
	         }
	      }    
	      catch(Exception e){
	         e.printStackTrace();
	         try{
	            conn.rollback();
	         }
	         catch(SQLException e1){
	            System.out.print(e1.getStackTrace());
	         }
	            
	      }
	      finally{
	         if(stm != null){
	            try{
	               stm.close();
	            }
	            catch(SQLException e1){
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	   }
	   
	   public static boolean CheckUser(Connection conn, String cpf){
	      String sqlLogin = "SELECT * FROM usuarios WHERE cpf=?";
	      boolean check = true;
	      PreparedStatement stm = null;
	      ResultSet rs = null;
	      
	      try{
	         stm = conn.prepareStatement(sqlLogin);        
	         stm.setString(1, cpf.replaceAll("[^0123456789]", ""));
	         rs = stm.executeQuery();
	         
	         if(rs.next()){ check = true; }else{ check = false; }
	         
	      }    
	      catch(Exception e){
	         e.printStackTrace();
	         try{
	            conn.rollback();
	         }
	         catch(SQLException e1){
	            System.out.print(e1.getStackTrace());
	         }
	            
	      }
	      finally{
	         if(stm != null){
	            try{
	               stm.close();
	            }
	            catch(SQLException e1){
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	      
	      return check;
	   }
	   
}
