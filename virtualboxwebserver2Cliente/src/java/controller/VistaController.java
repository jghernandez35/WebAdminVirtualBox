/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.MaquinaVirtual;
import entity.Sesion;
import entity.UserA;
import model.StringMD;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author AcerF5w10
 */
@Controller
public class VistaController {
    public Sesion s;
    RestTemplate restTemplate = new RestTemplate();
    
    
    @RequestMapping(value = "admin_stop", method = RequestMethod.GET)
    public String admin_stop(@ModelAttribute(value = "nombre") String nombre, Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vstop/"+nombre+"/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Respuesta desde Servicio /user/vstop/ AUX: "+aux);
        m.addAttribute("mensaje", aux);
        return admin_maquinas(m);
    }
    
    @RequestMapping(value = "admin_start", method = RequestMethod.GET)
    public String admin_start(@ModelAttribute(value = "nombre") String nombre, Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vstart/"+nombre+"/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Respuesta desde Servicio /user/vstart/ AUX: "+aux);
        m.addAttribute("mensaje", aux);
        return admin_maquinas(m);
    }
    
    @RequestMapping(value = "user_stop", method = RequestMethod.GET)
    public void user_stop(@ModelAttribute(value = "nombre") String nombre, Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vstop/"+nombre+"/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Respuesta desde Servicio /user/vstop/ AUX: "+aux);
        m.addAttribute("mensaje", aux);
        //return admin_maquinas(m);
    }
    
    @RequestMapping(value = "user_start", method = RequestMethod.GET)
    public void user_start(@ModelAttribute(value = "nombre") String nombre, Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vstart/"+nombre+"/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Respuesta desde Servicio /user/vstart/ AUX: "+aux);
        m.addAttribute("mensaje", aux);
        //return admin_maquinas(m);
    }    
    // +++++++++++++++ // +++++++++++++++ // ------------------ // +++++++++++++++ // +++++++++++++++ //
     
    
    /*@RequestMapping(value = "admin_maquina_usuario", method = RequestMethod.GET)
    public String admin_maquina_usuario(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        System.out.println("En admin_maquina_usuario id: "+id);
        //String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/vdelete/", id, String.class);
        MaquinaVirtual mv = new MaquinaVirtual();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfindusu_id/"+id+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;
            mv.setId((String) jsonObject.get("id"));
            mv.setUsuNombre((String) jsonObject.get("usuNombre"));
            mv.setUsuIndex((String) jsonObject.get("usuIndex"));
            Double um = (double) jsonObject.get("usoMemoria");
            mv.setUsoMemoria(um);
            Double ucpu = (double) jsonObject.get("usoCpu");
            mv.setUsoCpu(ucpu);
            Double up = (double) jsonObject.get("usoProcesamiento");
            mv.setUsoProcesamiento(up);
            mv.setUsuId((String) jsonObject.get("usuId"));        
        
        
        //System.out.println("Respuesta Metodo POST: "+aux);
        m.addAttribute("userlist", jsonObject);
        String mensaje = "Maquinas encontradas ...";
        m.addAttribute("mensaje", mensaje);
        return admin_maquinas_usuario(m);
    }*/
    
    @RequestMapping(value = "user_maquina_usuario", method = RequestMethod.GET)
    public String user_maquina_usuario(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfindusu_id/"+id+"/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Objeto traido desde Servicio /user/vfindall/ AUX: "+aux);
        Object obj = JSONValue.parse(aux);
        JSONArray userlist = (JSONArray) obj;
        m.addAttribute("id", id);
        m.addAttribute("userlist", userlist);
        return "user/user_maquinas";
    }    
    
    @RequestMapping(value = "admin_maquinas", method = RequestMethod.GET)
    public String admin_maquinas(Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfindall/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Objeto traido desde Servicio /user/vfindall/ AUX: "+aux);
        Object obj = JSONValue.parse(aux);
        JSONArray userlist = (JSONArray) obj;
        m.addAttribute("userlist", userlist);
        return "admin/admin_maquinas";
    }
    
    @RequestMapping(value = "admin_agregar_maquina", method = RequestMethod.GET)
    public String admin_agregar_maquina(Model m){
        MaquinaVirtual aux = new MaquinaVirtual();
        m.addAttribute("aux", aux);        
        return "admin/admin_agregar_maquina";
    }
    
    @RequestMapping(value = "admin_agregar_maquina2", method = RequestMethod.GET)
    public String admin_agregar_maquina2(@ModelAttribute(value = "maquina") MaquinaVirtual mv , Model m) throws ParseException{
        System.out.println("Formulario ADD maquina mv.getId(): "+mv.getId());
        System.out.println("Formulario ADD maquina mv.getUsuIndex(): "+mv.getUsuIndex());
        System.out.println("Formulario ADD maquina mv.getUsuNombre(): "+mv.getUsuNombre());
        System.out.println("Formulario ADD maquina mv.getUsuid(): "+mv.getUsuId());
        System.out.println("Formulario ADD maquina mv.getUsoCpu(): "+mv.getUsoCpu());
        System.out.println("Formulario ADD maquina mv.getUsoMemoria(): "+mv.getUsoMemoria());
        System.out.println("Formulario ADD maquina mv.getUsoProcesamiento(): "+mv.getUsoProcesamiento());
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/vadd/", mv, String.class);
        System.out.println("Respuesta Metodo POST: "+aux);
        return admin_maquinas(m);
    }
    
    @RequestMapping(value = "admin_ver_maquina", method = RequestMethod.GET)
    public String admin_ver_maquina(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        MaquinaVirtual mv = new MaquinaVirtual();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfind/"+id+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;
            mv.setId((String) jsonObject.get("id"));
            mv.setUsuNombre((String) jsonObject.get("usuNombre"));
            mv.setUsuIndex((String) jsonObject.get("usuIndex"));
            Double um = (double) jsonObject.get("usoMemoria");
            mv.setUsoMemoria(um);
            Double ucpu = (double) jsonObject.get("usoCpu");
            mv.setUsoCpu(ucpu);
            Double up = (double) jsonObject.get("usoProcesamiento");
            mv.setUsoProcesamiento(up);
            mv.setUsuId((String) jsonObject.get("usuId"));
        m.addAttribute("mv", mv);        
        return "admin/admin_ver_maquina";
    }
    @RequestMapping(value = "user_ver_maquina", method = RequestMethod.GET)
    public String user_ver_maquina(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        MaquinaVirtual mv = new MaquinaVirtual();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfind/"+id+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;
            mv.setId((String) jsonObject.get("id"));
            mv.setUsuNombre((String) jsonObject.get("usuNombre"));
            mv.setUsuIndex((String) jsonObject.get("usuIndex"));
            Double um = (double) jsonObject.get("usoMemoria");
            mv.setUsoMemoria(um);
            Double ucpu = (double) jsonObject.get("usoCpu");
            mv.setUsoCpu(ucpu);
            Double up = (double) jsonObject.get("usoProcesamiento");
            mv.setUsoProcesamiento(up);
            mv.setUsuId((String) jsonObject.get("usuId"));
        m.addAttribute("id2",id);
        m.addAttribute("mv", mv);        
        return "user/user_ver_maquina";
    }
    
    @RequestMapping(value = "admin_eliminar_maquina", method = RequestMethod.GET)
    public String admin_eliminar_maquina(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        System.out.println("En admin_eliminar id: "+id);
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/vdelete/", id, String.class);
        System.out.println("Respuesta Metodo POST: "+aux);
        m.addAttribute("mensaje", aux);
        return admin_maquinas(m);
    }  
    
    @RequestMapping(value = "admin_actualizar_maquina2", method = RequestMethod.GET)
    public String admin_actualizar_maquina2(@ModelAttribute(value = "mv") MaquinaVirtual mv , Model m) throws ParseException{
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/vupd/", mv, String.class);
        m.addAttribute("mensaje", aux);
        return admin_maquinas(m);
    }     
    
    @RequestMapping(value = "admin_actualizar_maquina", method = RequestMethod.GET)
    public String admin_actualizar_maquina(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        MaquinaVirtual mv = new MaquinaVirtual();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/vfind/"+id+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;      
            mv.setId((String) jsonObject.get("id"));
            mv.setUsuNombre((String) jsonObject.get("usuNombre"));
            mv.setUsuIndex((String) jsonObject.get("usuIndex"));
            Double um = (double) jsonObject.get("usoMemoria");
            mv.setUsoMemoria(um);
            Double ucpu = (double) jsonObject.get("usoCpu");
            mv.setUsoCpu(ucpu);
            Double up = (double) jsonObject.get("usoProcesamiento");
            mv.setUsoProcesamiento(up);
            mv.setUsuId((String) jsonObject.get("usuId"));
        m.addAttribute("mv", mv);        
        return "admin/admin_actualizar_maquina";
    }    
    
// ------------------------- // -------------------------------- // ------------------------------ //
// ------------------------- // -------------------------------- // ------------------------------ //
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model m){
        m.addAttribute("sesion",s);
        return "index";
    }
    
    @RequestMapping(value = "inicio", method = RequestMethod.GET)
    public String inicio(){
        return "inicio";
    }

    @RequestMapping(value = "admin_eliminar", method = RequestMethod.GET)
    public String admin_eliminar(@ModelAttribute(value = "id") String id, Model m) throws ParseException{
        System.out.println("En admin_eliminar id: "+id);
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/delete/", id, String.class);
        System.out.println("Respuesta Metodo POST: "+aux);
        m.addAttribute("mensaje", aux);
        return admin_usuarios(m);
    }      
    
    @RequestMapping(value = "admin_actualizar2", method = RequestMethod.GET)
    public String admin_actualizar2(@ModelAttribute(value = "usuario") UserA u , Model m) throws ParseException{
        String c_encriptada = encriptar(u.getContrasena());
        u.setContrasena(c_encriptada);
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/upd/", u, String.class);
        m.addAttribute("mensaje", aux);
        return admin_usuarios(m);
    }     
    
    @RequestMapping(value = "admin_actualizar", method = RequestMethod.GET)
    public String admin_actualizar(@ModelAttribute(value = "email") String e, Model m) throws ParseException{
        UserA usuario = new UserA();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/findemail/"+e+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;      
            usuario.setId((String) jsonObject.get("id"));
            Integer i = (int) (long) (long ) jsonObject.get("identificacion");
            usuario.setIdentificacion(i);
            usuario.setNombres((String) jsonObject.get("nombres"));
            usuario.setApellidos((String) jsonObject.get("apellidos"));
            usuario.setEmail((String) jsonObject.get("email"));
            Integer c = (int) (long) (long ) jsonObject.get("celular");
            usuario.setCelular(c);
            Integer t = (int) (long) (long ) jsonObject.get("telefono");
            usuario.setTelefono(t);
            usuario.setTipousuario((String) jsonObject.get("tipousuario"));
            usuario.setContrasena((String) jsonObject.get("contrasena"));
        m.addAttribute("usuario", usuario);        
        return "admin/admin_actualizar";
    }
    
    @RequestMapping(value = "admin_ver", method = RequestMethod.GET)
    public String admin_ver(@ModelAttribute(value = "email") String e, Model m) throws ParseException{
        UserA usuario = new UserA();
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/findemail/"+e+"/", String.class);
        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;      
            usuario.setId((String) jsonObject.get("id"));
            Integer i = (int) (long) (long ) jsonObject.get("identificacion");
            usuario.setIdentificacion(i);
            usuario.setNombres((String) jsonObject.get("nombres"));
            usuario.setApellidos((String) jsonObject.get("apellidos"));
            usuario.setEmail((String) jsonObject.get("email"));
            Integer c = (int) (long) (long ) jsonObject.get("celular");
            usuario.setCelular(c);
            Integer t = (int) (long) (long ) jsonObject.get("telefono");
            usuario.setTelefono(t);
            usuario.setTipousuario((String) jsonObject.get("tipousuario"));
            usuario.setContrasena((String) jsonObject.get("contrasena"));
        m.addAttribute("usuario", usuario);        
        return "admin/admin_ver";
    }
    
    @RequestMapping(value = "admin_agregar", method = RequestMethod.GET)
    public String admin_agregar(Model m){
        UserA aux = new UserA();
        m.addAttribute("aux", aux);        
        return "admin/admin_agregar";
    }
    
    @RequestMapping(value = "admin_agregar2", method = RequestMethod.GET)
    public String admin_agregar2(@ModelAttribute(value = "usuario") UserA u , Model m) throws ParseException{
        String c_encriptada = encriptar(u.getContrasena());
        u.setContrasena(c_encriptada);
        String aux = restTemplate.postForObject("http://192.168.43.133:8085/user/add/", u, String.class);
        System.out.println("Respuesta Metodo POST: "+aux);
        m.addAttribute("mensaje", aux);
        return admin_usuarios(m);
    }    
    
    @RequestMapping(value = "admin_usuarios", method = RequestMethod.GET)
    public String admin_usuarios(Model m) throws ParseException{
        String aux = restTemplate.getForObject("http://192.168.43.133:8085/user/findall/", String.class);//tendria que usar el servicio para buscar un usuario
        System.out.println("Objeto traido desde Servicio /user/findall/ AUX: "+aux);
        Object obj = JSONValue.parse(aux);
        JSONArray userlist = (JSONArray) obj;
        m.addAttribute("userlist", userlist);
        return "admin/admin_usuarios";
    }
    
    @RequestMapping(value = "iniciarsesion", method = RequestMethod.GET)
    public String iniciarsesion(@ModelAttribute(value = "sesion") Sesion s, Model m) throws ParseException {
        String aux = "";
        UserA usuario = new UserA();
        String c_encriptada = encriptar(s.getContrasena());
        if(s.getEmail()!=""){
            System.out.println("Del Formulario correo: " + s.getEmail()+" contraseña: " + s.getContrasena());
            aux = restTemplate.getForObject("http://192.168.43.133:8085/user/findemail/"+s.getEmail()+"/", String.class);//se usa el servicio para buscar un usuario
        }else return "error";
        
        System.out.println("Objeto traido desde Servicio AUX: "+aux);

        Object obj;
        JSONParser parser = new JSONParser();
        obj = parser.parse(aux);
        JSONObject jsonObject = (JSONObject) obj;
        if(!jsonObject.get("nombres").equals("error")){
            
            usuario.setId((String) jsonObject.get("id"));
            Integer i = (int) (long) (long ) jsonObject.get("identificacion");
            usuario.setIdentificacion(i);
            usuario.setNombres((String) jsonObject.get("nombres"));
            usuario.setApellidos((String) jsonObject.get("apellidos"));
            usuario.setEmail((String) jsonObject.get("email"));
            Integer c = (int) (long) (long ) jsonObject.get("celular");
            usuario.setCelular(c);
            Integer t = (int) (long) (long ) jsonObject.get("telefono");
            usuario.setTelefono(t);
            usuario.setTipousuario((String) jsonObject.get("tipousuario"));
            usuario.setContrasena((String) jsonObject.get("contrasena"));            
            
            
            //String id = (String) jsonObject.get("id");
            //System.out.println(id);
            //long  identificacion = (long ) jsonObject.get("identificacion");
            //System.out.println(identificacion);
            String nombres = (String) jsonObject.get("nombres");
            //System.out.println(nombres);		
            //String apellidos = (String) jsonObject.get("apellidos");
            //System.out.println(apellidos);
            String email = (String) jsonObject.get("email");
            //System.out.println(email);
            //long  celular = (long ) jsonObject.get("celular");
            //System.out.println(celular);
            //long  telefono = (long ) jsonObject.get("telefono");
            //System.out.println(telefono);
            String tipousuario = (String) jsonObject.get("tipousuario");
            //System.out.println(tipousuario);
            String contrasena = (String) jsonObject.get("contrasena");
            //System.out.println(contrasena);
            
            if (c_encriptada.equals(contrasena) && s.getEmail().equals(email)) {

                System.out.println("CORRESPONDEN CONTRASENIA Y USUARIO (EMAIL)");
                m.addAttribute("nombre", nombres);//asociamos el nombre usuario/indexjsp a la variable {$nombre} para mostrar en cada usuario
                String tipoU = tipousuario;
                System.out.println("Seleccionando Vista el tipo de usuario es: " + tipousuario);
                if (tipousuario.equals("user")) {
                    System.out.println("Abriendo Vista de USUARIO");
                    m.addAttribute("usuario", usuario);
                    return "user/indexu";
                } else  if (tipousuario.equals("admin")){
                    System.out.println("Abriendo Vista de ADMINISTRADOR");
                    m.addAttribute("user", email);
                    //m.addAttribute("lst", model.getAllj());
                    //m.addAttribute("user", u);

                    return "admin/indexa";
                    //return "redirect:getAllj.html";
                }
            } else {
                //System.out.println("CONTRASENA ENCRIPTADA LISTA PARA INGRESAR:      "+u.getContrasenia());
                return "error";
            }
        }
        System.out.println("Return: error");
         return "error";
    }    

    //encriptar
    public String encriptar(String pass) {
        StringMD alg = new StringMD();
        String encriptado = alg.getStringMessageDigest(pass, StringMD.MD2);
        System.out.println("esta es la contrasenia encriptadad -------------------------------" + encriptado);
        return encriptado;
    }
    
    @RequestMapping(value = "indexa", method = RequestMethod.GET)
    public String indexa(){
        return "admin/indexa";
    }

    @RequestMapping(value = "indexu", method = RequestMethod.GET)
    public String indexu(){
        return "user/indexu";
    }
    
    @RequestMapping(value = "prueba", method = RequestMethod.GET)
    public String prueba(Model m) /*throws URISyntaxException*/{
        
        //URI url = new URI("http://192.168.1.4:8085/user/find2/02");
        String mensaje = restTemplate.getForObject("http://192.168.43.133:8085/user/find2/02", String.class);  
        System.out.println("Desde el Servicio : "+mensaje);
        String aux = "Jose desde VistaController SpringFramework";
        m.addAttribute("mensaje",mensaje);
        m.addAttribute("aux", aux);
        return "data";
    }   
   
}
