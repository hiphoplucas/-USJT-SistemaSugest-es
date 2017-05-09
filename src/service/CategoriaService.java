package service;

import java.util.ArrayList;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaService {
	CategoriaDAO dao = new CategoriaDAO();
	
	public int criar(Categoria categoria) {
		return dao.criar(categoria);
	}
	public Categoria carregar(int id){
		return dao.carregar(id);
	}
	public ArrayList<Categoria> listarCategoria(){
		return dao.listarCategoria();
	}
}
