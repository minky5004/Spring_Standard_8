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

    // 발제문서에 있던 내용
    @GetMapping("/private")
    public String privateApi(@AuthenticationPrincipal CustomUserDetails userDetails) {
        String userEmail = userDetails.getUsername();
        return "hello userEmail=" + userEmail;
    }
}
