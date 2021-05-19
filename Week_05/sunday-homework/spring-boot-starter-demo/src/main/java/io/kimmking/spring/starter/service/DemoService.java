package io.kimmking.spring.starter.service;

import io.kimmking.spring.starter.properties.DemoProperties;

public class DemoService {

	DemoProperties demoProperties;

	public DemoProperties getDemoProperties() {
		return demoProperties;
	}

	public void setDemoProperties(DemoProperties demoProperties) {
		this.demoProperties = demoProperties;
	}

	public String doDemoService(String content) {
		
		return demoProperties.getPrefix() +"-"+ content +"-"+ demoProperties.getSurfix() ;
	}
}
