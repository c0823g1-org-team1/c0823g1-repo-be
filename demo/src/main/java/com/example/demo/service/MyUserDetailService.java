package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.MyUserDetail;
import com.example.demo.model.Role;
import com.example.demo.repository.TuanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private TuanAccountRepository tuanAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = tuanAccountRepository.findByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("Tài Khoản" + username + "Không Tồn Tại");
        }
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(account.getRole().getName());
        System.out.println(authority);
        grantList.add(authority);

        return new User(account.getUsername(), //
                account.getPassword(), grantList);
    }
}
