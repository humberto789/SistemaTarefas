package br.com.esig.sistematarefas.beans;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.esig.sistematarefas.daos.TarefaDao;
import br.com.esig.sistematarefas.models.Tarefa;

@Model
public class AdminEditarTarefaBean {
	@Inject
	private TarefaDao tarefaDao;
	
	@Inject
	private FacesContext context;
	
	private Tarefa tarefa = new Tarefa();
	
	private Integer id;
	
	public void carregarTarefa() {
		tarefa = tarefaDao.buscarPorId(getId());
	}
	
	@Transactional
	public String editar() {
		
		tarefa.setId(id);
		
		tarefaDao.editarCampos(tarefa);

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Tarefa " + id + " editada com sucesso!"));
		
		return "/restrito/lista_tarefas?faces-redirect=true";

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
