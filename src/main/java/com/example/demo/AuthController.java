package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth/signup")
    public void signup(@RequestBody SignupRequest req) {
        Member member = new Member(req.getEmail(), req.getPassword(), req.getRole());
        memberRepository.save(member);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody LoginRequest req) {
        Member member = memberRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다."));
        
        String token = jwtUtil.generateToken(member.getEmail(), member.getRole());
        return new TokenResponse(token);
    }
}