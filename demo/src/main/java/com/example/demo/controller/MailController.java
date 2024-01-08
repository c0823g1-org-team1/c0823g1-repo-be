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
@RequestMapping("Tuan_account")
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
    public String forgot(@RequestParam String account) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<Account> accountList = accountService.getList();
        String email = null;
        String pass = null;
        int id = 0;
        for (Account account1 : accountList) {
            if (account1.getNameAccount().equals(account)) {
                email = account1.getEmailClient();
                id = account1.getId();
                break;
            }
        }
        String subject = "Quen mat khau";
        String url = "http://localhost:8080/Tuan_account/formPassword/" + id;
        message.setTo(email);
        message.setSubject(subject);
        message.setText(url);
        javaMailSender.send(message);
        return "Tuan_account/result";
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