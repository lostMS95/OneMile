package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.commu.CommuDTO;

public class CommuDaoImpl implements CommuDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void write(CommuDTO commuDto) {
		sqlSession.insert("commu.write", commuDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("commu.sequence");
		return seq;
	}
}
