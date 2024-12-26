package br.com.inm.reqresin.api.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.reqresin.api.massatestes.MassaAPIListaUsuario;
import br.com.inm.reqresin.api.services.UserListAPI;
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

	private UserListAPI apiusuario;
	private String numeropagina;


	@Dado("que a URL da API Listar Usuarios esteja montada")
	public void que_a_url_esteja_montada_com_método_get() {
		apiusuario = new UserListAPI();
		apiusuario.montaAPIListaUsuarios();

	}

	@Quando("não é informado a página de usuário a ser extraida")
	public void não_seja_passado_o_parâmetro_page() {
		numeropagina = "";
	}

	@Quando("invocar o método get na Lista de usuário")
	public void invocar_o_método_lista_de_usuário() {

		apiusuario.chamarAPIListaUsuarios(numeropagina);

	}

	@Entao("deve trazer lista de usuarios validos da página {string}")
	public void deve_trazer_dados_válidos_da_primeira_página(String paginainformada) {

		// Checa o status code
		assertEquals(apiusuario.retornaStatusCode(), MassaAPIListaUsuario.STATUS200);

		switch (paginainformada) {

		case "1": {
			// Checa o dado de dois usuarios
			assertTrue(apiusuario.verificaDadosUsuario(1, MassaAPIListaUsuario.USUARIO1_ID,
					MassaAPIListaUsuario.USUARIO1_EMAIL, MassaAPIListaUsuario.USUARIO1_FIRST_NAME,
					MassaAPIListaUsuario.USUARIO1_LAST_NAME, MassaAPIListaUsuario.USUARIO1_AVATAR));
			assertTrue(apiusuario.verificaDadosUsuario(2, MassaAPIListaUsuario.USUARIO2_ID,
					MassaAPIListaUsuario.USUARIO2_EMAIL, MassaAPIListaUsuario.USUARIO2_FIRST_NAME,
					MassaAPIListaUsuario.USUARIO2_LAST_NAME, MassaAPIListaUsuario.USUARIO2_AVATAR));
			break;
		}
		case "2": {
			// Checa o dado de dois usuarios
			assertTrue(apiusuario.verificaDadosUsuario(1, MassaAPIListaUsuario.USUARIO7_ID,
					MassaAPIListaUsuario.USUARIO7_EMAIL, MassaAPIListaUsuario.USUARIO7_FIRST_NAME,
					MassaAPIListaUsuario.USUARIO7_LAST_NAME, MassaAPIListaUsuario.USUARIO7_AVATAR));
			assertTrue(apiusuario.verificaDadosUsuario(2, MassaAPIListaUsuario.USUARIO8_ID,
					MassaAPIListaUsuario.USUARIO8_EMAIL, MassaAPIListaUsuario.USUARIO8_FIRST_NAME,
					MassaAPIListaUsuario.USUARIO8_LAST_NAME, MassaAPIListaUsuario.USUARIO8_AVATAR));
			break;
		}

		case "3": {
			// Verifica se esta vazio a quantidade de usuarios
			assertTrue(apiusuario.verificaSeNaoHaUsuario());
			break;
		}
		
		default: {
			throw new IllegalArgumentException("Página não implementada para validação");
		}
		
		}
		assertTrue(apiusuario.verificaDadosGerais(MassaAPIListaUsuario.PER_PAGE, MassaAPIListaUsuario.TOTAL,
				MassaAPIListaUsuario.TOTAL_PAGES));


		assertTrue(
				apiusuario.verificaDadosSuporte(MassaAPIListaUsuario.URL_SUPPORT, MassaAPIListaUsuario.TEXT_SUPPORT));
	}

	@Entao("a página exibida deve ser a página {string}")
	public void a_página_deve_ser_a_primeira(String paginainformada) throws Exception {

		switch (paginainformada) {

		case "1": {
			assertEquals(apiusuario.verificaPaginaAtual(), MassaAPIListaUsuario.PAGINA1);
			break;
		}
		case "2": {
			assertEquals(apiusuario.verificaPaginaAtual(), MassaAPIListaUsuario.PAGINA2);
			break;
		}

		case "3": {
			assertEquals(apiusuario.verificaPaginaAtual(), MassaAPIListaUsuario.PAGINA3);
			break;
		}

		default: {
			throw new IllegalArgumentException("Página não implementada para validação");
		}

		}
		
		apiusuario.logResposta();
	}
	
	@Quando("é informado a página {string} a ser extraida")
	public void é_informado_a_página_a_ser_extraida(String numeropagina) {
		this.numeropagina = numeropagina;

	}
	

}
