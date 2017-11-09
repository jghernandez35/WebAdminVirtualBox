/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.MaquinaVirtual;
import com.apliweb.virtualboxwebserver.data.MaquinaVirtualRepository;
import com.apliweb.virtualboxwebserver.data.UserA;
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
    private MaquinaVirtualRepository userRepository;   
    public MaquinaVirtual aux = new MaquinaVirtual();
    public MaquinaVirtual mverror = new MaquinaVirtual();

    @RequestMapping(value="/user/vadd", method=RequestMethod.POST)
    public @ResponseBody String vadd (@RequestBody MaquinaVirtual vuser){
        System.out.println("En Microservicio VIRTUAL UserController POST /user/add vuser.getUsuNombre() ===> "+ vuser.getUsuNombre());
        userRepository.save(vuser);
        return "Saved";
    }
    
    @RequestMapping(value="/user/vfindall", method=RequestMethod.GET)
    public @ResponseBody Iterable<MaquinaVirtual> vfindAll (){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/findall ===> ");
        return userRepository.findAll();
    }
    
    @RequestMapping(value="/user/vfindusu_id/{usu_id}", method=RequestMethod.GET)
    public @ResponseBody MaquinaVirtual vfindUsu_id (@PathVariable("usu_id") String usu_id){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/findusu_id/ ===> email : "+usu_id);
        /*aux = userRepository.findByEmail(email);
        if(aux != null){
            System.out.println("id = "+aux.getId());
            System.out.println("nombres = "+aux.getNombres());
            System.out.println("email = "+aux.getEmail());
            System.out.println("celular = "+aux.getCelular());
            System.out.println("En Microservicio UserController GET /user/findemail < === aux.getNombres() : "+aux.getNombres());
            return aux;
        }else
            */mverror.setUsuNombre("error");
            return mverror;
    }

    @RequestMapping(value="/user/vfind2/{idmv}", method=RequestMethod.GET)
    public @ResponseBody String vfind2 (@PathVariable("idmv") String idmv){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/find2/{idmv} IDMV ===> "+ idmv);
        String var = "esta es una prueba realizada por JOSE HERNANDEZ  VIRTUAL desde El MicroServicio";
        return var;
    }
        
    @RequestMapping(value="/user/vfind/{idmv}", method=RequestMethod.GET)
    public @ResponseBody MaquinaVirtual vfind (@PathVariable("idmv") String idmv){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/find/{idmv} IDMV ===> "+ idmv);
        aux = userRepository.findOne(idmv);
        if(aux != null){
            System.out.println("id = "+aux.getId());
            System.out.println("nombres = "+aux.getUsuNombre());
            System.out.println("index = "+aux.getUsuIndex());
        }
        return aux;
    }
    
    @RequestMapping(value="/user/vdelete/{idmv}", method=RequestMethod.DELETE)
    public @ResponseBody String vdelete (@PathVariable("idmv") String idmv){
        System.out.println("En Microservicio UserController DELETE /user/delete/{idmv} IDMV ===> "+ idmv);
        userRepository.delete(idmv);
        return "Deleted";
    }
    
    @RequestMapping(value="/user/vupd", method=RequestMethod.PUT)
    public @ResponseBody String vupd (@RequestBody MaquinaVirtual jsonv){
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd jsonv.getUsuNombre() ===> "+ jsonv.getUsuNombre());
        userRepository.delete(jsonv.getId());
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd ELIMINADO VIEJO");
        userRepository.save(jsonv);
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd AGREGADO NUEVO");
        return "Updated";
    }  
}