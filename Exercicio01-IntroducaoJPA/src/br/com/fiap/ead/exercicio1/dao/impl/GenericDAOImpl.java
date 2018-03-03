package br.com.fiap.ead.exercicio1.dao.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.fiap.ead.exercicio1.dao.GenericDAO;
import br.com.fiap.ead.exercicio1.exceptions.CommitException;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir() {
		em.persist(classe);
	}


	@Override
	public T pesquisar(K codigo) throws NoResultsException {
		T object = em.find(classe, codigo);
		
		if (object == null) {
			throw new NoResultsException("Não foi encontrado nenhum valor com o código digitado.");
		}
		
		return object;
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@Override
	public void deletar(T entity) {
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new CommitException("Erro ao realizar o commit.");
		}
	}

}
