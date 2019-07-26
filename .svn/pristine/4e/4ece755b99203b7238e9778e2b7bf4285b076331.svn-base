package com.tce.core.model.sso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tce.common.model.DateAudit;
import com.tce.core.model.LoginStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "user")
public class User extends DateAudit {

	private static final long serialVersionUID = -8354883971261896784L;

	@Id
	@Column(name="user_id")
	private String id;
	
	private String title;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Getter @Setter
	private String username;

	@Size(max = 100)
	private String password;
	
	private String pin;
	
	private boolean status;
		
	@Column(name="login_status")
	private int loginStatus;
	
	
//	public User(@NotBlank @Size(max = 30) String id, @NotBlank @Size(max = 40) @Email String email,
//			@NotBlank @Size(max = 100) String password, String mobileNo) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.mobileNo = mobileNo;
//	}

	public User(String id, @Size(max = 100) String password) {
		super();
		this.id = id;
		this.password = password;
	}


	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@JsonProperty
	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	@JsonIgnore
	public void setLoginStatus(LoginStatus status) {
		this.loginStatus = status.value();
	}

}