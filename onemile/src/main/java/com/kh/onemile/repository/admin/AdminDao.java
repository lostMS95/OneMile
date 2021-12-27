package com.kh.onemile.repository.admin;

import com.kh.onemile.entity.admin.ApproveDTO;

public interface AdminDao {
	void regApproveMember(ApproveDTO approveDTO);
	void deniedApproveMember(int memberNo);
}
