package com.kh.onemile.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.admin.ApproveDTO;
import com.kh.onemile.repository.admin.AdminDao;
import com.kh.onemile.util.Sequence;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AdminServiceImpl implements AdminService{
	String approveSeq ="approve_seq";
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private Sequence sequnce;
	
	//가입시 회원 승인 정보 등록.
	public void regApproveMember(int memberNo) {
		log.debug("memberNo    "+memberNo);
		ApproveDTO approveDTO = setApproveDTO(memberNo);
		adminDao.regApproveMember(approveDTO);
	}
	//회원 승인 DTO에 정보 설정.
	public ApproveDTO setApproveDTO(int memberNo) {
		ApproveDTO approveDTO = new ApproveDTO();
		// 가입 승인 시퀀스 가져오기
		int approveNo = sequnce.nextSequence(approveSeq);
		// 정보 설정.
		approveDTO.setApproveNo(approveNo);
		approveDTO.setSeqName(approveSeq);
		approveDTO.setMemberNo(memberNo);
		log.debug(approveDTO.toString());
		
		return approveDTO;
	}
	@Override
	public void deniedApproveMember(int memberNo) {
		adminDao.deniedApproveMember(memberNo);
	}
}
