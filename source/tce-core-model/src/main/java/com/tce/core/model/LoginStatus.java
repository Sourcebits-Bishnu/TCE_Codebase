package com.tce.core.model;

public enum LoginStatus {
	ACTIVE(1),CHANGEPASSWORD(2);
	
	private int status;
	
	private LoginStatus(int status) {
		this.status = status;
	}
	
	public int value() {
		return status;
	}

}
