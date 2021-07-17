/**
 * 
 */
package com.fastjava.acervo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastjava.acervo.Entidades.Autor;

/**
 * @author grupo 1
 *
 */
public interface IAutorRepositorio extends JpaRepository<Autor, Long>{
}
