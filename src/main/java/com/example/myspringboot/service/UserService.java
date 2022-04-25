package com.example.myspringboot.service;


import com.example.myspringboot.entity.User;
import com.example.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }



}