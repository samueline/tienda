/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.reto1.app.entidad;

/**
 *
 * @author samue
 */

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")

public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", nullable=false , length=50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable=false , length=50)
    private String password;
    @NonNull
    @Column(name = "user_name",nullable=false , length=80)
    private String  name;
}
