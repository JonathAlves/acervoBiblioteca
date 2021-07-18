package Avisos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fastjava.acervo.Excessoes.ExcessaoAutorNaoEncontrado;

@ControllerAdvice
class AvisoAutorNaoEncontrado {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoAutorNaoEncontrado.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String employeeNotFoundHandler(ExcessaoAutorNaoEncontrado ex) {
		return ex.getMessage();
	}
}
