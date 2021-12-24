package com.kh.onemile.dto.miles;

import java.util.Date;

import lombok.Data;

//마일즈 참가자  DTO
@Data
public class MilesParticipateDTO {
	private int mpNo;
	private int milesNo;
	private int memberNo;
	
	private Date joinDate; //가입일
	private String level; //모임내 회원 등급( "멤버" , "운영진" , "호스트" )
}
