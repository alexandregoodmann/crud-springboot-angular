package br.com.goodmann.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {

	public NotAcceptableException() {
	}

	public NotAcceptableException(String msg) {
		super(msg);
	}

}
