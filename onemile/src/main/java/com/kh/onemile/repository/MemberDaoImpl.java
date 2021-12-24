package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.dto.member.MemberDTO;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join",memberDTO);
	}

}
