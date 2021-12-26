package com.kh.onemile;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.repository.MemberDao;
import com.kh.onemile.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class MemberJoinTest {
	@Autowired
	private MemberService memberService; 
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSession sqlSession;
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
		memberDTO.setIntro(" 1");
		memberDTO.setCorona("Y");
		memberDTO.setGender("남자");
		
		memberService.join(memberDTO);


	}
	
	
}