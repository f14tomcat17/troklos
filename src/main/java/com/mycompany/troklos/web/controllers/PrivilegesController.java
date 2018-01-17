/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.web.controllers;

import com.mycompany.troklos.businesslayer.Privileges;
import com.mycompany.troklos.servicelayer.PrivilegesService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author daniel
 */
@Controller("PrivilegesController")
@RequestMapping("/privileges")
public class PrivilegesController {
    
    private final HttpHeaders httpHeaders = new HttpHeaders();
    
    @RequestMapping(method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Privileges>> getAll() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new PrivilegesService().getAll(), httpHeaders, HttpStatus.OK);
    } 
    
    
    @RequestMapping(value="{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Privileges> getById(@PathVariable int id) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new PrivilegesService().getById(id), httpHeaders, HttpStatus.OK);
    }   
}
