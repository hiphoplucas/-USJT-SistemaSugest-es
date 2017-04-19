package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import service.CategoriaService;



/**
 * Servlet implementation class ManterCategoriaController
 */
@WebServlet("/ManterCategoria.do")
public class ManterCategoriaController extends HttpServlet {
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
		String pEspecialidade = request.getParameter("categoria");
		String pCor = request.getParameter("cor");;
		
		//instanciar o javabean
		Categoria categoria = new Categoria();
		categoria.setCategoria(pEspecialidade);
		categoria.setCor(pCor);
		
		//instanciar o service
		CategoriaService cs = new CategoriaService();
		cs.criar(categoria);
		categoria = cs.carregar(categoria.getId());
				
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"categoria: "+categoria.getCategoria()+"<br>");
		out.println(	"cor: "+categoria.getCor()+"<br>");
	    out.println("</body></html>");
	}

}
