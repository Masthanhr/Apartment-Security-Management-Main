package com.cg.aps.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class AdminExistsException extends RuntimeException {
			public AdminExistsException(String msg) {
				super(msg);
			}

}
