package com.tce.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tce.core.service.sso.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Lazy @Autowired    
    private UserService userService;

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
    	auth.userDetailsService((UserDetailsService)userService).passwordEncoder(passwordEncoder);
    	// @formatter:on
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http
			.authorizeRequests()
			.antMatchers("/0/**").permitAll()
			.anyRequest().authenticated()
			;
		http
			.csrf().disable();
		// @formatter:on
    }

}
