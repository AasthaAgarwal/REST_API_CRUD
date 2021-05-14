package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.example.demo.controller.AtaController;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = AtaController.class)
public class RestApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCrudApplication.class, args);
		
		System.out.println("aaplication Started");
	}

}
