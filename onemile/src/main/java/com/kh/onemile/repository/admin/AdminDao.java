package com.kh.onemile.repository.admin;

import com.kh.onemile.entity.admin.ApproveDTO;

public interface AdminDao {
	public void regApproveMember(ApproveDTO approveDTO);
	public void deniedApproveMember(int memberNo);
	public void approveMember(int memberNo);
}
