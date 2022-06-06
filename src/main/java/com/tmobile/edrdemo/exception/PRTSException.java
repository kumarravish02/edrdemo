package com.tmobile.edrdemo.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class PRTSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	private static final Logger logger = LogManager.getLogger(PRTSException.class);

	public PRTSException() {
		super();
		msg = "unknown";
	}

	public PRTSException(String message) {
		super(message);
		msg = message;
		logger.error(message);
	}

	public PRTSException(Exception e) {
		logger.error(e);
		this.msg = e.getMessage();
	}

	public String getMessage() {
		return msg;
	}
}
