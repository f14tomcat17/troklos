/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.web.controllers;

import com.mycompany.troklos.businesslayer.Request;
import com.mycompany.troklos.servicelayer.RequestService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 *
 * @author daniel
 */

@Controller("requestController")
@EnableWebMvc
@RequestMapping("/requests")
public class RequestController {
    private final HttpHeaders httpHeaders = new HttpHeaders();
    
    @RequestMapping(method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List> getAll() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new RequestService().getAll(), httpHeaders, HttpStatus.OK);
    } 
    
    
    @RequestMapping(value="{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Request> getById(@PathVariable int id) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new RequestService().getById(id), httpHeaders, HttpStatus.OK);
    }   
    
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Integer> insert(@RequestBody Request request) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        new RequestService().insert(request);
        return new ResponseEntity<>(request.getIdrequest(), httpHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Request> update(@RequestBody Request request) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        new RequestService().update(request);
        return new ResponseEntity<>(request, httpHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Integer> delete(@PathVariable int id) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        new RequestService().delete(id);
        return new ResponseEntity<>(id, httpHeaders, HttpStatus.OK);
    }
}
