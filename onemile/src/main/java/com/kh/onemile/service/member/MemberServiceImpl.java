package com.kh.onemile.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.repository.member.MemberDao;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.MemberJoinVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Sequence seq;
	
	//회원가입
	@Override
	public void join(MemberJoinVO memberJoinVO) {
		int mem = seq.joinSequence(SEQNAME);	
		memberJoinVO.setMemberNo(mem);
		memberDao.join(memberJoinVO);
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