package br.com.fiap.ddd.ead.aula06.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ddd.ead.aula06.daoImpl.AlunoDAOImpl;
import br.com.fiap.ddd.ead.aula06.daoImpl.LivroDAOImpl;
import br.com.fiap.ddd.ead.aula06.entity.Aluno;
import br.com.fiap.ddd.ead.aula06.entity.Livro;
import br.com.fiap.ddd.ead.aula06.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		
		LivroDAOImpl livroDAOImpl = new LivroDAOImpl(em);
		AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl(em);
		
		Livro livro = new Livro("Harry", "J.K");
		Aluno aluno = new Aluno("Camila");
		
		//cadastrar
		livroDAOImpl.inserir(livro);
		alunoDAOImpl.inserir(aluno);
		
		//buscar
		livroDAOImpl.pesquisar(1);
		alunoDAOImpl.pesquisar("78943");
		
		
		//atualizar
		
		
		//remover
		livroDAOImpl.pesquisar(1);
		
		
		
		
		
		em.close();
		fabrica.close();
		
	}
}
