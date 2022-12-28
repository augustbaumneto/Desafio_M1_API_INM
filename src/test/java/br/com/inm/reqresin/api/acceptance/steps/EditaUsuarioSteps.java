package br.com.inm.reqresin.api.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.reqresin.api.massatestes.MassaAPIEditaUsuario;
import br.com.inm.reqresin.api.services.UserEditAPI;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da Feature EditarUsuario
 * 
 * @author August Neto
 *
 */
public class EditaUsuarioSteps {

	private UserEditAPI apieditausuario;
	
	private String nome;
	private String cargo;
	
	private String id;

	@Dado("que é informado um {string} válido na requisição")
	public void que_é_informado_um_válido_na_requisição(String nomeparametro) {
		switch (nomeparametro) {
		
			case "nome":{
				nome = MassaAPIEditaUsuario.USUARIO1_NOME;
				cargo = null;
				break;
			}
			case "cargo":{
				cargo = MassaAPIEditaUsuario.USUARIO1_CARGO;
				nome = null;
				break;
			}
		}
		
	}

	@Dado("e informado o id do usuario para edicao no parametro path")
	public void e_informado_o_id_do_usuario_para_edicao_no_parametro_path() {
	    id = MassaAPIEditaUsuario.USUARIO1_ID;
	}
	
	@Dado("que a URL da API Editar Usuario esteja montada")
	public void que_a_url_da_api_editar_usuario_esteja_montada() {
		apieditausuario = new UserEditAPI();
		apieditausuario.montaAPIEditaUsuario(nome, cargo);
	}
	
	
	
	@Quando("invocar o método put de Edição de usuário")
	public void invocar_o_método_put_de_edição_de_usuário() {
		apieditausuario.chamarAPIEditaUsuarioPut(id);
	}
	
	@Entao("usuário deve ser editado e api deve retornar o código de status {string}")
	public void usuário_deve_ser_editado_e_api_deve_retornar_o_código_de_status(String codigoretorno) {
		assertEquals(apieditausuario.retornaStatusCode(), Integer.parseInt(codigoretorno));

	}
	
	@Entao("o corpo da resposta deve conter o {string} editado com mesmo valor")
	public void o_corpo_da_resposta_deve_conter_o_editado_com_mesmo_valor(String nomeparametro) {
	    
		switch (nomeparametro) {
		
			case "nome":{
				assertTrue(apieditausuario.verificaNomeEditado(nome));
				break;
			}
			case "cargo":{
				assertTrue(apieditausuario.verificaCargoEditado(cargo));
				break;
			}
		}
		
	}

	@Entao("a data de edicao deve ser valida")
	public void a_data_de_edicao_deve_ser_valida() {		
		
		assertTrue(apieditausuario.verificaDataEdicao());
		
		apieditausuario.logResposta();
	}
	
	@Dado("que são informados ambos os parametros válidos na requisição")
	public void que_são_informados_ambos_os_parametros_válidos_na_requisição() {
		nome = MassaAPIEditaUsuario.USUARIO2_NOME;
		cargo = MassaAPIEditaUsuario.USUARIO2_CARGO;
		
	}
	
	@Entao("o corpo da resposta deve conter ambos valores editados com o mesmo valor")
	public void o_corpo_da_resposta_deve_conter_ambos_valores_editados_com_o_mesmo_valor() {
		assertTrue(apieditausuario.verificaNomeEditado(nome));
		assertTrue(apieditausuario.verificaCargoEditado(cargo));
	}
	
	@Quando("invocar o método patch de Edição de usuário")
	public void invocar_o_método_patch_de_edição_de_usuário() {
		apieditausuario.chamarAPIEditaUsuarioPatch(id);
	}
	
}
