package com.example.myspringboot.service;


import com.example.myspringboot.entity.User;
import com.example.myspringboot.exception.ResourceNotFoundException;
import com.example.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public User selectUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        //orElseThrow의 아규먼트 타입 Supplier
        //Supplier의 추상메서드 T get()
        User existUser = optionalUser.orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return existUser;
    }

    public User updateUser(Long id, User userDetail) {
        User existUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        // name 필드 수정하기 위해 settet method 호출
        existUser.setName(userDetail.getName());
        // email 필드 수정하기 위해 settet method 호출
        existUser.setEmail(userDetail.getEmail());
        return existUser;
    }

    public ResponseEntity<?> deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "User Not Found");
        }
        User existUser = optionalUser.get();
        userRepository.delete(existUser);
        return ResponseEntity.ok("User Delete OK");
    }
}