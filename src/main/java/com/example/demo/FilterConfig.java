/*
package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter(JwtUtil jwtUtil) {
        FilterRegistrationBean<JwtAuthenticationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new JwtAuthenticationFilter(jwtUtil));
        bean.addUrlPatterns("/private/*"); // private 하위만 적용
        bean.setOrder(1);
        return bean;
    }
}
*/
