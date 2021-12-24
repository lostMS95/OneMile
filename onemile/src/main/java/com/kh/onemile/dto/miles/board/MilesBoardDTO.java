package com.kh.onemile.dto.miles.board;

import java.util.Date;

import lombok.Data;
//마일즈 게시판  DTO
@Data
public class MilesBoardDTO {
	private int mbNo;
	private int milesNo;
	private int memberNo;
	
	private String title;
	private String context;
	private Date regDate;
	private int hit;
	private String viewYN;
	
}
