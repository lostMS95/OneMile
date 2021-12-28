package com.kh.onemile.service.admin;

public interface AdminService {
	
	void regApproveMember(int memberNo);
	void deniedApproveMember(int memberNo);
	void approveMember(int memberNo);
}
