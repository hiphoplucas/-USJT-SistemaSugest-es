package service;

import dao.CategoriaDAO;
import model.Categoria;
import model.Usuario;

public class CategoriaService {
	CategoriaDAO dao = new CategoriaDAO();
	
	public int criar(Categoria categoria) {
		return dao.criar(categoria);
	}
	public Categoria carregar(int id){
		return dao.carregar(id);
	}
}
