package com.kh.onemile.repository.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.admin.ApproveDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSession sqlSession;
	
	public void regApproveMember(ApproveDTO approveDTO){
		int result = sqlSession.insert("admin.regApproveMember", approveDTO);
		log.debug(" result  "+ result);
	}
	public void deniedApproveMember(int memberNo) {
		sqlSession.delete("admin.deleteMember", memberNo);
	}
}
