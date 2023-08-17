package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @PostMapping("/member")
    public Member account(@RequestBody MemberDTO dto){
        Member member = new Member(dto.getId(), dto.getName(), dto.getAge());
        return memberRepository.save(member);
    }

}
