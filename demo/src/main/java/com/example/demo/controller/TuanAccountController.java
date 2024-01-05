package com.example.demo.controller;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.Account;
import com.example.demo.service.ITuanAccountService;
import com.example.demo.service.ITuanRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class TuanAccountController {
    @Autowired
    private ITuanAccountService accountService;
    @Autowired
    private ITuanRoleService roleService;


    @GetMapping("login")
    private String showFormLogin() {
        return "/Tuan_account/login";
    }
    @GetMapping("register")
    private String showFormRegister(Model model) {
        AccountDTO accountDto = new AccountDTO();
    model.addAttribute("accountDto",accountDto);
        return "/Tuan_account/register";
    }
    @PostMapping("register")
    public String register(@Valid @ModelAttribute("accountDto") AccountDTO accountDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "Tuan_account/register";
        }else {
            return "Tuan_account/login";
        }
    }
}
