package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.commu.CommuDTO;
@Repository
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
