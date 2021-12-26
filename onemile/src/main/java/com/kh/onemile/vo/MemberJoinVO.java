package com.kh.onemile.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//회원정보 + 프로필 이미지
@Data
public class MemberJoinVO {
	private int memberNo;
	private String email;
	private String pw;
	private String nick;
	private String phone;
	private String gender;
	private Date birth;
	private String grade;
	private Date joinDate;
	private String mbti;
	private String intro;
	private String corona;
	private Date nickModi;
	private String exitYN;
	private Date exitDate;
	private List<MultipartFile> attach;
}