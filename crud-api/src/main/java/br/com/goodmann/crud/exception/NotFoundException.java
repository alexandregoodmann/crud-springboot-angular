package br.com.goodmann.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Registro não encontrado")
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
	}

	public NotFoundException(String msg) {
		super(msg);
	}

}
