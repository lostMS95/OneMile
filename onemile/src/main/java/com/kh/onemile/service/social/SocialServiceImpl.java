package com.kh.onemile.service.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.map.MapDTO;
import com.kh.onemile.entity.social.SocialDTO;
import com.kh.onemile.repository.map.MapDao;
import com.kh.onemile.repository.member.MemberDao;
import com.kh.onemile.repository.social.SocialDao;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.SocialVO;

public class SocialServiceImpl implements SocialService{
	final String SEQID = "social_seq";

	@Autowired
	private SocialDao socialDao;
	
	@Autowired
	private MapDao mapDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Sequence seq;
	
	//소셜링 만들기
	@Override
	public void regSocial(SocialVO socialVo) {
		
		//시퀀스 생성
		int socialNo = seq.nextSequence(SEQID);
		
		SocialDTO socialDto = new SocialDTO();
		socialDto.setSocialNo(socialNo);
		socialDto.setMemberNo(socialVo.getMemberNo());
		socialDto.setName(socialVo.getName());
		socialDto.setType(socialVo.getType());
		socialDto.setContext(socialVo.getContext());
		socialDto.setStartDate(socialVo.getStratDate());
		socialDto.setEndDate(socialVo.getEndDate());
		
		double lat = socialVo.getLat();
		double lon = socialVo.getLon();
		
		MapDTO mapDto = new MapDTO();
			
		int mapNo = seq.nextSequence("map_seq");
			
		mapDto.setLat(lat);
		mapDto.setLon(lon);
		mapDto.setMapNo(mapNo);
		mapDto.setDetailaddress(socialVo.getDetailaddress());
			
		mapDao.regMap(mapDto);
		socialDto.setMapNo(mapNo);
	}

	//소셜링 디테일
//	@Override
//	public SocialVO detail(int socialNo) {
//		
//	}

	@Override
	public List<SocialDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeSocial(SocialVO socialVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SocialVO detail(int socialNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
