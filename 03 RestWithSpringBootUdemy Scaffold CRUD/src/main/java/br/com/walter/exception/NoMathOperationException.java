package br.com.walter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
public class NoMathOperationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoMathOperationException(String ex) {
		 super(ex);
	}

}
