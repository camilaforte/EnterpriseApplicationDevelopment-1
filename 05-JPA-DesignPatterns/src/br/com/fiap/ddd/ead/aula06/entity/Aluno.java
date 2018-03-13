package br.com.fiap.ddd.ead.aula06.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ALUNO")
public class Aluno {

	@Id
	@Column(name = "cd_aluno", nullable = false, length = 150)
	private int rm;

	@Column(name = "nm_aluno", nullable = false, length = 150)
	private String nome;

	public Aluno() {
		super();
	}

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
