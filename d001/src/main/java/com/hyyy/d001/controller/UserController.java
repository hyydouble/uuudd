package com.hyyy.d001.controller;

import com.hyyy.d001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyyy.d001.model.User;
import com.hyyy.d001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/del/{id}")
    public void  delete(@PathVariable(value = "id") int id){
        userService.deleteUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll(); }


    @GetMapping("/update")
    public void  update(@RequestParam(value = "id")int id,
                         @RequestParam(value = "name")String name){

        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.updateUser(user); }

    @GetMapping("/add")
    public void add(@RequestParam(value = "id")Integer id,
                    @RequestParam(value = "name")String name){

        User uu = new User();
        uu.setId(id);
        uu.setName(name);
        userService.add(uu); }

    @GetMapping("/adda")
    public void add1(){
        User uu = new User();
        uu.setId('6');
        uu.setName("kka");
        userService.add(uu); }



    @GetMapping(value = "/findbyid/{id}")
    public User  findbyId (@PathVariable(value = "id") int id){
            User user = userService.findbyId(id);
            return user;
    }



}
