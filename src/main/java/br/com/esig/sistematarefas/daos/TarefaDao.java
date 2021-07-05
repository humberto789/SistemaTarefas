package br.com.esig.sistematarefas.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.esig.sistematarefas.models.Filtro;
import br.com.esig.sistematarefas.models.Tarefa;

public class TarefaDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	public List<Tarefa> listar() {
		String jpql = "select distinct(t) from Tarefa t";

		return manager.createQuery(jpql, Tarefa.class).getResultList();
	}

	public List<Tarefa> listarConcluidas() {
		String jpql = "select distinct(t) from Tarefa t where t.concluida=false";

		return manager.createQuery(jpql, Tarefa.class).getResultList();
	}

	public void excluir(Tarefa tarefa) {
		manager.remove(manager.merge(tarefa));
	}

	public void concluir(Tarefa tarefa) {

		Query query = manager.createQuery("update Tarefa t set t.concluida=:concluida WHERE t.id= :id");
		query.setParameter("id", tarefa.getId());
		query.setParameter("concluida", true);
		query.executeUpdate();

	}

	public void editarCampos(Tarefa tarefa) {
		
		System.out.println("tarefa " + tarefa.getId());
		System.out.println("RESPONSAVEL Titulo " + tarefa.getTitulo());

		manager.merge(tarefa);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> filtragem(Filtro filtro) {

		Session session = manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Tarefa.class);

		if (filtro.getTitulo() != null) {
			if (!filtro.getTitulo().isEmpty()) {
				criteria.add(Restrictions.ilike("titulo", filtro.getTitulo(), MatchMode.ANYWHERE));
			}
		}
		if (filtro.getId() != null) {
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		if (filtro.getResponsavel() != null) {
			criteria.add(Restrictions.eq("responsavel", filtro.getResponsavel()));
		}

		criteria.add(Restrictions.eq("concluida", filtro.isConcluida()));

		return criteria.list();
	}

	public Tarefa buscarPorId(Integer id) {
		String jpql = "select t from Tarefa t where t.id = :id";
		return manager.createQuery(jpql, Tarefa.class).setParameter("id", id).getSingleResult();

	}
}
