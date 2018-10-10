package com.osoto.connections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring Boot application class for City Connections REST app.
 * 
 * @author osoto
 *
 */
@SpringBootApplication
public class CityConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityConnectionsApplication.class, args);
	}
	
	@Bean
	public DispatcherServlet dispatcherServlet() {
		DispatcherServlet ds = new DispatcherServlet();
		ds.setThrowExceptionIfNoHandlerFound(true);
		return ds;
	}
	
}
