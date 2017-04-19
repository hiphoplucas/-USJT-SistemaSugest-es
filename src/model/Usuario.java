package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String email;
	private String cfp;
	private String senha;
	private int idEspecialidade;
	
	public Usuario() {
		
	}
	public Usuario(int id, String nome, String email, String cfp, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cfp = cfp;
		this.senha = senha;
	}
	public Usuario(int id, String nome, String email, String cfp, String senha, int idEspecialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cfp = cfp;
		this.senha = senha;
		this.idEspecialidade = idEspecialidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCfp() {
		return cfp;
	}
	public void setCfp(String cfp) {
		this.cfp = cfp;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdEspecialidade() {
		return idEspecialidade;
	}
	public void setIdEspecialidade(int idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}	
}
