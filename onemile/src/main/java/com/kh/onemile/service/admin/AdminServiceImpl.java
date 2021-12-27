package com.kh.onemile.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onemile.entity.admin.ApproveDTO;
import com.kh.onemile.repository.admin.AdminDao;
import com.kh.onemile.util.Sequence;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private Sequence sequnce;
	
	public void regApproveMember(int memberNo) {
		adminDao.regApproveMember(setApproveDTO(memberNo));
	}
	public ApproveDTO setApproveDTO(int memberNo) {
		ApproveDTO approveDTO = new ApproveDTO();
		int approveNo = sequnce.joinSequence(SEQNAME);
		approveDTO.setApproveNo(approveNo);
		approveDTO.setSeqName(SEQNAME);
		approveDTO.setMemberNo(memberNo);
		adminDao.regApproveMember(approveDTO);
		return approveDTO;
	}
	@Override
	public void deniedApproveMember(int memberNo) {
		adminDao.deniedApproveMember(memberNo);
	}
}
