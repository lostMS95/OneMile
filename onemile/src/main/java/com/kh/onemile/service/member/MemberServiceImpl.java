package com.kh.onemile.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	//회원가입
	@Override
	public void join(MemberDTO memberDTO) {
		memberDao.join(memberDTO);
	}
	//로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		return memberDao.login(memberDTO);
	}
	//아이디찾기
	@Override
	public MemberDTO findId(MemberDTO memberDTO) {
		return memberDao.findId(memberDTO);
		
		
	}
	
	
}