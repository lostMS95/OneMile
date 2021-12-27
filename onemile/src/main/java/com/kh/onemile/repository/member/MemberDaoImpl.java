package com.kh.onemile.repository.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.vo.MemberJoinVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//회원가입
	@Override
	public void join(MemberJoinVO memberJoinVO) {
		String origin = memberJoinVO.getPw();
		//회원가입 암호화
		String encrypt = encoder.encode(origin);
		memberJoinVO.setPw(encrypt);
		sqlSession.insert("member.join",memberJoinVO);
	}
	
	//로그인
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		MemberDTO findDto = sqlSession.selectOne("member.get",memberDto.getEmail());
		//로그인 암호화
		String arwPw = encoder.encode(findDto.getPw());
		
		if(findDto != null && arwPw.equals(findDto.getPw())) {
				
					return findDto;
			}
		else {
				return null;
			}
		}
	//아이디 찾기

	@Override
	public MemberDTO findId(MemberDTO memberDTO) {
		Map<String, Object> param = new HashMap<>();
		param.put("nick", memberDTO.getNick());
//		param.put("birth", memberDTO.getBirth());
		param.put("phone", memberDTO.getPhone());
		MemberDTO findDto = sqlSession.selectOne("member.findId",param);
		return findDto;
		
		
	}
	//회원번호 하나 가져오기
	@Override
	public int getMemberNo(String email) {
		return sqlSession.selectOne("member.memberNoByEmail", email);
	}
}
