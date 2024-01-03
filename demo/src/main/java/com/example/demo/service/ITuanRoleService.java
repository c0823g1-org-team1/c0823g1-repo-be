package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface ITuanRoleService {
    List<Role> getList();

    Role findById(int id);
}
