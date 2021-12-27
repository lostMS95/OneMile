package com.kh.onemile.service.admin;

import com.kh.onemile.entity.admin.ApproveDTO;

public interface AdminService {
	final String SEQNAME="approve_seq";
	void regApproveMember(int memberNo);
	void deniedApproveMember(int memberNo);
}
