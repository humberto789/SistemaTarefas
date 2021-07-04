package br.com.esig.sistematarefas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.esig.sistematarefas.daos.TarefaDao;
import br.com.esig.sistematarefas.models.Filtro;
import br.com.esig.sistematarefas.models.Tarefa;

@Model
public class AdminListaTarefasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TarefaDao tarefaDao;

	private Tarefa tarefa = new Tarefa();

	private Filtro filtro = new Filtro();

	
	private List<Tarefa> tarefasFiltradas;
	
	public void consultar() {

		tarefasFiltradas = tarefaDao.filtragem(filtro);
		
		filtro = new Filtro();
	}

	public void gerarLista() {

		tarefasFiltradas = tarefaDao.listar();

	}
	
	public List<Tarefa> listaCompleta() {
		return tarefaDao.listar();
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefasFiltradas() {
		return tarefasFiltradas;
	}

	public void setTarefasFiltradas(List<Tarefa> tarefasFiltradas) {
		this.tarefasFiltradas = tarefasFiltradas;
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

}
