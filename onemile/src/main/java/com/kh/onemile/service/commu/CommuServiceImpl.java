package com.kh.onemile.service.commu;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.commu.CommuDTO;
import com.kh.onemile.entity.image.CommuImageDTO;
import com.kh.onemile.entity.image.ImageDTO;
import com.kh.onemile.entity.map.MapDTO;
import com.kh.onemile.repository.CommuDao;
import com.kh.onemile.repository.CommuImageDao;
import com.kh.onemile.repository.ImageDao;
import com.kh.onemile.repository.MapDao;
import com.kh.onemile.vo.CommuVO;

@Service
public class CommuServiceImpl implements CommuService{
	
	@Autowired
	CommuDao commuDao;
	
	@Autowired
	ImageDao imageDao;
	
	@Autowired
	CommuImageDao commuImageDao;
	
	@Autowired
	MapDao mapDao;

	@Override
	public void write(CommuVO commuVo) throws IllegalStateException, IOException {
		
		//시퀀스 생성
		int commuNo = commuDao.getSeq();
		
		//게시글 Dto 설정
		CommuDTO commuDto = new CommuDTO();
		commuDto.setCommuNo(commuNo);
		commuDto.setMemberNo(commuVo.getMemberNo());
		commuDto.setMiddleName(commuVo.getMiddleName());
		commuDto.setTitle(commuVo.getTitle());
		commuDto.setContent(commuVo.getTitle());
		commuDto.setViewYN(commuVo.getViewYN());
		
		double lat = commuVo.getLat();
		double lon = commuVo.getLon();
		
		boolean map = lat != 0 && lon != 0; //map 좌표가 0이 아니면
		
		if (map) { //지도가 있으면
			MapDTO mapDto = new MapDTO();
			
			int mapNo = mapDao.getSeq();
			
			mapDto.setLat(lat);
			mapDto.setLon(lon);
			mapDto.setMapNo(mapNo);
			mapDto.setDetailaddress(commuVo.getDetailaddress());
			
			mapDao.insert(mapDto);
			commuDto.setMapNo(mapNo);
			
			commuDao.withMap(commuDto);
		}else {
			//게시글 작성
			commuDao.write(commuDto);
		}
		
		for(MultipartFile multipartFile : commuVo.getAttach()) {
			if(!multipartFile.isEmpty()) {
				ImageDTO imageDto = new ImageDTO();
				
				int seq = imageDao.getSeq();
				
				imageDto.setImageNo(seq);
				imageDto.setUploadName(multipartFile.getOriginalFilename());
				imageDto.setFileSize(multipartFile.getSize());
				imageDto.setFileType(multipartFile.getContentType());
				
				imageDao.insert(imageDto, multipartFile);
				
				CommuImageDTO commuImageDto = new CommuImageDTO();
				
				int cmiNo = commuImageDao.getSeq();
				commuImageDto.setCmiNo(cmiNo);
				commuImageDto.setCommuNo(commuNo);
				commuImageDto.setImageNo(seq);
				commuImageDao.insert(commuImageDto);
			}
		}
	}

	@Override
	public boolean change(CommuVO commuVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hide(String viewYN) {
		// TODO Auto-generated method stub
		return false;
	}
}
