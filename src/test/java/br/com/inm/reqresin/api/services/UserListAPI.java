/**
 * 
 */
package br.com.inm.reqresin.api.services;



import java.util.ArrayList;
import java.util.List;

import br.com.inm.reqresin.api.services.json.PaginaUsuarioJson;
import br.com.inm.reqresin.api.services.json.UsuarioJson;
import io.restassured.RestAssured;

/**
 * @author August Neto
 *
 * Classe que representa a API List User (https://reqres.in/)
 *
 */
public class UserListAPI extends UserAPIBase {

	//Parametros da resposta 
	public static final String PARAM_RESP_TOTAL = "total";
	public static final String PARAM_RESP_DATA = "data";
	public static final String PARAM_RESP_DATA_ID = "id";
	public static final String PARAM_RESP_DATA_EMAIL = "email";
	public static final String PARAM_RESP_DATA_FIRSTNAME = "first_name";
	public static final String PARAM_RESP_DATA_LASTNAME = "last_name";
	public static final String PARAM_RESP_DATA_AVATAR = "avatar";
	public static final String PARAM_RESP_PAGE = "page";
	public static final String PARAM_RESP_PERPAGE = "per_page";
	public static final String PARAM_RESP_TOTALPAGES = "total_pages";
	public static final String PARAM_RESP_SUPPORT = "support";
	public static final String PARAM_RESP_SUPPORT_URL = "url";
	public static final String PARAM_RESP_SUPPORT_TEXT = "text";
	
	private PaginaUsuarioJson respostaapi;
	
	
	//Construtor padrão
	public UserListAPI() {
		super();

	}

	/**
	 * Prepara a requisição
	 */
	public void montaAPIListaUsuarios() {
		requisicao = 
				RestAssured.given();				
				
	}
	
	/**
	 * Chama o metodo get de lista de usuário, guarda o json de retorno e monta a os dados em uma classe java
	 * 
	 * @param numerodapagina Numero da pagina a ser retornada
	 * 
	 */
	public void chamarAPIListaUsuarios(String numerodapagina) {
		
		requisicao = requisicao
				.when();
		if (numerodapagina.isEmpty())
			resposta = requisicao.get();
		else
			resposta = requisicao.get("/"+numerodapagina);
		
		guardarResposta();
		montaPagina();
		
	}
	
	
	/**
	 * 
	 * Valida se o usuario possui os mesmos dados de comparação
	 * 
	 * @param numerousuario Numero de usuario (posição na lista)
	 * @param id
	 * @param email
	 * @param primeironome
	 * @param ultimonome
	 * @param avatar
	 * @return  true se os dados estiverem ok, retorna falso se tiver algum dado errado, ou se o numero do usuário for maior que a quantidade de usuários presentes
	 */
	public boolean verificaDadosUsuario(int numerousuario, int id, String email, String primeironome, String ultimonome, String avatar) {

		if (!(numerousuario <= respostaapi.getTotal())) { 
			return false;
			}
		else {
			UsuarioJson[] usuarios = respostaapi.getData();
						
			return (id == usuarios[numerousuario-1].getId())&&
					(email.equals(usuarios[numerousuario-1].getEmail()))&&
					(primeironome.equals(usuarios[numerousuario-1].getFirst_name()))&&
					(ultimonome.equals(usuarios[numerousuario-1].getLast_name()))&&
					(avatar.equals(usuarios[numerousuario-1].getAvatar())); 
		}
	}
	
	/**
	 * 
	 * Monta o json em um objeto para facilitar a manipulação no java
	 * 
	 */
	private void montaPagina() {
		
		int quantidadeusuario = jsonpath.getInt(PARAM_RESP_PERPAGE);
		List<UsuarioJson> listausuarios = new ArrayList<UsuarioJson>();
		
		for (int i=0; i < quantidadeusuario; i=i+1 ) {
			UsuarioJson usuario = new UsuarioJson(jsonpath.getInt(PARAM_RESP_DATA+"["+i+"]."+PARAM_RESP_DATA_ID),
					jsonpath.getString(PARAM_RESP_DATA+"["+i+"]."+PARAM_RESP_DATA_EMAIL),
					jsonpath.getString(PARAM_RESP_DATA+"["+i+"]."+PARAM_RESP_DATA_FIRSTNAME),
					jsonpath.getString(PARAM_RESP_DATA+"["+i+"]."+PARAM_RESP_DATA_LASTNAME),
					jsonpath.getString(PARAM_RESP_DATA+"["+i+"]."+PARAM_RESP_DATA_AVATAR));
			listausuarios.add(usuario);
		}
			
		respostaapi = new PaginaUsuarioJson(jsonpath.getInt(PARAM_RESP_PAGE),
											jsonpath.getInt(PARAM_RESP_PERPAGE),
											jsonpath.getInt(PARAM_RESP_TOTAL),
											jsonpath.getInt(PARAM_RESP_TOTALPAGES),
											listausuarios,
											jsonpath.getString(PARAM_RESP_SUPPORT+"."+PARAM_RESP_SUPPORT_URL),
											jsonpath.getString(PARAM_RESP_SUPPORT+"."+PARAM_RESP_SUPPORT_TEXT));
		
	}

	/**
	 * 
	 * Retorna a página atual
	 * 
	 * @return
	 */
	public int verificaPaginaAtual() {
		
		return respostaapi.getPage();
	}

	/**
	 * 
	 * Verifica os dados do cabeçário
	 * 
	 * @param perpage
	 * @param total
	 * @param totalpages
	 * @return
	 */
	public boolean verificaDadosGerais(int perpage, int total, int totalpages) {
		
		return (perpage == respostaapi.getPer_page())&&
				(total== respostaapi.getTotal())&&
				(totalpages== respostaapi.getTotal_pages());
	}

	/**
	 * 
	 * Verifica se os dados do support esta correto
	 * 
	 * @param urlsupport
	 * @param textsupport
	 * @return
	 */
	public boolean verificaDadosSuporte(String urlsupport, String textsupport) {
		

		return (urlsupport.equals(respostaapi.getSupport().getUrl()))&&
				(textsupport.equals(respostaapi.getSupport().getText()));
	}
	
	/* packages para separação de codigos

dependencia do jackson.

versão iniciais
listaUsuarios.featueres
RunListaUsuarioTest
ListaUsuarioSteps
pom xml jackson*/
}
