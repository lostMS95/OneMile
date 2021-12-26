package com.kh.onemile.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//회원정보 + 프로필 이미지
@Data
public class MemberJoinVO {
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
	
	private MultipartFile attach;
}