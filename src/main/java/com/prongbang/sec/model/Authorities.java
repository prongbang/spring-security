package com.prongbang.sec.model;

import java.io.Serializable;

public class Authorities implements Serializable {

	private static final long serialVersionUID = 1105921463571059980L;

	private String username;
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
