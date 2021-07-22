package com.fastjava.acervo.Excessoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvisoErro500 {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoErro500.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String employeeNotFoundHandler(ExcessaoErro500 ex) {
		return ex.getMessage();
	}
}
