package com.tce.core.web.sso;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tce.core.model.sso.OAuthConstants;
import com.tce.core.service.sso.OAuthClientDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("")
public class TokenController {
	
	static interface HTTPPARAMS {
		String CLIENTCREDS = "clientCreds";
		String APIVERSION = "apiVersion";
		String SESSIONTIMEOUT = "sessionTimeout";
	}

	@Value("${api.version}")
	private String apiVersion;

	@Resource(name = "tokenStore")
	private TokenStore tokenStore;
	
	@Autowired
	private OAuthClientDetailService oauthClientService;


	@GetMapping("/0/api/{version}/sso/clientid")
	@ResponseBody
	public ResponseEntity<?> getClientId(HttpSession session,HttpServletResponse response) throws Exception {
		String clientId = session.getId();
		log.info("clientid {}",clientId);
		String clientCreds = oauthClientService.registerClient(clientId);
		response.addCookie(createCookie(clientCreds, 30*60));
		
		Map<String, String> model = new HashMap<>();
//		model.put(HTTPPARAMS.CLIENTCREDS, clientCreds);
		model.put(HTTPPARAMS.APIVERSION, apiVersion);
		model.put(HTTPPARAMS.SESSIONTIMEOUT, oauthClientService.getSessionTimeOutms());
		return ResponseEntity.ok(model);
	}

	private Cookie createCookie(final String content, final int expirationTimeSeconds) {
		final Cookie cookie = new Cookie(OAuthConstants.WEBCLIENT.COOKIE, content);
		cookie.setMaxAge(expirationTimeSeconds);
		cookie.setHttpOnly(true);
		cookie.setPath(OAuthConstants.WEBCLIENT.COOKIE_PATH);
		return cookie;
	}
	
	@DeleteMapping("/1/api/{version}/sso/revoke/{token}")
	@ResponseBody
	public ResponseEntity<?> revokeToken(@PathVariable String token) throws Exception {
		OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(token);
		tokenStore.removeAccessTokenUsingRefreshToken(refreshToken);
		tokenStore.removeRefreshToken(refreshToken);
		
		Map<String, String> model = new HashMap<>();
		model.put("status", "success");
		return ResponseEntity.ok(model);
	}
}
