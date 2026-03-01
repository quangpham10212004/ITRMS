package com.robin.itrms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robin.itrms.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


}
