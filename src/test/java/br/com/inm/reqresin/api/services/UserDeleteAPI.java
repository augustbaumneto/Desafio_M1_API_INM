/**
 * 
 */
package br.com.inm.reqresin.api.services;


import io.restassured.RestAssured;

/**
 * @author August Neto
 *
 *         Classe que representa a API List User (https://reqres.in/)
 *
 */
public class UserDeleteAPI extends UserAPIBase {

	private String urlauxiliar;
	

	// Construtor padrão
	public UserDeleteAPI() {
		super();

	}
	
	/**
	 * Prepara a requisição para apagar usuarios
	 */
	public void montaAPIApagaUsuario() {
		requisicao = RestAssured
				.given();

	}

	/**
	 * 
	 * Prepara o complemento da url para apagar o usuario
	 * 
	 * @param idapagar
	 */
	public void prepararUrlApagar(int idapagar) {

			urlauxiliar = "/" + idapagar;

	}

	/**
	 * Chama a api para deletar o usuário
	 * 
	 */
	public void chamarAPIDeletaUsuario() {
		requisicao = requisicao.when();

		resposta = requisicao.delete(urlauxiliar);

		guardarResposta();

	}

}
