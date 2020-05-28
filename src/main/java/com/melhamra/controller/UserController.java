package com.melhamra.controller;


import com.melhamra.model.User;
import com.melhamra.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private final UserDaoImpl userDao;


    public UserController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        userDao.saveUser(user);
    }
}
