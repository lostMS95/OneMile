package com.kh.onemile.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.member.MemberDTO;
import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.util.RandomUtil;

@Service
public class GmailService implements EmailService{
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomUtil randomUtil;

	@Override
	public void sendCertificationNumber(MemberDTO memberDTO,String email) {
		//랜덤번호 생성 부분
		String number = randomUtil.RandomNumber(6);
		
		//실제 이메일 발송 부분
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberDTO.getEmail());
		message.setSubject("[원마일] 인증번호 메일입니다");
		message.setText("인증번호 : " + number);
		sender.send(message);
		
		//데이터베이스 등록 부분
		CertiDTO certiDTO = new CertiDTO();
		certiDTO.setEmail(memberDTO.getEmail());
		certiDTO.setSerial(number);
	
		
	
		
		
	}
}