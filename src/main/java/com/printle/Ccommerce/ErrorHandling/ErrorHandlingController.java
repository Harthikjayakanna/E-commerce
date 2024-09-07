package com.printle.Ccommerce.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler{
	@ExceptionHandler(NotFound.class)
	public ResponseEntity<String> exceptione(NotFound e){
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(InvalidCredientials.class)
	public ResponseEntity<String> exceptiontwo(){
		return new ResponseEntity<String>("Either password or email are wrong",HttpStatus.BAD_REQUEST);
	}
}
