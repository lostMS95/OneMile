package com.kh.onemile.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class CommuDetailVO {
	
	//기본 게시판
	private int commuNo;
	private String middleName;
	private String title;
	private String content;
	@DateTimeFormat(pattern="YYYY-MM-DD HH24:mm:ss")
	private Date regDate;
	private int hit;
	private String viewYN;
	
	//지도
	private double lat;
	private double lon;
	private String detailaddress;
	
	//이미지
	private byte[] load;
	
	//회원정보
	private String nick;
}
