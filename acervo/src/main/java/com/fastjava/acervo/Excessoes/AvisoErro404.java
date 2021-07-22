package com.fastjava.acervo.Excessoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvisoErro404 {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoErro404.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ExcessaoErro404 ex) {
		return ex.getMessage();
	}
}
