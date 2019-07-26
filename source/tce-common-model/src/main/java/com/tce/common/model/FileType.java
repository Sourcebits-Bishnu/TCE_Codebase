package com.tce.common.model;

import java.util.List;
import java.util.Map;

public interface FileType {
	
//	public static final String WEBTYPE_SEP = "/-/";
//	public static final String WEBPATH_SEP = "/";
	
	public enum KEYS {
		ORGID,USERID,SESSIONID;
	}
	
	public String getType();
	
	public boolean requiresSession();
	
	public boolean requireContext();
	
	public List<String> getFilePath(Map<KEYS, String> context,String[] params);
}
