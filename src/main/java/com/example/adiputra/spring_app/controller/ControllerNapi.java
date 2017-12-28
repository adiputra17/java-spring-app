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
import com.example.adiputra.spring_app.model.Napi;
import com.example.adiputra.spring_app.model.Faktor;
import com.example.adiputra.spring_app.service.ServiceNapi;
import com.example.adiputra.spring_app.service.ServiceFaktor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Controller
public class ControllerNapi {
    @Autowired
    private ServiceNapi serviceNapi;
    @Autowired
    private ServiceFaktor serviceFaktor;

    @RequestMapping(value="/napi/list", method=RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("napimodel", serviceNapi.getAll());
        return "/napi/napi-list";
    }

    @RequestMapping(value = "/napi/input", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("napi", new Napi());
        model.addAttribute("faktormodel", serviceFaktor.getAll());
        model.addAttribute("faktor", new Faktor());
        return "/napi/napi-input";
    }

    @RequestMapping(value = "/napi/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        Napi napi = serviceNapi.getById(Long.parseLong(id));
        model.addAttribute("napi", napi);
        model.addAttribute("faktormodel", serviceFaktor.getAll());
        model.addAttribute("faktor", new Faktor());
            return "/napi/napi-edit";
    }

    @RequestMapping(value = "/napi/save", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute Napi napi, BindingResult result) {
        for (FieldError err:result.getFieldErrors()){
		System.out.println(err.getDefaultMessage()); // Output: must be greater than or equal to 10
	}
	if (result.hasErrors()){
		return "/napi/napi-input";
	}
        if(serviceNapi.update(napi)){
            System.out.println("UPDATE");
        }
        else{
            System.out.println("SAVE");
            serviceNapi.save(napi);
        }
        return "redirect:/napi/list";
    }
    
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
        return "redirect:/napi/input";
    }

    @RequestMapping(value = "/napi/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        serviceNapi.delete(Long.parseLong(id));
        return "redirect:/napi/list";
    }
    
    @RequestMapping(value="/napi/statistic", method=RequestMethod.GET)
    public String getAllFaktor(Model model) {
        model.addAttribute("faktormodel", serviceFaktor.getAll());
        model.addAttribute("count", serviceNapi.getCount());
        return "/napi/napi-statistic";
    }
}
