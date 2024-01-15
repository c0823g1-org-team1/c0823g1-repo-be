package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Cấu hình đường dẫn tới các tệp tin nguồn tin nhắn
        messageSource.setBasename("classpath:validation-message");
        // Cấu hình encoding là UTF-8
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
