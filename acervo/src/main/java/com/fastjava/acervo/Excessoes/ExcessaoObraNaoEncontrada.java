package com.fastjava.acervo.Excessoes;

public class ExcessaoObraNaoEncontrada extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcessaoObraNaoEncontrada(Long id) {
		super("Obra com o id " + id + " não encontrada!");
	}

}
