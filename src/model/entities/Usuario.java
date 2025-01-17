package model.entities;

public class Usuario {
	private Long id;
	private String login;
	private String currentLogin;
	private String senha;
	private Boolean isAdmin;
	
	public Usuario(String login) {
		super();
		this.login = login;
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String login,String currentLogin, String senha) {
		super();
		this.login = login;
		this.currentLogin = currentLogin;
		this.senha = senha;
	}

	public Usuario(String login, Boolean isAdmin) {
		super();
		this.login = login;
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getCurrentLogin() {
		return currentLogin;
	}
	
	public void setCurrentLogin(String currentLogin) {
		this.currentLogin = currentLogin;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
