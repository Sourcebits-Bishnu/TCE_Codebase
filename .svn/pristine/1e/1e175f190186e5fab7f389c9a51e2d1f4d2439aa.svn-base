package com.tce.common.model;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.tce.common.model.FileType.KEYS;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileTypeFactory {
		
	private static Map< String, FileType > map = new TreeMap < String, FileType > ();

	public static FileType findFileType(String typeName) {
		return map.get(typeName);
	}
	
	public static File getFile(FileType ftype,Map<KEYS, String> context,String[] params){
		List<String> folders = ftype.getFilePath(context, params);
		StringBuffer path = new StringBuffer();
		for(String f : folders) {
			path.append(f).append(File.separator);
		}
		return new File(path.toString());
	}
	
	public static File getFile(FileType ftype){
		return getFile(ftype,null,null);
	}
	
	public static File createFolder(FileType ftype){
		File f =  getFile(ftype,null,null);
		if(!f.exists()) {
			f.mkdirs();
		}
		return f;
	}
	
	public static File getFile(FileType ftype,String fileName){
		return new File(getFile(ftype,null,null),fileName);
	}
	
//	public static String getWebPath(FileType ftype,String[] params) {			
//		StringBuffer path = new StringBuffer(ftype.getType());
//		path.append(FileType.WEBTYPE_SEP);
//		for(int i = 0, n=params.length - 1 ; i < n;i++) {
//			path.append(params[i]).append(FileType.WEBPATH_SEP);
//		}
//		path.append(params[params.length - 1]);
//		return path.toString();
//	}
//
//
//	public static void addWebFileType(FileType[] types) {
//		for (FileType t : types) {
//			if (!map.containsKey(t.getType())) {
//				log.debug("Adding {}",t.getType());
//				map.put(t.getType(), t);
//			}
//		}
//	}
	
	public static void createDir(FileType[] types) {
		for (FileType t : types) {
			File d = getFile(t);
			if(!d.exists()) {
				d.mkdirs();
				log.debug("created {}",d.getName());
			}			
		}
	}
}
