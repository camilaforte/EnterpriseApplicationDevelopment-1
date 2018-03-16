package br.com.fiap.ads.ead.aula06.entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EAD_NOTA_FISCAL")
@SequenceGenerator(name="notafiscal", sequenceName="SQ_EAD_T_NOTA_FISCAL", initialValue=1, allocationSize=1)
public class NotaFiscal {

	@Id
	@Column(name="cd_nota_fiscal")
	@GeneratedValue(generator="notafiscal", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_nota_fiscal", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="vl_nota_fiscal", nullable=false)
	private double valor;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	public NotaFiscal() { }
	
	public NotaFiscal(Calendar data, double valor, Pedido pedido) {
		super();
		this.data = data;
		this.valor = valor;
		this.pedido = pedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
