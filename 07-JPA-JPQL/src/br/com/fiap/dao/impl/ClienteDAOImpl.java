package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		TypedQuery<Cliente> query = em.createQuery("FROM Cliente c WHERE c.nome LIKE :pNome AND c.endereco.cidade.nome LIKE :pNomeCidade", Cliente.class);
		query.setParameter("pNome", "%" + nome + "%");
		query.setParameter("pNomeCidade", "%" + cidade + "%");
		return query.getResultList();
	}

}







