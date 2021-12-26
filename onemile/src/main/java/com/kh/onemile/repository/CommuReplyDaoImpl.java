package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.commu.CommuReplyDTO;

public class CommuReplyDaoImpl implements CommuReplyDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void write(CommuReplyDTO commuReplyDto) {
		sqlSession.insert("crp.write", commuReplyDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("crp.sequence");
		return seq;
	}
}
