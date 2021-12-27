package com.kh.onemile.repository;

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
	//회원가입
	@Override
	public void join(MemberJoinVO memberJoinVO) {
		sqlSession.insert("member.join",memberJoinVO);
	}
	//로그인
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		return sqlSession.selectOne("member.get", memberDto.getEmail());
		}
	//아이디 찾기
	@Override
	public MemberDTO findId(MemberDTO memberDTO) {
		Map<String, Object> param = new HashMap<>();
		param.put("nick", memberDTO.getNick());
		param.put("phone", memberDTO.getPhone());
		MemberDTO findDto = sqlSession.selectOne("member.findId",param);
		return findDto;
	}
	//이메일 회원번호 가져오기
	@Override
	public int getMemberNo(String email) {
		return sqlSession.selectOne("member.memberNoByEmail", email);
	}
	//회원탈퇴
	@Override
	public boolean quit(String email, String pw) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail(email);
		memberDTO.setPw(pw);
		int count = sqlSession.delete("member.quit",memberDTO);
		return count > 0;
	}
}