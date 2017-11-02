/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver;

import com.apliweb.virtualboxwebserver.control.UsersService;
import com.apliweb.virtualboxwebserver.control.UsersWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AcerF5w10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WrapperServer {
    
    public static final String USERS_SERVICE_URL = "http://USERS-SERVICE";
    
 	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "services-client");
		SpringApplication.run(WrapperServer.class, args);
	}
        
        @LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The ServiceWrapper encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
        
	@Bean
	public UsersService usersService() {
		return new UsersService(USERS_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link UsersService} to use.
	 * 
	 * @return
	 */
	
        @Bean
	public UsersWrapper usersWrapper() {
		return new UsersWrapper(usersService());
	}
    
}
