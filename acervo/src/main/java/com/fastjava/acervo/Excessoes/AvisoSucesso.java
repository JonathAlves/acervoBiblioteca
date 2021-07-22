package com.fastjava.acervo.Excessoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvisoSucesso {
	@ResponseBody
	@ExceptionHandler(ExcessaoSucesso.class)
	@ResponseStatus(HttpStatus.OK)
	String employeeNotFoundHandler(ExcessaoSucesso ex) {
		return ex.getMessage();
	}
}
