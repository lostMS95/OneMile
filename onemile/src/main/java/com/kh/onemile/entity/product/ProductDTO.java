package com.kh.onemile.entity.product;

import java.util.Date;

import lombok.Data;

//공구 상품 DTO
@Data
public class ProductDTO {
	private int productNo;
	private int memberNo;
	
	private int tpNo;
	private String name;
	private int price;
	private String description;
	private Date deadline;
}
