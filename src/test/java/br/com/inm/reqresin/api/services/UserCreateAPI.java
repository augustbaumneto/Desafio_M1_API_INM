/**
 * 
 */
package br.com.inm.reqresin.api.services;



import br.com.inm.reqresin.api.services.json.UsuarioReqJson;
import br.com.inm.reqresin.api.services.json.UsuarioResCriadoJson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * 
 * Classe que representa a API Create User (https://reqres.in/)
 * 
 * @author August Neto
 *
 */
public class UserCreateAPI extends UserAPIBase {

	private UsuarioReqJson usuariorequisicao;
	private UsuarioResCriadoJson usuariocriado;
	
	/**
	 * Construtor padrão
	 */
	public UserCreateAPI() {
		super();
	}

	/**
	 * 
	 * Prepara a requisição para criar um usuario
	 * 
	 * @param nome
	 * @param cargo
	 */
	public void montaAPICriaUsuario(String nome, String cargo) {
		usuariorequisicao = new UsuarioReqJson(nome, cargo);
		
		requisicao = RestAssured
						.given()
							.body(usuariorequisicao)
							.contentType(ContentType.JSON);
	}

	/**
	 * Chama o metodo post de criação de usuário.
	 * 
	 */
	public void chamarAPICriaUsuario() {

		requisicao = requisicao.when();
		
		resposta = requisicao.post();
		

		guardarResposta();
		montaPagina();

	}

	/**
	 * 
	 * Monta o json em um objeto para facilitar a manipulação no java
	 * 
	 */
	private void montaPagina() {

		usuariocriado=json
			.extract()
				.body()
				.as(UsuarioResCriadoJson.class);

	}

	/**
	 * 
	 * Verifica se os dados do usuario criado é igual aos dados enviados na requisição 
	 * 
	 * @param nome
	 * @param cargo
	 * @return
	 */
	public boolean verificaDadosUsuarioCriado(String nome, String cargo) {
		
		return (usuariocriado.getName().equals(nome))&&
				(usuariocriado.getJob().equals(cargo));
	}

	/**
	 * 
	 * Verifica se o Id criado é um numero inteiro
	 * 
	 * @return
	 */
	public boolean verificaIdValido() {
		
		try {
			Integer.parseInt(usuariocriado.getid());
			return true;
		} catch (NumberFormatException e) {
		
		return false;
		}
	}

	/**
	 * 
	 * Apenas verifica se a data de criação não é vazia
	 * 
	 * @return
	 */
	public boolean verificaDataCriacao() {
		
		return !usuariocriado.getCreatedAt().isEmpty();
		
	}
	
	
}
