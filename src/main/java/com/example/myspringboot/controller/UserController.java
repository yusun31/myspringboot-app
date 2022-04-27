package com.example.myspringboot.controller;

import com.example.myspringboot.controller.form.UserForm;
import com.example.myspringboot.entity.User;
import com.example.myspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name", "스프링부트");
        return "leaf";
    }

    @GetMapping("/index")
    public String userList(Model model) {
        List<User> userList = userService.selectAllUser();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(UserForm myUser) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid UserForm userForm, BindingResult result, Model model) {
        // 검증 오류가 있다면
        if (result.hasErrors()) {
            // 입력 Form 화면에 머물러 있게 함
            return "add-user";
        }
        User user = new User();
        // UserFrom 객체의 Property를 User객체의 Property로 값을 복사해줌
        BeanUtils.copyProperties(userForm, user);
        // DB에 등록 요청
        userService.insertUser(user);
        model.addAttribute("users", userService.selectAllUser());
        return "index";
    }

}
