package com.tce.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum SysDir implements FileType {
	CLASSEDGE_DATA_DIR(System.getProperty("classedge.data.dir")){
		@Override
		public List<String> getFilePath(Map<KEYS, String> context,String[] params) {
			List<String> paths = new ArrayList<>();			
			paths.add(fileName);
			return paths;
		}
	},
	CLASSEDGE_REPO_DIR("ce-repo"){
		@Override
		public List<String> getFilePath(Map<KEYS, String> context,String[] params) {
			List<String> paths = SysDir.CLASSEDGE_DATA_DIR.getFilePath(null, null);			
			paths.add(fileName);
			return paths;
		}
	},	
	TEMP("temp"){
		@Override
		public List<String> getFilePath(Map<KEYS, String> context,String[] params) {
			List<String> paths = SysDir.CLASSEDGE_DATA_DIR.getFilePath(null, null);			
			paths.add(fileName);
			return paths;
		}
	},
	CONTENT("content"),
	RESOURCES("resources"),
	TMPT("templates"){
		@Override
		public List<String> getFilePath(Map<KEYS, String> context,String[] params) {
			List<String> paths = RESOURCES.getFilePath(null, null);
			paths.add(fileName);
			return paths;
		}	
	};
	
	protected String fileName;
	
	private SysDir(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public List<String> getFilePath(Map<KEYS, String> context,String[] params) {
		List<String> paths = CLASSEDGE_REPO_DIR.getFilePath(null, null);
		paths.add(fileName);
		return paths;
	}
	
	@Override
	public String getType() {		
		throw new UnsupportedOperationException() ;
	}
	
	@Override
	public boolean requiresSession() {
		throw new UnsupportedOperationException() ;
	}
	
	@Override
	public boolean requireContext() {
		throw new UnsupportedOperationException() ;
	}
}
