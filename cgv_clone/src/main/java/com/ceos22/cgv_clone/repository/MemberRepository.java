package com.ceos22.cgv_clone.repository;

import com.ceos22.cgv_clone.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
