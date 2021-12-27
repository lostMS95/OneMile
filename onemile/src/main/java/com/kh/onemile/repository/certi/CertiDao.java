package com.kh.onemile.repository.certi;

import com.kh.onemile.entity.member.certi.CertiDTO;

public interface CertiDao {
	//발송이력 DB에 저장
	void insert(CertiDTO certiDTO);
	//DB 비교
	boolean check(CertiDTO certiDTO);
}