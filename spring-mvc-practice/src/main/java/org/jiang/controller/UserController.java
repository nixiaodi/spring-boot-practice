package org.jiang.controller;

import org.jiang.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/15
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String addUser() {
        userService.addUser();
        return "ok";
    }
}
