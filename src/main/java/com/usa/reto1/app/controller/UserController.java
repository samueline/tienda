/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.reto1.app.controller;

import com.usa.reto1.app.entidad.User;
import com.usa.reto1.app.servicio.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author samue
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    // Esta parte es para que al ADMIN obtenga lista de los usuarios actuales
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

   
    
    // Esta parte se usa cuando el ADMIN va a crear un nuevo usuario
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }


    // Esta parte permitira verificar si un usuario existe por el atributo 'email'
        @GetMapping("/{email}")
    public boolean verification(@PathVariable("email")String email){
        return service.getUserByEmail(email);
    }
  @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email")String email, @PathVariable("password")String password){
        return service.authUser(email, password);
    }
}
