package com.kh.onemile;

import java.util.Date;

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
		Date a = new Date();
		a.setTime(1155214512L);
		memberDTO.setMemberNo(2);
		memberDTO.setEmail("testUser1@naver.com");
		memberDTO.setPw("testpassword1");
		memberDTO.setNick("쿠쿠루삥빵뽕");
		memberDTO.setPhone("010-6485-0241");
		memberDTO.setBirth(a);
		memberDTO.setMbti("INFP");
		memberDTO.setIntro("1");
		memberDTO.setCorona("Y");
		memberDTO.setGender("남자");

		memberService.join(memberDTO);
	}
}