package com.kh.onemile.repository;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.vo.MemberJoinVO;

public interface MemberDao {
	//회원가입
	void join(MemberJoinVO memberJoinVO);
	//단일조회
	MemberDTO login(MemberDTO memberDto);
	//아이디 찾기
	MemberDTO findId(MemberDTO memberDTO);
	
}