package br.com.esig.sistematarefas.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.esig.sistematarefas.models.Responsavel;


public class ResponsavelDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Responsavel responsavel) {
		manager.persist(responsavel);
	}
	
	public List<Responsavel> listar(){
		
		return manager.createQuery("select r from Responsavel r", Responsavel.class).getResultList();
		
	}
	
	public Responsavel buscarPorEmailESenha(String email, String senha) {
		
		String jpql = "select r from Responsavel r where r.email=:email and r.senha=:senha";
		
		Responsavel resultado;
		
		try {
			resultado = manager.createQuery(jpql, Responsavel.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();
		
		} catch(Exception e){
			return null;
		}
		return resultado;
		
	}
	
}
