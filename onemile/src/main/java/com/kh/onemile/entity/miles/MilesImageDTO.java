package com.kh.onemile.entity.miles;

import java.util.Date;

import lombok.Data;

//마일즈 이미지  DTO
@Data
public class MilesImageDTO {
	private int miNo;
	private int imageNo;
	private int milesNo;
	
	private String thumbnail;
}
