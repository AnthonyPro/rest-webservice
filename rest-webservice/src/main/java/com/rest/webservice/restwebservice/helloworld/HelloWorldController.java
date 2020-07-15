package com.rest.webservice.restwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//2/ Tell the class that this is an REST controller for REST reqeusts by annotation: @RestController.

@RestController 
public class HelloWorldController {
	
	
	@Autowired
	private MessageSource messageSource;  
	
	//GET
	//URI - /hello-world
	//1/Method - "Hello World"
	
	
	//METHOD 1 CLEAN 
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	//public String helloWorld() {
	//return "Hello World"; 
	//}	
	
		//METHOD 2 GETMAPPING V.S REQUESTMAPPING AND WITHOUT AN BEAN
		@GetMapping(path = "/hello-world")
		public String helloWorld() {
			return "Hello Veedjay"; 
		}
		
		// METHOD 3 GETMAPPING BY BEAN and CLASS HelloWorldBean.java 
		@GetMapping(path = "/hello-world-bean")
		public HelloWorldBean helloWorldBean() {
			return new HelloWorldBean ("Hello World"); 
		}
		
		//hello-world/patch-variable/veedjay
		@GetMapping(path = "/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean (String.format("Hello World, %s", name)); 
		}
		
		//METHOD 4 INTERNATIONALIZATION 
		@GetMapping(path = "/hello-world-internationalized")
		public String helloWorldInternationalized() {
			return messageSource.getMessage("good.morning.message", null, 
										LocaleContextHolder.getLocale());
		}
}
