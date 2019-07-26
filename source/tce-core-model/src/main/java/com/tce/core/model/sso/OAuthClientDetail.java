package com.tce.core.model.sso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetail {
	
	@Id
	@Getter @Setter
	@Column(name="client_id")
	private String clientId;
	@Getter @Setter
	@Column(name="resource_ids")
	private String resourceIds;
	@Getter @Setter
	@Column(name="client_secret")
	private String clientSecret;
	@Getter @Setter
	@Column(name="scope")
	private String scope;
	@Getter @Setter
	@Column(name="authorized_grant_types")
	private String authorizedGrantTypes;
	@Getter @Setter
	@Column(name="web_server_redirect_uri")
	private String webServerRedirectUri;
	@Getter @Setter
	@Column(name="authorities")
	private String authorities;
	@Getter @Setter
	@Column(name="access_token_validity")
	private Integer accessTokenValidity;
	@Getter @Setter
	@Column(name="refresh_token_validity")
	private Integer refreshTokenValidity;
	@Getter @Setter
	@Column(name="additional_information")
	private String additionalInformation;
	@Getter @Setter
	@Column(name="autoapprove")
	private String autoapprove;
}
