package com.kh.onemile.service.email;
import com.kh.onemile.entity.member.certi.CertiDTO;

public interface EmailService {
	//인증번호 전송
	void sendCertificationNumber(String email);
	//이메일 DB체크
	boolean check(CertiDTO certiDTO);
}