package com.example.demo.controller;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.service.ITuanAccountService;
import com.example.demo.service.ITuanRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class TuanAccountController {
    @Autowired
    private ITuanAccountService accountService;
    @Autowired
    private ITuanRoleService roleService;

    @GetMapping("")
    public String getAllAccount(Model model,
                                @RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "6") Integer size,
                                @RequestParam(value = "account_name", defaultValue = "", required = false) String account_name,
                                @RequestParam(value = "role_id", defaultValue = "-1", required = false) Integer role_id,
                                @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
                                @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), sortBy);
        Page<Account> accounts = this.accountService.getAllAccountPage(pageable, account_name, role_id);
        model.addAttribute("account_name",account_name);
        model.addAttribute("role_id",role_id);
        model.addAttribute("accounts",accounts);
        return "/Tuan_account/managementAccount";

    }


    @GetMapping("login")
    private String showFormLogin() {
        return "/Tuan_account/login";
    }

    @GetMapping("register")
    private String showFormRegister(Model model) {
        AccountDTO accountDto = new AccountDTO();
        model.addAttribute("accountDto", accountDto);
        return "/Tuan_account/register";
    }

    @PostMapping("register")
    public String register(@Valid @ModelAttribute("accountDto") AccountDTO accountDto, BindingResult bindingResult, Model model) {
        Boolean flag = false;
        if (accountService.checkUserAccount(accountDto.getNameAccount()) != null) {
            model.addAttribute("isExits", 1);
            flag = true;
        }
        if (accountService.checkPhoneAccount(accountDto.getPhoneClient()) != null) {
            model.addAttribute("isExits2", 1);
            flag = true;
        }
        if (accountService.checkEmailAccount(accountDto.getEmailClient()) != null) {
            model.addAttribute("isExits3", 1);
            flag = true;

        }
        if (flag == true) {
            return "Tuan_account/register";
        }


        if (bindingResult.hasFieldErrors()) {
            return "Tuan_account/register";
        } else {
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            account.setRole(roleService.findById(1));
            accountService.save(account);
            return "Tuan_account/login";
        }
    }
}
