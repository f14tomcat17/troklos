/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.web.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 *
 * @author daniel
 */

@RestController("indexController")
@EnableWebMvc
@RequestMapping(value={"/index", "/"})
public class IndexController {
    
    private final HttpHeaders httpHeaders = new HttpHeaders();
    
    @RequestMapping(method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<String> getDefaultResponse() {           
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>("{\"resources\":[\"privileges\",\"request\",\"user\"]}", httpHeaders, HttpStatus.OK);
    }
    
         
}
