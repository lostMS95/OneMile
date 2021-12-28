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
import com.kh.onemile.util.Sequence;
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
	
	@Autowired
	private Sequence seq;

	//글쓰기
	@Override
	public void write(CommuVO commuVo) throws IllegalStateException, IOException {
		
		//시퀀스 생성
		int commuNo = seq.nextSequence("commu_seq");
		
		//게시글 Dto 설정
		CommuDTO commuDto = new CommuDTO();
		commuDto.setCommuNo(commuNo);
		commuDto.setMemberNo(commuVo.getMemberNo());
		commuDto.setMiddleName(commuVo.getMiddleName());
		commuDto.setTitle(commuVo.getTitle());
		commuDto.setContent(commuVo.getTitle());
		
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
			
			mapDao.regMap(mapDto);
			commuDto.setMapNo(mapNo);
			
			commuDao.write(commuDto);
		}else {
			//게시글 작성
			commuDao.write(commuDto);
		}
		
		
	}
	
	//수정하기
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
			
			mapDao.regMap(mapDto);
			commuDto.setMapNo(mapNo);
		}
			commuDao.write(commuDto);
	}

	//숨김처리
	@Override
	public void hide(String viewYN) {
		// TODO Auto-generated method stub
	}

	//카테고리별 리스트
	@Override
	public List<CommuDTO> menuList(String middleName) {
		List<CommuDTO> list = commuDao.menuList(middleName);
		return list;
	}
	
	//상세조회
	@Override
	public CommuDetailVO detail(int commuNo) throws IOException {
		CommuDTO commuDto = new CommuDTO();
		commuDto = commuDao.detail(commuNo);
		
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
