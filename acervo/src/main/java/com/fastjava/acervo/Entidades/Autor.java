/**
 * 
 */
package com.fastjava.acervo.Entidades;

import java.sql.Date;

import javax.persistence.*;

/**
 * @author grupo 1
 *
 */
@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "NOME", length = 120, nullable = false)
	private String nome;
	@Column(name = "PAÍS", nullable = false)
	private String nacionalidade;
	@Column(name = "DATA", nullable = false)
	private Date nascimento;
	@Column(name = "CPF")
	private String cpf;
	/**
	 * 
	 */
	public Autor() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nome
	 * @param nacionalidade
	 * @param nascimento
	 */
	public Autor(String nome, String nacionalidade, Date nascimento) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.nascimento = nascimento;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}
	/**
	 * @param nacionalidade the nacionalidade to set
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	/**
	 * @return the nascimento
	 */
	public Date getNascimento() {
		return nascimento;
	}
	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", nascimento=" + nascimento
				+ ", cpf=" + cpf + "]";
	}
}
