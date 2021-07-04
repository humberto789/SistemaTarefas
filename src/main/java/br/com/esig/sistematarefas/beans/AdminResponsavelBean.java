package br.com.esig.sistematarefas.beans;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.esig.sistematarefas.daos.ResponsavelDao;
import br.com.esig.sistematarefas.models.Responsavel;

@Model
public class AdminResponsavelBean {
	
	private Responsavel responsavel = new Responsavel();
	
	@Inject
	private FacesContext context;
	
	@Inject
	private ResponsavelDao responsavelDao;
	
	@Transactional	
	public String salvar() {

		responsavelDao.salvar(getResponsavel());

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Responsavel " + getResponsavel().getId() + " cadastrado com sucesso!"));
		
		return "/login?faces-redirect=true";
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
}
