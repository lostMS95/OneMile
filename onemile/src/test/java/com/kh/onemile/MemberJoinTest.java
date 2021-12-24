package com.kh.onemile;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.service.member.MemberService;

@SpringJUnitConfig
public class MemberJoinTest {
	@Autowired
	private MemberService memberService; 
	@Test
	public void join() {
		MemberDTO memberDTO = new MemberDTO();
		
		memberService.join(memberDTO);
	}
}
