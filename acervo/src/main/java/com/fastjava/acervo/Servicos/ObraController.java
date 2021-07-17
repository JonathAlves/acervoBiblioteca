/**
 * 
 */
package com.fastjava.acervo.Servicos;

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
import com.fastjava.acervo.Excessoes.ExcessaoObraNaoEncontrada;
import com.fastjava.acervo.Repositorios.IObraRepositorio;

/**
 * @author grupo 1
 *
 */
@RequestMapping("/Acervo")
@RestController	
public class ObraController {
	
	private final IObraRepositorio obraRepositorio;
	
	//Construtor 
	public ObraController(IObraRepositorio repositorio) {
		this.obraRepositorio = repositorio;
	}
	
	//Cadastra uma nova obra no sistema
	@PostMapping("/obras")
	public Obra cadastraObra(@RequestBody Obra obra) {
		return obraRepositorio.save(obra);
	}
	
	//Lista todas as obras cadastradas
	@GetMapping("/obras")
	public List<Obra> listaObras(){
		return obraRepositorio.findAll();
	}
	
	@GetMapping("/obras/{id}")
	public Obra buscaObra(@PathVariable Long id) {
		return obraRepositorio.findById(id)
				.orElseThrow(() -> new ExcessaoObraNaoEncontrada(id));
	}
	
	@PutMapping("/obras/{id}")
	public Obra editaObra(@RequestBody Obra novaObra, @PathVariable Long id) {
		return obraRepositorio.findById(id)
				.map(obra -> {
					obra.setNomeDaObra(novaObra.getNomeDaObra());
					obra.setDescricao(novaObra.getDescricao());
					obra.setDataPublicacao(novaObra.getDataPublicacao());
					obra.addAutor(new Autor());
					return obraRepositorio.save(obra);
				})
				.orElseGet(() -> {
					novaObra.setId(id);
					return obraRepositorio.save(novaObra);
				});
	}
	
	@DeleteMapping("/obras/{id}")
	public void deletarObra(@PathVariable Long id) {
		obraRepositorio.deleteById(id);
	}
	
}
