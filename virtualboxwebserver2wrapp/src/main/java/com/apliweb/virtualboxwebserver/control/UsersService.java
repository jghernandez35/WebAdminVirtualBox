/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.UserA;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AcerF5w10
 */
@Service
public class UsersService {
    
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    protected Logger logger = Logger.getLogger(UsersService.class.getName());

    public UsersService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }
    
    public String add(UserA juser) {
        System.out.println("En UsersService ==> ADD juser.getNombres() _ serviceUrl "+ juser.getNombres()+"_"+serviceUrl);
        String result = restTemplate.postForObject(serviceUrl 
                + "/user/add", juser, String.class);
        return result;
    }

    public List<UserA> findAll() {
        System.out.println("En UsersService ==> FINDALL serviceUrl = "+ serviceUrl);
        UserA[] users = restTemplate.getForObject(serviceUrl
                + "/user/findall", UserA[].class);

        if (users == null || users.length == 0) {
            return null;
        } else {
            return Arrays.asList(users);
        }
    }

    public UserA findEmail(String email) {
        System.out.println("En UsersService ==> FINDEMAIL serviceUrl _ EMAIL= "+ serviceUrl+" "+ email);
        UserA user = restTemplate.getForObject(serviceUrl
                + "/user/findemail/{email}", UserA.class, email);

        //if (user == null) {
        //    return null;
        //} else {
            System.out.println("En UsersService < == FINDEMAIL _ users.getNombres() : "+user.getNombres());
            return user;
        //}
    }

        public String find2(String idu) {
        System.out.println("En UsersService ==> FIND2 serviceUrl _ IDU "+ serviceUrl+"_"+idu);
        String user = restTemplate.getForObject(serviceUrl
                + "/user/find2/{idu}", String.class, idu);
        return user;
    }
        
    public UserA find(String idu) {
        System.out.println("En UsersService ==> FIND serviceUrl _ IDU "+ serviceUrl+"_"+idu);
        UserA user = restTemplate.getForObject(serviceUrl
                + "/user/find/{idu}", UserA.class, idu);
        return user;
    }

    public String delete(String idu) {
        System.out.println("En UsersService ==> DELETE serviceUrl _ IDU "+ serviceUrl+"_"+idu);
        restTemplate.delete(serviceUrl+"/user/delete/"+idu);
        return "Deleted";
    }

    public String upd(UserA juser) {
        System.out.println("En UsersService ==> UPD juser.getNombres()_serviceUrl "+ juser.getNombres()+"_"+serviceUrl);        
        restTemplate.put(serviceUrl
                + "/user/upd", juser);
        return "updated";
    }

}
