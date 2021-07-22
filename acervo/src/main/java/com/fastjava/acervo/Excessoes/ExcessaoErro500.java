package com.fastjava.acervo.Excessoes;

public class ExcessaoErro500 extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public ExcessaoErro500(String msg) {
		super(msg);
	}
}
