/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adiputra.spring_app.model;

/**
 *
 * @author adiputra
 */
 
import javax.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

public class Napi {
    
    @Id
    @GeneratedValue
    private long id;
    
    //@Size(min=3, max=100)
    @NotEmpty(message = "Nama tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String nama;

    //@Size(min=3, max=100)
    @NotEmpty(message = "Alamat tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String alamat;
    
    //@Size(min=3, max=100)
    @NotEmpty(message = "Jenis Kelamin tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String jen_kel;
    
    //@Size(min=3, max=100)
    //@NotEmpty(message = "Faktor tidak boleh kosong!")
//    @Column(length=100, nullable = false)
//    private int faktor;
    
    //@Size(min=3, max=100)
    @NotEmpty(message = "Lama Penjara tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String lama;
    
    //@Size(min=3, max=100)
    @NotEmpty(message = "Tanggal masuk tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String masuk;
    
    //@Size(min=3, max=100)
    @NotEmpty(message = "Tanggal tidak boleh kosong!")
    @Column(length=100, nullable = false)
    private String keluar;
    
    //RELATIONSHIP
    @ManyToOne
    private Faktor faktor;
}