package com.tce.content.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tce.common.model.FileTypeFactory;
import com.tce.common.model.SysDir;
import com.tce.content.model.LessonConstants;

@Service
public class ContentUtil {

	private static final Logger logger = LoggerFactory.getLogger(ContentUtil.class);

	/**
	 * read file from path *
	 * 
	 * @param filePath
	 * @return
	 */
	public String getFileFromPath(String filePath) {
		String content = null;
		try {
			File f = FileTypeFactory.getFile(SysDir.CONTENT,filePath);					
			if (f.exists()) {
				content = new String(Files.readAllBytes(f.toPath()));
				return content;
			}
			
		} catch (IOException ioex) {
			logger.error("Error while fetching content data : ", ioex);
		} catch (Exception ex) {
			logger.error("Error while fetching content data : ", ex);
		}
		return content;
	}

	/**
	 * write json file in content folder * *
	 * 
	 * @param uploadPath
	 * @return
	 */
	public String uploadFile(String json, String path, String fileName) {
		try {
			// Save the playlist.json file in tomcat server
			File file = FileTypeFactory.getFile(SysDir.CONTENT,path);
			// make dir if not exists
			if (!file.exists())
				file.mkdirs();

			file = new File(file , fileName);

			// create file if not exist
			if (!file.exists()) {
				boolean status = file.createNewFile();
				logger.info("File Created Successfully! {} ", status);
			}			
			FileUtils.write(file, json, StandardCharsets.UTF_8);
			logger.info("File Saved Successfully!");
			return new String(json.getBytes(), StandardCharsets.UTF_8);
		} catch (Exception ex) {
			logger.debug("Error While Uploading PlayList : {}", ex);
		}
		return null;
	}



	public String getBasePath(String id) {
		if (id.contains("vtp-")) {
			return LessonConstants.VTP_BASE_PATH;
		} else if (id.contains("tp-")) {
			return LessonConstants.TOPIC_BASE_PATH;
		} else if (id.contains("tq-")) {
			return LessonConstants.TOPICQ_BASE_PATH;
		}
		return "";
	}

}
