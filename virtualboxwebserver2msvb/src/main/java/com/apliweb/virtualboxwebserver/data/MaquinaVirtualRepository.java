/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.data;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AcerF5w10
 */
public interface MaquinaVirtualRepository extends CrudRepository<MaquinaVirtual,String>{
    
    //busca un usuario por el campo EMAIL pero tengo problemas con el ".com" de los emails asi que toca cambiar la logica
    // para que ese campo sea mejor el usuario.
    //@Query(value = "SELECT * FROM usuarios_sistema us WHERE us.EMAIL = ?1", nativeQuery = true)
    //UserA findByEmail(String email);
    //raund 3 List<UserA> findByEmail(String email);  
   
}
