package com.kh.onemile.entity.member;

import lombok.Data;

//회원온도 테이블
@Data
public class MemberTemperatureDTO {
	private int tpNo;
	private int memberNo;
	private int tp;
}
