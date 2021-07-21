/**
 * 
 */
package com.fastjava.acervo.Entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author grupo 1
 *
 */
@Entity
public class ObrasAutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOME", length = 240, nullable = false)
	private String nomeDaObra;
	@Column(name = "DESCRICAO", length = 240, nullable = false)
	private String descricao;
	@Column(name = "DATA", nullable = false)
	private Date dataPublicacao;

	/**
	 * 
	 */

	public ObrasAutor() {
	}

	public ObrasAutor(String nome, String descricaoObra, Date data) {
		this.nomeDaObra = nome;
		this.descricao = descricaoObra;
		this.dataPublicacao = data;
	}

	/**
	 * @return the nomeDaObra
	 */
	public String getNomeDaObra() {
		return nomeDaObra;
	}

	/**
	 * @param nomeDaObra the nomeDaObra to set
	 */
	public void setNomeDaObra(String nomeDaObra) {
		this.nomeDaObra = nomeDaObra;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataPublicacao
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id Obra: " + id);
		sb.append("\nNome da Obra: " + nomeDaObra);
		sb.append("\nDescrição: " + descricao);
		sb.append("\nData de Publicacao: " + dataPublicacao);

		return sb.toString();
	}
}
