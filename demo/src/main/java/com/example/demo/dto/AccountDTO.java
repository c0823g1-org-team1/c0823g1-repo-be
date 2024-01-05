package com.example.demo.dto;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Validator {
    private int id;
    @Size(min = 6,max = 20 , message = "Tài Khoản Chỉ Được 6-20 ký tự")
    private String nameAccount;
    @Size(min =6 ,max = 20,message = "Mật Khẩu Chỉ được 6-20 ký tự")
    private String password;
    @Size(min = 4,max = 20,message = "Tên Của Bạn từ 4 - 20 ký tự")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Tên Không được ký tự đặc biệt và số")
    private String nameClient;
    @Pattern(regexp = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$",message = "Chỉ được số và 10 số")
    private String phoneClient;
    @Pattern(regexp = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$",message = "Nhập đúng định dạng email")
    private String emailClient;
    private Date date;
    @Pattern(regexp = "[0-9]{12}",message = "Nhập đúng định dạng căn cước công dân 12 số")
    private String identifyClient;
    private Boolean isDelete;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
