package com.sophossolutions.ChallengeCodility.exception;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sophossolutions.ChallengeCodility.dto.ErrorDto;

@ControllerAdvice
@RestController
public class FilterException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ModelNotFound.class)
	public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler(WebRequest request, ModelNotFound ex){
		ex.printStackTrace();
		HttpStatus status =  HttpStatus.NOT_FOUND;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , ex.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, status);
	}
	
	@ExceptionHandler(IOException.class)
	public final ResponseEntity<ErrorDto> ConstraintViolationExceptionHandler(WebRequest request, IOException ex){
		ex.printStackTrace();
		HttpStatus status =  HttpStatus.BAD_REQUEST;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , "Error generando el archivo", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, status);
	} 
	
	@ExceptionHandler(ClassNotFoundException.class)
	public final ResponseEntity<ErrorDto> ClassNotFoundExceptionHandler(WebRequest request, ClassNotFoundException ex){
		ex.printStackTrace();
		HttpStatus status =  HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , ex.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, status);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto> ExceptionHandler(WebRequest request, Exception ex){
		ex.printStackTrace();
		HttpStatus status =  HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , "Ha ocurrido un error inesperado", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		status =  HttpStatus.METHOD_NOT_ALLOWED;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , "Metodo no soportado", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		status =  HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , "el formato es inválido", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		status =  HttpStatus.NOT_FOUND;
		ErrorDto error = new ErrorDto(status.toString(), status.value() , "Url no existe", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, status);
	}

}
