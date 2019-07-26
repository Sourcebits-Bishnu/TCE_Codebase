package com.tce.core.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.tce.core.service.sso.OAuthClientDetailService;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("coreDS")
	private DataSource dataSource;
	
	@Autowired
	private UserAuthenticationConverter authConverter;

	@Lazy @Autowired
	private OAuthClientDetailService oauthClientService;

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		// OAuth exposes two endpoints for checking tokens (/oauth/check_token and /oauth/token_key). 
		//Those endpoints are not exposed by default (have access "denyAll()").
		oauthServer.tokenKeyAccess("denyAll()").checkTokenAccess("hasAuthority('ROLE_INT_CLIENT')")
		.addTokenEndpointAuthenticationFilter(new OAuthClientCookieFilter());
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails((ClientDetailsService)oauthClientService);
	}


	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
		tokenConverter.setUserTokenConverter(authConverter);
		endpoints.tokenStore(tokenStore())
		        .tokenEnhancer(new CustomTokenEnhancer())
				.accessTokenConverter(tokenConverter)
				.authenticationManager(authenticationManager)
				.pathMapping("/oauth/token", "/0/api/1/sso/token")
				.pathMapping("/oauth/check_token", "/0/int/1/sso/check_token");

	}


	@Bean
	public JdbcTokenStore tokenStore() throws NamingException {
		return new JdbcTokenStore(dataSource);
	}
	

}

/**
https://tools.ietf.org/html/rfc6749#section-6
 **/