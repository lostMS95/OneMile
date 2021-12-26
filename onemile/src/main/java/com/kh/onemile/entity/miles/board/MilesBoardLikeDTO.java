package com.kh.onemile.entity.miles.board;

import lombok.Data;

// 마일즈 게시판 좋아요 DTO
@Data
public class MilesBoardLikeDTO {
	private int mblNo;
	private int mbNo;
	private int memberNo; //게시판 글에 좋아요한 회원 번호
	
}
