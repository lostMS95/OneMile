package com.kh.onemile.service.image;

import java.io.IOException;
import java.util.List;

import com.kh.onemile.entity.image.ImageDTO;
import com.kh.onemile.vo.ImageVO;

public interface ImageService {
	void regImage(ImageVO imageVo) throws IllegalStateException, IOException;
	void deleteImage(int imageNo);
	ImageVO loadImage(int imageNo) throws IOException;
	List<ImageDTO> listByBoardNo(int boardNo);
}
