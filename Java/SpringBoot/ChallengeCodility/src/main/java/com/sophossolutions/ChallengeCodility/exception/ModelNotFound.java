package com.sophossolutions.ChallengeCodility.exception;

public class ModelNotFound  extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ModelNotFound(String mensaje) {
		super(mensaje);
	}

}
