package com.sophosolutions.generalcodilityreport.exception;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sophosolutions.generalcodilityreport.dto.ErrorDto;


@ControllerAdvice
@RestController
public class Filter extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ModelNotFound.class)
	public final ResponseEntity<ErrorDto> filterModelNotFound(WebRequest request, ModelNotFound ex){
		
		HttpStatus statusUno =  HttpStatus.NOT_FOUND;
		ErrorDto error = new ErrorDto(statusUno.toString(), statusUno.value() , ex.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusUno);
	}
	
	@ExceptionHandler(IOException.class)
	public final ResponseEntity<ErrorDto> filterReadWrite(WebRequest request, IOException ex){
		
		HttpStatus statusDos =  HttpStatus.BAD_REQUEST;
		ErrorDto error = new ErrorDto(statusDos.toString(), statusDos.value() , "Error generando el archivo", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusDos);
	} 
	
	@ExceptionHandler(ClassNotFoundException.class)
	public final ResponseEntity<ErrorDto> filterClassNotFound(WebRequest request, ClassNotFoundException ex){
		
		HttpStatus statusTres =  HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(statusTres.toString(), statusTres.value() , ex.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusTres);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto> filterException(WebRequest request, Exception ex){
		
		HttpStatus statusCuatro =  HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(statusCuatro.toString(), statusCuatro.value() , "Ha ocurrido un error inesperado", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusCuatro);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		HttpStatus statusCinco =  HttpStatus.METHOD_NOT_ALLOWED;
		ErrorDto error = new ErrorDto(statusCinco.toString(), statusCinco.value() , "Metodo no soportado", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusCinco);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		HttpStatus statusSeis =  HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		ErrorDto error = new ErrorDto(statusSeis.toString(), statusSeis.value() , "el formato es inválido", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusSeis);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		HttpStatus statusSiete = HttpStatus.BAD_REQUEST;
		BindingResult resultado = ex.getBindingResult();
		List<FieldError> fieldErrors = resultado.getFieldErrors();
		StringBuilder errorMessage = new StringBuilder();
		fieldErrors.forEach(f -> errorMessage.append(f.getField() + "-> " + f.getDefaultMessage() + " "));

		ErrorDto error = new ErrorDto(statusSiete.toString(), statusSiete.value(), errorMessage.toString(),
				((ServletWebRequest) request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusSiete);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		HttpStatus statusOcho =  HttpStatus.NOT_FOUND;
		ErrorDto error = new ErrorDto(statusOcho.toString(), statusOcho.value() , "Url no existe", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(error, statusOcho);
	}

}
