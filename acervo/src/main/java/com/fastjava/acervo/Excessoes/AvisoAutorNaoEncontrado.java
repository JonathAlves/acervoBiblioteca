package com.fastjava.acervo.Excessoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AvisoAutorNaoEncontrado {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoAutorNaoEncontrado.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String employeeNotFoundHandler(ExcessaoAutorNaoEncontrado ex) {
		return ex.getMessage();
	}
}
