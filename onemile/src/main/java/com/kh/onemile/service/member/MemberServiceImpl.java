package com.kh.onemile.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.repository.MemberDao;
import com.kh.onemile.repository.certi.CertiDao;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.MemberJoinVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CertiDao certiDao;
	@Autowired
	private Sequence seq;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private PasswordEncoder encoder;

	
	//회원가입
	@Override
	public void join(MemberJoinVO memberJoinVO) {
		String origin = memberJoinVO.getPw();
		// 비밀번호 암호화
		String encrypt = encoder.encode(origin);
		memberJoinVO.setPw(encrypt);
		int memNo = seq.joinSequence(SEQNAME);
		memberJoinVO.setMemberNo(memNo);
		memberDao.join(memberJoinVO);
		adminDao.approveMember(memNo);
	}

	//로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		//로그인 암호화
		String arwPw = encoder.encode(memberDTO.getPw());
		memberDTO.setPw(arwPw);
		
		return memberDao.login(memberDTO);
	}
	//회원탈퇴
	@Override
	public boolean quit(String email, String pw) {
		return memberDao.quit(email,pw);
	}
	//아이디찾기
	@Override
	public MemberDTO findId(MemberDTO memberDTO) {
		return memberDao.findId(memberDTO);
	}
	//이메일 체크
	@Override
	public boolean emailCheck(CertiDTO certiDTO) {
		return certiDao.check(certiDTO);
	}
}