package com.kh.onemile.service.miles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.miles.MilesDTO;
import com.kh.onemile.repository.miles.MilesDao;
import com.kh.onemile.util.Sequence;
import com.kh.onemile.vo.MilesVO;

@Service
public class MilesServiceImpl implements MilesService{
	final String SEQID = "miles_seq";
	final String SEQNAME = "miles_no";
	@Autowired
	private Sequence seq;
	@Autowired
	private MilesDao milesDao;
	
	@Override
	public void create(MilesVO milesVo) {
		int milesNo = seq.nextSequence(SEQID);
		milesVo.setMilesNo(milesNo);
		System.out.println("생성한 마일즈 번호"+milesNo);
		milesDao.create(milesVo);
		
		/*
		 * MilesDTO milesDTO = new MilesDTO(); milesDTO.setMilesNo(milesNo);
		 * milesDTO.setSmallName(milesVo.getSmallName());
		 * milesDTO.setMemberNo(milesVo.getMemberNo());
		 * milesDTO.setAdNo(milesVo.getAdNo()); milesDTO.setName(milesVo.getName());
		 * milesDTO.setContext(milesVo.getContext());
		 * milesDTO.setArea(milesVo.getArea());
		 */
	}
}