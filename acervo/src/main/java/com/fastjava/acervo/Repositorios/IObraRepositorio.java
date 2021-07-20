/**
 * 
 */
package com.fastjava.acervo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastjava.acervo.Entidades.Obra;

/**
 * @author grupo 1
 *
 */

public interface IObraRepositorio extends JpaRepository<Obra, Long>{
}
