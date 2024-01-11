package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourGuildDTO implements Validator {
    private int id;
    @Size(min = 4,max = 30,message = "Tên Của Bạn từ 4 - 30 ký tự")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Tên Không hợp lệ")
    private String name;
    private Date date;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    @Pattern(regexp = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$",message = "Chỉ được số và 10 số và bắt đầu bằng số 0")
    private String phoneGuild;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    @Pattern(regexp = "^[\\w.-]+@[a-zA-Z_-]+?(?:\\.[a-zA-Z]{2,})+$",message = "Email Không hợp lệ")
    private String emailGuild;
    private boolean isDelete;
    @Override
    public boolean supports(Class<?> clazz) {
        return TourGuildDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
