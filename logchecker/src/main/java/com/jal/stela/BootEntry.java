package com.jal.stela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by Kei.Kangai on 2015/07/02.
 */
@SpringBootApplication
public class BootEntry {

    public static void main(String[] args) {
        SpringApplication.run(BootEntry.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
