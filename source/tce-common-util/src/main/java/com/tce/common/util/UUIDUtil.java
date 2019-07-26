package com.tce.common.util;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.tce.common.model.UUIDType;

@Repository("uuidUtil")
public class UUIDUtil {

	public static final String SEPERATOR = "-";
	public static final String LANG_SEPERATOR = "_";
	
	public static final String ROLE = "rle-";
	

	public String getId(UUIDType type){
		return type.getName() + SEPERATOR + UUID.randomUUID();
	}
	
	public String getIdForOrg(UUIDType type,String orgId){
		return type.getName() + SEPERATOR + UUID.randomUUID() + SEPERATOR + orgId;
	}

}