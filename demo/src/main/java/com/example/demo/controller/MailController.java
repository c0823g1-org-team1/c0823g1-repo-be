package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.ITuanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class MailController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private ITuanAccountService accountService;

    @GetMapping("/forgot1")
    public String show() {
        return "Tuan_account/forgot";
    }

    @GetMapping("/forgot")
    public String forgot(@RequestParam String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<Account> accountList = accountService.getList();
        String subject = "Đổi mật khẩu";
        String url;
        String buttonText = "Đổi mật khẩu ngay";
        String htmlButton;
        for (Account account : accountList) {
            if (account.getEmailClient().equals(email)) {
                subject = "Đổi mật khẩu";
                url = "http://localhost:8080/account/formPassword/" + account.getId();
                message.setTo(email);
                message.setSubject(subject);
                message.setText(url);
                javaMailSender.send(message);
                return "redirect:/account/forgot1";
            }
        }
        return "redirect:/account/forgot1";
    }

    @GetMapping("formPassword/{id}")
    private String formEditPass(@PathVariable int id, Model model) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "Tuan_account/formEditPass";
    }

    @PostMapping("formPassword/changePass")
    private String change(Model model, Account account) {
        Account account1 = accountService.findById(account.getId());
        account1.setPassword(account.getPassword());
        accountService.save(account1);
        return "redirect:/";
    }
}