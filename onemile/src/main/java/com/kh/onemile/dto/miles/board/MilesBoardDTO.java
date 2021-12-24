package com.kh.onemile.dto.miles.board;

import java.util.Date;

import lombok.Data;
//마일즈 게시판  DTO
@Data
public class MilesBoardDTO {
	private int mbNo;
	private int milesNo;
	private int memberNo;
	private int mcNo; //게시판 카테고리 번호( 공지 , 후기 ,자유 )
	
	private String title;
	private String context;
	private Date regDate;
	private int hit;
	private String viewYN;
	
}
