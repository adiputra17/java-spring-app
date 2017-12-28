/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adiputra.spring_app.dao;

/**
 *
 * @author adiputra
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adiputra.spring_app.model.Faktor;

public interface DaoFaktor extends JpaRepository<Faktor, Long> {
}
