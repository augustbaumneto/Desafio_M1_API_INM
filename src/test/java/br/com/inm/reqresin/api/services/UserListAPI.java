/**
 * 
 */
package br.com.inm.reqresin.api.services;



import java.util.List;
import java.util.function.BooleanSupplier;

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
	
	public static final String PARAM_PATH_PAGE = "page";
	
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
	 * Chama o metodo get de lista de usuário passando o parametro path da página. Caso seja "" vazio, 
	 *     o parametro não é informado. Também guarda o json de retorno e monta a os dados em uma classe 
	 *     java apropriada
	 * 
	 * @param numerodapagina Numero da pagina a ser retornada. Se informado vazio, não utilizada par
	 * 
	 */
	public void chamarAPIListaUsuarios(String numerodapagina) {
		
		requisicao = requisicao
				.when();
		if (numerodapagina.isEmpty())
			resposta = requisicao.get();
		else
			resposta = requisicao.get("?"+PARAM_PATH_PAGE+"="+numerodapagina);
		
		guardarResposta();
		montaPagina();
		
	}
	
	
	/**
	 * 
	 * Valida se o usuario possui os mesmos dados de comparação
	 * 
	 * @param posicaousuario Posição do usuario na resposta trazida
	 * @param id
	 * @param email
	 * @param primeironome
	 * @param ultimonome
	 * @param avatar
	 * @return  true se os dados estiverem ok, retorna falso se tiver algum dado errado, ou se o numero do usuário for maior que a quantidade de usuários presentes
	 */
	public boolean verificaDadosUsuario(int posicaousuario, int id, String email, String primeironome, String ultimonome, String avatar) {

		if (!(posicaousuario <= respostaapi.getTotal())) { 
			return false;
			}
		else {
			UsuarioJson[] usuarios = respostaapi.getData();
						
			return (id == usuarios[posicaousuario-1].getId())&&
					(email.equals(usuarios[posicaousuario-1].getEmail()))&&
					(primeironome.equals(usuarios[posicaousuario-1].getFirst_name()))&&
					(ultimonome.equals(usuarios[posicaousuario-1].getLast_name()))&&
					(avatar.equals(usuarios[posicaousuario-1].getAvatar())); 
		}
	}
	
	/**
	 * 
	 * Monta o json em um objeto para facilitar a manipulação no java
	 * 
	 */
	private void montaPagina() {
		
		List <UsuarioJson>listausuarios = jsonpath.getList(PARAM_RESP_DATA, UsuarioJson.class);
			
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

	/**
	 * 
	 * Verifica se não há usuarios na pagina.
	 * 
	 * @return
	 */
	public boolean verificaSeNaoHaUsuario() {
		return respostaapi.getData().length==0;
	}
	
	/* packages para separação de codigos

dependencia do jackson.

versão iniciais
listaUsuarios.featueres
RunListaUsuarioTest
ListaUsuarioSteps
pom xml jackson*/
}
