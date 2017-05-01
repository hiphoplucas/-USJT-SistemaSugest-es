package service;

import model.Categoria;
import model.Usuario;

import java.util.ArrayList;

import dao.UsuarioDAO;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	public int criarAvaliador(Usuario usuario) {
		return dao.criarAvaliador(usuario);
	}
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	public ArrayList<Usuario> listarAvaliador(){
		return dao.listarAvaliador();
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}

}
