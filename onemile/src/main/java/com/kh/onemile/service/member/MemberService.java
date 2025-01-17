package com.kh.onemile.service.member;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.vo.MemberJoinVO;

public interface MemberService {
	
	//회원가입
	public int join(MemberJoinVO memberJoinVO);
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	//회원탈퇴
	public boolean quit(String email, String pw);
	//아이디찾기
	public MemberDTO findId(MemberDTO memberDTO);
	//이메일 전송 체크
	public boolean emailCheck(CertiDTO certiDTO);

	//비밀번호 변경
	public boolean changePw(String email, String nowPw, String changePw);

	//닉네임
	public String getNick(int memberNo);

}