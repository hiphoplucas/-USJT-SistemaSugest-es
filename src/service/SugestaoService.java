package service;

import java.util.ArrayList;

import dao.SugestaoDAO;
import model.Sugestao;

public class SugestaoService {
	SugestaoDAO dao = new SugestaoDAO();
	
	public int novaSugestao(Sugestao sugestao) {
		return dao.novaSugestao(sugestao);
	}
	public ArrayList<Sugestao> listarTopSugestao(){
		return dao.listarTopSugestao();
	}
	public ArrayList<Sugestao> listarSugestao(){
		return dao.listarSugestao();
	}
	public Sugestao carregar(int id){
		return dao.carregar(id);
	}
	public ArrayList<Sugestao> listarSugestaoAvalia(int idEspecialidade){
		return dao.listarSugestaoAvalia(idEspecialidade);
	}
	public ArrayList<Sugestao> participacao(){
		return dao.participacao();
	}
	public void atualizar(int idSugestao){
		dao.atualizar(idSugestao);
	}
}
