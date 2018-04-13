package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> buscar(String nome, String cidade);

	List<Cliente> buscarPorEstados(List<String> estados);

	List<Cliente> pesquisarPorDiasReserva(int dias);

	List<Cliente> pesquisarPorEstado(String estado);
	
}