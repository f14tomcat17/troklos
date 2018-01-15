/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.web.controllers;

import com.mycompany.troklos.servicelayer.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author daniel
 */

@Controller("UserController")
@RequestMapping("/users")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {                
        return new ModelAndView("users", "message", "Num users: "+new UserService().getAll().size());
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable int id) {
        return new ModelAndView("users", "message", new UserService().getById(id).toString());
    }
}