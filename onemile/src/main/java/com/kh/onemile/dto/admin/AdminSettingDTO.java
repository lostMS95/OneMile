package com.kh.onemile.dto.admin;

import lombok.Data;

// 관리자 모임 참여인원 세팅
@Data
public class AdminSettingDTO {
	private int adNo;
	private String isFree;
	private String groupType;
}
