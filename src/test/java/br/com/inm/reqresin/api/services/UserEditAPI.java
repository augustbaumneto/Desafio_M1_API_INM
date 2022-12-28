/**
 * 
 */
package br.com.inm.reqresin.api.services;



import static io.restassured.RestAssured.given;

import br.com.inm.reqresin.api.services.json.UsuarioReqJson;
import br.com.inm.reqresin.api.services.json.UsuarioResEditadoJson;
import io.restassured.http.ContentType;

/**
 * 
 * Classe que representa a API Edit User Put e Patch (https://reqres.in/)
 * 
 * @author August Neto
 *
 */
public class UserEditAPI extends UserAPIBase {

	private UsuarioReqJson usuariorequisicao;
	private UsuarioResEditadoJson usuarioeditado;
	
	/**
	 * Construtor padrão
	 */
	public UserEditAPI() {
		super();
	}

	/**
	 * 
	 * Prepara a requisição para editar um usuario
	 * 
	 * @param nome
	 * @param cargo
	 */
	public void montaAPIEditaUsuario(String nome, String cargo) {
		
		if (nome==null) {
			if (!(cargo==null)) {
				usuariorequisicao = new UsuarioReqJson();
				usuariorequisicao.setJob(cargo);
			} else {
				usuariorequisicao = new UsuarioReqJson();
			}
			
		} else {
			if (!(cargo==null)) {
				usuariorequisicao = new UsuarioReqJson(nome, cargo);
			}else {
				usuariorequisicao = new UsuarioReqJson();
				usuariorequisicao.setName(nome);
			}
			
		}
		
		requisicao = given()
							.body(usuariorequisicao)
							.contentType(ContentType.JSON);
	}

	/**
	 * Chama o metodo put de edição de usuário.
	 * 
	 */
	public void chamarAPIEditaUsuarioPut(String idusuario) {

		requisicao = requisicao.when();
		
		resposta = requisicao.put("/"+idusuario);
		

		guardarResposta();
		montaPagina();

	}

	/**
	 * 
	 * Monta o json em um objeto para facilitar a manipulação no java
	 * 
	 */
	private void montaPagina() {

		usuarioeditado=json
			.extract()
				.body()
				.as(UsuarioResEditadoJson.class);

	}

	/**
	 * 
	 * Verifica se o nome do usuario editado é igual aos dados enviados na requisição 
	 * 
	 * @param nome
	 * @return
	 */
	public boolean verificaNomeEditado(String nome) {
		
		return (usuarioeditado.getName().equals(nome));
	}

	/**
	 * 
	 * Verifica se o cargodo usuario editado é igual aos dados enviados na requisição 
	 * 
	 * @param cargo
	 * @return
	 */
	public boolean verificaCargoEditado(String cargo) {
		
		return (usuarioeditado.getJob().equals(cargo));
	}

	/**
	 * 
	 * Apenas verifica se a data de edição não é vazia
	 * 
	 * @return
	 */
	public boolean verificaDataEdicao() {
		
		return !usuarioeditado.getUpdatedAt().isEmpty();
		
	}

	public void chamarAPIEditaUsuarioPatch(String idusuario) {
	requisicao = requisicao.when();
		
		resposta = requisicao
					.patch("/"+idusuario);
		

		guardarResposta();
		montaPagina();
		
	}
	

}
