package com.tce.common.web;

import com.tce.common.model.SystemConstants;
import com.tce.common.model.SystemConstants.Status;

import lombok.Getter;
import lombok.Setter;

public class StatusResponse {

	@Getter @Setter 
	private String status;
	    
    public StatusResponse(String status) {
        this.status = status;
    }
    
    public StatusResponse(Status status) {
    	this(status.text());
    }
    
    public static final StatusResponse SUCCESS = new StatusResponse(SystemConstants.Status.SUCCESS);
    public static final StatusResponse FAILURE = new StatusResponse(SystemConstants.Status.FAILURE);
}
