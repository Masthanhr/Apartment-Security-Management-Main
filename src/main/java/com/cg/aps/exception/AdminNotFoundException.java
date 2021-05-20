package com.cg.aps.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException(String msg) {

		super(msg);
	}

}
