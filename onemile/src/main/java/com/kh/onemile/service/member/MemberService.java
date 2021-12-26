package com.kh.onemile.service.member;

import com.kh.onemile.entity.member.MemberDTO;

public interface MemberService {
	//회원가입
	public void join(MemberDTO memberDTO);
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	//아이디찾기
	public MemberDTO findId(MemberDTO memberDTO);
	
}