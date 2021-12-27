package com.kh.onemile.service.email;

import com.kh.onemile.entity.member.MemberDTO;

public interface EmailService {
	//인증번호 전송 서비스
	void sendCertificationNumber(String email);
}
