package com.SpringBoot.gajarest;

public class AuthBean {

	private String name;

	public AuthBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloBean [name=" + name +"]";
	}
	

}
