package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @PostMapping("/member")
    public Member account(@RequestBody @Valid MemberDTO dto){
        Member member = new Member(dto.getId(), dto.getName(), dto.getAge());
        return memberRepository.save(member);
    }

}
