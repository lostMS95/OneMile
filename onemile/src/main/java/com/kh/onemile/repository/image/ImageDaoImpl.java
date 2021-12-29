package com.kh.onemile.repository.image;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	public void regImage(ImageDTO imageDto, MultipartFile multipartFile) throws IllegalStateException, IOException {
		
		File target = new File(directory, String.valueOf(imageDto.getImageNo()));
		multipartFile.transferTo(target);
		
		imageDto.setSaveName(String.valueOf(imageDto.getImageNo()));
		sqlSession.insert("image.regImage", imageDto);
	}

	@Override
	public boolean deleteImage(int imageNo) {
		int count = sqlSession.delete("image.deleteImage", imageNo);
		return count > 0;
	}

	@Override
	public ImageDTO get(int imageNo) {
		return sqlSession.selectOne("image.get", imageNo);
	}
	
	@Override
	public byte[] load(int imageNo) throws IOException {
		File target = new File(directory, String.valueOf(imageNo));
		byte[] data = FileUtils.readFileToByteArray(target);
		return data;
	}

	@Override
	public List<ImageDTO> listByBoardNo(int boardNo) {
		List<ImageDTO> list = sqlSession.selectList("image.listByBoardNo", boardNo);
		return list;
	}
}
