package com.example.demo.service;

import com.example.demo.model.Account;

import java.util.List;

public interface ITuanAccountService {
    void save(Account account);

    Account findById(int id);

    List<Account> getList();

    void delete(Account account);
}
