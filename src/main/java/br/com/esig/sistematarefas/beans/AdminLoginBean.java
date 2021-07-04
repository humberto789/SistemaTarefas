package br.com.esig.sistematarefas.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.sistematarefas.daos.ResponsavelDao;
import br.com.esig.sistematarefas.models.Responsavel;

@Named
@SessionScoped
public class AdminLoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Responsavel responsavel;
	
	@Inject
	private ResponsavelDao responsavelDao;
	
	@Inject
	private FacesContext context;
	
	private String email;
	
	private String senha;
	
	public String logar() {
		
		responsavel = responsavelDao.buscarPorEmailESenha(email, senha);
		
		if(responsavel!=null) {
			
			return "/restrito/index?faces-redirect=true";
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email e/ou senha invalidos", ""));
		
		return "/login?faces-redirect=true";
		
	}
	
	public String deslogar() {
		context.getExternalContext().invalidateSession();
		responsavel = null;
		return "/login.xhtml?faces-redirect=true";
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
