package br.com.fiap.ads.ead.aula06.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ads.ead.aula06.daoImpl.NotaFiscalDAOImpl;
import br.com.fiap.ads.ead.aula06.entities.NotaFiscal;
import br.com.fiap.ads.ead.aula06.entities.Pedido;
import br.com.fiap.ads.ead.aula06.exception.CommitExption;
import br.com.fiap.ads.ead.aula06.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Pedido p = new Pedido(Calendar.getInstance(), "pedido da fabrica de Campinas.");
		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 999.11, p);
		
		NotaFiscalDAOImpl daoFiscal = new NotaFiscalDAOImpl(em);
//		PedidoDAOImpl daoPedido = new PedidoDAOImpl(em);
		
//		daoPedido.inserir(p);
		daoFiscal.inserir(notaFiscal);
		try {
			daoFiscal.commit();
		} catch (CommitExption e) {
			e.printStackTrace();
		}
		
		em.close();
		emf.close();
		
	}
	
}
