/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adiputra.spring_app.model;

import javax.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

/**
 *
 * @author adiputra
 */
public class Faktor {
    @Id
    @GeneratedValue
    private long id;
        	
    @NotEmpty(message = "Nama Kasus tidak boleh kosong!")
    @Column(length=255, nullable = false)
    private String nama;
    
    @Override
    public String toString() {
        return nama;
    }
}
