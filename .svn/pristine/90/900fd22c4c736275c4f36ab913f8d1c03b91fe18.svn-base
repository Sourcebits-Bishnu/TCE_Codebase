package com.tce.core.web.authz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tce.core.model.authz.Organization;
import com.tce.core.service.authz.OrganizationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/0/api/{version}/admin")
public class PublicOrganizationController {

	@Autowired
	private OrganizationService orgService;	
	
	@GetMapping(value = "/organizations/{searchFor}")
	public ResponseEntity<?> listOrganization(@PathVariable("searchFor")String searchFor) throws Exception {		
		
		List<String> orgs = new ArrayList<String>();
		if(searchFor != null && searchFor.trim().length() != 0) {
			List<Organization> result =  orgService.listOrganization(searchFor);					
	        for(Organization org : result){
				orgs.add(org.getName());
			}
		}
		log.debug("{} >> {}",searchFor,orgs);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("query", searchFor);
		data.put("suggestions", orgs);
		
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	}

}
