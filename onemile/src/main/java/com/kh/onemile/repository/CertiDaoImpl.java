package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.member.certi.CertiDTO;
import com.kh.onemile.repository.certi.CertiDao;

@Repository
public class CertiDaoImpl implements CertiDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	//디비에 저장
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
