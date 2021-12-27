package com.kh.onemile.service.commu;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.onemile.entity.commu.CommuDTO;
import com.kh.onemile.entity.image.CommuImageDTO;
import com.kh.onemile.entity.image.ImageDTO;
import com.kh.onemile.entity.map.MapDTO;
import com.kh.onemile.repository.commu.CommuDao;
import com.kh.onemile.repository.image.CommuImageDao;
import com.kh.onemile.repository.image.ImageDao;
import com.kh.onemile.repository.map.MapDao;
import com.kh.onemile.repository.member.MemberDao;
import com.kh.onemile.vo.CommuDetailVO;
import com.kh.onemile.vo.CommuVO;

@Service
public class CommuServiceImpl implements CommuService{
	
	@Autowired
	private CommuDao commuDao;
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private CommuImageDao commuImageDao;
	
	@Autowired
	private MapDao mapDao;
	
	@Autowired
	private MemberDao memberDao;

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
				
				imageDao.insertImage(imageDto, multipartFile);
				
				CommuImageDTO commuImageDto = new CommuImageDTO();
				
				int cmiNo = commuImageDao.getSeq();
				commuImageDto.setCmiNo(cmiNo);
				commuImageDto.setCommuNo(commuNo);
				commuImageDto.setImageNo(seq);
				commuImageDao.insert(commuImageDto);
			}
		}
	}
	
	//게시글 수정에서 이미지 삭제
	@Override
	public void deleteImage(int imageNo) {
		//이미지 삭제 (비동기 처리 예정)
		imageDao.deleteImage(imageNo);
	}
	
	@Override
	public void change(CommuVO commuVo) throws IllegalStateException, IOException {
		
		int commuNo = commuVo.getCommuNo();
		
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
					
				imageDao.insertImage(imageDto, multipartFile);
				
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
	public void hide(String viewYN) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<CommuDTO> menuList(String middleName) {
		List<CommuDTO> list = commuDao.menuList(middleName);
		return list;
	}
	
	@Override
	public CommuDetailVO detail(int commuNo) throws IOException {
		CommuDTO commuDto = new CommuDTO();
		commuDto = commuDao.get(commuNo);
		
		CommuDetailVO commuVo = new CommuDetailVO();
		commuVo.setContent(commuDto.getContent());
		commuVo.setMiddleName(commuDto.getMiddleName());
		commuVo.setHit(commuDto.getHit());
		commuVo.setRegDate(commuDto.getRegDate());
		commuVo.setTitle(commuDto.getTitle());
		commuVo.setViewYN(commuDto.getViewYN());
		
		int memberNo = commuDto.getMemberNo();
//		MemberDTO memberDto = new MemberDTO();
//		memberDto = memberDao.getNick(memberNo);
//		commuVo.setNick(memberDto.getNick());
		
		CommuImageDTO cmiDto = new CommuImageDTO();
		cmiDto = commuImageDao.get(commuDto.getCmiNo());
		
		//이미지 불러오기
		commuVo.setLoad(imageDao.load(cmiDto.getImageNo()));
			
		int mapNo = commuDto.getMapNo();
		
		MapDTO mapDto = new MapDTO();
		mapDto = mapDao.get(mapNo);
		
		commuVo.setLat(mapDto.getLat());
		commuVo.setLon(mapDto.getLon());
		commuVo.setDetailaddress(mapDto.getDetailaddress());
		
		return commuVo;
	}
}
