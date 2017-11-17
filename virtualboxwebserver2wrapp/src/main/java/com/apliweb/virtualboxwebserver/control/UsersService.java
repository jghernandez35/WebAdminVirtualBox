/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.MaquinaVirtual;
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
    protected String serviceUrl2;

    protected Logger logger = Logger.getLogger(UsersService.class.getName());

    public UsersService(String serviceUrl,String serviceUrl2) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
        this.serviceUrl2 = serviceUrl2.startsWith("http") ? serviceUrl2 : "http://" + serviceUrl2;
    }

    public String vstop(String nombre) {
        System.out.println("En UsersService ==> VSTOP serviceUrl _ NOMBRE "+ serviceUrl2+"_"+nombre);
        String user = restTemplate.getForObject(serviceUrl2
                + "/user/vstop/{nombre}", String.class, nombre);
        return user;
    }
    
    public String vstart(String nombre) {
        System.out.println("En UsersService ==> VSTART serviceUrl _ NOMBRE "+ serviceUrl2+"_"+nombre);
        String user = restTemplate.getForObject(serviceUrl2
                + "/user/vstart/{nombre}", String.class, nombre);
        return user;
    }

    //--------------------------------------------------------------------------
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
            System.out.println("En UsersService < == FINDEMAIL _ users.getNombres() : "+user.getNombres());
            return user;
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
    
    // PARTE DEL SERVICIO DE MAQUINAS VIRTUALES INICIO
    
    public String vadd(MaquinaVirtual jvuser) {
        System.out.println("En VIRTUAL UsersService ==> VADD jvuser.getUsuNombre() _ serviceUrl2 "+ jvuser.getUsuNombre()+"_"+serviceUrl2);
        String result = restTemplate.postForObject(serviceUrl2 
                + "/user/vadd", jvuser, String.class);
        return result;
    }

    public List<MaquinaVirtual> vfindAll() {
        System.out.println("En VIRTUAL UsersService ==> VFINDALL serviceUrl2 = "+ serviceUrl2);
        MaquinaVirtual[] vusers = restTemplate.getForObject(serviceUrl2
                + "/user/vfindall", MaquinaVirtual[].class);

        if (vusers == null || vusers.length == 0) {
            return null;
        } else {
            return Arrays.asList(vusers);
        }
    }

    public List<MaquinaVirtual> vfindUsu_id(String usu_id) {
        System.out.println("En VIRTUAL UsersService ==> VFINDUSU_ID serviceUrl2 _ USU_ID= "+ serviceUrl2+" "+ usu_id);
        MaquinaVirtual[] vusers = restTemplate.getForObject(serviceUrl2
                + "/user/vfindusu_id/{usu_id}", MaquinaVirtual[].class, usu_id);
            //System.out.println("En UsersService < == VFINDUSU_ID _ vuser.getUsuNombre() : "+vuser.getUsuNombre());
        if (vusers == null || vusers.length == 0) {
            return null;
        } else {
            return Arrays.asList(vusers);
        }            
            //return vuser;
    }

    public String vfind2(String idmv) {
        System.out.println("En VIRTUAL UsersService ==> VFIND2 serviceUrl2 _ IDU "+ serviceUrl2+"_"+idmv);
        String user = restTemplate.getForObject(serviceUrl2
                + "/user/vfind2/{idmv}", String.class, idmv);
        return user;
    }
        
    public MaquinaVirtual vfind(String idmv) {
        System.out.println("En VIRTUAL UsersService ==> VFIND serviceUrl2 _ IDMV "+ serviceUrl2+"_"+idmv);
        MaquinaVirtual vuser = restTemplate.getForObject(serviceUrl2
                + "/user/vfind/{idmv}", MaquinaVirtual.class, idmv);
        return vuser;
    }

    public String vdelete(String idmv) {
        System.out.println("En VIRTUAL UsersService ==> VDELETE serviceUrl2 _ IDU "+ serviceUrl2+"_"+idmv);
        restTemplate.delete(serviceUrl2+"/user/vdelete/"+idmv);
        return "Deleted";
    }

    public String vupd(MaquinaVirtual jvuser) {
        System.out.println("En VIRTUAL UsersService ==> VUPD jvuser.getUsuNombre() _serviceUrl2 "+ jvuser.getUsuNombre()+"_"+serviceUrl2);        
        restTemplate.put(serviceUrl2
                + "/user/vupd", jvuser);
        return "updated";
    }
}
