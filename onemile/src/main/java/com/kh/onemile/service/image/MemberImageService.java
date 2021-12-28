package com.kh.onemile.service.image;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.image.ImageDTO;
import com.kh.onemile.entity.image.MemberImageDTO;
import com.kh.onemile.repository.image.ImageDao;
import com.kh.onemile.repository.image.MemberImageDao;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.ImageVO;

@Service
@Qualifier("memberImage")
public class MemberImageService implements ImageService{

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private MemberImageDao memberImageDao;
	
	@Autowired
	private Sequence seq;

	@Override
	public void regImage(ImageVO imageVo) throws IllegalStateException, IOException {
		for(MultipartFile multipartFile : imageVo.getAttach()) {
			if(!multipartFile.isEmpty()) {
				ImageDTO imageDto = new ImageDTO();
				
				int imageNo = seq.nextSequence("image_seq");
				
				imageDto.setImageNo(imageNo);
				imageDto.setUploadName(multipartFile.getOriginalFilename());
				imageDto.setFileSize(multipartFile.getSize());
				imageDto.setFileType(multipartFile.getContentType());
				
				imageDao.regImage(imageDto, multipartFile);
				
				MemberImageDTO memberImageDto = new MemberImageDTO();
				
				int meiNo = seq.nextSequence("mei_seq");
				memberImageDto.setMeiNo(meiNo);
				memberImageDto.setImageNo(imageNo);
				memberImageDto.setMemberNo(imageVo.getMemberNo());
				memberImageDto.setImageDivision(imageVo.getImageDivision());
			}
		}
	}

	@Override
	public void deleteImage(int imageNo) {
		//이미지 삭제 (비동기 처리 예정)
		imageDao.deleteImage(imageNo);
		memberImageDao.deleteImage(imageNo);
	}
}
