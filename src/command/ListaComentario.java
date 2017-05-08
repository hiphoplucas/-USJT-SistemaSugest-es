package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import service.ComentarioService;



public class ListaComentario implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		ComentarioService cs = new ComentarioService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Comentario> listaComentario = null;
		listaComentario = cs.listarComentario();
		session.setAttribute("listaComentario", listaComentario);
		
		//System.out.println(lista.get(0));
		
		view = request.getRequestDispatcher("verMais.jsp");
		view.forward(request, response);


	}

	public int busca(Comentario comentario, ArrayList<Comentario> listaComentario) {
		Comentario to;
		for (int i = 0; i < listaComentario.size(); i++) {
			to = listaComentario.get(i);
			if (to.getId() == comentario.getId()) {
				return i;
			}
		}
		return -1;
	}

}
