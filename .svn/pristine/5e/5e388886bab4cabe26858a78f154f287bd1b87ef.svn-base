package com.tce.content.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import com.tce.core.model.sso.OAuthConstants;

@Configuration
@EnableResourceServer
public class WebClientSecurityConfig extends ResourceServerConfigurerAdapter {

	@Value("${auth.url}")
	private String serverUrl;
	
	@Autowired
	private UserAuthenticationConverter authConverter;
	
	@Bean
    public RemoteTokenServices remoteTokenServices() {
        final RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setCheckTokenEndpointUrl(serverUrl + "/0/int/1/sso/check_token");
        tokenServices.setClientId(OAuthConstants.CLIENT.USERNAME);
        tokenServices.setClientSecret(OAuthConstants.CLIENT.USERNAME);
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        tokenConverter.setUserTokenConverter(authConverter);
        tokenServices.setAccessTokenConverter(tokenConverter);
        return tokenServices;
	}


	
    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(remoteTokenServices()).resourceId("tce-content");
    }
    
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests()
			.antMatchers("/0/**").permitAll()
			.anyRequest().authenticated();
		// @formatter:on
	}


}
