package com.fastjava.acervo.Excessoes;

public class ExcessaoCpfNulo extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public ExcessaoCpfNulo() {
		super("Nacionalidade brasileira, o CPF é obrigatório!");
	}
}
