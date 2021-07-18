package Avisos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fastjava.acervo.Excessoes.ExcessaoObraNaoEncontrada;

@ControllerAdvice
class AvisoObraNaoEncontrada {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoObraNaoEncontrada.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String employeeNotFoundHandler(ExcessaoObraNaoEncontrada ex) {
		return ex.getMessage();
	}

}
