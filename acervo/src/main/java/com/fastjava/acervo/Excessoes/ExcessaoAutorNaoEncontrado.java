package com.fastjava.acervo.Excessoes;

public class ExcessaoAutorNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcessaoAutorNaoEncontrado(Long id) {
		super("Não foi possível encontrar o autor. (id: "+ id +")");
	}
}
