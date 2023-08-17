package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("local")
public class LogTraceTest {

    @Autowired
    MemberRepository memberRepository;
    @Test
    void name() {
        Member kangheon = new Member(1L, "kangheon", 1);
        memberRepository.save(kangheon);
    }
}
