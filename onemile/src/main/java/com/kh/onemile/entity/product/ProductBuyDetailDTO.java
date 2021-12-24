package com.kh.onemile.entity.product;

import lombok.Data;

//공동구매 상품 구매 상세 DTO
@Data
public class ProductBuyDetailDTO {
	private int pbdNo;
	private int pbNo;
	
	private String productName;
	private int quantity;
	private int price;
	private String status;
}
