package com.tce.common.exception;

import com.tce.common.model.MessageConstants;

import lombok.Getter;
import lombok.Setter;

public class TataException extends Exception {

	private static final long serialVersionUID = -9066771620L;

	@Getter @Setter
	private Integer errorCode;
	
	@Getter @Setter
	private String errorMsg;
	
	
	public TataException(MessageConstants message) {
		super();
		this.errorCode = message.getCode();
		this.errorMsg = message.getMsg();
	}
	
}
