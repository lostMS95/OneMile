package com.kh.onemile.dto.admin;

import lombok.Data;

// 신고 목록 DTO
@Data
public class ReportListDTO {
	private int rlNo;
	private int memberNo;
	private String rlType;
	private String rlReason;
}
