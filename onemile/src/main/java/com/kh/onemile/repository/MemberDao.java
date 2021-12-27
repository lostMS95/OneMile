package com.kh.onemile.repository;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.vo.MemberJoinVO;

public interface MemberDao {

	// 회원가입
	void join(MemberJoinVO memberJoinVO);

	// 단일조회
	MemberDTO login(MemberDTO memberDto);

	// 아이디 찾기
	MemberDTO findId(MemberDTO memberDTO);

	//번호가져오기
	int getMemberNo(String email);
	
	//회원탈퇴
	boolean quit(String email, String pw);

}