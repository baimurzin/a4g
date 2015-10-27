package com.github.baimurzin.controller;

import com.github.baimurzin.response.Response;
import com.wordnik.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vlad on 21.10.15.
 */
@Controller
@RequestMapping(value = "/api/")
@Api(value = "TeamController")
public class TeamController {

    @RequestMapping(value = "teams", method = RequestMethod.GET)
    @ResponseBody
    public Response getAllTeams() {
        Response response = new Response();
        return response;
    }
}
