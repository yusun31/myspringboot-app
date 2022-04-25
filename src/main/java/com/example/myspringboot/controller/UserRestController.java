package com.example.myspringboot.controller;

import com.example.myspringboot.entity.User;
import com.example.myspringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private UserService userService;

    //Constructor Injection (생성자 주입 방식)
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //POST http://localhost:8087/api/users
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    //GET http://localhost:8087/api/users
    @GetMapping
    public List<User> getUsers(){
        return userService.selectAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.selectUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
        return userService.updateUser(id, userDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}