package com.printle.Ccommerce.ErrorHandling;

public class NotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Not found your record";
	}

}
