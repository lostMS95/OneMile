package com.kh.onemile.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.repository.CertiDao;
import com.kh.onemile.repository.MemberDao;
import com.kh.onemile.util.RandomUtil;

@Transactional //0 or 100? 
@Service
public class GmailService implements EmailService{
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomUtil randomUtil;
	
	@Autowired
	private CertiDao certiDao;

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void sendCertificationNumber(String email) {
		//랜덤번호 생성 부분
		String number = randomUtil.RandomNumber(6);
		
		int memberNo = memberDao.getMemberNo(email);
		System.out.println("찾기"+memberNo);
		
		//실제 이메일 발송 부분
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[원마일] 인증번호 메일입니다");
		message.setText("인증번호 : " + number);
		sender.send(message);
		
		
		//데이터베이스 등록 부분
		CertiDTO certiDTO = new CertiDTO();
		certiDTO.setEmail(email);
		certiDTO.setSerial(number);
		certiDTO.setMemberNo(memberNo);

		
		certiDao.insert(certiDTO);
		
	}

	@Override
	public boolean check(CertiDTO certiDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}