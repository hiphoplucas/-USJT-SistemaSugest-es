package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Sugestao;
import service.CategoriaService;
import service.SugestaoService;

public class CarregaMinhaSugestao implements Command {
	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		CategoriaService cs = new CategoriaService();
		SugestaoService ss = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria();
		session.setAttribute("lista", lista);
		
		ArrayList<Sugestao> listaSugestaoUsuario = null;
		listaSugestaoUsuario = ss.listarSugestaoUsuario(pIdUsuario);
		session.setAttribute("listaSugestaoUsuario", listaSugestaoUsuario);
		
		view = request.getRequestDispatcher("avaliarSugestao.jsp");
		view.forward(request, response);
		


	}
}