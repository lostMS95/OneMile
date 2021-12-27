package com.kh.onemile.service.member;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.vo.MemberJoinVO;

public interface MemberService {
	final String SEQNAME = "member_seq";
	//회원가입
	public void join(MemberJoinVO memberJoinVO);
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	//아이디찾기
	public MemberDTO findId(MemberDTO memberDTO);
	
}