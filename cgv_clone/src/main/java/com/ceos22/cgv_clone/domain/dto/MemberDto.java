package com.ceos22.cgv_clone.domain.dto;

import com.ceos22.cgv_clone.domain.member.Gender;
import com.ceos22.cgv_clone.domain.member.Member;

public record MemberDto(
        Long id,
        String loginId,
        String password,
        String name,
        int age,
        Gender gender
) {
    public static MemberDto from(Member m) {
        return new MemberDto(
                m.getId(),
                m.getLoginId(),
                m.getPassword(),
                m.getName(),
                m.getAge(),
                m.getGender()
        );
    }
}
