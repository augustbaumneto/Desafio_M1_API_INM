package br.com.inm.reqresin.api.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.reqresin.api.massatestes.MassaAPIListaUsuario;
import br.com.inm.reqresin.api.services.UserListAPI;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da Features ListarUsuarios
 * 
 * @author August Neto
 *
 */
public class ListaUsuarioSteps {

	public UserListAPI apiusuario;
	public String numeropagina;
	
	/**
	 * Classe para preparar o cenário
	 * 
	 */
	@Before
	public void setup() {
		apiusuario = new UserListAPI();
	}
	
	@Dado("que a URL esteja montada")
	public void que_a_url_esteja_montada_com_método_get() {
		
		apiusuario.montaAPIListaUsuarios();
		
	}
	
	@Quando("não é informado a página a ser extraida")
	public void não_seja_passado_o_parâmetro_page() {
	   numeropagina = "";
	}
	
	@Quando("invocar o método get na Lista de usuário")
	public void invocar_o_método_lista_de_usuário() {
		
		
		apiusuario.chamarAPIListaUsuarios(numeropagina);
	
	}
	
	@Entao("deve trazer lista de usuarios validos")
	public void deve_trazer_dados_válidos_da_primeira_página() {
	
		//Checa o status code
		assertEquals(apiusuario.retornaStatusCode(),MassaAPIListaUsuario.STATUS200);
		
		//Checa o dado de dois usuarios
		assertTrue(apiusuario.verificaDadosUsuario(1, MassaAPIListaUsuario.USUARIO1_ID, MassaAPIListaUsuario.USUARIO1_EMAIL, MassaAPIListaUsuario.USUARIO1_FIRST_NAME, MassaAPIListaUsuario.USUARIO1_LAST_NAME, MassaAPIListaUsuario.USUARIO1_AVATAR));
	    assertTrue(apiusuario.verificaDadosUsuario(2, MassaAPIListaUsuario.USUARIO2_ID, MassaAPIListaUsuario.USUARIO2_EMAIL, MassaAPIListaUsuario.USUARIO2_FIRST_NAME, MassaAPIListaUsuario.USUARIO2_LAST_NAME, MassaAPIListaUsuario.USUARIO2_AVATAR));
	    
	    assertTrue(apiusuario.verificaDadosGerais(MassaAPIListaUsuario.PER_PAGE,MassaAPIListaUsuario.TOTAL,MassaAPIListaUsuario.TOTAL_PAGES));
	    
	    assertTrue(apiusuario.verificaDadosSuporte(MassaAPIListaUsuario.URL_SUPPORT,MassaAPIListaUsuario.TEXT_SUPPORT));
	}
	
	@Entao("a página deve ser a primeira")
	public void a_página_deve_ser_a_primeira() {
		
		assertEquals(apiusuario.verificaPaginaAtual(),MassaAPIListaUsuario.PAGINA1);
		
		
		//System.out.println(resposta.asPrettyString());
		
	}

}
