/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.reto1.app.servicio;

import com.usa.reto1.app.entidad.User;
import com.usa.reto1.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // this method will return to us all the existent users
    public List<User>getAll() {
        return repository.getAll();
    }

    // this method will return to us each specified user by his/her id
    public Optional<User> getUser(int userId){
        return repository.getUser(userId);
    }

    // this method will save a new user
    public User save(User user){
        if (user.getId() == null){
            if(getUserByEmail(user.getEmail()) == false){
                return repository.save(user);
            }else {
                return user;
            }
        }else {
            return user;
        }
    }

    // This method will to look if an user exist on the system by its email

    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email);
    }


    public User authUser(String email, String password){
        Optional<User> user = repository.authUser(email, password);

        if (user.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        }else {
            return user.get();
        }
    }

}