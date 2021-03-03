package com.tian.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author David Tian
 * @desc
 * @since 2020-04-03 20:01
 */
@Controller
@RequestMapping("/web")
public class helloController {

    @RequestMapping(value = {"/hello"},method = RequestMethod.GET)
    public String hello(){
        return "HelloWord";
    }
}