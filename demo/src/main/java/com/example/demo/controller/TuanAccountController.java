package com.example.demo.controller;

import com.example.demo.service.ITuanAccountService;
import com.example.demo.service.ITuanRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class TuanAccountController {
    @Autowired
    private ITuanAccountService accountService;
    @Autowired
    private ITuanRoleService roleService;


    @GetMapping("login")
    private String login() {
        return "/Tuan_account/loginandregister";
    }
}
