package com.tce.core.web.authz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tce.core.service.authz.OrganizationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/1/api/{version}/admin")
public class RoleController {
	
	@Autowired
	private OrganizationService orgService;
	
	@GetMapping(value = "/roles")
	public ResponseEntity<?> listRoles(@RequestParam("orgId")String orgId) throws Exception{
		log.debug("orgId {}",orgId);
		return new ResponseEntity<Object>(orgService.listRole(orgId),HttpStatus.OK);
	}

}
