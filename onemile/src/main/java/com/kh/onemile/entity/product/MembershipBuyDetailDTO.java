package com.kh.onemile.entity.product;

import lombok.Data;

//멤버십 구매 상세 DTO
@Data
public class MembershipBuyDetailDTO {
	private int msbdNo;
	private int msbNo;
	
	private String productName;
	private int quantity;
	private int price;
	private String status;
}