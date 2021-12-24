package com.kh.onemile.dto.member;

import java.util.Date;

import lombok.Data;

//회원 DTO
@Data
public class MemberDTO {
	private int memberNo;
	private String email;
	private String pw;
	private String nickName;
	private String phone;
	private String gender;
	private Date date;
	private String grade;
	private Date joinDate;
	private String mbti;
	private String Intro;
	private String corona;
	private Date nickModi;
	private String exitYN;
	private Date exitDate;
}
