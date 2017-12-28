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

import com.example.adiputra.spring_app.model.Napi;
import com.example.adiputra.spring_app.dao.DaoNapi;


@Service
public class ServiceNapi {

    @Autowired
    private DaoNapi daoNapi;
    
    public void save(Napi napi){
        daoNapi.save(napi);
    }

    public boolean update(Napi napi) {
        Napi oldNapi = daoNapi.findOne(napi.getId());
        if(oldNapi != null){
            oldNapi.setNama(napi.getNama());
            oldNapi.setAlamat(napi.getAlamat());
            oldNapi.setJen_kel(napi.getJen_kel());
            oldNapi.setFaktor(napi.getFaktor());
            oldNapi.setLama(napi.getLama());
            oldNapi.setMasuk(napi.getMasuk());
            oldNapi.setKeluar(napi.getKeluar());
            daoNapi.save(oldNapi);
            System.out.println("Id : "+ napi.getId() +" success");
            return true;
        }
        System.out.println("Id : "+ napi.getId());
        return false;
    }
    public List<Napi> getAll() {		
        return daoNapi.findAll();
    }
    public Napi getById(Long napiId) {
        return daoNapi.findOne(napiId);
    }
    public void delete(Long napiId) {
        daoNapi.delete(napiId);
    }
    public Long getCount(){
        return daoNapi.count();
    }
}
