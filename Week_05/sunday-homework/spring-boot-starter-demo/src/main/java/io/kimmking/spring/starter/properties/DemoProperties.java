package io.kimmking.spring.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "io.kimmking.demo")
public class DemoProperties {

	private String prefix;
	private String surfix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSurfix() {
		return surfix;
	}
	public void setSurfix(String surfix) {
		this.surfix = surfix;
	}
	
}
