package com.example.dinnertime.controller;

import com.example.dinnertime.model.Users;
import com.example.dinnertime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersRepository usersRepo;

    @RequestMapping("/getAll")
    public Iterable<Users> getAll(){
        return usersRepo.findAll();
    }
    @RequestMapping("/{id}")
    public Users getUserById(@PathVariable long id){
        return usersRepo.findById(id);
    }

    @PostMapping("/sign_up")
    public String signUp(@RequestBody Users user){
        System.out.println(user.getPassword());
        usersRepo.save(user);
        return user + " Added";
    }

}
