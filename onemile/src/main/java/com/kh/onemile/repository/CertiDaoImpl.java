package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.member.certi.CertiDTO;

@Repository
public class CertiDaoImpl implements CertiDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(CertiDTO certiDTO) {
		sqlSession.insert("certi.insert", certiDTO);
	}

	@Override
	public boolean check(CertiDTO certiDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
