package com.kh.onemile.repository.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.admin.ApproveDTO;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSession sqlSession;
	
	public void regApproveMember(ApproveDTO approveDTO){
		sqlSession.insert("admin.regApproveMember", approveDTO);
	}
	public void deniedApproveMember(int memberNo) {
		sqlSession.delete("admin.deleteMember", memberNo);
	}
}
