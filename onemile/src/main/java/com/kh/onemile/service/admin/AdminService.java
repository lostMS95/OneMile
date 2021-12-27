package com.kh.onemile.service.admin;

public interface AdminService {
	final String SEQNAME="approve_seq";
	void regApproveMember(int memberNo);
	void deniedApproveMember(int memberNo);
}
