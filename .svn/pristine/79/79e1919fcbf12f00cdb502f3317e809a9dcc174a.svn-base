package com.tce.core.web.authz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tce.common.web.StatusResponse;
import com.tce.core.model.authz.Organization;
import com.tce.core.service.authz.OrganizationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/1/api/{version}/admin")
public class OrganizationController {

	@Autowired
	private OrganizationService orgService;
	
	@PutMapping(value = "/privilege")
	@PreAuthorize("hasPermission('Organization','VIEW_ORG')")
	public ResponseEntity<?> createPrivilege() throws Exception{
		
		orgService.importPrivileges();

		return new ResponseEntity<Object>(StatusResponse.SUCCESS,HttpStatus.OK);
	}
	
	@GetMapping(value = "/organizations")
	@PreAuthorize("hasPermission('Organization','VIEW_ORG')")
	public ResponseEntity<?> listOrganization() throws Exception {		
		List<Organization> result =  orgService.listOrganization();		
		log.debug("{}",result);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
	
	@PostMapping(value = "/organization")
	@PreAuthorize("hasPermission('Organization','MODIFY_ORG')")
	public ResponseEntity<?> createOrganization(@RequestBody OrganizationRequest request) throws Exception{
		
		orgService.createOrganization(request.getOrgId(), request.getOrgName());
		
		return new ResponseEntity<Object>(StatusResponse.SUCCESS,HttpStatus.OK);
	}
	
	@PutMapping(value = "/organization")
	@PreAuthorize("hasPermission('Organization','MODIFY_ORG')")
	public ResponseEntity<?> updateOrganization(@RequestBody OrganizationRequest request) throws Exception{
		
		orgService.updateOrganization(request.getOrgId(), request.getOrgName());
		
		return new ResponseEntity<Object>(StatusResponse.SUCCESS,HttpStatus.OK);
	}

}
