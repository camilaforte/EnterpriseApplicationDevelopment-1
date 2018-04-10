package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {

		TypedQuery<Pacote> query = em.createQuery("FROM Pacote p WHERE p.dataSaida between :pDtInicio AND :pDtFim", Pacote.class);
		query.setParameter("pDtFim", fim).setParameter("pDtInicio", inicio);
		return query.getResultList();
	}

}
