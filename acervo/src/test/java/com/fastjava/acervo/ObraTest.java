package com.fastjava.acervo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fastjava.acervo.Entidades.Autor;
import com.fastjava.acervo.Entidades.Obra;
import com.fastjava.acervo.Repositorios.IObraRepositorio;

public class ObraTest {

//	private static final Logger log = LoggerFactory.getLogger(ObraTest.class);
//	private List<Obra> obras = new ArrayList<>();
//
//	private List<Autor> autores = new ArrayList<>();
//
//	private Obra addObraMock(Integer id) {
//		Obra obra = new Obra("Nome" + id, "Descrição" + id, Date.valueOf("1999-10-10"), autores);
//		obra.setId((long)id);
//		return obra;
//	}
//
//	private Autor addAutorMock(Integer id) {
//		return new Autor("Nome" + id, "nacionalidade" + id, Date.valueOf(LocalDate.now()), obras);
//
//	}
//
//	private void loadObras() {
//		obras.add(addObraMock(1));
//		obras.add(addObraMock(2));
//	}
//
//	private void loadAutores() {
//		autores.add(addAutorMock(1));
//		autores.add(addAutorMock(2));
//	}
//
//	@MockBean
//	private IObraRepositorio mockRepositorio;
//
//	@Test
//	void main() {
//		log.info("------------------- ObraTest ------------------");
//		consultaTodosTest();
//		log.info("------------------------------------------------------");
//	}
//
//	public void consultaTodosTest() {
//		loadAutores();
//		loadObras();
//		IObraRepositorio mockRepositorio = mock(IObraRepositorio.class);
//		when(mockRepositorio.findAll()).thenReturn(obras);
//		List<Obra> listaRetornoGET = mockRepositorio.findAll();
//		Assert.assertTrue(listaRetornoGET.size() > 0);
//		Assert.assertTrue(listaRetornoGET.get(0).getAutores().size() > 0);
//		Assert.assertTrue(listaRetornoGET.get(1).getAutores().size() > 0);
//		log.info("Teste Consulta todas as obras - OK");
//
//	}
}
