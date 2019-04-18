/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.entity;

import java.lang.annotation.Documented;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
@Entity(name = "USER")
public class UserEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    
}
