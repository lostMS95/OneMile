package com.kh.onemile.entity.product;

import lombok.Data;

//멤버십 DTO
@Data
public class MembershipDTO {
	private int mspNo;
	private int memberNo;
	
	private String mspProduct;
	private int mspPrice;
}
	