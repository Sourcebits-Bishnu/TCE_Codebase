package com.tce.core.web.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/1/api/{version}/tool")
public class ToolController {
	
	@GetMapping(value = "/placeholder")
	public ResponseEntity<?> placeholder() throws Exception{
		log.debug("placeholder");
		Map<String, String> model = new HashMap<>();
		model.put("status", "success");
		return new ResponseEntity<Object>(model,HttpStatus.OK);
	}

}
