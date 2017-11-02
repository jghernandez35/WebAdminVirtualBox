/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.UserA;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AcerF5w10
 */
@RestController
public class UsersWrapper {
    
    @Autowired
    protected UsersService usersService;

    protected Logger logger = Logger.getLogger(UsersWrapper.class
            .getName());

    public UsersWrapper(UsersService usersService) {
        this.usersService = usersService;
    }
    
    @RequestMapping(value="/user/add", method=RequestMethod.POST)
    public @ResponseBody String add (@RequestBody UserA juser){
        System.out.println("En UserWrapper POST /user/add => "+ juser.getNombres());
        return usersService.add(juser);
    }

    @RequestMapping(value="/user/findall", method=RequestMethod.GET)
    public @ResponseBody Iterable<UserA> findAll (){
        System.out.println("En UserWrapper GET => /user/findall");
        return usersService.findAll();
    }
    
    @RequestMapping(value="/user/find/{idu}", method=RequestMethod.GET)
    public @ResponseBody UserA find (@PathVariable("idu") String idu){
        System.out.println("En UserWrapper GET => /user/find/{idu}"+ idu);
        return usersService.find(idu);
    }
      
    @RequestMapping(value="/user/delete", method=RequestMethod.DELETE)
    public @ResponseBody String delete (@RequestBody String idu){
        System.out.println("En UserWrapper DELETE => /user/delete"+ idu);
        return usersService.delete(idu);
    }
    
    @RequestMapping(value="/user/upd", method=RequestMethod.PUT)
    public @ResponseBody String upd (@RequestBody UserA jsonuser){
        System.out.println("En UserWrapper PUT => "+ jsonuser.getNombres());
        return usersService.upd(jsonuser);
    }    
    
}
