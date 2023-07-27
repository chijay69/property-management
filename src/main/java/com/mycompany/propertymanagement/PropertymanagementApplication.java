package com.mycompany.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PropertymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertymanagementApplication.class, args);
	}

}
