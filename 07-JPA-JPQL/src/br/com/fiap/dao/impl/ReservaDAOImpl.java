package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public long contarQuantidade() {
		return em.createQuery("SELECT COUNT(r) FROM Reserva r", Long.class).getSingleResult();
	}

	@Override
	public long quantidadeReservaPorCliente(int codigoCliente) {
		return em.createQuery("SELECT COUNT(r) FROM Reserva r WHERE r.cliente.id = :codigoCliente", Long.class).
				setParameter("codigoCliente", codigoCliente).getSingleResult();
	}

}
