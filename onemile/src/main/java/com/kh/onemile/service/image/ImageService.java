package com.kh.onemile.service.image;

import java.io.IOException;

import com.kh.onemile.vo.ImageVO;

public interface ImageService {
	void regImage(ImageVO imageVo) throws IllegalStateException, IOException;
	void deleteImage(int imageNo);
}
