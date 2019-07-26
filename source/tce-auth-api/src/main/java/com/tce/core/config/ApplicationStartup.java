package com.tce.core.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.tce.common.model.DateFormats;
import com.tce.common.model.SystemConstants;
import com.tce.core.model.authz.Role;
import com.tce.core.model.sso.User;
import com.tce.core.model.tools.BuildDetails;
import com.tce.core.service.authz.OrganizationService;
import com.tce.core.service.sso.UserService;
import com.tce.core.service.tools.ToolsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private ToolsService toolService;
	
	@Autowired
	private UserService usrService;
	
	@Autowired
	private OrganizationService orgService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			log.info("startup event called");
			String buildName = "tce-setup";
			BuildDetails bd = toolService.findBuildDetails(buildName);
			if(bd == null) {
				orgService.importPrivileges();
				
				orgService.createOrganization(SystemConstants.DEFAULT_ORG.ID, SystemConstants.DEFAULT_ORG.NAME);
				
				List<Role> roles = orgService.listRole(SystemConstants.DEFAULT_ORG.ID);
				String roleId = null;
				for(Role r : roles) {
					if(r.getName().equals("ClassEdge Admin")) {
						roleId = r.getRoleId();
						break;
					}
				}
				
				User u = new User();
				u.setUsername("dev.admin");
				u.setPassword("dev.admin");
				u.setTitle("Mr.");
				u.setFirstName("Developer");
				usrService.saveUser(u,SystemConstants.DEFAULT_ORG.ID,roleId);
				
				bd = new BuildDetails();
				bd.setName(buildName);
				bd.setVersion("1.0");
				bd.setUpdatedOn(DateFormats.TYPE1_DATE.now());
				toolService.saveBuildDetails(bd);
			} else {
				log.info("skipping setup as it is already present");
			}
		} catch (Exception e) {
			log.error("error at startup {}",e);
		}
	}

}
