package com.tce.core.model;

import com.tce.common.model.MessageConstants;

public enum CoreMessageConstants implements MessageConstants{
	
	ROLE_ADD_FAILED(-1001, "Couldn't add role"), 
	ROLE_DELETE_FAILED(-1002, "Couldn't delete role"),
	ROlE_FETCH_FAILED(-1003, "Couldn't fetch role"), 
	
	ORG_CREATE_FAILED(-1010, "Couldn't create the organization"),
	ORG_FETCH_FAILED(-1011, "Couldn't find the organization"),
	ORG_EXISTS(-1012, "Organization already exists"),
	
	CTX_FETCH_FAILED(-1020, "Couldn't find the context"),
	PRIV_FETCH_FAILED(-1025, "Couldn't find the privilege"),
	
	USER_EXIST(-1030, "User already exists"),
	USER_PIN_EXIST(-1034, "Pin is already taken. Try another pin!"),
	SIGNIN_PIN_FAILUIRE(-1036, "Invalid Pin. Please try again."), 
	SIGIN_CREDENTIALS_INVALID(-1039, "Login credentials are invalid"),
	/*
	
	SIGNIN_FAILUIRE(-1007, "SignIn Failure"),
	SIGNIN_PIN_INVALID(-1008, "PIN Should not be blank or null"),
	
	
	BAD_CREDENTIALS(-1010, "The UserID and / or Password is invalid. Please try again."),
	REQUSET_MODEL_VALIDATION_EXCEPTION(-1011, "Please enter the valid format"),
	GET_TOKEN_FAILED(-1012, "Token Generated failed."), 
	CHANGE_PASSWORD_FAIL(-1013, "Change Password Failed"),
	
	GENERATE_PIN_FAILED(-1015, "Pin Generation Failed"),
	SAVE_PIN_FAILED(-1016, "PIN is already taken, Please enter different PIN."),
	CHANGE_PASSWORD_SUCCESS(1000 , "Password Changed Successfully"),
	
	LOGOUT_SUCCESS(1017, "User Logout successfully."),
	LOGOUT_FAILURE(-1018, "Couldn't perform Logout."),
	
	CLIENT_REGISTER_SUCCESS(1019, "Client registered successfully."),
	CLIENT_REGISTER_FAILURE(-1020, "Issue with Client registration.")*/;

	private final Integer code;
	private final String msg;

	private CoreMessageConstants(Integer code, String msg) {
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
