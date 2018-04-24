package br.com.fiap.ead.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_MEDICO")
public class Medico {

	@Id
	@Column(name="nr_crm", nullable=false, unique=true)
	private long crm;
	
	@Column(name="nm_medico", nullable=false, length=250)
	private String nome;
	
	@Column(name="ds_especialidade", length=100, nullable=false)
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	public Medico() {

	}
	
	public Medico(long crm, String nome, Especialidade especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
}
