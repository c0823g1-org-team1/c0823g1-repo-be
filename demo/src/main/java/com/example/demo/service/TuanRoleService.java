package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.TuanRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuanRoleService implements ITuanRoleService{
    @Autowired
    private TuanRoleRepository roleRepository;
    @Override
    public List<Role> getList() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).get();
    }
}
