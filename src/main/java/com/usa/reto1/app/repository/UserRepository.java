/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.reto1.app.repository;

/**
 *
 * @author samue
 */

import com.usa.reto1.app.entidad.User;
import com.usa.reto1.app.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> getUser(int id){
        return repository.findById(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }

   public boolean getUserByEmail(String email){
        Optional<User> user = repository.findByEmail(email);
        return !user.isEmpty();
    }

    

    public Optional<User> authUser(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    

}