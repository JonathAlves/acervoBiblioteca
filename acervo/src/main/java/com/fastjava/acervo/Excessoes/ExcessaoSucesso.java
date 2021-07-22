package com.fastjava.acervo.Excessoes;

public class ExcessaoSucesso extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcessaoSucesso(String msg) {
		super(msg);
	}
}
