package com.tce.core.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.requestMatcher(new OAuthRequestedMatcher())
        	.authorizeRequests().anyRequest().fullyAuthenticated();
		// @formatter:on
	}


	private static class OAuthRequestedMatcher implements RequestMatcher {
	    public boolean matches(HttpServletRequest request) {
	        String auth = request.getHeader("Authorization");
	        boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
	        boolean haveAccessToken = request.getParameter("access_token")!=null;
	        return haveOauth2Token || haveAccessToken;
	    }
	}
}
