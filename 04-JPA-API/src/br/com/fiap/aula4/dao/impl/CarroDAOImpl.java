package br.com.fiap.aula4.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula4.dao.CarroDAO;

public class CarroDAOImpl implements CarroDAO {

	private EntityManager em;
	
	public CarroDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public void create(Carro carro) {
		em.persist(carro);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public void update(Carro carro) {
		em.merge(carro);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public void delete(int codigo) {
		em.remove(em.find(Carro.class, codigo));
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public Carro find(int codigo) {
		return em.find(Carro.class, codigo);
	}
	
}
