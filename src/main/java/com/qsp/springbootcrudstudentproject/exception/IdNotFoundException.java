package com.qsp.springbootcrudstudentproject.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception {
	
	String msg;
	
	public IdNotFoundException(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
}
