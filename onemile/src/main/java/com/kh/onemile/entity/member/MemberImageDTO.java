package com.kh.onemile.entity.member;

import lombok.Data;

//회원이미지 DTO
@Data
public class MemberImageDTO {
	private int meiNo;
	private int imageNo;
	private int memberNo;
	private String imageDivision;
}
