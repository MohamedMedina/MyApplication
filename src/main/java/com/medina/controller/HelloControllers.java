package com.medina.controller;

import java.util.Locale;

import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllers 
{
	@Autowired
	private MessageSource messageSource;
		
	
	@GetMapping (path = "/hello")
 public String hello() 
 {
	return "hello from mohamed medina";
}
	@GetMapping (path = "/hello-bean")
	 public helloBean helloBean() 
	 {
		return  new helloBean("hello from mohamed medina");
	}
	@GetMapping (path = "/hello/{name}")
	 public helloBean helloBeanPathVariable(@PathVariable String name) 
	 {
		return  new helloBean(String.format("hello from mohamed medina,%s",name));
	}
	// this controller for internationalization
	@GetMapping (path = "/hello-internationalization")
	 public String helloBeanInternationalize( @RequestHeader(name = "Accept-Language", required = false) Locale locale) 
	 {
		return  messageSource.getMessage("good.morning.message",null,locale);
	}
}
