package br.com.fiap.aula4.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula4.dao.CarroDAO;
import br.com.fiap.aula4.exceptions.CarNotFoundException;
import br.com.fiap.aula4.exceptions.CommitException;

public class CarroDAOImpl implements CarroDAO {

	private EntityManager em;
	
	public CarroDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public void create(Carro carro) {
		em.persist(carro);
	}

	@Override
	public void update(Carro carro) {
		em.merge(carro);
	}

	@Override
	public void delete(int codigo) throws CarNotFoundException {
		Carro carro = em.find(Carro.class, codigo);
		
		if (carro == null) {
			throw new CarNotFoundException("Registro n�o encontrado.");
		}
		
		em.remove(carro);
	}

	@Override
	public Carro find(int codigo) {
		return em.find(Carro.class, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro no commit.");
		}
	}

}
