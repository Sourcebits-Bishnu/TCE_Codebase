package com.tce.core.model.authz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tce.common.model.DateAudit;

import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "privilege")
public class Privilege extends DateAudit  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="priv_id")
	private Long privId;

	private String title;
	
	private int bit;
	
	@Column(name="ctx_id")
	private Long ctxId;
	
	public Long getPrivId() {
		return privId;
	}

	public void setPrivId(Long privId) {
		this.privId = privId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}


	public Long getCtxId() {
		return ctxId;
	}

	public void setCtxId(Long ctxId) {
		this.ctxId = ctxId;
	}
}
