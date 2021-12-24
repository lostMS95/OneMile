package com.kh.onemile.entity.social;

import java.util.Date;

import lombok.Data;

//소셜링  DTO
@Data
public class SocialDTO {
	private int socialNo;
	private int memberNo;
	private int mapNo;
	private String smallType;
	private int adNo;
	
	private String name; //소모임 이름
	private String type; //모임 분류( 정모 , 소모임)
	private String context; //모임 소개 내용
	private Date startDate; //시작시각
	private Date endDate; // 종료시각
	private String viewYN; //숨김여부
}
