package br.com.fiap.ead.exercicio1.dao;

import br.com.fiap.ead.exercicio1.exceptions.CommitException;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public interface GenericDAO<T, K> {

	void inserir();
	void commit() throws CommitException;
	T pesquisar(K codigo) throws NoResultsException;
	void atualizar(T entity);
	void deletar(T entity);
	
}
