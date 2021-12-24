package com.kh.onemile.entity.member.town;

import lombok.Data;

// 내 동네 DTO
@Data
public class TownDTO {
	private int townNo;
	private int memberNo;
	private String townHome;
}
