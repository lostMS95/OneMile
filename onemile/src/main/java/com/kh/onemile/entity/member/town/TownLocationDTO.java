package com.kh.onemile.entity.member.town;

import lombok.Data;

// 내 동네 위치 DTO
@Data
public class TownLocationDTO {
	private int tlNo;
	private int townNo;
	private String lat;
	private String lon;
}
