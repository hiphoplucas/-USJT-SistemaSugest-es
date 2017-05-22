package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import service.CategoriaService;

public class InativaCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		
		Categoria categoria = new Categoria();
		categoria.setId(pIdCategoria);
		
		CategoriaService cs = new CategoriaService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cs.inativarCategoria(pIdCategoria);
		categoria = cs.carregar(categoria.getId());
		request.setAttribute("categoria", categoria);
		
		view = request.getRequestDispatcher("categorias.jsp");
		view.forward(request, response);
		


	}
}