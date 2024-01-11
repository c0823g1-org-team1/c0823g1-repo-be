package com.example.demo.service;

import com.example.demo.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ITuanAccountService {
    void save(Account account);

    Account findById(int id);

    List<Account> getList();

    void delete(Account account);
    Account checkUserAccount(String nameAccount);
    Account checkPhoneAccount(String phone_client);
    Account checkEmailAccount(String email_client);
    Account checkIndentifyAccount(String identify_client);
    Page<Account> getAllAccountPage(Pageable pageable, @Param("account_name")String account_name, @Param("role_id") Integer role_id);
    Account findByUserName(String userName);
}
