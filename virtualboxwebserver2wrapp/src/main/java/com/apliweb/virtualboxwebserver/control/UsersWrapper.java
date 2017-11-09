/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.MaquinaVirtual;
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
    
    protected Logger logger = Logger.getLogger(UsersWrapper.class.getName());
    
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
    
    @RequestMapping(value="/user/find2/{idu}", method=RequestMethod.GET)
    public @ResponseBody String find2 (@PathVariable("idu") String idu){
        System.out.println("En UserWrapper GET => /user/find2/{idu}"+ idu);
        return usersService.find2(idu);
    }   
    
    @RequestMapping(value="/user/findemail/{email}", method=RequestMethod.GET)
    public @ResponseBody UserA findEmail (@PathVariable("email") String email){
        System.out.println("En UserWrapper GET => /user/findEmail/{email}"+ email);
        UserA user = usersService.findEmail(email);
        //if(user.getNombres().equals("error")){
            return user;
        //}else return user;
    }
          
    @RequestMapping(value="/user/find/{idu}", method=RequestMethod.GET)
    public @ResponseBody UserA find (@PathVariable("idu") String idu){
        System.out.println("En UserWrapper GET => /user/find/{idu}"+ idu);
        return usersService.find(idu);
    }
      
    @RequestMapping(value="/user/delete", method=RequestMethod.POST)
    public @ResponseBody String delete (@RequestBody String idu){
        System.out.println("En UserWrapper DELETE => /user/delete"+ idu);
        return usersService.delete(idu);
    }
    
    @RequestMapping(value="/user/upd", method=RequestMethod.POST)
    public @ResponseBody String upd (@RequestBody UserA jsonuser){
        System.out.println("En UserWrapper PUT-POST => "+ jsonuser.getNombres());
        return usersService.upd(jsonuser);
    }    
    
    //PARTE DEL SERVICIO DE MAQUINAS VIRTUALES INICIO
 
    @RequestMapping(value="/user/vadd", method=RequestMethod.POST)
    public @ResponseBody String vadd (@RequestBody MaquinaVirtual mv){
        System.out.println("En VIRTUAL UserWrapper POST /user/vadd => "+ mv.getUsuNombre());
        return usersService.vadd(mv);
    }

    @RequestMapping(value="/user/vfindall", method=RequestMethod.GET)
    public @ResponseBody Iterable<MaquinaVirtual> vfindAll (){
        System.out.println("En VIRTUAL UserWrapper GET => /user/vfindall");
        return usersService.vfindAll();
    }
    
    @RequestMapping(value="/user/vfind2/{idmv}", method=RequestMethod.GET)
    public @ResponseBody String vfind2 (@PathVariable("idmv") String idmv){
        System.out.println("En VIRTUAL UserWrapper GET => /user/Vfind2/{idu}"+ idmv);
        return usersService.vfind2(idmv);
    }   
    
    @RequestMapping(value="/user/vfindusu_id/{usu_id}", method=RequestMethod.GET)
    public @ResponseBody MaquinaVirtual vfindUsu_id (@PathVariable("usu_id") String usu_id){
        System.out.println("En VIRTUAL UserWrapper GET => /user/vfindusu_id/{usu_id}"+ usu_id);
        MaquinaVirtual vuser = usersService.vfindUsu_id(usu_id);
        //if(user.getNombres().equals("error")){
            return vuser;
        //}else return user;
    }
          
    @RequestMapping(value="/user/vfind/{idmv}", method=RequestMethod.GET)
    public @ResponseBody MaquinaVirtual vfind (@PathVariable("idmv") String idmv){
        System.out.println("En VIRTUAL UserWrapper GET => /user/vfind/{idmv}"+ idmv);
        return usersService.vfind(idmv);
    }
      
    @RequestMapping(value="/user/vdelete", method=RequestMethod.POST)
    public @ResponseBody String vdelete (@RequestBody String idmv){
        System.out.println("En VIRTUAL UserWrapper DELETE => /user/vdelete"+ idmv);
        return usersService.vdelete(idmv);
    }
    
    @RequestMapping(value="/user/vupd", method=RequestMethod.POST)
    public @ResponseBody String vupd (@RequestBody MaquinaVirtual jvuser){
        System.out.println("En VIRTUAL UserWrapper PUT-POST => "+ jvuser.getUsuNombre());
        return usersService.vupd(jvuser);
    }     

}
