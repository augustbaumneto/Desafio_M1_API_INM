package br.com.inm.reqresin.api.services.json;

import lombok.Data;

/**
 * 
 * Classe para guardar as requisições de criação e edição de usuários das apis post, put e patch
 * 
 * @author August Neto
 *
 */
@Data
public class UsuarioReqJson {

	private String name;
	private String job;
	
	//Construtor padrão
	public UsuarioReqJson() {
	
	}

	//Constutor Completo
	public UsuarioReqJson(String name, String job) {
		this.name = name;
		this.job = job;
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

	
}
