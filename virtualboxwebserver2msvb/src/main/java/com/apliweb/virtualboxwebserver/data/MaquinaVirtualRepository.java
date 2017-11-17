/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AcerF5w10
 */
public interface MaquinaVirtualRepository extends CrudRepository<MaquinaVirtual,String>{
    
    //busca una maquina por el campo usuId
    @Query(value = "SELECT * FROM maquina_virtual mv WHERE mv.USU_ID = ?1", nativeQuery = true)
    Iterable<MaquinaVirtual> findByUid(String usu_id);
    //raund 3 List<UserA> findByEmail(String email);  
   
}
