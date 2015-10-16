package com.github.baimurzin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vlad on 16.10.15.
 */
@Controller
@RequestMapping
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    @ResponseBody
    public Object test() {
        return "LOL";
    }

    @RequestMapping(value = "/apanel/1")
    @ResponseBody
    public Object testAdmin() {
        return 1;
    }
}
