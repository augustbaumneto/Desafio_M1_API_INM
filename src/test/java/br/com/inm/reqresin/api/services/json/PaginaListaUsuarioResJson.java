/**
 * 
 */
package br.com.inm.reqresin.api.services.json;

import java.util.List;

/**
 * Classe padrão para o Json de resposta da api listar usuário
 * 
 * @author August Neto
 *
 */
public class PaginaListaUsuarioResJson {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	
	private UsuarioResListaUsuarioJson data[];
	
	private SuporteListaUsuarioJson support;
	
	/**
	 * Construtor padrão
	 * 
	 */
	public PaginaListaUsuarioResJson() {
	}
	

	/**
	 * Construtor completo
	 * 
	 */

	public PaginaListaUsuarioResJson(int page, int per_page, int total, int total_pages, List<UsuarioResListaUsuarioJson> listausuarios, String url, String text) {
		this.page=page;
		this.per_page=per_page;
		this.total=total;
		this.total_pages=total_pages;
		
		data = new UsuarioResListaUsuarioJson[listausuarios.size()];
		
		for (UsuarioResListaUsuarioJson u : listausuarios) {
			data[listausuarios.indexOf(u)]= u;
			
		}
		
		support = new SuporteListaUsuarioJson();
		support.setUrl(url);
		support.setText(text);
	}

	
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the per_page
	 */
	public int getPer_page() {
		return per_page;
	}

	/**
	 * @param per_page the per_page to set
	 */
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the total_pages
	 */
	public int getTotal_pages() {
		return total_pages;
	}

	/**
	 * @param total_pages the total_pages to set
	 */
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	/**
	 * @return the data
	 */
	public UsuarioResListaUsuarioJson[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(UsuarioResListaUsuarioJson[] data) {
		this.data = data;
	}

	/**
	 * @return the support
	 */
	public SuporteListaUsuarioJson getSupport() {
		return support;
	}

	/**
	 * @param support the support to set
	 */
	public void setSupport(SuporteListaUsuarioJson support) {
		this.support = support;
	}

	
	
}
