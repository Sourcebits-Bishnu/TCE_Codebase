package com.tce.core.model.authz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.ToString;


@ToString
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO,
		    generator="native"
	)
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
	)
	@Column(name="perm_id")
	private Long permId;
	
	@Column(name="ctx_id")
	private Long ctxId = -1L;
	
	private int bitsum;
	
	private String actor;
	
	private String model;	

	public Long getPermId() {
		return permId;
	}

	public void setPermId(Long permId) {
		this.permId = permId;
	}

	public Long getCtxId() {
		return ctxId;
	}

	public void setCtxId(Long ctxId) {
		this.ctxId = ctxId;
	}

	public int getBitsum() {
		return bitsum;
	}

	public void setBitsum(int bitsum) {
		this.bitsum = bitsum;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

		
}
