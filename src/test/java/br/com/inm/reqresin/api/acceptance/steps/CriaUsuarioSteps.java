package br.com.inm.reqresin.api.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.reqresin.api.massatestes.MassaAPICriaUsuario;
import br.com.inm.reqresin.api.services.UserCreateAPI;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da Feature CriarUsuario
 * 
 * @author August Neto
 *
 */
public class CriaUsuarioSteps {

	private UserCreateAPI apicriausuario;
	
	private String nome;
	private String cargo;


	@Dado("que a URL da API Criar Usuario esteja montada")
	public void que_a_url_da_api_criar_usuario_esteja_montada() {
		apicriausuario = new UserCreateAPI();
		apicriausuario.montaAPICriaUsuario(nome, cargo);
	}
	
	@Dado("é informado os dados válidos na requisição")
	public void é_informado_os_dados_válidos_na_requisição() {
		nome = MassaAPICriaUsuario.USUARIO1_NOME;
		cargo = MassaAPICriaUsuario.USUARIO1_CARGO;
	}
	
	@Quando("invocar o método post de Criação de usuário")
	public void invocar_o_método_post_de_criação_de_usuário() {
		apicriausuario.chamarAPICriaUsuario();
	}
	
	@Entao("usuário deve ser criado e api deve retornar o código de status {string}")
	public void usuário_deve_ser_criado_e_api_deve_retornar_o_código_de_status(String codigoretorno) {
		assertEquals(apicriausuario.retornaStatusCode(), Integer.parseInt(codigoretorno));

	}
	
	@Entao("o corpo da resposta deve conter dados válidos")
	public void o_corpo_da_resposta_deve_conter_dados_válidos() {
	    
		assertTrue(apicriausuario.verificaDadosUsuarioCriado(nome, cargo));
		assertTrue(apicriausuario.verificaIdValido());
		assertTrue(apicriausuario.verificaDataCriacao());
		
		apicriausuario.logResposta();
	}

}
