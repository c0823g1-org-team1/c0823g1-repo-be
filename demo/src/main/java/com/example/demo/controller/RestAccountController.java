package com.example.demo.controller;


import com.example.demo.dto.AccountDTODO;
import com.example.demo.model.Account;
import com.example.demo.service.ITuanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestAccountController {
    @Autowired
    private ITuanAccountService iTuanAccountService;
    @GetMapping("/account/detail/{accId}")
    public ResponseEntity<Account> getDetail(@PathVariable int accId){
        Account account = iTuanAccountService.findById(accId);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
}
