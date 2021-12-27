package com.kh.onemile.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
		MemberDTO findDto = sqlSession.selectOne("member.get",memberDto.getEmail());
		
		if(findDto != null && memberDto.getPw().equals(findDto.getPw())) {
			
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
}
