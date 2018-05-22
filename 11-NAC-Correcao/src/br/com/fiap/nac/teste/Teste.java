package br.com.fiap.nac.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.LocacaoDAOImp;
import br.com.fiap.nac.entities.Apartamento;
import br.com.fiap.nac.entities.Cliente;
import br.com.fiap.nac.entities.Locacao;
import br.com.fiap.nac.entities.Sexo;
import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = emf.createEntityManager();
		LocacaoDAO dao = new LocacaoDAOImp(em);
		
//		Cliente cliente = new Cliente("Joao Carlos Costa Lopes", new GregorianCalendar(1987, Calendar.JULY, 24), Sexo.MASCULINO);
//		Apartamento ap = new Apartamento("Rua Ilansa, 520 - Mooca", "casa térrea, 2 dormitórios, 200 metros quadradps", null);
//		
//		Locacao locacao = new Locacao(Calendar.getInstance(), new GregorianCalendar(2019, Calendar.JANUARY, 01), ap, cliente);
//		
//		dao.cadastrar(locacao);
//		try {
//			dao.salvar();
//		} catch (DBException e) {
//			System.out.println(e.getMessage());
//		}
		
		List<Locacao> locacoes = dao.buscarLocacaoPorData(new GregorianCalendar(1987, Calendar.JULY, 24), Calendar.getInstance());
		
		for (Locacao loc : locacoes) {
			System.out.println(loc.getCliente().getNome());
		}
	
		em.close();
		emf.close();
		
	}
	
}
