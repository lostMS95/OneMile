package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.miles.board.MilesBoardReplyDTO;
@Repository
public class MilesBoardReplyDaoImpl implements MilesBoardReplyDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(MilesBoardReplyDTO milesBoardReplyDto) {
		sqlSession.insert("mr.insert", milesBoardReplyDto);
	} 

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("mr.sequence");
		return seq;
	}
}
