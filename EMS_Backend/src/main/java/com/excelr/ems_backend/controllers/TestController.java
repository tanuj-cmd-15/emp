package com.excelr.ems_backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String Test() {
		return "Hey Im working...";
	}
	
}
