package com.example.Customer.Util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicUtil {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
