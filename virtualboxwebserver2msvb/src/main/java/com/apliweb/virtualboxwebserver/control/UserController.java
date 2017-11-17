/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.control;

import com.apliweb.virtualboxwebserver.data.MaquinaVirtual;
import com.apliweb.virtualboxwebserver.data.MaquinaVirtualRepository;
import com.apliweb.virtualboxwebserver.data.UserA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.virtualbox_4_2.IMachine;
import org.virtualbox_4_2.IProgress;
import org.virtualbox_4_2.ISession;
import org.virtualbox_4_2.IVirtualBox;
import org.virtualbox_4_2.LockType;
import org.virtualbox_4_2.MachineState;
import org.virtualbox_4_2.VirtualBoxManager;

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
    
    @RequestMapping(value="/user/vstop/{nombre}", method=RequestMethod.GET)
    public @ResponseBody String vstop (@PathVariable("nombre") String nombre){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/vstop/{nombre} NOMBRE ===> "+ nombre);
        String var = " ... Maquina Detenida ... ";
        VirtualBoxManager mgr = VirtualBoxManager.createInstance(null); 
        String url = "http://localhost:18083/";
        String user = "jose.hernandez";
        String passwd = "";
        mgr.connect(url, user, passwd);   
        //parte 2
        IVirtualBox vbox = mgr.getVBox();
        //alternativa para evitar error al eliminar
        ISession session = null;
        IProgress prog; 
        List<IMachine> machines = vbox.getMachines();
        for (IMachine machine : machines) {
            if(machine.getName().equals(nombre)){
                System.out.println("Maquina "+nombre+" encontrada");
                
                MachineState state = machine.getState();
                System.out.println("Estado de la maquina: "+state);

                if (MachineState.Running == state) {
                    session = mgr.getSessionObject();
                    machine.lockMachine(session, LockType.Shared);
                    prog = session.getConsole().powerDown();
                    prog.waitForCompletion(10000);
                    session.unlockMachine();
                }else{
                    System.out.println(nombre+" esta apagada");
                    var = "Maquina "+nombre+" esta apagada";
                }                 
                System.out.println("Maquina Virtual machine.getName() detenida: "+machine.getName());
            }else var = "Maquina "+nombre+" no encontrada imposible detener ";
        }
        mgr.disconnect();
        return var;
        
        /*
        IMachine machine = vbox.findMachine(nombre);
        ISession session = null;
        IProgress prog;        
            MachineState state = machine.getState();
            System.out.println("Estado de la maquina: "+state);

            if (MachineState.Running == state) {
                session = mgr.getSessionObject();
                machine.lockMachine(session, LockType.Shared);
                prog = session.getConsole().powerDown();
                prog.waitForCompletion(10000);
                session.unlockMachine();
            }else{
                System.out.println(nombre+" esta apagada");
                var = nombre+" esta apagada";
            }        
            mgr.disconnect();
            return var;
        */
    } 
    
    @RequestMapping(value="/user/vstart/{nombre}", method=RequestMethod.GET)
    public @ResponseBody String vstart (@PathVariable("nombre") String nombre){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/vstart/{nombre} NOMBRE ===> "+ nombre);
        String var = " ... Maquina "+nombre+" Iniciada ... ";
        VirtualBoxManager mgr = VirtualBoxManager.createInstance(null); 
        String url = "http://localhost:18083/";
        String user = "jose.hernandez";
        String passwd = "";
        mgr.connect(url, user, passwd);   
        //parte 2
        IVirtualBox vbox = mgr.getVBox();
        List<IMachine> machines = vbox.getMachines();
        for (IMachine machine : machines) {
            if(machine.getName().equals(nombre)){
                System.out.println("Maquina "+nombre+" encontrada");
                mgr.startVm(machine.getName(), null, 7000);
                System.out.println("Maquina Virtual machine.getName() iniciada: "+machine.getName());
            }else var = "Maquina "+nombre+" no encontrada no se puede iniciar";
        }
        mgr.disconnect();
        return var;
    }     

    // +++++++++++++++ // +++++++++++++++ // +++++++++++++++ // +++++++++++++++ // +++++++++++++++ //
    @RequestMapping(value="/user/vadd", method=RequestMethod.POST)
    public @ResponseBody String vadd (@RequestBody MaquinaVirtual vuser){
        System.out.println("En Microservicio VIRTUAL UserController POST /user/add vuser.getUsuNombre() ===> "+ vuser.getUsuNombre());
        userRepository.save(vuser);
        return "Maquina agregada correctamente";
    }
    
    @RequestMapping(value="/user/vfindall", method=RequestMethod.GET)
    public @ResponseBody Iterable<MaquinaVirtual> vfindAll (){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/findall ===> ");
        return userRepository.findAll();
    }
    
    @RequestMapping(value="/user/vfindusu_id/{usu_id}", method=RequestMethod.GET)
    public @ResponseBody Iterable<MaquinaVirtual> vfindUsu_id (@PathVariable("usu_id") String usu_id){
        System.out.println("En Microservicio VIRTUAL UserController GET /user/findusu_id/ ===> usu_id : "+usu_id);
        return userRepository.findByUid(usu_id);
        /*if(aux != null){
            System.out.println("id = "+aux.getId());
            System.out.println("usuario = "+aux.getUsuId());
            System.out.println("nombre = "+aux.getUsuNombre());
            System.out.println("index = "+aux.getUsuIndex());
            System.out.println("En Microservicio UserController GET /user/findusu_id < === aux.getUsuNombre() : "+aux.getUsuNombre());
            return aux;
        }else
            mverror.setUsuNombre("error");
            return mverror;*/
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
        return "Maquina eliminada correctamente";
    }
    
    @RequestMapping(value="/user/vupd", method=RequestMethod.PUT)
    public @ResponseBody String vupd (@RequestBody MaquinaVirtual jsonv){
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd jsonv.getUsuNombre() ===> "+ jsonv.getUsuNombre());
        userRepository.delete(jsonv.getId());
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd ELIMINADO VIEJO");
        userRepository.save(jsonv);
        System.out.println("En Microservicio VIRTUAL UserController PUT /user/upd AGREGADO NUEVO");
        return "Maquina actualizada correctamente";
    }  
}