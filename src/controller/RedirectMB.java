package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class RedirectMB {
	public String pagina = "index.xhtml";
	
	public void recordes() throws IOException{
		pagina = "recordes.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
	}
	
	public void atletas() throws IOException {
		pagina = "atletas.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
	}
	
	public void paises() throws IOException {
		pagina = "paises.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
	}
	
	public void principal() throws IOException{
		pagina = "index.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
	}
}
