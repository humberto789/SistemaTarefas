package br.com.esig.sistematarefas.conf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer {
	
	@RequestScoped
	@Produces
	public FacesContext getFacesContextContext() {
		return FacesContext.getCurrentInstance();
	}
}
