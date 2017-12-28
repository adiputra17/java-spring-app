/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adiputra.spring_app.service;

/**
 *
 * @author adiputra
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adiputra.spring_app.model.Faktor;
import com.example.adiputra.spring_app.dao.DaoFaktor;

@Service
public class ServiceFaktor {
    @Autowired
    private DaoFaktor daoFaktor;

    public DaoFaktor getDao() {
        return daoFaktor;
    }
    public void save(Faktor faktor) {
        daoFaktor.save(faktor);
    }
    public boolean update(Faktor faktor) {
    Faktor oldFaktor = daoFaktor.findOne(faktor.getId());
        if(oldFaktor != null){
            oldFaktor.setNama(faktor.getNama());
            daoFaktor.save(oldFaktor);
            System.out.println("Id : "+ faktor.getId());
            return true;
        }
        System.out.println("Id : "+ faktor.getId());
        return false;
    }
    public List<Faktor> getAll() {
        return daoFaktor.findAll();
    }
    public Faktor getById(Long faktorId) {
        return daoFaktor.findOne(faktorId);
    }
    public void delete(Long faktorId) {
        daoFaktor.delete(faktorId);
    }
}
