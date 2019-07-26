package com.tce.content.model;

import com.tce.common.model.MessageConstants;

public enum LessonMessageConstants implements MessageConstants{
	
	NO_CONTENT(-2003, "No Content Found For Request");

	private final Integer code;
	private final String msg;

	private LessonMessageConstants(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
