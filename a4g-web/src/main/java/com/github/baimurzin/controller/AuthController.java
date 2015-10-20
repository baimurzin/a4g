package com.github.baimurzin.controller;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.dto.UserRegistrationForm;
import com.github.baimurzin.response.Response;
import com.github.baimurzin.service.UserLoginService;
import com.github.baimurzin.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vlad on 16.10.15.
 */
@Controller
@Api(value = "Authentication", description = "Authentication")
@RequestMapping()
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    ShaPasswordEncoder shaPasswordEncoder;
    @Autowired
    private UserLoginService userLoginService;
    private String decodePassword(String password) {
        return shaPasswordEncoder.encodePassword(password, "");
    }

    private boolean isEmailExist(UserRegistrationForm userRegistrationForm){
        return userService.findByEmail(userRegistrationForm.getEmail()) != null;
    }

    private boolean isLoginExist(UserRegistrationForm form) {
        return userService.findByLogin(form.getLogin()) !=null;
    }

    private boolean isPasswordEquals(UserRegistrationForm userRegistrationForm) {
        return userRegistrationForm.getPassword().equals(userRegistrationForm.getConfirmPassword());
    }

    @ApiOperation(httpMethod = "POST", value = "Provides registration new users")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Response registerUser(@RequestBody UserRegistrationForm form, HttpServletResponse response, HttpServletRequest request) {
        Response customResponse = new Response();
        if (isEmailExist(form)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setCode(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setResponse("Email already exist");
            return customResponse;
        } else if (isLoginExist(form)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setCode(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setResponse("Login already exist");
            return customResponse;
        } else if (!isPasswordEquals(form)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setCode(HttpServletResponse.SC_BAD_REQUEST);
            customResponse.setResponse("Password and confirmation password are not equals");
            return customResponse;
        }

        form.setPassword(decodePassword(form.getPassword()));

        response.setStatus(HttpServletResponse.SC_CREATED);
        customResponse.setCode(HttpServletResponse.SC_CREATED);
        UserEntity userEntity = userService.createUser(form);
        customResponse.setResponse(userEntity);
        return customResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/session")
    public @ResponseBody
    Response session(HttpServletResponse response) {
        if (!userLoginService.isAuthenticated()){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return new Response(HttpServletResponse.SC_UNAUTHORIZED);
         } else {
            Response resp = new Response(HttpServletResponse.SC_FOUND);
            resp.setResponse(userLoginService.getCurrentUser());
            return resp;
        }
    }

}
