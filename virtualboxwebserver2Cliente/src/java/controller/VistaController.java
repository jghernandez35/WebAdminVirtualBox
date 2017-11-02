/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.sun.media.jfxmedia.logging.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author AcerF5w10
 */
@Controller
public class VistaController {
    
    
    @RequestMapping("index")
    public ModelAndView redireccion(){
        ModelAndView MV = new ModelAndView();
        MV.setView("index");
        return MV;
    }
    
    @RequestMapping(value = "prueba", method = RequestMethod.GET)
    public String prueba(Model m) /*throws URISyntaxException*/{
        
        RestTemplate restTemplate = new RestTemplate();
        //URI url = new URI("http://192.168.1.4:8085/user/find2/02");
        String mensaje = restTemplate.getForObject("http://192.168.1.4:8085/user/find2/02", String.class);  
        System.out.println("Desde el Servicio : "+mensaje);
        String aux = "Jose desde VistaController SpringFramework";
        m.addAttribute("mensaje",mensaje);
        m.addAttribute("aux", aux);
        return "data";
    }
    
}
