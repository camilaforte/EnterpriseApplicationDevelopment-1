package br.com.fiap.ead.exercicio1.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.ead.exercicio1.entities.Genero;
import br.com.fiap.ead.exercicio1.entities.Motorista;
import br.com.fiap.ead.exercicio1.entities.Veiculo;

public class Main {

	public static void main(String[] args) {
		
		Veiculo v = new Veiculo("DZB1291", "vermelho", 2001);
		Motorista m = new Motorista(999333, "Joao Carlos", new GregorianCalendar(1987, Calendar.JULY, 24), null, Genero.MASCULINO)
		
		
	}
	
}
