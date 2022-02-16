package fr.koor.library.business;

public class User {
	
	private int id;
	private String login;
	private String password;
	private int numberConnexion;
	
	
	
	
	
	
	public User(int id, String login, String password, int numberConnexion) {
		
		this.id=id;
		this.login=login;
		this.password=password;
		this.numberConnexion=numberConnexion;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	public int getNumberConnexion() {
		return numberConnexion;
	}
	public void setNumberConnexion(int numberConnexion) {
		this.numberConnexion = numberConnexion;
	}
	
	

}
