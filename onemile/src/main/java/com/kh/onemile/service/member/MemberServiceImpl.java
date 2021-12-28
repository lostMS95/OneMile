package com.kh.onemile.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.repository.admin.AdminDao;
import com.kh.onemile.repository.certi.CertiDao;
import com.kh.onemile.repository.member.MemberDao;
import com.kh.onemile.service.admin.AdminService;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.util.SetDefaut;
import com.kh.onemile.vo.MemberJoinVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	final String SEQID = "member_seq";
	final String SEQNAME = "member_no";//혹시 몰라서 보류 나중에 지우기
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CertiDao certiDao;
	@Autowired
	private Sequence seq;
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private SetDefaut setDefault;
	
	// 회원가입
	@Override
	public int join(MemberJoinVO memberJoinVO) {
		setDefault.setMemberCoronaDefault(memberJoinVO.getCorona());
		// 비밀번호 암호화
		String origin = memberJoinVO.getPw();
		String encrypt = encoder.encode(origin);
		memberJoinVO.setPw(encrypt);
		
		//다음 회원번호 가져오기.
		int memNo = seq.nextSequence(SEQID);
		memberJoinVO.setMemberNo(memNo);
		log.debug("가입한 회원번호   "+ memNo);
		memberDao.join(memberJoinVO);
		
		return memNo;
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

	@Override
	public String getNick(int memberNo) {
		return memberDao.getNick(memberNo);
	}
}