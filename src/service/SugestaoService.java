package service;

import dao.SugestaoDAO;
import model.Categoria;
import model.Sugestao;

public class SugestaoService {
	SugestaoDAO dao = new SugestaoDAO();
	
	public int novaSugestao(Sugestao sugestao) {
		return dao.novaSugestao(sugestao);
	}
}
