/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.UserA;
import com.apliweb.virtualboxwebserver.data.UsuariosSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UsuariosSistemaRepository userRepository;
    public UserA aux = new UserA();
    
    
    @RequestMapping(value="/user/add", method=RequestMethod.POST)
    public @ResponseBody String add (@RequestBody UserA juser){
        System.out.println("En Microservicio UserController POST /user/add juser.nombre===> "+ juser.getNombres());
        userRepository.save(juser);
        return "Saved";
    }
    
    @RequestMapping(value="/user/findall", method=RequestMethod.GET)
    public @ResponseBody Iterable<UserA> findAll (){
        System.out.println("En Microservicio UserController GET /user/findall ===> ");
        return userRepository.findAll();
    }
    
    @RequestMapping(value="/user/find/{idu}", method=RequestMethod.GET)
    public @ResponseBody UserA find (@PathVariable("idu") String idu){
        System.out.println("En Microservicio UserController GET /user/find/{idu} IDU ===> "+ idu);
        
        aux = userRepository.findOne(idu);
        if(aux != null){
            System.out.println("id = "+aux.getId());
            System.out.println("nombres = "+aux.getNombres());
            System.out.println("email = "+aux.getEmail());
            System.out.println("celular = "+aux.getCelular());
        }
        return aux;
    }
    
    @RequestMapping(value="/user/delete/{idu}", method=RequestMethod.DELETE)
    public @ResponseBody String delete (@PathVariable("idu") String idu){
        System.out.println("En Microservicio UserController DELETE /user/delete/{idu} IDU ===> "+ idu);
        userRepository.delete(idu);
        return "Deleted";
    }
    
    @RequestMapping(value="/user/upd", method=RequestMethod.PUT)
    public @ResponseBody String upd (@RequestBody UserA jsonuser){
        System.out.println("En Microservicio UserController PUT /user/upd jsonuser.nombre ===> "+ jsonuser.getNombres());
        userRepository.save(jsonuser);
        return "Updated";
    }    
}