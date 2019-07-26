package com.tce.common.config;

import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import com.tce.common.util.FileSystemUtil;
import com.tce.common.util.JSONUtil;
import com.tce.common.web.security.AuthenticationConverter;
import com.tce.common.web.security.CustomPermissionEvaluator;


@Configuration
public class CommonConfig{
	
    @Bean
    public PasswordEncoder  passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
    
    @Bean
    public CustomPermissionEvaluator  evaluator(JSONUtil jsonUtil,FileSystemUtil fsUtil) {
    	return new CustomPermissionEvaluator(jsonUtil,fsUtil);
    }
    
	@Bean
	public UserAuthenticationConverter authConverter() throws NamingException {
		return new AuthenticationConverter();
	}
}
