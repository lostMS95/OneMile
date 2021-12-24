package com.kh.onemile.entity.miles.board;

import lombok.Data;
//마일즈 게시판 이미지 DTO
@Data
public class MilesBoardImgDTO {
	private int mbiNo;
	private int mbNo;
	private int imageNo; //게시판 글에 좋아요한 회원 번호
}
