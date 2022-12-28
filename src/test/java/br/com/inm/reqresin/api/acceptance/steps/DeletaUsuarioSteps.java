package br.com.inm.reqresin.api.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.inm.reqresin.api.services.UserDeleteAPI;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da Features DeletaUsuario
 * 
 * @author August Neto
 *
 */
public class DeletaUsuarioSteps {

	private UserDeleteAPI apideletausuario;
	
	private int idapagar; 


	@Dado("que a URL da API Deletar usuário esteja montada")
	public void que_a_url_da_api_deletar_usuário_esteja_montada() {
		apideletausuario = new UserDeleteAPI();
		apideletausuario.montaAPIApagaUsuario();
	}
	@Dado("é informado na url o {int} do usuário a ser apagado")
	public void é_informado_na_url_o_do_usuário_a_ser_apagado(int idusuario) {
		idapagar = idusuario;
		
		//Se for um usuario não existente
		if (idapagar <= 0 || idapagar > 12) 
			throw new IllegalArgumentException("Usuário não existente");
		
	    apideletausuario.prepararUrlApagar(idapagar);
	}
	@Quando("invocar o método delete na API de usuários")
	public void invocar_o_método_delete_na_api_de_usuários() {
		apideletausuario.chamarAPIDeletaUsuario();
	}
	@Entao("usuário deve ser apagado e retornado o código {string}")
	public void usuário_deve_ser_apagado_e_retornado_o_código(String codigoretorno) {
		// Checa o status code
		assertEquals(apideletausuario.retornaStatusCode(), Integer.parseInt(codigoretorno));
		
		apideletausuario.logResposta();
	}


}
