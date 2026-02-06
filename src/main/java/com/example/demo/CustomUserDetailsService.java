package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberRepository.findByEmail(username).orElseThrow();
        return new CustomUserDetails(member);
    }
}
