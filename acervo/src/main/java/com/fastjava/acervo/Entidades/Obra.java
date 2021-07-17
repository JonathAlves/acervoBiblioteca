/**
 * 
 */
package com.fastjava.acervo.Entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author grupo 1
 *
 */
@Entity
public class Obra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "NOME", length = 240, nullable = false)
	private String nomeDaObra;
	@Column(name = "DESCRICAO", length = 240, nullable = false)
	private String descricao;
	@Column(name = "DATA", nullable = false)
	private Date dataPublicacao;
	@ElementCollection
	private List<Autor> autores = new ArrayList<>();
	/**
	 * 
	 */
	
	public Obra() {}
	
	public Obra(String nome, String descricaoObra, Date data, List<Autor> autores) {
		this.nomeDaObra = nome;
		this.descricao = descricaoObra;
		this.dataPublicacao = data;	
		this.autores = autores;
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
	/**
	 * @return the autores
	 */
	public List<Autor> getAutores() {
		return autores;
	}
	
	public void addAutor(Autor autor) {
		autores.add(autor);
	}
	
	public void removerAutor(Autor autor) {
		autores.remove(autor);
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Id Obra: " + id);
	    sb.append("\nNome da Obra: "+ nomeDaObra);
	    sb.append("\nDescrição: "+descricao);
	    sb.append("\nData de Publicacao: "+ dataPublicacao);
	    sb.append("\nAutores: "+ autores);

	    return sb.toString();
	}
}
