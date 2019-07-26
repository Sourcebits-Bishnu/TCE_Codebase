package com.tce.common.web.security;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import com.tce.common.util.JSONUtil;
import com.tce.core.model.sso.UserPrincipal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationConverter  implements UserAuthenticationConverter {
	
	private static final String PRINCIPAL = "PRINCIPAL";
	
	@Autowired
	private JSONUtil jsonUtil;

	@Override
	public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if(userAuthentication.getPrincipal() != null) {
			response.put(PRINCIPAL, jsonUtil.writer(userAuthentication.getPrincipal()));
		} 
		return response;
	}

	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		if (map.containsKey(PRINCIPAL)) {
			try {
				UserPrincipal principal = jsonUtil.readAsClass((String)map.get(PRINCIPAL), UserPrincipal.class);
				return new UsernamePasswordAuthenticationToken(principal, "N/A", principal.getAuthorities());
			} catch (IOException ioe) {
				log.error("Credentials could not be parsed",ioe);
				throw new RuntimeException("Credentials could not be parsed");
			}
		}
		return null;
	}
	

}
