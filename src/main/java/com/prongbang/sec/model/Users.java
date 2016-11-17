package com.prongbang.sec.model;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = -189742432710315857L;

	private String username;
	private String password;
	private Integer enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer isEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
