package br.com.fiap.ads.ead.aula06.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ads.ead.aula06.dao.NotaFiscalDAO;
import br.com.fiap.ads.ead.aula06.daoImpl.NotaFiscalDAOImpl;
import br.com.fiap.ads.ead.aula06.entities.ItemPedido;
import br.com.fiap.ads.ead.aula06.entities.NotaFiscal;
import br.com.fiap.ads.ead.aula06.entities.Pedido;
import br.com.fiap.ads.ead.aula06.exception.CommitExption;
import br.com.fiap.ads.ead.aula06.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
//		Pedido p = new Pedido(Calendar.getInstance(), "pedido da fabrica de Campinas.");
//		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 999.11, p);
//		
		NotaFiscalDAO daoFiscal = new NotaFiscalDAOImpl(em);
////		PedidoDAOImpl daoPedido = new PedidoDAOImpl(em);
//		
////		daoPedido.inserir(p);
//		daoFiscal.inserir(notaFiscal);
//		try {
//			daoFiscal.commit();
//		} catch (CommitExption e) {
//			e.printStackTrace();
//		}

		Pedido p = new Pedido(Calendar.getInstance(), "10 pizzas de portugues.");
		NotaFiscal nf = new NotaFiscal(new GregorianCalendar(2018, Calendar.MARCH, 19), 77.50, p);
		
		ItemPedido[] ip = {
			new ItemPedido("pizza de calabresa", 10.00),
			new ItemPedido("pizza de mussarela", 12.00),
			new ItemPedido("pizza de palmito", 11.00),
			new ItemPedido("pizza de peperoni", 15.00),
			new ItemPedido("pizza de brocolis", 9.00),
			new ItemPedido("pizza de 4 queijos", 15.00),
			new ItemPedido("pizza de berinjela", 10.00),
			new ItemPedido("pizza de abobrinha", 10.00),
			new ItemPedido( "pizza de chocolate", 10.00),
		};
		
		for (ItemPedido itemPedido : ip) {
			p.adicionarItem(itemPedido);
		}
		
		try {
			daoFiscal.inserir(nf);
			daoFiscal.commit();
		} catch (CommitExption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
		emf.close();
		
	}
	
}
