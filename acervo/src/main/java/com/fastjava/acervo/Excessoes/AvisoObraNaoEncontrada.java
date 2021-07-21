package Avisos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fastjava.acervo.Excessoes.ExcessaoObraNaoEncontrada;

@ControllerAdvice
public class AvisoObraNaoEncontrada {
	
	@ResponseBody
	@ExceptionHandler(ExcessaoObraNaoEncontrada.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ExcessaoObraNaoEncontrada ex) {
		return ex.getMessage();
	}

}
