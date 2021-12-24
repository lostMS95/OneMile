package com.kh.onemile.dto.social.chat;

import java.util.Date;

import lombok.Data;

// 소셜 채팅 메세지 DTO
@Data
public class MessageDTO {
	private int msgNo;
	private int chatNo;
	
	private String message;
	private Date time;
	
}
