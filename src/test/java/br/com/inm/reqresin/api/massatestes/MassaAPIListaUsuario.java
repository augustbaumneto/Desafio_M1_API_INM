/**
 * 
 */
package br.com.inm.reqresin.api.massatestes;



/**
 * 
 * Classe que representa a massa de dados para a API de usuarios
 * 
 * @author August Neto
 *
 */
public class MassaAPIListaUsuario {

	// Dados de testes

	//Status Code
	public static final int STATUS200 = 200;
	public static final int STATUS204 = 204;
	
	//Geral
	public static final int PAGINA1 = 1;
	public static final int PAGINA2 = 2;
	public static final int PAGINA3 = 3;
	public static final int PER_PAGE = 6;
	public static final int TOTAL = 12;
	public static final int TOTAL_PAGES = 2;
	
	
	//Usuarios
	public static final int USUARIO1_ID = 1;
	public static final String USUARIO1_EMAIL = "george.bluth@reqres.in";
	public static final String USUARIO1_FIRST_NAME = "George";
	public static final String USUARIO1_LAST_NAME = "Bluth";
	public static final String USUARIO1_AVATAR = "https://reqres.in/img/faces/1-image.jpg";

	public static final int USUARIO2_ID = 2;
	public static final String USUARIO2_EMAIL = "janet.weaver@reqres.in";
	public static final String USUARIO2_FIRST_NAME = "Janet";
	public static final String USUARIO2_LAST_NAME = "Weaver";
	public static final String USUARIO2_AVATAR = "https://reqres.in/img/faces/2-image.jpg";

	/*
	 * 2 id 3 email "emma.wong@reqres.in" first_name "Emma" last_name "Wong" avatar
	 * "https://reqres.in/img/faces/3-image.jpg" 3 id 4 email "eve.holt@reqres.in"
	 * first_name "Eve" last_name "Holt" avatar
	 * "https://reqres.in/img/faces/4-image.jpg" 4 id 5 email
	 * "charles.morris@reqres.in" first_name "Charles" last_name "Morris" avatar
	 * "https://reqres.in/img/faces/5-image.jpg" 5 id 6 email
	 * "tracey.ramos@reqres.in" first_name "Tracey" last_name "Ramos" avatar
	 * "https://reqres.in/img/faces/6-image.jpg" support
	 */

	public static final int USUARIO8_ID = 8;
	public static final String USUARIO8_EMAIL = "lindsay.ferguson@reqres.in";
	public static final String USUARIO8_FIRST_NAME = "Lindsay";
	public static final String USUARIO8_LAST_NAME = "Ferguson";
	public static final String USUARIO8_AVATAR = "https://reqres.in/img/faces/8-image.jpg";

	public static final int USUARIO7_ID = 7;
	public static final String USUARIO7_EMAIL = "michael.lawson@reqres.in";
	public static final String USUARIO7_FIRST_NAME = "Michael";
	public static final String USUARIO7_LAST_NAME = "Lawson";
	public static final String USUARIO7_AVATAR = "https://reqres.in/img/faces/7-image.jpg";

	
	//Support
	public static final String URL_SUPPORT = "https://reqres.in/#support-heading";
	public static final String TEXT_SUPPORT = "To keep ReqRes free, contributions towards server costs are appreciated!";

	
	
	
	/**
	 */
	public MassaAPIListaUsuario() {

	}

}
