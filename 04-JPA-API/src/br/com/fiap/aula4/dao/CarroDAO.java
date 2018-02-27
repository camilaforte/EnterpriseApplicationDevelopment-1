package br.com.fiap.aula4.dao;

import br.com.fiap.aula04.entities.Carro;

public interface CarroDAO {

	void create(Carro carro);
	void update(Carro carro);
	void delete(int codigo);
	Carro find(int codigo);
	
}
