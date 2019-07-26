package com.tce.core.model.sso;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tce.core.model.authz.Organization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private User user;
	
	@Getter @Setter
	private Organization organization;
	
	@Getter @Setter
	private List<CEAuthority> authorities;
	
	public UserPrincipal(User user, Organization org, List<CEAuthority> authorities) {
		this.user = user;
		this.organization = org;
		this.authorities = authorities;
	}

	
	@JsonIgnore
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return organization.getName()+OAuthConstants.SEPERATOR+user.getUsername();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}


}
