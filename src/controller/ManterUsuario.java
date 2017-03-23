package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import dao.Conexao;
import dao.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		Conexao bd = new Conexao();
		

		
		String Nome = request.getParameter("nome");
		String Email = request.getParameter("email");
		
		String acao = request.getParameter("acao");
		
		switch(acao){
		
			case "CADASTRAR":
				
				Usuario usuario = new Usuario(Nome, "", Email, "", "", 0);
				UsuarioDao dao = new UsuarioDao();
				
				try { 
					
					conn = (Connection) bd.obtemConexao();
					conn.setAutoCommit(false);
					dao.IncluirColaborador(conn, usuario);
					conn.commit();
					
				}catch(Exception e){
		            e.printStackTrace();
		        }
				
				
				
				
			break;
		
		}
			
		
	}

}
