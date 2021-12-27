package com.kh.onemile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.onemile.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class Test01 {
	@Autowired
	private SqlSession sqlSession; 
	
	@Test
	public void test() {
		int result = sqlSession.selectOne("seq.get","mi_no");
		System.out.println(result);
		Map<String, Object> updateValue = new LinkedHashMap<String, Object>();
		updateValue.put("seq_name", "mi_no");
		updateValue.put("seq_no", 1);
		sqlSession.update("seq.increase",updateValue);
		System.out.println(result);
	}
	
}
