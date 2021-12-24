package com.kh.onemile.entity.miles.board;

import lombok.Data;

// 마일즈 게시판 댓글 DTO
@Data
public class MilesBoardReplyDTO {
	private int mrNo;
	private int replyNo;
	private int mbNo; //게시판 글에 좋아요한 회원 번호
}
