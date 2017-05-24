package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class AlteraAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pCpf = request.getParameter("cpf");
		int pCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		System.out.println(pNome+" "+pEmail+" "+pCpf+" "+pCategoria);
		
		Usuario usuario = new Usuario();
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setIdEspecialidade(pCategoria);
		usuario.setCpf(pCpf);
					
		UsuarioService us = new UsuarioService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		us.atualizarAvaliador(usuario);
		us.carregar(pIdUsuario);
		request.setAttribute("usuario", usuario);
				
		view = request.getRequestDispatcher("controller.do?command=ListarAvaliador&status= in ('ativo')");
		view.forward(request, response);
		


	}
}