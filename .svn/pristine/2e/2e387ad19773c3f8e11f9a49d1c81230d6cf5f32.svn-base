package com.tce.core.model.authz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_role")
public class UserRoles implements Serializable {
	
	private static final long serialVersionUID = -2006882875949828696L;
	
	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO,
		    generator="native"
	)
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
	)
	private Long id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "role_id")
	private String roleId;

	@Column(name = "org_id")
	private String orgId;

	public UserRoles() {}


	public UserRoles(String userId, String roleId, String orgId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.orgId = orgId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}



}