package com.github.baimurzin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vlad on 16.10.15.
 */
@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String render() {
        return "index";
    }
}
