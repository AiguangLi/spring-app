package com.lios.study.app.controller;

import com.lios.study.app.annotations.RestResponseResult;
import com.lios.study.app.models.User;
import com.lios.study.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liaiguang
 * @date 2020/6/12
 */
@RestController
@RestResponseResult
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/save")
    public User saveUser(@RequestParam String name, @RequestParam String password) throws Exception {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        boolean saved = userService.saveUser(user);
        if (saved) {
            return user;
        } else {
            throw new Exception("添加失败");
        }
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id) throws Exception {
        return userService.findUserById(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() throws Exception {
        return userService.getUserList();
    }
}