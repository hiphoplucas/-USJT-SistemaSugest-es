package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class ManterUsuarioAvaliadorController
 */
@WebServlet("/ManterUsuarioAvaliador.do")
public class ManterUsuarioAvaliadorController extends HttpServlet {
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
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");;
		String pCpf = request.getParameter("cpf");;
		String pSenha = request.getParameter("senha");;
		int pIdEspecialidade = Integer.parseInt("idEspecialidade");
		
		//instanciar o javabean
		Usuario usuario = new Usuario();
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setCfp(pCpf);
		usuario.setSenha(pSenha);
		usuario.setIdEspecialidade(pIdEspecialidade);
		
		//instanciar o service
		UsuarioService us = new UsuarioService();
		us.criarAvaliador(usuario);
		usuario = us.carregar(usuario.getId());
				
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+usuario.getId()+"<br>");
		out.println(	"nome: "+usuario.getNome()+"<br>");
		out.println(	"Email: "+usuario.getEmail()+"<br>");
		out.println(	"Cpf: "+usuario.getCfp()+"<br>");
		out.println(	"Especialidade: "+usuario.getIdEspecialidade()+"<br>");
	    out.println("</body></html>");
	}

}
