/**
 * 
 */
package com.fastjava.acervo.Servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastjava.acervo.Entidades.Autor;
import com.fastjava.acervo.Entidades.Obra;
import com.fastjava.acervo.Excessoes.ExcessaoCpfNulo;
import com.fastjava.acervo.Excessoes.ExcessaoObraNaoEncontrada;
import com.fastjava.acervo.Repositorios.IAutorRepositorio;
import com.fastjava.acervo.Repositorios.IObraRepositorio;

/**
 * @author grupo 1
 *
 */
@RequestMapping("/Acervo")
@RestController
public class ObraController {

	private final IObraRepositorio obraRepositorio;
	private final IAutorRepositorio autorRepositorio;
	private List<Autor> autores = new ArrayList<>();
	private List<Autor> autoresExistentes = new ArrayList<>();
	

	// Construtor
	public ObraController(IObraRepositorio repositorio, IAutorRepositorio repoAutor) {
		this.obraRepositorio = repositorio;
		this.autorRepositorio = repoAutor;
	}

	// Cadastra uma nova obra no sistema incluindo a obra cadastrada em numa lista
	// correspondente a um autor. (Não aparece no postman)
	@PostMapping("/obras")
	public Obra cadastraObra(@RequestBody Obra obra) {
		int cont = 0;
		autores = obra.getAutores();
		autoresExistentes = autorRepositorio.findAll();
		for (Autor autor : autores) {
			
			verificaCPF(autor);
			for(Autor autorBanco : autoresExistentes) {
				if(autorBanco.getCpf().equals(autor.getCpf())) {
					cont++;
				}
			}
			if(cont > 0) {
				cont = 0;
				continue;
			}else {
				cont = 0;
				autor.insereObra(obra);
				
			}
			System.out.println(autor);
			autorRepositorio.save(autor);
		}

		return obraRepositorio.save(obra);
	}

	// Lista todas as obras cadastradas
	@GetMapping("/obras")
	public List<Obra> listaObras() {
		return obraRepositorio.findAll();
	}

	@GetMapping("/obras/{id}")
	public Obra buscaObra(@PathVariable Long id) {
		return obraRepositorio.findById(id).orElseThrow(() -> new ExcessaoObraNaoEncontrada(id));
	}

	@PutMapping("/obras/{id}")
	public Obra editaObra(@RequestBody Obra novaObra, @PathVariable Long id) {
		return obraRepositorio.findById(id).map(obra -> {
			obra.setNomeDaObra(novaObra.getNomeDaObra());
			obra.setDescricao(novaObra.getDescricao());
			obra.setDataPublicacao(novaObra.getDataPublicacao());
			obra.addAutor(new Autor());
			return obraRepositorio.save(obra);
		}).orElseGet(() -> {
			novaObra.setId(id);
			return obraRepositorio.save(novaObra);
		});
	}

	@DeleteMapping("/obras/{id}")
	public void deletarObra(@PathVariable Long id) {
		obraRepositorio.deleteById(id);
	}

	@DeleteMapping("/obras")
	public void deletaObras() {
		obraRepositorio.deleteAll();
	}

	public void verificaCPF(Autor autor) {
		if (autor.getNacionalidade().equalsIgnoreCase("Brasil") && autor.getCpf() == null) {
			throw new ExcessaoCpfNulo();
		}
	}
}
