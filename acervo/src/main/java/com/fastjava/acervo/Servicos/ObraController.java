/**
 * 
 */
package com.fastjava.acervo.Servicos;

import java.sql.Date;
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
import com.fastjava.acervo.Entidades.ObrasAutor;
import com.fastjava.acervo.Excessoes.ExcessaoErro500;
import com.fastjava.acervo.Excessoes.ExcessaoErro404;
import com.fastjava.acervo.Repositorios.IAutorRepositorio;
import com.fastjava.acervo.Repositorios.IObraRepositorio;

import Avisos.MensagemSucesso;

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
	// correspondente a um autor.
	
	@PostMapping("/obras")
	public String cadastraObra(@RequestBody Obra obra) {
		ObrasAutor obrasAutor = new ObrasAutor();
		autores = obra.getAutores();
		autoresExistentes = autorRepositorio.findAll();
		obrasAutor.setNomeDaObra(obra.getNomeDaObra());
		obrasAutor.setDescricao(obra.getDescricao());
		obrasAutor.setDataPublicacao(obra.getDataPublicacao());
		for (Autor autor : autores) {
			verificaDesconhecido(autor);
			verificaCPF(autor);		
			autor.insereObra(obrasAutor);
			autorRepositorio.save(autor);
		}
		
		obraRepositorio.save(obra);

		
		MensagemSucesso msg = new MensagemSucesso("Nome: "+obra.getNomeDaObra() +"\nDescrição: "+obra.getDescricao()+"\nData de publicação: "+ obra.getDataPublicacao()+"\n\nObra cadastrada com sucesso!");
		return msg.toString();
	}

	// Lista todas as obras cadastradas
	@GetMapping("/obras")
	public List<Obra> listaObras() {
		return obraRepositorio.findAll();
	}

	@GetMapping("/obras/{id}")
	public Obra buscaObra(@PathVariable Long id){
		return obraRepositorio.findById(id).orElseThrow(() -> new ExcessaoErro404("Obra não encontrada! ID: (" +id+ ")"));
	}

	@PutMapping("/obras/{id}")
	public String editaObra(@RequestBody Obra novaObra, @PathVariable Long id) {
		MensagemSucesso msg = new MensagemSucesso();
		return obraRepositorio.findById(id).map(obra -> {
			if(novaObra.getNomeDaObra() == null || novaObra.getDescricao() == null || novaObra.getDataPublicacao() == null) {
				throw new ExcessaoErro500("Erro na aplicação! Algum dos atributos está nulo.");
			}
			obra.setNomeDaObra(novaObra.getNomeDaObra());
			obra.setDescricao(novaObra.getDescricao());
			obra.setDataPublicacao(novaObra.getDataPublicacao());
			obra.setAutores(autores);
			obraRepositorio.save(obra);
			msg.setMensagem("Obra atualizada com sucesso!");
			return msg.toString();
		}).orElseGet(() -> {
			novaObra.setId(id);
			obraRepositorio.save(novaObra);
			msg.setMensagem("Obra atualizada com sucesso!");
			return msg.toString(); 
		});
	}

	@DeleteMapping("/obras/{id}")
	public String deletarObra(@PathVariable Long id) {
		obraRepositorio.findById(id).orElseThrow(() -> new ExcessaoErro404("Obra não encontrada! ID: (" +id+ ")"));
		obraRepositorio.deleteById(id);
		MensagemSucesso msg = new MensagemSucesso("\nObra excluida com sucesso!");
		return msg.toString();
	}

	@DeleteMapping("/obras")
	public String deletaObras() {
		obraRepositorio.deleteAll();
		MensagemSucesso msg = new MensagemSucesso("\nTodas as obras excluidas com sucesso!");
		return msg.toString();
	}

	public void verificaCPF(Autor autor) {
		if (autor.getNacionalidade().equalsIgnoreCase("Brasil") && autor.getCpf() == null) {
			throw new ExcessaoErro500("Nacionalidade brasileira, é obrigatório informar o CPF!");
		}
	}
	
	public void verificaDesconhecido(Autor autor) {
		if(autor.getNome().equalsIgnoreCase("desconhecido")) {
			autor.setNacionalidade("DESCONHECIDA");
			autor.setCpf("DESCONHECIDO");
		}
	}
}
