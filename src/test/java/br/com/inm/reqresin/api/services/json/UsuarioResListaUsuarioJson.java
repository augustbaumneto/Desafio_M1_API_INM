/**
 * 
 */
package br.com.inm.reqresin.api.services.json;

/**
 * 
 * Classe que representa o JSON de usuário da reposta da api lista de usuarios
 * 
 * @author August Neto
 *
 */
public class UsuarioResListaUsuarioJson {

	
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	
	/**
	 * Construtor base
	 * 
	 */
	public UsuarioResListaUsuarioJson() {
		
	}

	/**
	 * Construtor completo
	 * 
	 */
	public UsuarioResListaUsuarioJson(int id, String email, String primeironome, String ultimonome, String avatar) {
		this.id=id;
		this.email = email;
		first_name = primeironome;
		last_name = ultimonome;
		this.avatar=avatar;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	
}
