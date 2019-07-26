package com.tce.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;


@Repository("fileSystemUtil")
public class FileSystemUtil {


	public String loadResourceToString(String resourceFileString)
	throws Exception {
		InputStream resourceFileURL=this.getClass().getClassLoader().getResourceAsStream(resourceFileString);
		StringWriter writer = new StringWriter();
		IOUtils.copy(resourceFileURL, writer);
		return writer.toString();
	}
	
	public String loadFileToString(File resourceFile)
	throws Exception {
		InputStream resourceFileURL=new FileInputStream(resourceFile);
		StringWriter writer = new StringWriter();
		IOUtils.copy(resourceFileURL, writer);
		return writer.toString();
	}

//	public String decryptResourceToString(String resourceFileString)
//	throws Exception {
//		InputStream resourceFileURL=this.getClass().getClassLoader().getResourceAsStream(resourceFileString);
//		if(resourceFileURL == null){
//			throw new FileNotFoundException();
//		}
//		StringWriter writer = new StringWriter();
//		IOUtils.copy(resourceFileURL, writer);
//		String contents = Encryption.decrypt(SisConstants.CLASSEDGE_ENCRYPTION_KEY_LP, writer.toString());
//		return contents;
//	}
//
//	public String decryptFileToString(File resourceFile)
//	throws Exception {
//		String fileData = FileUtils.readFileToString(resourceFile);
//		String contents = Encryption.decrypt(SisConstants.CLASSEDGE_ENCRYPTION_KEY_LP, fileData);
//		return contents;
//	}


	

}
