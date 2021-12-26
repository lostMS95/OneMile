package com.kh.onemile.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo; //댓글 번호 - 시퀀스
	private int memberNo; //댓글 작성자
	private int replyReceiverNo; //댓글 받는 사람
	
	private String content; //댓글 내용
	private Date regDate ; //댓글 작성시간
	private String viewYN; //댓글 숨김여부
	
	private int mrNo; //마일즈 게시글 댓글 번호
	private int mbNo; //마일즈 게시글 번호
	
	private int crpNo; //커뮤 댓글 번호
	private int commuNo; //커뮤번호
}
