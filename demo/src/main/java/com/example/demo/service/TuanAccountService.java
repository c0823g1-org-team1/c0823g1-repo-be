package com.example.demo.service;

import com.example.demo.dto.RankDTO;
import com.example.demo.model.Account;
import com.example.demo.repository.TuanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuanAccountService implements ITuanAccountService {
    @Autowired
    private TuanAccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> getList() {
        return accountRepository.findAll();
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account checkUserAccount(String nameAccount) {
        return accountRepository.checkUserAccount(nameAccount);
    }

    @Override
    public Account checkPhoneAccount(String phone_client) {
        return accountRepository.checkPhoneAccount(phone_client);
    }

    @Override
    public Account checkEmailAccount(String email_client) {
        return accountRepository.checkEmailAccount(email_client);
    }

    @Override
    public Account checkIndentifyAccount(String identify_client) {
        return accountRepository.checkIndentifyAccount(identify_client);
    }
    @Override
    public Page<Account> getAllAccountPage(Pageable pageable, String account_name, Integer role_id) {
        return accountRepository.getAllAccountPage(pageable,account_name,role_id);
    }

    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUsername(userName);
    }

    @Override
    public List<RankDTO> checkRank(int id) {
        return accountRepository.checkRank(id);
    }

}
