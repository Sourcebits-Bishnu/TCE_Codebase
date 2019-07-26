package com.tce.core.web.sso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tce.common.exception.TataException;
import com.tce.common.model.PageResponse;
import com.tce.common.util.FileSystemUtil;
import com.tce.common.util.JSONUtil;
import com.tce.common.web.StatusResponse;
import com.tce.common.web.security.CustomPermissionEvaluator;
import com.tce.core.model.CoreMessageConstants;
import com.tce.core.model.LoginStatus;
import com.tce.core.model.authz.Menu;
import com.tce.core.model.sso.User;
import com.tce.core.model.sso.UserPrincipal;
import com.tce.core.service.sso.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/1/api/{version}/admin")
public class UserController {
	
	@Autowired
	private JSONUtil jsonUtil;

	@Autowired
	private FileSystemUtil fsUtil;
	
	@Autowired
	private CustomPermissionEvaluator  evaluator;
	
	@Autowired
	private UserService usrService;
	
	@GetMapping(value = "/current")
	@PreAuthorize("hasPermission('ClassEdge','VIEW')")
	public ResponseEntity<?> currentUser(Authentication auth) throws Exception{
		User u = ((UserPrincipal)auth.getPrincipal()).getUser();
		log.debug("currentUser {}",u);
		Menu leftMenu = jsonUtil.readAsClass(fsUtil.loadResourceToString("menu.props"), Menu.class);
		
		checkPermission(leftMenu.getSubmenu(), auth);
				
		Map<String, Object> model = new HashMap<>();
		model.put("fullName", u.getFirstName() +" "+u.getLastName());
		model.put("showSwitch", "true");
		model.put("menuoptions", leftMenu);
		model.put("selectedmenu", "Manage");
		return new ResponseEntity<Object>(model,HttpStatus.OK);
	}
	
	private void checkPermission(List<Menu> incoming,Authentication auth) {
		
		if(incoming != null && incoming.size() != 0) {
			Iterator<Menu> itr = incoming.iterator(); 
	        while (itr.hasNext()) { 
	        	Menu m = itr.next();
	        	if(m.getPermission() != null) {
					if(!evaluator.hasPermission(auth, m.getPermission().getContext(), m.getPermission().getPrivilege())) {
						log.info("{} no permission",m.getName());
						itr.remove();
					}
				} 
	        	checkPermission(m.getSubmenu(), auth);
	        } 
		}
	}
	
	
	
	@PostMapping(value = "/user")
	@PreAuthorize("hasPermission('Users','MODIFY_USER')")
	public ResponseEntity<?> createUser(@RequestBody UserRequest request) throws Exception{
		
		log.debug("createUser {}",request);
		
		if(usrService.existsByUsername(request.getUserName())) {
			throw new TataException(CoreMessageConstants.USER_EXIST);
		}
		
		User u = new User();
		u.setUsername(request.getUserName());
		u.setPassword(request.getPassword());
		u.setTitle("Mr.");
		u.setFirstName(request.getUserName());
		u.setLoginStatus(LoginStatus.CHANGEPASSWORD);
		usrService.saveUser(u,request.getOrganization(),request.getRole());

		return new ResponseEntity<Object>(StatusResponse.SUCCESS,HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	@PreAuthorize("hasPermission('Users','MODIFY_USER')")
	public ResponseEntity<?> listUser(@RequestParam("start")int start,@RequestParam("length")int length) throws Exception {
		
		log.info("{}",start);
		
		Pageable pageable = PageRequest.of(start, length != -1 ? length : 10);
		Page<User> result =  usrService.getAllUsers(pageable);	
			
		log.debug("{}",result);
		return new ResponseEntity<Object>(new PageResponse(1,result.getTotalPages(),result.getTotalPages(),result.getContent()),HttpStatus.OK);
	}

}
