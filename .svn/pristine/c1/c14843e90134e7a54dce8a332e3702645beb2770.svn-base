package com.tce.core.model.authz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "context")
public class Context implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ctx_id")
	private Long ctxId;
	
	private String name;

	public Long getCtxId() {
		return ctxId;
	}

	public void setCtxId(Long ctxId) {
		this.ctxId = ctxId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
