package com.dicegame.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="El par�metro introducido no existe.")
public class NotFoundException extends Exception {

	public NotFoundException(String msg) {
		super(msg);
	}
	
	public NotFoundException() {
		super();
	}
}
