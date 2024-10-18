package com.hys.exam.springbatch_10.app.member.repository;

import com.hys.exam.springbatch_10.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
