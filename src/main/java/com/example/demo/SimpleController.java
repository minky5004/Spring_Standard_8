package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/public")
    public String publicApi(){
        return "this is public API";
    }

    @GetMapping("/private")
    public String privateApi(Authentication authentication) {
        String userEmail = (String) authentication.getPrincipal();
        return "hello userEmail=" + userEmail;
    }
}
