/**
 * 
 */
package br.com.inm.reqresin.api.services;

import static io.restassured.RestAssured.*;

import br.com.inm.reqresin.api.massatestes.DadosGeraisAPI;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * Classe base da API Usuários
 * 
 * 
 * @author August Neto
 *
 */
public abstract class UserAPIBase {

		// URL da api para consulta de usuário único
		protected static final String URI_USERS = "https://reqres.in/api/users";
		
		protected RequestSpecification requisicao;
		protected Response resposta;
		protected ValidatableResponse json;
		protected JsonPath jsonpath;
		
		//Nome de parâmetros comuns do header
		private final String XAPIKEY = "x-api-key";
	
	/**
	 * 
	 * Construtor padrão.
	 * 
	 */
	protected UserAPIBase() {
		
		//Definir a base da URL
		baseURI = URI_USERS;
		Header headerapikey = new Header(XAPIKEY, DadosGeraisAPI.APIKEYVALUE);
		requisicao =given()
						.header(headerapikey);
	}
	
	/**
	 * Guardar os dados da requisição
	 * 
	 */
	protected void guardarResposta() {
		
		//Guarda a resposta
		json = resposta
				.then();
		jsonpath =resposta
				.jsonPath();

	}
	
	/**
	 * 
	 *   Retorna o status code da requisição
	 * 
	 * @return
	 */
	public int retornaStatusCode() {
		
		return resposta.getStatusCode();
	}
	
	/**
	 *   Retorna o corpo
	 * 
	 */
	
	public String retornaBody() {

		return resposta
				.prettyPrint();
	}

	/**
	 *   Imprime log da resposta
	 * 
	 */
	
	public void logResposta() {

		System.out.println("----REQUISIÇÃO----");
		requisicao
			.log().all();
		System.out.println("----RESPOSTA----");
		json
			.log().all();
		
	
		
	}
	

	
	
}
