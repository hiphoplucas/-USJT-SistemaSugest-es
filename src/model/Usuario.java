package model;

public class Usuario {

	   private String nome;
	   private String cpf;
	   private String email;
	   private String senha;
	   private String curso;
	   private int id;
	   private int tipo;
	   private int idEspecialidade;
	  
	   public static String publicNome;
	   
	   public Usuario(){
	      nome = "";
	      cpf = "";
	      email= "";
	      senha= "";
	      curso= "";
	      id=0;   
	   }

	   public Usuario(String n, String cp, String e, String s, String c, int esp){
	      setNome(n);
	      publicNome = n;
	      setCpf(cp);
	      setEmail(e);
	      setSenha(s);
	      setCurso(c);
	      setIdEspecialidade(esp);
	   }
	   
	   public Usuario(int id, String n, String cp, String e, String s, String c){      
	      setIdUsuario(id);
	      setNome(n);
	      setCpf(cp);
	      setEmail(e);
	      setSenha(s);
	      setCurso(c);
	      
	   }

	   public void setIdUsuario(int i){
		   id = i;
	   }
	   public int getidUsuario(){
	      return id;
	   }
	   
	   public void setTipoUsuario(int i){
		   id = i;
	   }
	   public int getTipoUsuario(){
	      return id;
	   }
	   
	   public static void setPublicNome(String s){
	      publicNome = s;
	   }
	   
	   public static String getPublicNome(){
	      return publicNome;
	   }
	   
	   public void setNome(String n){
	      nome = n;
	   }
	   public String getNome(){
	      return nome;
	   }
	   
	   public void setCpf(String cp){
	      cpf = cp.replaceAll("[^0123456789]", "");
	   }
	   public String getCpf(){
	      return cpf;
	   }

	   public void setEmail(String e){
	      email = e;
	   }
	   public String getEmail(){
	      return email;
	   }

	   public void setSenha(String s){
	      senha = MD5.MD5(s);
	   }
	   public String getSenha(){
	      return senha;
	   }
	   public void setCurso(String c){
	      curso = c;
	   }
	   public String getCurso(){
	      return curso;
	   }
	   public void setTipo(int t){
	      tipo = t;
	   }
	   public int getTipo(){
	      return tipo;
	   }
	   public void setIdEspecialidade(int i){
	      idEspecialidade = i;
	   }
	   public int getIdEspecialidade(){
	      return idEspecialidade;
	   }

}
