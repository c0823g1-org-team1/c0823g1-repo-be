package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameAccount;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy = "account")
    private Set<DetailAccount> detailAccounts;

    public Account() {
    }

    public Account(int id, String nameAccount, String password, Role role) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<DetailAccount> getDetailAccounts() {
        return detailAccounts;
    }

    public void setDetailAccounts(Set<DetailAccount> detailAccounts) {
        this.detailAccounts = detailAccounts;
    }
}
