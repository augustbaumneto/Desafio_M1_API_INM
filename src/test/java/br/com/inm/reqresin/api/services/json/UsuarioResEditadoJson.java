/**
 * 
 */
package br.com.inm.reqresin.api.services.json;

import lombok.Data;

/**
 * 
 * Classe responsável por guardar o json da resposta do usuário editado pelas api put e patch
 * 
 * @author August Neto
 *
 */
@Data
public class UsuarioResEditadoJson {

	private String name;
	private String job; 
	private String updatedAt;
	
	
	/**
	 * Construtor padrão
	 */
	public UsuarioResEditadoJson() {
		
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
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}


	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
}
