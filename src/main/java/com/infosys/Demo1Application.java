package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Driver class runs app immediately as a Spring Boot Application
/*Spring Boot Application annotation allows for auto configuration, componenet scan
as well as any extra configuration. Instead of needing a spring configuration is generated
from dependencie jars. Componentscan (included) searches for spring components
which would normally have to be done with <context:component-scan>*/ 
@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
}
