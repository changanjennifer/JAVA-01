package io.kimmking.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kimmking.spring.starter.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@GetMapping("/doDemo")
	public String doDemo() {
		return demoService.doDemoService("这是内容");
	}

}
