package com.kh.onemile.entity.reply;

import java.util.Date;

import lombok.Data;

//댓글 DTO
@Data
public class ReplyDTO {
	private int replyNo;
	private int memberNo;
	private int replyReceiverNo;
	
	private String content;
	private Date regDate ;
	private String viewYN;
}
