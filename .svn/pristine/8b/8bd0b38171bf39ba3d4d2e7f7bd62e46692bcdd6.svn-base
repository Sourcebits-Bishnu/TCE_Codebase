package com.tce.common.web.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.tce.common.model.FileTypeFactory;
import com.tce.common.model.SysDir;
import com.tce.common.util.FileSystemUtil;
import com.tce.common.util.JSONUtil;
import com.tce.core.model.authz.Privilege;
import com.tce.core.model.authz.PrivilegeTmplt;
import com.tce.core.model.sso.CEAuthority;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Setter
	Map<String, Long> contextCache;
	
	@Setter
	Map<Long, Map<String,Integer>> privilegeCache;
	
	public CustomPermissionEvaluator(JSONUtil jsonUtil, FileSystemUtil fsUtil) {
		try {
			//read tmplt
			PrivilegeTmplt tmplt = jsonUtil.readAsClass(
					fsUtil.loadFileToString(FileTypeFactory.getFile(SysDir.TMPT, "privileges.props")), PrivilegeTmplt.class);
			contextCache = new HashMap<>();
			privilegeCache = new HashMap<>();
			for(PrivilegeTmplt.ContextTmplt ctx : tmplt.getCtxlist()) {
				Long ctxId = ctx.getId();
				contextCache.put(ctx.getName(), ctxId);
				for(Privilege p : ctx.getPrivlist()) {
					if(!privilegeCache.containsKey(ctxId)) {
						Map<String,Integer> pmap = new HashMap<>();
						pmap.put(p.getTitle(), p.getBit());
						privilegeCache.put(ctxId, pmap);
					} else {
						privilegeCache.get(ctxId).put(p.getTitle(), p.getBit());
					}
				}
			}
			
			log.info("{} + {}",contextCache,privilegeCache);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * This method is used to check whether requested user is authorized to access
	 * the service or not.
	 * 
	 * @param authentication details
	 * @return status
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public boolean hasPermission(Authentication authentication, Object accessType, Object privilegeType) {
		log.info("checking permissions !!!");
		if (authentication != null && accessType instanceof String && privilegeType instanceof String) {
			Long ctxId = contextCache.get(accessType);
			if(ctxId == null) {
				log.error("context not found");
				return false;
			}
			
			Map<String, Integer> privList = privilegeCache.get(ctxId);
			if(privList == null) {
				log.error("context privileges not found");
				return false;
			}
			
			int bit = privList.get(privilegeType);
			if(bit == 0) {
				log.error("privilege not found");
				return false;
			}
			
			List<CEAuthority> authorities = (List<CEAuthority>)authentication.getAuthorities();
			for(CEAuthority auth : authorities) {
				if(auth.equals(ctxId)) {
					if (auth.hasPermission(bit)) {
						return true;
					}
				}				
			}
			
			log.info("User is not having the permission");
			return false;
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable serializable, String targetType,
			Object permission) {
		return false;
	}

}