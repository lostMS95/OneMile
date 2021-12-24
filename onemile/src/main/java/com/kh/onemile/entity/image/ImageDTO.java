package com.kh.onemile.entity.image;

import lombok.Data;

@Data
public class ImageDTO {
	private int imageNo;
	private String uploadName;
	private String saveName;
	private long fileSize;
	private String fileType;
}
