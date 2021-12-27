package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.reply.ReplyDTO;
@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(ReplyDTO replyDto) {
		sqlSession.insert("reply.write",replyDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("reply.sequence");
		return seq;
	}
}
