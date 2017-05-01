package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sugestao;
import service.SugestaoService;

public class CriarSugestao implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		int pCategoria = Integer.parseInt(request.getParameter("categoria"));
		String pTitulo = request.getParameter("titulo");
		String pSugestao = request.getParameter("sugestao");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(id);
		sugestao.setEspecialidade(pCategoria);
		sugestao.setTitulo(pTitulo);
		sugestao.setSugestao(pSugestao);
		SugestaoService ss = new SugestaoService();
		ss.novaSugestao(sugestao);
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
				
		view = request.getRequestDispatcher("sugestoes.jsp");
		view.forward(request, response);


	}

	public int busca(Sugestao sugestao, ArrayList<Sugestao> lista) {
		Sugestao to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdSugestao() == sugestao.getIdSugestao()) {
				return i;
			}
		}
		return -1;
	}

}
