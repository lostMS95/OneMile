package com.kh.onemile.entity.member.notification;

import java.util.Date;

import lombok.Data;

// 알림 DTO
@Data
public class NotificationDTO {
	private int notiNo;
	private int memberNo;
	private String type;
	private String msg;
	private Date notiTime;
	private String read;
}
