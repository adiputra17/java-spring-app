/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adiputra.spring_app.controller;

/**
 *
 * @author adiputra
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import com.example.adiputra.spring_app.model.Faktor;
import com.example.adiputra.spring_app.service.ServiceFaktor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ControllerFaktor {
    @Autowired
    private ServiceFaktor serviceFaktor;
    
    @RequestMapping(value = "/faktor/save", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute Faktor faktor, BindingResult result) {
        for (FieldError err:result.getFieldErrors()){
		System.out.println(err.getDefaultMessage()); // Output: must be greater than or equal to 10
	}
	if (result.hasErrors()){
            return "/napi/napi-input";
	}
        if(serviceFaktor.update(faktor)){
            System.out.println("UPDATE");
        }
        else{
            System.out.println("SAVE");
            serviceFaktor.save(faktor);
        }
        return "redirect:/napi/list";
    }
}
