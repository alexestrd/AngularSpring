package com.backend.backend.controllers;

import com.backend.backend.dao.UserDao;
import com.backend.backend.models.UserModel;
import com.backend.backend.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    /*Obteniendo solo un usuario */
    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable Long id){

        return userDao.getUser(id);
    }


    /*Registrando usuario con POST */
    @RequestMapping(value = "api/register", method = RequestMethod.POST)
    public void getUser(@RequestBody UserModel user){

            Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(1,1024, 1, user.getPassword());
            user.setPassword(hash);
            userDao.postUser(user);
    }



    /*Editando usuario */
    @RequestMapping(value = "api/user", method = RequestMethod.PUT)
    public UserModel editUser(){
        UserModel user = new UserModel();

        return user;
    }

    /*  Obteniendo varios usuarios*/
    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<UserModel> getUsers(@RequestHeader (value = "Autorization") String token){

        String userID = jwtUtil.getKey(token);
        if (userID == null){
            return new ArrayList<>();
        }
        return userDao.getUsers();
    }

    /*Eliminando usuario */
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userDao.deleteUser(id);
    }
}
