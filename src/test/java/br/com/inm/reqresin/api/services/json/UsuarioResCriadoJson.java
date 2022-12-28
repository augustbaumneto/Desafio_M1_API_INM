/**
 * 
 */
package br.com.inm.reqresin.api.services.json;

import lombok.Data;

/**
 * 
 * Classe responsável por guardar o json da resposta dos usuários trazidos na api post de usuario
 * 
 * @author August Neto
 *
 */
@Data
public class UsuarioResCriadoJson {

	private String name;
	private String job; 
	private String id;
	private String createdAt;
	
	
	/**
	 * Construtor padrão
	 */
	public UsuarioResCriadoJson() {
		
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}


	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}


	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}


	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the id
	 */
	public String getid() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setid(String id) {
		this.id = id;
	}	
	
}
