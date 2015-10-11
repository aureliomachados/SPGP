package mvc.beans;

public class Usuario {
 private int id;
 private String cpf;
 private String nome;
 private String login;
 private String senha;
 private String perfil;
 private String departamento;
 private String situacao;
 
 	public Usuario() {
	}
 	
	public Usuario(String login) {
		this.login = login;
	}
	
	public Usuario( int id, String cpf, String nome, String login, String senha,
			String perfil, String departamento, String situacao) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.departamento = departamento;
		this.situacao = situacao;
		
	}
	public Usuario(String cpf, String nome, String login, String senha,
			String perfil, String departamento, String situacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.departamento = departamento;
		this.situacao = situacao;
		
	}

	public Usuario(String cpf, String nome, String login, String senha,
			String perfil, String departamento) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.departamento = departamento;
				
	}

	public Usuario(String login,String senha, String situacao) {
		this.login = login;
		this.senha = senha;
		this.situacao = situacao;
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}