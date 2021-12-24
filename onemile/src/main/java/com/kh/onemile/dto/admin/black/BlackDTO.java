package com.kh.onemile.dto.admin.black;

import java.util.Date;

import lombok.Data;

//블랙 회원 목록 DTO
@Data
public class BlackDTO {
	private int blackNo;
	private int memberNo;
	private int blackCount;
	private Date blackEnd;
	private String viewYN;
}
