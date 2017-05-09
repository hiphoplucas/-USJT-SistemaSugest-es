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

public class CriarComentario implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pComentario = request.getParameter("comentario");
		int pIdSugestao = Integer.parseInt(request.getParameter("idSugestao"));
		System.out.println(pComentario + pIdSugestao);

		Comentario comentario = new Comentario();
		comentario.setColaborador(15);
		comentario.setIdSugestao(pIdSugestao);
		comentario.setComentario(pComentario);
		
		ComentarioService cs = new ComentarioService();
		cs.criar(comentario);
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
						
		view = request.getRequestDispatcher("verMais.jsp");
		view.forward(request, response);


	}
}
