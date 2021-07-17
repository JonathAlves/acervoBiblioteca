package com.fastjava.acervo.Configuracao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fastjava.acervo.Entidades.Autor;
import com.fastjava.acervo.Entidades.Obra;
import com.fastjava.acervo.Repositorios.IObraRepositorio;

@Configuration
public class CarregarBaseDados {

	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);
	Obra obra = new Obra();
	List<Autor> autores = new ArrayList<>();

	@Bean
	CommandLineRunner initDatabase(IObraRepositorio repository) {
		autores.add(new Autor("Machado de assis", "Brasileiro", Date.valueOf("1839-19-28")));
		return args -> {
			log.info("Carregando " + repository.save(new Obra("Harry Potter", "Livro de fantasia", Date.valueOf("1999-10-10"), autores)));			
		};
	}
}
