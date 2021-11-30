/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.reto1.app.repository.crud;

import com.usa.reto1.app.entidad.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author samue
 */
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
