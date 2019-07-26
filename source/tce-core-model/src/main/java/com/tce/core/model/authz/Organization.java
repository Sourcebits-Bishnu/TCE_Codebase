package com.tce.core.model.authz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tce.common.model.DateAudit;

import lombok.ToString;

@ToString
@Entity
@Table(name = "organization")
public class Organization extends DateAudit{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="org_id")
	private String orgId;

	private String name;
		
	private boolean status;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
