package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private int id;
    private String nameAccount;
    private String password;
    private String nameClient;
    private String phoneClient;
    private String emailClient;
    private Date date;
    private Long identifyClient;
    private Boolean isDelete;




}
