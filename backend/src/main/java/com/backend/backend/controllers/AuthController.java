package com.backend.backend.controllers;


import com.backend.backend.dao.UserDao;
import com.backend.backend.models.UserModel;
import com.backend.backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody UserModel user){

        UserModel userLogin = userDao.obtenerUser(user);
        if (userLogin != null){

            String token = jwtUtil.create(String.valueOf(userLogin.getId()), userLogin.getEmail());
            return token;
        }else {
            return "401";
        }
    }


}

