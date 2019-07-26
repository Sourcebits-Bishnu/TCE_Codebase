package com.tce.core.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.tce.common.model.HttpConstants;
import com.tce.core.model.sso.OAuthConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OAuthClientCookieFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info(">>> cookie check {}",request.getRequestURL());
		HttpServletRequest wrappedRequest = null;
		if(request.getHeader(HttpConstants.AUTHORIZATION) != null) {
			//this will happen if there is an internal api call
			wrappedRequest = request;
		} else {
			wrappedRequest = new MutableHttpServletRequest(request);
			boolean cookieFound = false;
			if(request.getCookies() != null && request.getCookies().length != 0) {
				for(Cookie c : request.getCookies()) {
					if(c.getName().equals(OAuthConstants.WEBCLIENT.COOKIE)) {
						((MutableHttpServletRequest)wrappedRequest).putHeader(HttpConstants.AUTHORIZATION, "basic "+c.getValue());
						cookieFound = true;
						break;
					}
				}
			}
		
			if(!cookieFound) {
				((MutableHttpServletRequest)wrappedRequest).putHeader(HttpConstants.AUTHORIZATION, "basic notfound");
			}
		}
		
		filterChain.doFilter(wrappedRequest, response);
		
	}

}
