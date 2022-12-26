/**
 * 
 */
package br.com.inm.reqresin.api.services.json;

/**
 * 
 * Classe para o elemento suporte da resposta do Json da api lista usuário
 * 
 * @author August Neto
 *
 */
public class SuporteListaUsuarioJson {

	
	private String url;
	
	private String text;
	
	/**
	 * Classe inicial de chamada
	 */
	public SuporteListaUsuarioJson() {
		
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	
	
}
