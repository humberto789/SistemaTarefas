package br.com.esig.sistematarefas.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.esig.sistematarefas.daos.ResponsavelDao;
import br.com.esig.sistematarefas.daos.TarefaDao;
import br.com.esig.sistematarefas.models.Prioridade;
import br.com.esig.sistematarefas.models.Responsavel;
import br.com.esig.sistematarefas.models.Tarefa;

@Model
public class AdminTarefasBean implements Serializable {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Tarefa tarefa = new Tarefa();

	@Inject
	private TarefaDao tarefaDao;

	@Inject
	private ResponsavelDao responsavelDao;

	@Inject
	private FacesContext context;

	@Transactional
	public String salvar() {

		tarefaDao.salvar(tarefa);

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Tarefa " + tarefa.getId() + " cadastrado com sucesso!"));
		
		return "/restrito/lista_tarefas?faces-redirect=true";

	}

	@Transactional
	public String excluir(Tarefa tarefa) {

		System.out.println("ACONTECEU");

		tarefaDao.excluir(tarefa);

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Tarefa " + tarefa.getId() + " excluida com sucesso!"));

		return "/restrito/lista_tarefas?faces-redirect=true";
	}

	@Transactional
	public String concluirTarefa(Tarefa tarefa) {

		System.out.println("Fui executado");

		tarefaDao.concluir(tarefa);

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Tarefa " + tarefa.getId() + " concluida com sucesso!"));

		return "/restrito/lista_tarefas?faces-redirect=true";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Responsavel> getResponsaveis() {
		return responsavelDao.listar();
	}

	public Prioridade[] getPrioridades() {
		return Prioridade.values();
	}

}
