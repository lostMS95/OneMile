package com.kh.onemile.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.repository.admin.AdminDao;
import com.kh.onemile.repository.member.MemberDao;
import com.kh.onemile.service.admin.AdminService;
import com.kh.onemile.service.admin.AdminServiceImpl;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.MemberJoinVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private Sequence seq;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AdminService adminService;
	// 회원가입
	@Override
	public void join(MemberJoinVO memberJoinVO) {
		
		String origin = memberJoinVO.getPw();
		// 비밀번호 암호화
		String encrypt = encoder.encode(origin);
		memberJoinVO.setPw(encrypt);
		//회원번호 시퀀스 가져오기.
		int memNo = seq.joinSequence(SEQNAME);
		memberJoinVO.setMemberNo(memNo);
	
		memberDao.join(memberJoinVO);
		adminService.regApproveMember(memNo);
	}

	// 로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) {

		// 로그인 암호화
		String arwPw = encoder.encode(memberDTO.getPw());
		memberDTO.setPw(arwPw);
		
		return memberDao.login(memberDTO);
	}

	// 아이디찾기
	@Override
	public MemberDTO findId(MemberDTO memberDTO) {
		return memberDao.findId(memberDTO);

	}

}