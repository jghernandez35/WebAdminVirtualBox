/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author AcerF5w10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args){
        System.setProperty("spring.config.name", "users-server");
        SpringApplication.run(Application.class,args);
    }      
}
