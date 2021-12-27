package com.kh.onemile.repository.image;

import java.io.File;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.image.ImageDTO;

@Repository
public class ImageDaoImpl implements ImageDao{
	
	@Autowired
	private SqlSession sqlSession;

	//저장용 폴더
	private File directory = new File("C:/upload/member");
		
	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("image.sequence");
		return seq;
	}
	
	@Override
	public void insert(ImageDTO imageDto, MultipartFile multipartFile) throws IllegalStateException, IOException {
		
		File target = new File(directory, String.valueOf(imageDto.getImageNo()));
		multipartFile.transferTo(target);
		
		imageDto.setSaveName(String.valueOf(imageDto.getImageNo()));
		sqlSession.insert("image.insert", imageDto);
	}
}
