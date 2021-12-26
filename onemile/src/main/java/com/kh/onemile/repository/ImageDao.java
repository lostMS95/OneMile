package com.kh.onemile.repository;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.image.ImageDTO;

public interface ImageDao {
	void insert(ImageDTO imageDto, MultipartFile multipartFile) throws IllegalStateException, IOException;
	int getSeq();
}
