/**
 * 
 */
package com.fastjava.acervo.Servicos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastjava.acervo.Entidades.Autor;
import com.fastjava.acervo.Excessoes.ExcessaoAutorNaoEncontrado;
import com.fastjava.acervo.Repositorios.IAutorRepositorio;

/**
 * @author grupo 1
 *
 */

@RequestMapping("/Acervo")
@RestController
public class AutorController {
	private final IAutorRepositorio autorRepositorio;

	public AutorController(IAutorRepositorio repositorio) {
		this.autorRepositorio = repositorio;
	}

	@GetMapping("/autores/{id}")
	public Autor buscaAutor(@PathVariable Long id) {
		return autorRepositorio.findById(id).orElseThrow(() -> new ExcessaoAutorNaoEncontrado(id));
	}


	@GetMapping("/autores")
	public List<Autor> listaAutores() {
		return autorRepositorio.findAll();
	}
	
	
	
}
