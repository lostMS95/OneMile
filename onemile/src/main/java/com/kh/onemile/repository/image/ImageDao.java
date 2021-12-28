package com.kh.onemile.repository.image;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.image.ImageDTO;

public interface ImageDao {
	void insertImage(ImageDTO imageDto, MultipartFile multipartFile) throws IllegalStateException, IOException;
	int getSeq();
	boolean deleteImage(int imageNo);
	ImageDTO get(int imageNo);
	byte[] load(int imageNo) throws IOException;
}
